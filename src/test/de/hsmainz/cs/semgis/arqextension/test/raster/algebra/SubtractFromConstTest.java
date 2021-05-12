package de.hsmainz.cs.semgis.arqextension.test.raster.algebra;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.jupiter.api.Test;

import de.hsmainz.cs.semgis.arqextension.raster.algebra.SubtractFromConst;
import de.hsmainz.cs.semgis.arqextension.test.util.SampleRasters;
import io.github.galbiston.geosparql_jena.implementation.datatype.raster.HexWKBRastDatatype;

public class SubtractFromConstTest extends SampleRasters {

	public static final String combinedRasterLiteral="";
	
	@Test
	public void testSubtractConst() {
		NodeValue covLiteral = NodeValue.makeNode(wkbString4, HexWKBRastDatatype.INSTANCE);
        NodeValue covLiteral2 = NodeValue.makeInteger(10);
        NodeValue bandnum = NodeValue.makeInteger(0);
        SubtractFromConst instance=new SubtractFromConst();
        NodeValue expResult = NodeValue.makeNode(wkbString4, HexWKBRastDatatype.INSTANCE);
        NodeValue result = instance.exec(covLiteral,bandnum,covLiteral2);
        System.out.println(displayRasterSummary(wkbString4));
        System.out.println(displayRasterSummary(result));
        assertNotEquals(expResult, result);
	}

}
