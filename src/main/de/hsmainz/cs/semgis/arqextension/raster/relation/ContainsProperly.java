package de.hsmainz.cs.semgis.arqextension.raster.relation;

import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase2;
import org.apache.sis.coverage.grid.GridCoverage;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.operation.TransformException;
import org.opengis.util.FactoryException;

import de.hsmainz.cs.semgis.arqextension.util.LiteralUtils;
import de.hsmainz.cs.semgis.arqextension.util.Wrapper;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapperFactory;
import io.github.galbiston.geosparql_jena.implementation.datatype.WKTDatatype;
import io.github.galbiston.geosparql_jena.implementation.datatype.raster.CoverageWrapper;

public class ContainsProperly extends FunctionBase2 {

	
	//TODO: Convert to properly contains
	
	@Override
	public NodeValue exec(NodeValue v,NodeValue v1) {
		Wrapper wrapper1=LiteralUtils.rasterOrVector(v);
		Wrapper wrapper2=LiteralUtils.rasterOrVector(v1);
		if(wrapper1 instanceof GeometryWrapper && wrapper2 instanceof GeometryWrapper) {
			GeometryWrapper transGeom2;
			try {
				transGeom2 = ((GeometryWrapper)wrapper2).transform(((GeometryWrapper)wrapper1).getSrsInfo());
				return NodeValue.makeBoolean(containsProperly(((GeometryWrapper)wrapper1).getXYGeometry(),transGeom2.getXYGeometry()));
			} catch (MismatchedDimensionException | TransformException | FactoryException e) {
				throw new RuntimeException("CRS transformation failed");
			}
		}else if(wrapper1 instanceof CoverageWrapper && wrapper2 instanceof CoverageWrapper) {
			GridCoverage raster=((CoverageWrapper)wrapper1).getGridGeometry();
			GridCoverage raster2=((CoverageWrapper)wrapper2).getGridGeometry();		
			Geometry bbox1 = LiteralUtils.toGeometry(raster.getGridGeometry().getEnvelope());
		    Geometry bbox2 = LiteralUtils.toGeometry(raster2.getGridGeometry().getEnvelope());
		    return NodeValue.makeBoolean(containsProperly(bbox1,bbox2));	
		}else {
			if(wrapper1 instanceof CoverageWrapper) {
				GridCoverage raster=((CoverageWrapper)wrapper1).getGridGeometry();
				Geometry bbox1 = LiteralUtils.toGeometry(raster.getGridGeometry().getEnvelope());
				Geometry geom=((GeometryWrapper)wrapper2).getXYGeometry();
				return NodeValue.makeBoolean(containsProperly(bbox1, geom));
			}else {
				GridCoverage raster=((CoverageWrapper)wrapper2).getGridGeometry();
				Geometry bbox1 = LiteralUtils.toGeometry(raster.getGridGeometry().getEnvelope());
				Geometry geom=((GeometryWrapper)wrapper1).getXYGeometry();
				return NodeValue.makeBoolean(containsProperly(bbox1, geom));				
			}
		}
	}
	
	
	public Boolean containsProperly(Geometry geom1,Geometry geom2) {
        if(!geom1.contains(geom2)) {
        	return false;
        }else {
        	Coordinate oldcoord=null;
        	for(Coordinate coord:geom1.getCoordinates()) {
        		if(oldcoord!=null) {
        			LineString ls=(LineString) GeometryWrapperFactory.createLineString(new Coordinate[] {oldcoord, coord},WKTDatatype.URI).getXYGeometry();
        			if(ls.intersects(geom2)) {
        				return false;
        			}
        		}
        		oldcoord=coord;
        	}
        	return true;
        }
	}

}
