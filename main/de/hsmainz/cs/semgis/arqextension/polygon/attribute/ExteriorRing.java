package de.hsmainz.cs.semgis.arqextension.polygon.attribute;

import org.apache.jena.datatypes.DatatypeFormatException;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase1;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Polygon;

import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapperFactory;
import io.github.galbiston.geosparql_jena.implementation.datatype.WKTDatatype;

public class ExteriorRing extends FunctionBase1 {

	@Override
	public NodeValue exec(NodeValue arg0) {
        try {
            GeometryWrapper geometry = GeometryWrapper.extract(arg0);
            Geometry geom = geometry.getParsingGeometry();
            if (geom instanceof Polygon) {
            	
            	LineString result=((Polygon) geom).getExteriorRing();
            	GeometryWrapper lineStringWrapper = GeometryWrapperFactory.createGeometry(result, "<http://www.opengis.net/def/crs/EPSG/0/"+geom.getSRID()+">", WKTDatatype.URI);
            	return lineStringWrapper.asNodeValue();
            }
            throw new ExprEvalException("Given geometry has to be a polygon");
        } catch (DatatypeFormatException ex) {
            throw new ExprEvalException(ex.getMessage(), ex);
        }
	}

}
