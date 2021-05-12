package de.hsmainz.cs.semgis.arqextension.geometry.attribute;

import org.apache.jena.datatypes.DatatypeFormatException;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase1;
import org.locationtech.jts.geom.Geometry;

import de.hsmainz.cs.semgis.arqextension.linestring.attribute.LineLength3D;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;

public class Length3D extends FunctionBase1 {

	@Override
	public NodeValue exec(NodeValue v) {
		try {
            GeometryWrapper geometry = GeometryWrapper.extract(v);
            Geometry geom = geometry.getParsingGeometry();
            Double length3d=LineLength3D.length3D(geom);
            return NodeValue.makeDouble(length3d);
        } catch (DatatypeFormatException ex) {
            throw new ExprEvalException(ex.getMessage(), ex);
        }
	}

}
