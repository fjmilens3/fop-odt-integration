package com.fjmilens3.fop.opendocument.states;

import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Column;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;
import org.odftoolkit.simple.text.Paragraph;
import org.odftoolkit.simple.text.list.List;
import org.odftoolkit.simple.text.list.ListItem;

/**
 * Abstract superclass that represents a particular state within an {@link com.fjmilens3.fop.opendocument.ODTHandler} instance.  These states contain
 * much of the logic necessary to generate new parts in the ODT output based on the current and previous states of the
 * handler.
 *
 * @author Frederick John Milens III
 */
public abstract class ODTHandlerState {

    /**
     * The parent state.
     */
    private ODTHandlerState parent;

    /**
     * Constructor.
     *
     * @param parent The parent state.
     */
    public ODTHandlerState(ODTHandlerState parent) {
        this.parent = parent;
    }

    /**
     * Returns the parent state.
     *
     * @return The parent state.
     */
    public final ODTHandlerState getParent() {
        return parent;
    }

    /**
     * Performs any final cleanup logic associated with removing this state from the chain of states.  This should be
     * used sparingly and only when there seems to be no other option (such as with the extraneous table row that must
     * be added to reliably implement cell merges).
     */
    public void dispose() {
    }

    /**
     * Returns a boolean indicating if this represents a document state.
     *
     * @return A boolean.
     */
    public boolean isDocumentState() {
        return false;
    }

    /**
     * Returns a boolean indicating if this represents a block state.
     *
     * @return A boolean.
     */
    public boolean isBlockState() {
        return true;
    }

    /**
     * Returns a boolean indicating if this represents a list label state.
     *
     * @return A boolean.
     */
    public boolean isListLabelState() {
        return false;
    }

    /**
     * Returns a boolean indicating if this represents a list state.
     *
     * @return A boolean.
     */
    public boolean isListState() {
        return false;
    }

    /**
     * Returns a boolean indicating if this represents a list item state.
     *
     * @return A boolean.
     */
    public boolean isListItemState() {
        return false;
    }

    /**
     * Returns a boolean indicating if this represents a table state.
     *
     * @return A boolean.
     */
    public boolean isTableState() {
        return false;
    }

    /**
     * Returns a boolean indicating if this represents a table column state.
     *
     * @return A boolean.
     */
    public boolean isTableColumnState() {
        return false;
    }

    /**
     * Returns a boolean indicating if this represents a table row state.
     *
     * @return A boolean.
     */
    public boolean isTableRowState() {
        return false;
    }

    /**
     * Returns a boolean indicating if this represents a table cell state.
     *
     * @return A boolean.
     */
    public boolean isTableCellState() {
        return false;
    }

    /**
     * Returns a boolean indicating if this represents a header state.
     *
     * @return A boolean.
     */
    public boolean isHeaderState() {
        return false;
    }

    /**
     * Returns a boolean indicating if this represents a footer state.
     *
     * @return A boolean.
     */
    public boolean isFooterState() {
        return false;
    }

    /**
     * Returns a boolean indicating if this state can be used to create new lists.
     *
     * @return A boolean.
     */
    public boolean isListFactory() {
        return false;
    }

    /**
     * Returns a boolean indicating if this state can be used to create new list items.
     *
     * @return A boolean.
     */
    public boolean isListItemFactory() {
        return false;
    }

    /**
     * Returns a boolean indicating if this state can be used to create new paragraphs.
     *
     * @return A boolean.
     */
    public boolean isParagraphFactory() {
        return false;
    }

    /**
     * Returns a boolean indicating if this state can be used to create new tables.
     *
     * @return A boolean.
     */
    public boolean isTableFactory() {
        return false;
    }

    /**
     * Returns the current paragraph represented with this state.
     *
     * @return The current {@link Paragraph}.
     * @throws IllegalStateException If this state cannot have an associated paragraph.
     */
    public Paragraph getParagraph() throws IllegalStateException {
        throw new IllegalStateException("Handler state " + getClass().getSimpleName() + " cannot return a paragraph.");
    }

    /**
     * Returns the current table represented with this state.
     *
     * @return The current {@link Table}.
     * @throws IllegalStateException If this state cannot have an associated table.
     */
    public Table getTable() throws IllegalStateException {
        throw new IllegalStateException("Handler state " + getClass().getSimpleName() + " cannot return a table.");
    }

    /**
     * Returns the current table cell represented with this state.
     *
     * @return The current {@link Cell}.
     * @throws IllegalStateException If this state cannot have an associated table cell.
     */
    public Cell getTableCell(int index) throws IllegalStateException {
        throw new IllegalStateException("Handler state " + getClass().getSimpleName() + " cannot return a table cell.");
    }

    /**
     * Creates a new {@link Paragraph} using the appropriate mechanism for this state.
     *
     * @return The new {@link Paragraph} that was created.
     * @throws IllegalStateException If this state cannot create a new paragraph.
     */
    public Paragraph newParagraph() throws IllegalStateException {
        throw new IllegalStateException("Handler state " + getClass().getSimpleName() + " cannot create a paragraph.");
    }

    /**
     * Creates a new {@link List} using the appropriate mechanism for this state.
     *
     * @return The new {@link List} that was created.
     * @throws IllegalStateException If this state cannot create a new list.
     */
    public List newList() throws IllegalStateException {
        throw new IllegalStateException("Handler state " + getClass().getSimpleName() + " cannot create a list.");
    }

    /**
     * Creates a new {@link ListItem} using the appropriate mechanism for this state.
     *
     * @return The new {@link ListItem} that was created.
     * @throws IllegalStateException If this state cannot create a new list item.
     */
    public ListItem newListItem() throws IllegalStateException {
        throw new IllegalStateException("Handler state " + getClass().getSimpleName() + " cannot create a list item.");
    }

    /**
     * Creates a new {@link Table} using the appropriate mechanism for this state.
     *
     * @return The new {@link Table} that was created.
     * @throws IllegalStateException If this state cannot create a new table.
     */
    public Table newTable() throws IllegalStateException {
        throw new IllegalStateException("Handler state " + getClass().getSimpleName() + " cannot create a table.");
    }

    /**
     * Creates a new {@link Column} using the appropriate mechanism for this state.
     *
     * @return The new {@link Column} that was created.
     * @throws IllegalStateException If this state cannot create a new table column.
     */
    public Column newTableColumn() throws IllegalStateException {
        throw new IllegalStateException("Handler state " + getClass().getSimpleName() + " cannot create a table column.");
    }

    /**
     * Creates a new {@link Row} using the appropriate mechanism for this state.
     *
     * @return The new {@link Row} that was created.
     * @throws IllegalStateException If this state cannot create a new table row.
     */
    public Row newTableRow() throws IllegalStateException {
        throw new IllegalStateException("Handler state " + getClass().getSimpleName() + " cannot create a table row.");
    }
}
