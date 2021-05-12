package de.hsmainz.cs.semgis.arqextension.geometry.attribute;

import org.apache.jena.datatypes.DatatypeFormatException;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase1;
import org.locationtech.jts.geom.Geometry;

import de.hsmainz.cs.semgis.arqextension.util.LiteralUtils;
import de.hsmainz.cs.semgis.arqextension.util.Wrapper;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;

/**
 * Checks if the given geometry represents a GEOMETRYCOLLECTION.
 *
 */
public class IsCollection extends FunctionBase1 {

	@Override
	public NodeValue exec(NodeValue arg0) {
		Wrapper wrapper1=LiteralUtils.rasterOrVector(arg0);
    	if(wrapper1 instanceof GeometryWrapper) {
        try {
            GeometryWrapper geometry = GeometryWrapper.extract(arg0);
            Geometry geom = geometry.getParsingGeometry();
            String type=geom.getGeometryType().toUpperCase();
            if("GEOMETRYCOLLECTION".equals(type) || "COMPOUNDCURVE".equals(type) || type.startsWith("MULTI")) {
                return NodeValue.makeNodeBoolean(true);
            }
            return NodeValue.makeNodeBoolean(false);
        } catch (DatatypeFormatException ex) {
            throw new ExprEvalException(ex.getMessage(), ex);
        }
    	}else {
    		return NodeValue.FALSE;
    	}
	}

}
