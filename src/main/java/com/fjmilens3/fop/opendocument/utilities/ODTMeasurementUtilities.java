package com.fjmilens3.fop.opendocument.utilities;

import org.apache.fop.datatypes.Length;
import org.apache.fop.fo.properties.Property;
import org.apache.fop.fo.properties.SpaceProperty;

/**
 * Utility class containing methods for working with measurements and conversions appropriate to the FOP to ODT
 * generation process.
 *
 * @author Frederick John Milens III
 */
public final class ODTMeasurementUtilities {

    /**
     * Private constructor for utility class.
     */
    private ODTMeasurementUtilities() {
    }

    /**
     * Converts millipoints to points.  This is often necessary because internally Apache FOP often uses millipoints as
     * the primary unit of length.
     *
     * @param millipoints The measure in millipoints.
     * @return The measure in points.
     */
    public static double convertMillipointsToPoints(double millipoints) {
        return millipoints / 1000.0;
    }

    /**
     * Converts millipoints contained in a {@link Length} instance to points.
     *
     * @param length The {@link Length}.
     * @return The measure in points.
     */
    public static double convertMillipointsToPoints(Length length) {
        return convertMillipointsToPoints(length.getValue());
    }

    /**
     * Converts millipoints contained in a {@link Property} instance to points.
     *
     * @param property The {@link Property}.
     * @return The measure in points.
     */
    public static double convertMillipointsToPoints(Property property) {
        return convertMillipointsToPoints(property.getLength());
    }

    /**
     * Converts millipoints contained in a {@link SpaceProperty} instance to points.  Internally the conversion is
     * performed using the optimum length value for the property.
     *
     * @param property The {@link SpaceProperty}.
     * @return The measure in points.
     * @see SpaceProperty#getOptimum(org.apache.fop.datatypes.PercentBaseContext)
     */
    public static double convertMillipointsToPoints(SpaceProperty property) {
        return convertMillipointsToPoints(property.getOptimum(null));
    }
}
