package de.hsmainz.cs.semgis.arqextension.test.raster.attribute;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.jupiter.api.Test;

import de.hsmainz.cs.semgis.arqextension.raster.attribute.Summary;
import de.hsmainz.cs.semgis.arqextension.test.util.SampleRasters;
import io.github.galbiston.geosparql_jena.implementation.datatype.raster.HexWKBRastDatatype;

public class SummaryTest extends SampleRasters {
	
	@Test
	public void testSummary() {
		NodeValue covLiteral = NodeValue.makeNode(wkbString1, HexWKBRastDatatype.INSTANCE);
		NodeValue covLiteral2 = NodeValue.makeNode(wkbString4, HexWKBRastDatatype.INSTANCE);
		Summary instance=new Summary();
        NodeValue expResult = NodeValue.makeString("");
        NodeValue result = instance.exec(covLiteral);
        NodeValue result2 = instance.exec(covLiteral2);
        System.out.println(result);
        System.out.println(result2);
        assertNotEquals(expResult, result);
	}

}
