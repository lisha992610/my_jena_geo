package de.hsmainz.cs.semgis.arqextension.test.polygon.constructor;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Coordinate;

import de.hsmainz.cs.semgis.arqextension.polygon.constructor.PolygonFromText;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapperFactory;
import io.github.galbiston.geosparql_jena.implementation.datatype.WKTDatatype;

public class PolygonFromTextTest {

	public static final String testPolygon="POLYGON((-71.1776585052917 42.3902909739571,-71.1776820268866 42.3903701743239,-71.1776063012595 42.3903825660754,-71.1775826583081 42.3903033653531,-71.1776585052917 42.3902909739571))";
	
	/*@Test
	public void testPolygonFromText() {
        PolygonFromText instance=new PolygonFromText();
        List<Coordinate> coords=new LinkedList<Coordinate>();
        coords.add(new Coordinate(-71.1776585052917, 42.3902909739571));
        coords.add(new Coordinate(-71.1776820268866, 42.3903701743239));
        coords.add(new Coordinate(-71.1776063012595, 42.3903825660754));
        coords.add(new Coordinate(-71.1775826583081, 42.3903033653531));
        coords.add(new Coordinate(-71.1776585052917, 42.3902909739571));
        NodeValue expResult = NodeValue.makeNode(testPolygon, WKTDatatype.INSTANCE);
        NodeValue result = instance.exec(NodeValue.makeString(testPolygon));
        assertEquals(expResult, result);
	}*/
	
}
