package com.fjmilens3.fop.opendocument.utilities;

import org.apache.fop.fo.Constants;
import org.apache.fop.fo.properties.CommonFont;
import org.apache.fop.fo.properties.CommonTextDecoration;
import org.odftoolkit.simple.style.Font;
import org.odftoolkit.simple.style.StyleTypeDefinitions;

/**
 * Utility class for common operations on font and text properties involved in the FOP to ODT generation.
 *
 * @author Frederick John Milens III
 */
public final class ODTFontUtilities {

    /**
     * Private constructor for utility class.
     */
    private ODTFontUtilities() {
    }

    /**
     * Calculates the font size in points from a {@link CommonFont} object.
     *
     * @param properties The {@link CommonFont} properties.
     * @return The size in points.
     */
    private static double calculateFontSizeInPoints(CommonFont properties) {
        return properties.getFontSize().getValue() / 1000.0;
    }

    /**
     * Calculates the {@link StyleTypeDefinitions.FontStyle} from a {@link CommonFont} object.
     *
     * @param properties The {@link CommonFont} properties.
     * @return The font style.
     */
    private static StyleTypeDefinitions.FontStyle calculateFontStyle(CommonFont properties) {
        switch (properties.getFontWeight()) {
            case Constants.EN_700:
            case Constants.EN_800:
            case Constants.EN_900:
                return properties.getFontStyle() == Constants.EN_ITALIC ? StyleTypeDefinitions.FontStyle.BOLDITALIC : StyleTypeDefinitions.FontStyle.BOLD;
            default:
                return properties.getFontStyle() == Constants.EN_ITALIC ? StyleTypeDefinitions.FontStyle.ITALIC : StyleTypeDefinitions.FontStyle.REGULAR;
        }
    }

    /**
     * Calculates the {@link org.odftoolkit.simple.style.StyleTypeDefinitions.TextLinePosition} for the specified
     * {@link org.apache.fop.fo.properties.CommonTextDecoration}. This method only supports linethrough and underline
     * since overline is not yet supported by the ODFDOM Simple API. All other decorations will be ignored.
     * <p/>
     * Note that since the {@link org.apache.fop.fo.properties.CommonTextDecoration} is null for many FO elements, an
     * additional null check is performed in order to render the method safe for such situations.
     *
     * @param decoration The {@link org.apache.fop.fo.properties.CommonTextDecoration}.
     * @return The corresponding {@link org.odftoolkit.simple.style.StyleTypeDefinitions.TextLinePosition}.
     */
    public static StyleTypeDefinitions.TextLinePosition calculateTextLineStyle(CommonTextDecoration decoration) {
        if (decoration != null) {
            if (decoration.hasLineThrough() && decoration.hasUnderline()) {
                return StyleTypeDefinitions.TextLinePosition.THROUGHUNDER;
            } else if (decoration.hasLineThrough()) {
                return StyleTypeDefinitions.TextLinePosition.THROUGH;
            } else if (decoration.hasUnderline()) {
                return StyleTypeDefinitions.TextLinePosition.UNDER;
            }
        }
        return StyleTypeDefinitions.TextLinePosition.REGULAR;
    }

    /**
     * Calculates the horizontal alignment type for the ODT document based on the text align constant from Apache FOP.
     * This method supports {@link Constants#EN_CENTER}, {@link Constants#EN_END}, and {@link Constants#EN_JUSTIFY}
     * with all other constants being treated as left-justification.
     *
     * @param textAlign The text alignment value from {@link Constants}.
     * @return The calculated {@link StyleTypeDefinitions.HorizontalAlignmentType}.
     */
    public static StyleTypeDefinitions.HorizontalAlignmentType calculateHorizontalAlignmentType(int textAlign) {
        switch (textAlign) {
            case Constants.EN_CENTER:
                return StyleTypeDefinitions.HorizontalAlignmentType.CENTER;
            case Constants.EN_END:
                return StyleTypeDefinitions.HorizontalAlignmentType.RIGHT;
            case Constants.EN_JUSTIFY:
                return StyleTypeDefinitions.HorizontalAlignmentType.JUSTIFY;
            default:
                return StyleTypeDefinitions.HorizontalAlignmentType.LEFT;
        }
    }

    /**
     * Calculates a new {@link Font} object's values based on the font properties contained in an Apache FOP
     * {@link CommonFont} instance and its associated {@link java.awt.Color}.
     *
     * @param properties The font properties.
     * @param color      The font color.
     * @return The new {@link Font} instance for these properties.
     */
    public static Font calculateFont(CommonFont properties, java.awt.Color color) {
        return new Font(properties.getFirstFontFamily(),
                ODTFontUtilities.calculateFontStyle(properties),
                ODTFontUtilities.calculateFontSizeInPoints(properties),
                ODTColorUtilities.calculateColor(color));
    }
}
