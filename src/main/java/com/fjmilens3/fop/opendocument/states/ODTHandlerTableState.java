package com.fjmilens3.fop.opendocument.states;

import org.odftoolkit.simple.table.Column;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;

/**
 * {@link ODTHandlerState} representing the processing of a table in the document.
 *
 * @author Frederick John Milens III
 */
final class ODTHandlerTableState extends ODTHandlerState {

    /**
     * The {@link Table} associated with this state.
     */
    private Table table;

    /**
     * The number of columns that have been "created" by this state.
     */
    private int createdColumns = 0;

    /**
     * The number of rows that have been "created" by this state.
     */
    private int createdRows = 0;

    /**
     * Constructor.
     *
     * @param parent The parent state.
     * @param table The table associated with this state.
     */
    public ODTHandlerTableState(ODTHandlerState parent, Table table) {
        super(parent);
        this.table = table;
    }

    /**
     * Performs necessary cleanup at the end of generating a table. In particular, the extraneous final row in the table
     * that must be added to reliably implement cell merges for multirow cells must be deleted from the table.
     */
    @Override
    public void dispose() {
        table.removeRowsByIndex(table.getRowCount() - 1, 1);
    }

    /**
     * Returns true to indicate this is a table state.
     *
     * @return true
     */
    @Override
    public boolean isTableState() {
        return true;
    }

    /**
     * Returns the table associated with this state.
     *
     * @return The {@link Table}.
     */
    @Override
    public Table getTable() {
        return table;
    }

    /**
     * Returns a new table column (or the initial existing table column on the first call to the method).
     *
     * @return The {@link Column}.
     */
    @Override
    public Column newTableColumn() {
        return table.getColumnByIndex(createdColumns++);
    }

    /**
     * Returns a new table row (or the initial existing table row on the first call to the method).
     *
     * @return The {@link Row}.
     */
    @Override
    public Row newTableRow() {
        return table.getRowByIndex(createdRows++);
    }
}
