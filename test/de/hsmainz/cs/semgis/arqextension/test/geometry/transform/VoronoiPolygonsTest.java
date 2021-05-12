package de.hsmainz.cs.semgis.arqextension.test.geometry.transform;

import static org.junit.Assert.assertEquals;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.io.ParseException;

import de.hsmainz.cs.semgis.arqextension.geometry.transform.VoronoiPolygons;
import io.github.galbiston.geosparql_jena.implementation.datatype.WKTDatatype;

public class VoronoiPolygonsTest {

	public static final String testGeometry="GEOMETRYCOLLECTION(POINT(0 0))";

	public static final String res="POINT(0 0)";
		
		/*@Test
		public void testVoronoiPolygons() throws ParseException {
	        VoronoiPolygons instance=new VoronoiPolygons();
	        NodeValue input=NodeValue.makeNode(testGeometry, WKTDatatype.INSTANCE);
	        NodeValue expResult = NodeValue.makeNode(res, WKTDatatype.INSTANCE);
	        NodeValue result = instance.exec(input,NodeValue.makeInteger(0),NodeValue.makeInteger(0));
	        assertEquals(expResult, result);
		}*/
	
}
