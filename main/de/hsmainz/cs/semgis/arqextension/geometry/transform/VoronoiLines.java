package de.hsmainz.cs.semgis.arqextension.geometry.transform;

import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase3;

import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapperFactory;

public class VoronoiLines extends FunctionBase3 {

	@Override
	public NodeValue exec(NodeValue v1, NodeValue v2, NodeValue v3) {
		GeometryWrapper geom1 = GeometryWrapper.extract(v1);
        Double tolerance=v2.getDouble();
        GeometryWrapper extend_to=GeometryWrapper.extract(v3);
        throw new UnsupportedOperationException("Not supported yet.");
	}

}
