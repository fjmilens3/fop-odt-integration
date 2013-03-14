package com.fjmilens3.fop.opendocument.states;

import org.odftoolkit.simple.TextDocument;
import org.odftoolkit.simple.table.Table;
import org.odftoolkit.simple.text.Paragraph;
import org.odftoolkit.simple.text.list.List;

/**
 * {@link ODTHandlerState} representing the base document state at the beginning of processing a document.
 *
 * @author Frederick John Milens III
 */
final class ODTHandlerDocumentState extends ODTHandlerState {

    /**
     * The {@link TextDocument} associated with this state.
     */
    private TextDocument document;

    /**
     * Constructor.
     *
     * @param document The {@link TextDocument}.
     */
    public ODTHandlerDocumentState(TextDocument document) {
        super(null);
        this.document = document;
    }

    /**
     * Returns true to indicate this state is a document state.
     *
     * @return true
     */
    @Override
    public boolean isDocumentState() {
        return true;
    }

    /**
     * Returns true to indicate this state can create new lists.
     *
     * @return true
     */
    @Override
    public boolean isListFactory() {
        return true;
    }

    /**
     * Returns true to indicate this state can create new paragraphs.
     *
     * @return true
     */
    @Override
    public boolean isParagraphFactory() {
        return true;
    }

    /**
     * Returns true to indicate this state can create new tables.
     *
     * @return true
     */
    @Override
    public boolean isTableFactory() {
        return true;
    }

    /**
     * Returns a new {@link List} created by the document.
     *
     * @return The {@link List}.
     */
    @Override
    public List newList() {
        return document.addList();
    }

    /**
     * Returns a new {@link Paragraph} created by the document.
     *
     * @return The {@link Paragraph}.
     */
    @Override
    public Paragraph newParagraph() {
        return document.addParagraph("");
    }

    /**
     * Returns a new {@link Table} created by the document.  This table must have at least one cell and one row, with
     * an extra row at the bottom that must be removed at the end of generating the table; the latter requirement is
     * a result of weird NullPointerException issues that kept coming up when implementing cells that span multiple rows
     * in tables.
     *
     * @return The {@link Table}.
     */
    @Override
    public Table newTable() {
        return document.addTable(2, 1);
    }
}
