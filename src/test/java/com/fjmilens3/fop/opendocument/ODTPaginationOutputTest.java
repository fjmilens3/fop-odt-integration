package com.fjmilens3.fop.opendocument;

import org.junit.Test;

/**
 * Test cases using some of the pagination .fo examples from Apache FOP.
 *
 * @author Frederick John Milens III
 */
public class ODTPaginationOutputTest {

    /**
     * Generates the output files for the pagination/basic2.fo test case.
     *
     * @throws Exception If an error occurs.
     */
    @Test
    public void testPaginationSimpleFormattingObjects() throws Exception {
        ODTOutputTestUtilities.generateTestCaseOutput("pagination/basic2");
    }
}
