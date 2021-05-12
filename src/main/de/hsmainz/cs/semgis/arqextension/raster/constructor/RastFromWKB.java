package de.hsmainz.cs.semgis.arqextension.raster.constructor;

import java.io.IOException;

import org.apache.jena.datatypes.DatatypeFormatException;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase1;
import org.apache.sis.coverage.grid.GridCoverage;
import org.geotoolkit.coverage.wkb.WKBRasterReader;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.util.FactoryException;

import io.github.galbiston.geosparql_jena.implementation.datatype.raster.CoverageWrapper;
import io.github.galbiston.geosparql_jena.implementation.datatype.raster.HexWKBRastDatatype;

public class RastFromWKB extends FunctionBase1 {
	

	@Override
	public NodeValue exec(NodeValue arg0) {
        try {
            String wkbstring=arg0.getString();
    		WKBRasterReader reader=new WKBRasterReader();
    		GridCoverage coverage=reader.readCoverage(wkbstring.getBytes(),null);
    		CoverageWrapper wrapper=CoverageWrapper.createCoverage(coverage,null , HexWKBRastDatatype.URI);
    		return wrapper.asNodeValue();
            
        } catch (DatatypeFormatException ex) {
            throw new ExprEvalException(ex.getMessage(), ex);
        } catch (NoSuchAuthorityCodeException e) {
			// TODO Auto-generated catch block
        	throw new ExprEvalException(e.getMessage(), e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
        	throw new ExprEvalException(e.getMessage(), e);
		} catch (FactoryException e) {
			// TODO Auto-generated catch block
        	throw new ExprEvalException(e.getMessage(), e);
		}
	}


}
