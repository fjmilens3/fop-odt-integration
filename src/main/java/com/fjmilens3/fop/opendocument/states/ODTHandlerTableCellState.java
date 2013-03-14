package com.fjmilens3.fop.opendocument.states;

import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.text.Paragraph;
import org.odftoolkit.simple.text.list.List;

/**
 * {@link ODTHandlerState} representing the processing of a table cell in the document.
 *
 * @author Frederick John Milens III
 */
final class ODTHandlerTableCellState extends ODTHandlerState {

    /**
     * The {@link Cell} associated with this state.
     */
    private Cell cell;

    /**
     * Constructor.
     *
     * @param parent The parent state.
     * @param cell The cell associated with this state.
     */
    public ODTHandlerTableCellState(ODTHandlerState parent, Cell cell) {
        super(parent);
        this.cell = cell;
    }

    /**
     * Returns true to indicate this is a table cell state.
     *
     * @return true
     */
    @Override
    public boolean isTableCellState() {
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
     * Returns a new {@link Paragraph} created by this state.
     *
     * @return The {@link Paragraph}.
     */
    @Override
    public Paragraph newParagraph() {
        return cell.addParagraph("");
    }

    /**
     * Returns a new {@link List} created by this state.
     *
     * @return The {@link List}.
     */
    @Override
    public List newList() {
        return cell.addList();
    }
}
