package com.fjmilens3.fop.opendocument.states;

import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.text.Footer;
import org.odftoolkit.simple.text.Paragraph;
import org.odftoolkit.simple.text.list.List;

/**
 * {@link ODTHandlerState} for the state when the footer static content is being processed in the document.
 *
 * @author Frederick John Milens III
 */
final class ODTHandlerFooterState extends ODTHandlerState {

    /**
     * The {@link Footer} associated with this state.
     */
    private Footer footer;

    /**
     * The {@link Cell} that actually represents the content of the footer.
     */
    private Cell footerCell;

    /**
     * Constructor.
     *
     * @param parent The parent state.
     * @param footer The footer associated with this state.
     */
    public ODTHandlerFooterState(ODTHandlerState parent, Footer footer) {
        super(parent);
        this.footer = footer;
    }

    /**
     * Returns true to indicate that this is a footer state.
     *
     * @return true
     */
    @Override
    public boolean isFooterState() {
        return true;
    }

    /**
     * Returns true to indicate that this state can create new paragraphs.
     *
     * @return true
     */
    @Override
    public boolean isParagraphFactory() {
        return true;
    }

    /**
     * Returns true to indicate that this state can create new lists.
     *
     * @return true
     */
    @Override
    public boolean isListFactory() {
        return true;
    }

    /**
     * Returns a new paragraph created from the table cell in the page footer.
     *
     * @return The new {@link Paragraph}.
     */
    @Override
    public Paragraph newParagraph() {
        return getFooterCell().addParagraph("");
    }

    /**
     * Returns a new list created from the table cell in the page footer.
     *
     * @return The new {@link List}.
     */
    @Override
    public List newList() {
        return getFooterCell().addList();
    }

    /**
     * Returns the footer cell associated with this header.
     *
     * @return The footer cell.
     */
    private Cell getFooterCell() {
        if (footerCell == null) {
            footerCell = footer.addTable(1, 1).getCellByPosition(0, 0);
        }
        return footerCell;
    }
}
