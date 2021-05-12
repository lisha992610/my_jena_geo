package de.hsmainz.cs.semgis.arqextension.test.geometry.attribute;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Coordinate;

import de.hsmainz.cs.semgis.arqextension.geometry.attribute.MinimumRectangle;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapperFactory;
import io.github.galbiston.geosparql_jena.implementation.datatype.WKTDatatype;

public class MinimumRectangleTest {

	public static final String testPolygon="POLYGON ((0 0, 1 0, 1 1, 0.5 3.2e-4, 0 0))";
	
	@Test
	public void testMinimumRectangle() {
        NodeValue geometryLiteral = NodeValue.makeNode(testPolygon, WKTDatatype.INSTANCE);
        MinimumRectangle instance=new MinimumRectangle();
        //LINESTRING(0.5 0.00032,0.5 0)
        List<Coordinate> coords=new LinkedList<Coordinate>();
        coords.add(new Coordinate(0.,0.));
        coords.add(new Coordinate(0.5,-0.5));
        coords.add(new Coordinate(1.5,0.5));
        coords.add(new Coordinate(1.,1.));
        coords.add(new Coordinate(0.,0.));
        NodeValue expResult = GeometryWrapperFactory.createPolygon(coords, WKTDatatype.URI).asNodeValue();
        NodeValue result = instance.exec(geometryLiteral);
        assertEquals(expResult, result);
	}
	
}
