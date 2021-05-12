package de.hsmainz.cs.semgis.arqextension.test.envelope.relation;

import static org.junit.Assert.assertEquals;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.jupiter.api.Test;

import de.hsmainz.cs.semgis.arqextension.envelope.relation.BBOXBelow;
import io.github.galbiston.geosparql_jena.implementation.datatype.WKTDatatype;

public class BBOXBelowTest {

	public static final String testGeom1="LINESTRING (1 4, 1 7)";
	
	public static final String testGeom2="LINESTRING (0 0, 4 2)";
	
	public static final String testGeom3="LINESTRING (6 1, 6 5)";
	
	public static final String testGeom4="LINESTRING (2 3, 5 6)";
	
	
	@Test
	public void testBBOXBelow() {
        NodeValue geometryLiteral = NodeValue.makeNode(testGeom1, WKTDatatype.INSTANCE);
        NodeValue geometryLiteral1 = NodeValue.makeNode(testGeom2, WKTDatatype.INSTANCE);
        BBOXBelow instance=new BBOXBelow();
        NodeValue expResult = NodeValue.makeBoolean(false);
        NodeValue result = instance.exec(geometryLiteral,geometryLiteral1);
        assertEquals(expResult, result);
	}

	@Test
	public void testBBOXBelow1() {
        NodeValue geometryLiteral = NodeValue.makeNode(testGeom2, WKTDatatype.INSTANCE);
        NodeValue geometryLiteral1 = NodeValue.makeNode(testGeom1, WKTDatatype.INSTANCE);
        BBOXBelow instance=new BBOXBelow();
        NodeValue expResult = NodeValue.makeBoolean(true);
        NodeValue result = instance.exec(geometryLiteral,geometryLiteral1);
        assertEquals(expResult, result);
	}
	
}
