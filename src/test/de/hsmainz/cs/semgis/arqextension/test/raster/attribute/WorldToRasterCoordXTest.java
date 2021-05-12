package de.hsmainz.cs.semgis.arqextension.test.raster.attribute;

import static org.junit.Assert.assertEquals;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.jupiter.api.Test;

import de.hsmainz.cs.semgis.arqextension.raster.attribute.WorldToRasterCoordX;
import de.hsmainz.cs.semgis.arqextension.test.util.SampleRasters;
import io.github.galbiston.geosparql_jena.implementation.datatype.raster.HexWKBRastDatatype;

public class WorldToRasterCoordXTest extends SampleRasters {
	
	@Test
	public void testWorldToRasterCoordX() {
		NodeValue covLiteral = NodeValue.makeNode(wkbString1, HexWKBRastDatatype.INSTANCE);
		NodeValue x = NodeValue.makeInteger(1);
		NodeValue y = NodeValue.makeInteger(1);
		WorldToRasterCoordX instance=new WorldToRasterCoordX();
        NodeValue expResult = NodeValue.makeDouble(1);
        NodeValue result = instance.exec(covLiteral,x,y);
        assertEquals(expResult, result);
	}

}
