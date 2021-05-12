package de.hsmainz.cs.semgis.arqextension.test.geometry.exporter;

import static org.junit.Assert.assertEquals;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.jupiter.api.Test;

import de.hsmainz.cs.semgis.arqextension.geometry.exporter.AsSVG;
import io.github.galbiston.geosparql_jena.implementation.datatype.WKTDatatype;

public class AsSVGTest {

	public static final String testGeometry="POLYGON((0 0,0 1,1 1,1 0,0 0))";
	
	@Test
	public void testAsSVG() {
        NodeValue geometryLiteral = NodeValue.makeNode(testGeometry, WKTDatatype.INSTANCE);
        AsSVG instance=new AsSVG();
        NodeValue expResult = NodeValue.makeString("<svg><polygon points=' 0,0 0,1 1,1 1,0 0,0' />\n</svg>");
        NodeValue result = instance.exec(geometryLiteral);
        assertEquals(expResult, result);
	}
	
}
