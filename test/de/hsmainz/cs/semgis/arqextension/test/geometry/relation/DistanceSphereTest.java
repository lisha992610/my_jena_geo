package de.hsmainz.cs.semgis.arqextension.test.geometry.relation;

import static org.junit.Assert.assertEquals;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.jupiter.api.Test;

import de.hsmainz.cs.semgis.arqextension.geometry.relation.DistanceSphere;
import de.hsmainz.cs.semgis.arqextension.test.util.SampleRasters;
import io.github.galbiston.geosparql_jena.implementation.datatype.WKTDatatype;
import io.github.galbiston.geosparql_jena.implementation.datatype.raster.HexWKBRastDatatype;

public class DistanceSphereTest extends SampleRasters {

	public static final String testGeom="LINESTRING(77.29 29.07,77.42 29.26,77.27 29.31,77.29 29.07)";
	
	public static final String testGeom2="LINESTRING(5 5 ,10 10)";
	
	public static final String result="POINT(5 5)";
	
	@Test
	public void testDistanceSphere() {
        NodeValue geometryLiteral = NodeValue.makeNode(testGeom, WKTDatatype.INSTANCE);
        NodeValue geometryLiteral2 = NodeValue.makeNode(testGeom, WKTDatatype.INSTANCE);
        DistanceSphere instance=new DistanceSphere();
        NodeValue expResult = NodeValue.makeDouble(0.);
        NodeValue result = instance.exec(geometryLiteral,geometryLiteral2);
        assertEquals(expResult, result);
	}
	
	@Test
	public void testDistanceSphere2() {
        NodeValue geometryLiteral = NodeValue.makeNode(testGeom, WKTDatatype.INSTANCE);
        NodeValue geometryLiteral2 = NodeValue.makeNode(testGeom2, WKTDatatype.INSTANCE);
        DistanceSphere instance=new DistanceSphere();
        NodeValue expResult = NodeValue.makeDouble(7269372.186370237e0);
        NodeValue result = instance.exec(geometryLiteral,geometryLiteral2);
        System.out.println(result);
        assertEquals(expResult, result);
	}
	
	@Test
	public void testDistanceSphereRaster() {
		NodeValue covLiteral = NodeValue.makeNode(wkbString1, HexWKBRastDatatype.INSTANCE);
		NodeValue covLiteral2 = NodeValue.makeNode(wkbString1, HexWKBRastDatatype.INSTANCE);
		DistanceSphere instance=new DistanceSphere();
        NodeValue expResult = NodeValue.makeDouble(1);
        NodeValue result = instance.exec(covLiteral,covLiteral2);
        assertEquals(expResult, result);
	}
	
	@Test
	public void testDistanceSphereRaster2() {
		NodeValue covLiteral = NodeValue.makeNode(wkbString1, HexWKBRastDatatype.INSTANCE);
		NodeValue covLiteral2 = NodeValue.makeNode(wkbString4, HexWKBRastDatatype.INSTANCE);
		DistanceSphere instance=new DistanceSphere();
        NodeValue expResult = NodeValue.makeDouble(0);
        NodeValue result = instance.exec(covLiteral,covLiteral2);
        assertEquals(expResult, result);
	}
	
}
