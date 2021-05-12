package de.hsmainz.cs.semgis.arqextension.linestring.attribute;

import org.apache.jena.datatypes.DatatypeFormatException;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase1;
import org.locationtech.jts.geom.Geometry;

import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapperFactory;
import io.github.galbiston.geosparql_jena.implementation.datatype.WKTDatatype;

public class LineSelfIntersectionPoint extends FunctionBase1 {

	@Override
	public NodeValue exec(NodeValue v) {
		try {
            GeometryWrapper geometry = GeometryWrapper.extract(v);
            Geometry geom = geometry.getXYGeometry();
            if(geom.isSimple()) {
            	return NodeValue.makeNode("POINT EMPTY",WKTDatatype.INSTANCE);
            }else {
            	return GeometryWrapperFactory.createGeometry(geom.intersection(geom), geometry.getGeometryDatatypeURI()).asNodeValue();
            }
        } catch (DatatypeFormatException ex) {
            throw new ExprEvalException(ex.getMessage(), ex);
        }
	}

}
