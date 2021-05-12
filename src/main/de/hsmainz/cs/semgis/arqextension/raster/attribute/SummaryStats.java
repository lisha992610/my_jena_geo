/** *****************************************************************************
 * Copyright (c) 2017 Timo Homburg, i3Mainz.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the BSD License
 * which accompanies this distribution, and is available at
 * https://directory.fsf.org/wiki/License:BSD_4Clause
 *
 * This project extends work by Ian Simmons who developed the Parliament Triple Store.
 * http://parliament.semwebcentral.org and published his work und BSD License as well.
 *
 *
 ****************************************************************************** */
package de.hsmainz.cs.semgis.arqextension.raster.attribute;

import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapperFactory;
import io.github.galbiston.geosparql_jena.implementation.datatype.raster.CoverageWrapper;

import java.util.List;

import org.apache.jena.sparql.engine.binding.Binding;
import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase1;
import org.apache.jena.sparql.function.FunctionBase3;
import org.apache.jena.sparql.function.FunctionEnv;
import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.geometry.Envelope2D;
import org.apache.sis.geometry.GeneralEnvelope;
import org.locationtech.jts.geom.CoordinateXY;
import org.opengis.referencing.operation.TransformException;

public class SummaryStats extends FunctionBase3 {

	@Override
	public NodeValue exec(NodeValue v1,NodeValue v2, NodeValue v3) {
		CoverageWrapper wrapper=CoverageWrapper.extract(v1);
		GridCoverage raster=wrapper.getXYGeometry();
		Integer x = v2.getInteger().intValue();
        Integer y = v3.getInteger().intValue();
        Envelope2D pixelEnvelop;
        /*
        try {
            pixelEnvelop = raster.getGridGeometry().getGridToCRS(new GeneralEnvelope(x, y, 1, 1));
            CoordinateXY coord = new CoordinateXY(pixelEnvelop.getCenterX(), pixelEnvelop.getCenterY());
            GeometryWrapper summaryWrapper = GeometryWrapperFactory.createPoint(coord, wrapper.getSrsURI(), wrapper.getRasterDatatypeURI());
            return summaryWrapper.asNodeValue();
        } catch (TransformException e) {
            return NodeValue.nvNothing;
        }*/
		throw new UnsupportedOperationException("Not yet implemented");
	}

}
