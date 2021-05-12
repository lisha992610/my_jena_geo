package de.hsmainz.cs.semgis.arqextension.polygon.attribute;

import org.apache.jena.datatypes.DatatypeFormatException;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase1;
import org.locationtech.jts.algorithm.Orientation;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;

/**
 * Returns true if all exterior rings are oriented clockwise and all interior rings are oriented counter-clockwise. 
 *
 */
public class IsPolygonCW extends FunctionBase1 {

	@Override
	public NodeValue exec(NodeValue v) {
		 try {
	            GeometryWrapper geometry = GeometryWrapper.extract(v);
	            Geometry geom = geometry.getParsingGeometry();
	            if (geom instanceof Polygon) {
	                return NodeValue.makeBoolean(!Orientation.isCCW(geom.getCoordinates()));
	            }
	            return NodeValue.FALSE;
	        } catch (DatatypeFormatException ex) {
	            throw new ExprEvalException(ex.getMessage(), ex);
	        }
	}
	
}
