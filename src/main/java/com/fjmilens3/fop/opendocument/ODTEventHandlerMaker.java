package com.fjmilens3.fop.opendocument;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.fo.FOEventHandler;
import org.apache.fop.render.AbstractFOEventHandlerMaker;
import org.odftoolkit.simple.TextDocument;

import java.io.OutputStream;

/**
 * EventHandlerMaker for ODT event handlers implemented as part of the integration for ODT output from FOP.
 *
 * @author Frederick John Milens III
 */
public final class ODTEventHandlerMaker extends AbstractFOEventHandlerMaker {

    /**
     * The MIME type for an OpenOffice/LibreOffice ODT file.
     */
    public static final String MIME_TYPE = "application/vnd.oasis.opendocument.text";

    /**
     * Returns a new {@link ODTHandler} instance for OpenDocument Text files.
     *
     * @param foUserAgent  The {@link FOUserAgent} for the output.
     * @param outputStream The {@link OutputStream} for the handler's output.
     * @return A newly-instantiated {@link ODTHandler} for an OpenDocument Text file.
     * @throws FOPException If an error occurs while creating the new {@link FOEventHandler}.
     */
    @Override
    public ODTHandler makeFOEventHandler(FOUserAgent foUserAgent, OutputStream outputStream) throws FOPException {
        try {
            return new ODTHandler(foUserAgent, outputStream, TextDocument.newTextDocument());
        } catch (Exception e) {
            throw new FOPException("Unable to create instance of ODF Simple TextDocument: " + e.toString(), e);
        }
    }

    /**
     * Returns that this EventHandlerMaker requires an {@link OutputStream}.
     *
     * @return true
     */
    @Override
    public boolean needsOutputStream() {
        return true;
    }

    /**
     * Returns the supported MIME types for this handler ("application/vnd.oasis.opendocument.text").
     *
     * @return The supported MIME type.
     */
    @Override
    public String[] getSupportedMimeTypes() {
        return new String[]{MIME_TYPE};
    }
}
