package de.hsmainz.cs.semgis.arqextension.polygon.transform;

import java.util.Arrays;

import org.apache.jena.datatypes.DatatypeFormatException;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase1;
import org.locationtech.jts.algorithm.Orientation;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapperFactory;
import io.github.galbiston.geosparql_jena.implementation.datatype.WKTDatatype; 
/**
 * Orients all exterior rings counter-clockwise and all interior rings clockwise. 
 *
 */
public class ForcePolygonCCW extends FunctionBase1 {

	@Override
	public NodeValue exec(NodeValue v) {
        try {
            GeometryWrapper geometry = GeometryWrapper.extract(v);
            Geometry geom = geometry.getParsingGeometry();
            if (geom instanceof Polygon) {
            	if(Orientation.isCCW(geom.getCoordinates())) {
            		return geometry.asNodeValue();
            	}else {
            		return GeometryWrapperFactory.createPolygon(Arrays.asList(geom.reverse().getCoordinates()), WKTDatatype.URI).asNodeValue();
            	}
            }
            throw new ExprEvalException("Given geometry is not a Polygon");
        } catch (DatatypeFormatException ex) {
            throw new ExprEvalException(ex.getMessage(), ex);
        }
	}

}
