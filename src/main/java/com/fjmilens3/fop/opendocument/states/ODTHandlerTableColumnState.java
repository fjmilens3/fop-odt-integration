package com.fjmilens3.fop.opendocument.states;

import org.odftoolkit.simple.table.Column;

/**
 * {@link ODTHandlerState} representing the processing of a table column in the document.
 *
 * @author Frederick John Milens III
 */
final class ODTHandlerTableColumnState extends ODTHandlerState {

    /**
     * The {@link Column} associated with this state.
     */
    private Column column;

    /**
     * Constructor.
     *
     * @param parent The parent state.
     * @param column The column associated with this state.
     */
    public ODTHandlerTableColumnState(ODTHandlerState parent, Column column) {
        super(parent);
        this.column = column;
    }

    /**
     * Returns true indicating that this is a table column state.
     *
     * @return true
     */
    @Override
    public boolean isTableColumnState() {
        return true;
    }
}
