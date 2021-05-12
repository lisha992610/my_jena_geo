package de.hsmainz.cs.semgis.arqextension.geometry.attribute;

import org.apache.jena.datatypes.DatatypeFormatException;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase1;
import org.apache.sis.coverage.grid.GridCoverage;
import org.locationtech.jts.geom.Geometry;

import de.hsmainz.cs.semgis.arqextension.util.LiteralUtils;
import de.hsmainz.cs.semgis.arqextension.util.Wrapper;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;
import io.github.galbiston.geosparql_jena.implementation.datatype.raster.CoverageWrapper;

/**
 * Returns the minimum clearance of a geometry, a measure of a geometry's robustness.
 *
 */
public class MinimumClearance extends FunctionBase1 {

	@Override
	public NodeValue exec(NodeValue arg0) {
		Wrapper wrapper1=LiteralUtils.rasterOrVector(arg0);
    	if(wrapper1 instanceof GeometryWrapper) {
        try {
            GeometryWrapper geometry = GeometryWrapper.extract(arg0);
            org.locationtech.jts.precision.MinimumClearance clearance=new org.locationtech.jts.precision.MinimumClearance(geometry.getParsingGeometry());
            return NodeValue.makeDouble(clearance.getDistance());
        } catch (DatatypeFormatException ex) {
            throw new ExprEvalException(ex.getMessage(), ex);
        }      
	} else if(wrapper1 instanceof CoverageWrapper) {
    		 CoverageWrapper covwrap = CoverageWrapper.extract(arg0);
          GridCoverage cov = covwrap.getXYGeometry();
          Geometry geom=LiteralUtils.toGeometry(cov.getGridGeometry().getEnvelope());
          org.locationtech.jts.precision.MinimumClearance clearance=new org.locationtech.jts.precision.MinimumClearance(geom);
          return NodeValue.makeDouble(clearance.getDistance());
   	}else {
   		throw new ExprEvalException("No geometry or coverage literal");
   	}
	}

}
