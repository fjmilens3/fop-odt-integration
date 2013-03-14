package com.fjmilens3.fop.opendocument;

import org.junit.Test;

/**
 * Test cases using some of the footnotes .fo examples from Apache FOP.
 *
 * @author Frederick John Milens III
 */
public class ODTFootnotesOutputTest {

    /**
     * Generates the output files for the footnotes/simple.fo test case.
     *
     * @throws Exception If an error occurs.
     */
    @Test
    public void testFootnotesSimpleFormattingObjects() throws Exception {
        ODTOutputTestUtilities.generateTestCaseOutput("footnotes/simple");
    }
}
