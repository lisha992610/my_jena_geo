package de.hsmainz.cs.semgis.arqextension.geometry.srid;

import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase1;

public class EPSGToSRID extends FunctionBase1 {

	@Override
	public NodeValue exec(NodeValue v) {
		String epsg=v.getString();
		return NodeValue.makeInteger(Integer.valueOf(epsg.substring(epsg.indexOf(':')+1)));
	}

}
