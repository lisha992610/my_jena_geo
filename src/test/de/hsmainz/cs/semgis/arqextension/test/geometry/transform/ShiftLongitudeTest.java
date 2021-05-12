package de.hsmainz.cs.semgis.arqextension.test.geometry.transform;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Coordinate;

import de.hsmainz.cs.semgis.arqextension.geometry.transform.ShiftLongitude;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapperFactory;
import io.github.galbiston.geosparql_jena.implementation.datatype.WKTDatatype;

public class ShiftLongitudeTest {

	public static final String testPolygon="POLYGON((-340 0 2,0 5 2,5 0 2,-340 0 2))";
	
	@Test
	public void testFlipCoordinates() {
        NodeValue geometryLiteral = NodeValue.makeNode(testPolygon, WKTDatatype.INSTANCE);
        ShiftLongitude instance=new ShiftLongitude();
        List<Coordinate> coords=new LinkedList<Coordinate>();
        coords.add(new Coordinate(20,0));
        coords.add(new Coordinate(0,5));
        coords.add(new Coordinate(5,0));
        coords.add(new Coordinate(20,0));
        //        POLYGON((0 0,0 5,5 0,0 0),(1 1,3 1,1 3,1 1))
        NodeValue expResult = GeometryWrapperFactory.createPolygon(coords, WKTDatatype.URI).asNodeValue();
        NodeValue result = instance.exec(geometryLiteral);
        assertEquals(expResult, result);
	}
	
}
