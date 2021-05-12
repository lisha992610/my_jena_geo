package de.hsmainz.cs.semgis.arqextension.raster.editor;

import java.awt.geom.AffineTransform;
import java.awt.image.renderable.ParameterBlock;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.RenderedOp;

import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase3;
import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.coverage.grid.GridGeometry;
import org.apache.sis.util.resources.Vocabulary;
import org.locationtech.jts.geom.Envelope;
import org.locationtech.jts.geom.GeometryFactory;
import org.opengis.parameter.InvalidParameterValueException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import io.github.galbiston.geosparql_jena.implementation.datatype.raster.CoverageWrapper;

public class SetScale extends FunctionBase3{

	@Override
	public NodeValue exec(NodeValue v1, NodeValue v2, NodeValue v3) {
		CoverageWrapper wrapper=CoverageWrapper.extract(v1);
		GridCoverage raster=wrapper.getXYGeometry();
		Double xScale=v2.getDouble();
		Double yScale=v3.getDouble();
		if (xScale <= 0) {
            throw new InvalidParameterValueException("xScale must be greater than zero", "xScale",
                    xScale);
        }

        if (yScale <= 0) {
            throw new InvalidParameterValueException("yScale must be greater than zero", "yScale",
                    yScale);
        }

        //this.initilizeVariables(raster);

        final int numBands = raster.getSampleDimensions().size();

        Envelope extent = (Envelope) raster.getGridGeometry().getEnvelope();
        GridGeometry gridGeometry2D = raster.getGridGeometry();
		throw new UnsupportedOperationException("Not yet implemented");
        /*AffineTransform gridToWorld = (AffineTransform) gridGeometry2D.getGridToCRS();
        Double cellSizeX = Math.abs(gridToWorld.getScaleX()) * xScale;
        Double cellSizeY = Math.abs(gridToWorld.getScaleY()) * yScale;

        // 1. The output size is multiplied by the scale factor for both the x and y directions. The
        // number of columns and rows stays the same in this process, but the cell size is
        // multiplied by the scale factor.
        // 2. The scale factor must be positive.
        // 3. A scale factor greater than one means the image will be rescaled to a larger
        // dimension,
        // resulting in a larger extent because of a larger cell size.
        // 4. A scale factor less than one means the image will be rescaled to a smaller dimension,
        // resulting in a smaller extent because of a smaller cell size.

        // Rescale extent

        /*final PlanarImage inputImage = (PlanarImage) raster.getRenderedImage();
        double maxX = extent.getMinX() + (inputImage.getWidth() * cellSizeX);
        double maxY = extent.getMinY() + (inputImage.getHeight() * cellSizeY);

        CoordinateReferenceSystem crs = raster.getCoordinateReferenceSystem();
        GeometryFactory fac=new GeometryFactory();
        Envelope Extent = new Envelope(extent.getMinX(), maxX, extent.getMinY(), maxY);

        if (numBands == 1) {
        	GridCoverageFactory fact=new GridCoverageFactory();
            return createGridCoverage(raster.getName(), inputImage);
        } else {
            List<SampleDimension> bands = raster.getSampleDimensions();

            Set<Number> nodataValues = bands.get(0).getNoDataValues();
            Object noData = nodataValues == null ? Integer.MAX_VALUE : nodataValues[0];

            Map properties = raster.getProperties();
            properties.put(Vocabulary.formatInternational(VocabularyKeys.NODATA), noData);
            properties.put("GC_NODATA", noData);

            GridCoverageFactory factory = CoverageFactoryFinder.getGridCoverageFactory(null);
            return factory.create(raster.getName(), inputImage, Extent, bands, null,
                    properties);
        }*/
	}

}
