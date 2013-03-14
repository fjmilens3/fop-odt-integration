package com.fjmilens3.fop.opendocument;

import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Utility class for FOP-ODT test cases.
 *
 * @author Frederick John Milens III
 */
public final class ODTOutputTestUtilities {

    /**
     * The name of the output directory.
     */
    private static final File OUTPUT_DIRECTORY = new File("./target/generated-test-odt/");

    /**
     * Private constructor for utility class.
     */
    private ODTOutputTestUtilities() {
    }

    /**
     * Generates the output files for a particular test case. The output files will be the .odt
     * and .pdf files generated from the .fo file with the base name specified.
     *
     * @param baseName The base name of the .fo file (without file extension).
     * @throws Exception If an error occurs.
     */
    public static void generateTestCaseOutput(String baseName) throws Exception {
        final String foName = baseName + ".fo";
        generateOutput(ODTEventHandlerMaker.MIME_TYPE, foName, new File(OUTPUT_DIRECTORY, baseName + ".odt"));
        generateOutput(MimeConstants.MIME_PDF, foName, new File(OUTPUT_DIRECTORY, baseName + ".pdf"));
    }

    /**
     * Generates an output file with the specified filename using the FOP file with the specified name as input.
     *
     * @param mimeType The MIME type for the output.
     * @param fopFile  The FOP file as input.
     * @param outFile  The output file as output.
     * @throws Exception If an error occurs during the generation of the ODT from the FOP.
     */
    private static void generateOutput(String mimeType, String fopFile, File outFile) throws Exception {
        FopFactory fopFactory = FopFactory.newInstance();
        fopFactory.getRendererFactory().addFOEventHandlerMaker(new ODTEventHandlerMaker());
        outFile.getParentFile().mkdirs();
        OutputStream out = new BufferedOutputStream(new FileOutputStream(outFile));
        try {
            Fop fop = fopFactory.newFop(mimeType, out);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            Source src = new StreamSource(ODTOutputTestUtilities.class.getResourceAsStream("/fo/" + fopFile));
            Result res = new SAXResult(fop.getDefaultHandler());
            transformer.transform(src, res);
        } finally {
            out.close();
        }
    }
}
