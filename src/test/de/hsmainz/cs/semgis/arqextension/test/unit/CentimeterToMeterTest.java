package de.hsmainz.cs.semgis.arqextension.test.unit;

import static org.junit.Assert.assertEquals;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.jupiter.api.Test;

import de.hsmainz.cs.semgis.arqextension.unit.CentimeterToMeter;

public class CentimeterToMeterTest {

	@Test
	public void testCentimeterToMeter() {
        NodeValue unitamount = NodeValue.makeDouble(100.);
        CentimeterToMeter instance=new CentimeterToMeter();
        NodeValue expResult = NodeValue.makeDouble(1.);
        NodeValue result = instance.exec(unitamount);
        System.out.println(result);
        assertEquals(expResult, result);
	}
	
}
