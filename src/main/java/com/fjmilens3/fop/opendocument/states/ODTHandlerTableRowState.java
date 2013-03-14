package com.fjmilens3.fop.opendocument.states;

import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Row;

/**
 * {@link ODTHandlerState} representing the processing of a table row in the document.
 *
 * @author Frederick John Milens III
 */
final class ODTHandlerTableRowState extends ODTHandlerState {

    /**
     * The {@link Row} associated with this state.
     */
    private Row row;

    /**
     * Constructor.
     *
     * @param parent The parent state.
     * @param row The row associated with this state.
     */
    public ODTHandlerTableRowState(ODTHandlerState parent, Row row) {
        super(parent);
        this.row = row;
    }

    /**
     * Returns true indicating that this is a table row state.
     *
     * @return true
     */
    @Override
    public boolean isTableRowState() {
        return true;
    }

    /**
     * Returns the table cell at the specified zero-based index in this row.
     *
     * @param index The zero-based index.
     * @return The {@link Cell}.
     */
    @Override
    public Cell getTableCell(int index) {
        return row.getCellByIndex(index);
    }
}
