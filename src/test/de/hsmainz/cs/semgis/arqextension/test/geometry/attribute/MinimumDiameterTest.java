package de.hsmainz.cs.semgis.arqextension.test.geometry.attribute;

import static org.junit.Assert.assertEquals;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.jupiter.api.Test;

import de.hsmainz.cs.semgis.arqextension.geometry.attribute.MinimumDiameter;
import io.github.galbiston.geosparql_jena.implementation.datatype.WKTDatatype;

public class MinimumDiameterTest {

	public static final String testPolygon="POLYGON ((0 0, 1 0, 1 1, 0.5 3.2e-4, 0 0))";
	
	@Test
	public void testMinimumDiameter() {
        NodeValue geometryLiteral = NodeValue.makeNode(testPolygon, WKTDatatype.INSTANCE);
        MinimumDiameter instance=new MinimumDiameter();
        NodeValue expResult = NodeValue.makeDouble(0.7071067811865476);
        NodeValue result = instance.exec(geometryLiteral);
        assertEquals(expResult, result);
	}
	
}
