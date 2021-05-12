package de.hsmainz.cs.semgis.arqextension.test.geometry.attribute;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

import io.github.galbiston.geosparql_jena.implementation.GeometryWrapperFactory;
import io.github.galbiston.geosparql_jena.implementation.datatype.WKTDatatype;
import de.hsmainz.cs.semgis.arqextension.geometry.attribute.CompactnessRatio;

public class CompactnessRatioTest {

	public static final String testGeometry="GEOMETRYCOLLECTION(POINT(0 0))";
	
	@Test
	public void testCompactnessRatio() throws ParseException {
        CompactnessRatio instance=new CompactnessRatio();
        List<Coordinate> coords=new LinkedList<Coordinate>();
        coords.add(new Coordinate(0.,0.)); 
        WKTReader reader=new WKTReader();
        Geometry geom=reader.read(testGeometry);
        NodeValue input=GeometryWrapperFactory.createGeometry(geom, WKTDatatype.URI).asNodeValue();
        NodeValue expResult = GeometryWrapperFactory.createPoint(coords.get(0), WKTDatatype.URI).asNodeValue();
        NodeValue result = instance.exec(input);
        assertEquals(expResult, result);
	}
	
}
