package com.fjmilens3.fop.opendocument.states;

import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.text.Header;
import org.odftoolkit.simple.text.Paragraph;
import org.odftoolkit.simple.text.list.List;

/**
 * {@link ODTHandlerState} for the state when the header static content is being processed in the document.
 *
 * @author Frederick John Milens III
 */
final class ODTHandlerHeaderState extends ODTHandlerState {

    /**
     * The {@link Header} associated with this state.
     */
    private Header header;

    /**
     * The {@link Cell} that actually represents the content of the header.
     */
    private Cell headerCell;

    /**
     * Constructor.
     *
     * @param parent The parent state.
     * @param header The header associated with this state.
     */
    public ODTHandlerHeaderState(ODTHandlerState parent, Header header) {
        super(parent);
        this.header = header;
    }

    /**
     * Returns true to indicate that this is a header state.
     *
     * @return true
     */
    @Override
    public boolean isHeaderState() {
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
     * Returns a new paragraph created from the table cell in the page header.
     *
     * @return The new {@link Paragraph}.
     */
    @Override
    public Paragraph newParagraph() {
        return getHeaderCell().addParagraph("");
    }

    /**
     * Returns a new list created from the table cell in the page header.
     *
     * @return The new {@link List}.
     */
    @Override
    public List newList() {
        return getHeaderCell().addList();
    }

    /**
     * Returns the header cell associated with this header.
     *
     * @return The header cell.
     */
    private Cell getHeaderCell() {
        if (headerCell == null) {
            headerCell = header.addTable(1, 1).getCellByPosition(0, 0);
        }
        return headerCell;
    }
}
