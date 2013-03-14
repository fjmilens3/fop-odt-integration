package com.fjmilens3.fop.opendocument.states;

import org.odftoolkit.simple.TextDocument;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Column;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;
import org.odftoolkit.simple.text.Footer;
import org.odftoolkit.simple.text.Header;
import org.odftoolkit.simple.text.Paragraph;
import org.odftoolkit.simple.text.list.List;
import org.odftoolkit.simple.text.list.ListItem;

/**
 * State manager for {@link ODTHandlerState} instances. Internally this is implemented in a manner similar to a linked
 * list with each state keeping a reference to its parent.
 *
 * @author Frederick John Milens III
 */
public class ODTHandlerStateManager {

    /**
     * The current handler state.
     */
    protected ODTHandlerState currentState;

    /**
     * Pushes a block state onto the state manager.
     *
     * @param paragraph The paragraph associated with the new state.
     */
    public void pushBlockState(Paragraph paragraph) {
        currentState = new ODTHandlerBlockState(currentState, paragraph);
    }

    /**
     * Pushes a document state onto the state manager.
     *
     * @param document The document associated with the new state.
     */
    public void pushDocumentState(TextDocument document) {
        currentState = new ODTHandlerDocumentState(document);
    }

    /**
     * Pushes a header state onto the state manager.
     *
     * @param header The header associated with the new state.
     */
    public void pushHeaderState(Header header) {
        currentState = new ODTHandlerHeaderState(currentState, header);
    }

    /**
     * Pushes a footer state onto the state manager.
     *
     * @param footer The footer associated with the new state.
     */
    public void pushFooterState(Footer footer) {
        currentState = new ODTHandlerFooterState(currentState, footer);
    }

    /**
     * Pushes a list item state onto the state manager.
     *
     * @param listItem The list item associated with the new state.
     */
    public void pushListItemState(ListItem listItem) {
        currentState = new ODTHandlerListItemState(currentState, listItem);
    }

    /**
     * Pushes a list label state onto the state manager.
     */
    public void pushListLabelState() {
        currentState = new ODTHandlerListLabelState(currentState);
    }

    /**
     * Pushes a list state onto the state manager.
     *
     * @param list The list associated with the new state.
     */
    public void pushListState(List list) {
        currentState = new ODTHandlerListState(currentState, list);
    }

    /**
     * Pushes a table cell state onto the state manager.
     *
     * @param cell The cell associated with the new state.
     */
    public void pushTableCellState(Cell cell) {
        currentState = new ODTHandlerTableCellState(currentState, cell);
    }

    /**
     * Pushes a table column state onto the state manager.
     *
     * @param column The column associated with the new state.
     */
    public void pushTableColumnState(Column column) {
        currentState = new ODTHandlerTableColumnState(currentState, column);
    }

    /**
     * Pushes a table row state onto the state manager.
     *
     * @param row The row associated with the new state.
     */
    public void pushTableRowState(Row row) {
        currentState = new ODTHandlerTableRowState(currentState, row);
    }

    /**
     * Pushes a table state onto the state manager.
     *
     * @param table The table associated with the new state.
     */
    public void pushTableState(Table table) {
        currentState = new ODTHandlerTableState(currentState, table);
    }

    /**
     * Pops the current state from the stack, running any disposal logic that is necessary.
     */
    public void popState() {
        currentState.dispose();
        currentState = currentState.getParent();
    }

    /**
     * Returns the current {@link ODTHandlerState}.
     *
     * @return The current {@link ODTHandlerState}.
     */
    public ODTHandlerState getCurrentState() {
        return currentState;
    }

    /**
     * Returns a boolean indicating whether output should be skipped or suppressed.  This is currently required as a
     * special case for list labels since these are not supported by the ODF API, and we don't want to emit any content
     * under the list labels in the FO data.
     *
     * @return A boolean indicating if we're skipping output for now because of being inside a list label.
     */
    public boolean isProcessingListLabel() {
        ODTHandlerState state = currentState;
        while (state != null) {
            if (state.isListLabelState()) {
                return true;
            }
            state = state.getParent();
        }
        return false;
    }
}