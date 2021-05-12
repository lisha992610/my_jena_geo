package de.hsmainz.cs.semgis.arqextension.polygon.attribute;

import org.apache.jena.datatypes.DatatypeFormatException;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase1;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;

public class CircularityIndex extends FunctionBase1 {

	@Override
	public NodeValue exec(NodeValue v) {
		 try {
	            GeometryWrapper geometry = GeometryWrapper.extract(v);
	            Geometry geom = geometry.getParsingGeometry();
		if (geom instanceof Polygon) {
        	double areasum=0.,perimetersum=0.;
        	for(int i=0;i<geom.getNumGeometries();i++) {
        		areasum+=geom.getArea();
        		perimetersum+=geom.getLength();
        	}
        	return NodeValue.makeDouble((4*Math.PI*areasum)/(perimetersum*perimetersum));
        }
        return NodeValue.makeDouble(0.);
		 } catch (DatatypeFormatException ex) {
	            throw new ExprEvalException(ex.getMessage(), ex);
	        }
	}
}
