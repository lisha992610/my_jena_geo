package de.hsmainz.cs.semgis.arqextension.test.raster.attribute;

import static org.junit.Assert.assertEquals;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.jupiter.api.Test;

import de.hsmainz.cs.semgis.arqextension.raster.attribute.Width;
import de.hsmainz.cs.semgis.arqextension.test.util.SampleRasters;
import io.github.galbiston.geosparql_jena.implementation.datatype.raster.HexWKBRastDatatype;

public class WidthTest extends SampleRasters {
	
	@Test
	public void testRasterWidth() {
		NodeValue covLiteral = NodeValue.makeNode(wkbString1, HexWKBRastDatatype.INSTANCE);
        Width instance=new Width();
        NodeValue expResult = NodeValue.makeInteger(2);
        NodeValue result = instance.exec(covLiteral);
        assertEquals(expResult, result);
	}
	
}
