package com.fjmilens3.fop.opendocument;

import org.junit.Test;

/**
 * Test cases using some of the basic .fo examples from Apache FOP.
 *
 * @author Frederick John Milens III
 */
public class ODTBasicOutputTest {

    /**
     * Generates the output files for the basic/alignment.fo test case.
     *
     * @throws Exception If an error occurs.
     */
    @Test
    public void testBasicAlignmentFormattingObjects() throws Exception {
        ODTOutputTestUtilities.generateTestCaseOutput("basic/alignment");
    }

    /**
     * Generates the output files for the basic/border.fo test case.
     *
     * @throws Exception If an error occurs.
     */
    @Test
    public void testBasicBorderFormattingObjects() throws Exception {
        ODTOutputTestUtilities.generateTestCaseOutput("basic/border");
    }

    /**
     * Generates the output files for the basic/character.fo test case.
     *
     * @throws Exception If an error occurs.
     */
    @Test
    public void testBasicCharacterFormattingObjects() throws Exception {
        ODTOutputTestUtilities.generateTestCaseOutput("basic/character");
    }

    /**
     * Generates the output files for the basic/fonts.fo test case.
     *
     * @throws Exception If an error occurs.
     */
    @Test
    public void testBasicFontsFormattingObjects() throws Exception {
        ODTOutputTestUtilities.generateTestCaseOutput("basic/fonts");
    }

    /**
     * Generates the output files for the basic/leader.fo test case.
     *
     * @throws Exception If an error occurs.
     */
    @Test
    public void testBasicLeaderFormattingObjects() throws Exception {
        ODTOutputTestUtilities.generateTestCaseOutput("basic/leader");
    }

    /**
     * Generates the output files for the basic/link.fo test case.
     *
     * @throws Exception If an error occurs.
     */
    @Test
    public void testBasicLinkFormattingObjects() throws Exception {
        ODTOutputTestUtilities.generateTestCaseOutput("basic/link");
    }

    /**
     * Generates the output files for the basic/list.fo test case.
     *
     * @throws Exception If an error occurs.
     */
    @Test
    public void testBasicListFormattingObjects() throws Exception {
        ODTOutputTestUtilities.generateTestCaseOutput("basic/list");
    }

    /**
     * Generates the output files for the normal.fo test case.
     *
     * @throws Exception If an error occurs.
     */
    @Test
    public void testBasicNormalFormattingObjects() throws Exception {
        ODTOutputTestUtilities.generateTestCaseOutput("basic/normal");
    }

    /**
     * Generates the output files for the basic/basic.fo test case.
     *
     * @throws Exception If an error occurs.
     */
    @Test
    public void testBasicSimpleFormattingObjects() throws Exception {
        ODTOutputTestUtilities.generateTestCaseOutput("basic/simple");
    }

    /**
     * Generates the output files for the table.fo test case.
     *
     * @throws Exception If an error occurs.
     */
    @Test
    public void testBasicTableFormattingObjects() throws Exception {
        ODTOutputTestUtilities.generateTestCaseOutput("basic/table");
    }

    /**
     * Generates the output files for the textdeko.fo test case.
     *
     * @throws Exception If an error occurs.
     */
    @Test
    public void testBasicTextDecorationFormattingObjects() throws Exception {
        ODTOutputTestUtilities.generateTestCaseOutput("basic/textdeko");
    }
}
