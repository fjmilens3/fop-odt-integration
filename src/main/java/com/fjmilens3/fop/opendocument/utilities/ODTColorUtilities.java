package com.fjmilens3.fop.opendocument.utilities;

import org.odftoolkit.odfdom.type.Color;

/**
 * Utility class for common operations on color properties involved in the FOP to ODT generation.
 *
 * @author Frederick John Milens III
 */
public final class ODTColorUtilities {

    /**
     * Private constructor for utility class.
     */
    private ODTColorUtilities() {
    }

    /**
     * Calculates an ODT {@link Color} from a Java {@link java.awt.Color}.
     *
     * @param color The Java {@link java.awt.Color}.
     * @return The resulting ODT {@link Color}.
     */
    public static Color calculateColor(java.awt.Color color) {
        if (color != null) {
            return new Color(color);
        }
        return null;
    }

    /**
     * Calculates a hex string representing a color from a Java {@link java.awt.Color}.
     *
     * @param color The Java {@link java.awt.Color}.
     * @return The resulting RGB hex string for the color.
     */
    public static String calculateColorAsHex(java.awt.Color color) {
        if (color != null) {
            return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
        }
        return null;
    }
}
