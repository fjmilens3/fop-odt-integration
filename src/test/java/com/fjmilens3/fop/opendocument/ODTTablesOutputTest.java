package com.fjmilens3.fop.opendocument;

import org.junit.Test;

/**
 * Test cases using some of the tables .fo examples from Apache FOP.
 *
 * @author Frederick John Milens III
 */
public class ODTTablesOutputTest {

    /**
     * Generates the output files for the tables/headfoot.fo test case.
     *
     * @throws Exception If an error occurs.
     */
    @Test
    public void testTablesHeaderFooterFormattingObjects() throws Exception {
        ODTOutputTestUtilities.generateTestCaseOutput("tables/headfoot");
    }
}
