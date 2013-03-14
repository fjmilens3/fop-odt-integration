package com.fjmilens3.fop.opendocument.utilities;

import org.apache.fop.fo.Constants;
import org.apache.fop.fo.properties.CommonBorderPaddingBackground;
import org.odftoolkit.odfdom.dom.attribute.table.TableBorderModelAttribute;
import org.odftoolkit.odfdom.type.Color;
import org.odftoolkit.simple.style.Border;
import org.odftoolkit.simple.style.StyleTypeDefinitions;

/**
 * Utility class for working with borders as related to the FOP to ODT generation process.
 *
 * @author Frederick John Milens III
 */
public final class ODTBorderUtilities {

    /**
     * Private constructor for utility class.
     */
    private ODTBorderUtilities() {
    }

    /**
     * Calculates the TableBorderModelAttribute value for a particular border-collapse setting.  Currently this method
     * supports {@link Constants#EN_SEPARATE} and {@link Constants#EN_COLLAPSE}.
     *
     * @param borderCollapse The border collapse value.
     * @return The matching {@link TableBorderModelAttribute.Value}.
     * @throws IllegalArgumentException If the border-collapse constant is not one of the listed values.
     */
    public static TableBorderModelAttribute.Value calculateBorderCollapse(int borderCollapse) throws IllegalArgumentException {
        switch (borderCollapse) {
            case Constants.EN_SEPARATE:
                return TableBorderModelAttribute.Value.SEPARATING;
            case Constants.EN_COLLAPSE:
                return TableBorderModelAttribute.Value.COLLAPSING;
            default:
                throw new IllegalArgumentException("Unexpected border collapse value: " + borderCollapse);
        }
    }

    /**
     * Calculates a new {@link Border} for particular properties in a {@link CommonBorderPaddingBackground} instance.
     * The specific border is represented by the FOP constants for {@link CommonBorderPaddingBackground#BEFORE} for
     * the top border, {@link CommonBorderPaddingBackground#AFTER} for the bottom border,
     * {@link CommonBorderPaddingBackground#START} for the left border, and {@link CommonBorderPaddingBackground#END}
     * for the right border.
     * <p/>
     * TODO:  Add/improve support for different border styles.
     *
     * @param common The {@link CommonBorderPaddingBackground}.
     * @param border One of {@link CommonBorderPaddingBackground#BEFORE}
     * @return The {@link Border} instance.
     */
    public static Border calculateBorder(CommonBorderPaddingBackground common, int border) {
        switch (common.getBorderStyle(border)) {
            case Constants.EN_NONE:
            case Constants.EN_HIDDEN:
                return Border.NONE;
            default:
                return new Border(new Color(common.getBorderColor(border)), common.getBorderWidth(border, false) / 1000.0, StyleTypeDefinitions.SupportedLinearMeasure.PT);
        }
    }
}
