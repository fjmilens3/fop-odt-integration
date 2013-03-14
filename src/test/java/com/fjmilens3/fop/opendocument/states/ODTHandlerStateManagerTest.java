package com.fjmilens3.fop.opendocument.states;

import org.junit.Test;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Unit tests for the {@link ODTHandlerStateManager}.
 *
 * @author Frederick John Milens III
 */
public class ODTHandlerStateManagerTest {

    /**
     * The state manager under test.
     */
    private ODTHandlerStateManager stateManager = new ODTHandlerStateManager();

    /**
     * Tests that a block state is successfully pushed on the stack of states by the manager.
     */
    @Test
    public void testPushBlockState() {
        Paragraph paragraph = mock(Paragraph.class);
        stateManager.pushBlockState(paragraph);
        assertEquals(ODTHandlerBlockState.class, stateManager.getCurrentState().getClass());
    }

    /**
     * Tests that a document state is successfully pushed on the stack of states by the manager.
     */
    @Test
    public void testPushDocumentState() {
        TextDocument document = mock(TextDocument.class);
        stateManager.pushDocumentState(document);
        assertEquals(ODTHandlerDocumentState.class, stateManager.getCurrentState().getClass());
    }

    /**
     * Tests that a header state is successfully pushed on the stack of states by the manager.
     */
    @Test
    public void testPushHeaderState() {
        Header header = mock(Header.class);
        stateManager.pushHeaderState(header);
        assertEquals(ODTHandlerHeaderState.class, stateManager.getCurrentState().getClass());
    }

    /**
     * Tests that a footer state is successfully pushed on the stack of states by the manager.
     */
    @Test
    public void testPushFooterState() {
        Footer footer = mock(Footer.class);
        stateManager.pushFooterState(footer);
        assertEquals(ODTHandlerFooterState.class, stateManager.getCurrentState().getClass());
    }

    /**
     * Tests that a list item state is successfully pushed on the stack of states by the manager.
     */
    @Test
    public void testPushListItemState() {
        ListItem listItem = mock(ListItem.class);
        stateManager.pushListItemState(listItem);
        assertEquals(ODTHandlerListItemState.class, stateManager.getCurrentState().getClass());
    }

    /**
     * Tests that a list label state is successfully pushed on the stack of states by the manager.
     */
    @Test
    public void testPushListLabelState() {
        stateManager.pushListLabelState();
        assertEquals(ODTHandlerListLabelState.class, stateManager.getCurrentState().getClass());
    }

    /**
     * Tests that a list state is successfully pushed on the stack of states by the manager.
     */
    @Test
    public void testPushListState() {
        List list = mock(List.class);
        stateManager.pushListState(list);
        assertEquals(ODTHandlerListState.class, stateManager.getCurrentState().getClass());
    }

    /**
     * Tests that a table cell state is successfully pushed on the stack of states by the manager.
     */
    @Test
    public void testPushTableCellState() {
        Cell cell = mock(Cell.class);
        stateManager.pushTableCellState(cell);
        assertEquals(ODTHandlerTableCellState.class, stateManager.getCurrentState().getClass());
    }

    /**
     * Tests that a table column state is successfully pushed on the stack of states by the manager.
     */
    @Test
    public void testPushTableColumnState() {
        Column column = mock(Column.class);
        stateManager.pushTableColumnState(column);
        assertEquals(ODTHandlerTableColumnState.class, stateManager.getCurrentState().getClass());
    }

    /**
     * Tests that a table row state is successfully pushed on the stack of states by the manager.
     */
    @Test
    public void testPushTableRowState() {
        Row row = mock(Row.class);
        stateManager.pushTableRowState(row);
        assertEquals(ODTHandlerTableRowState.class, stateManager.getCurrentState().getClass());
    }

    /**
     * Tests that a table state is successfully pushed on the stack of states by the manager.
     */
    @Test
    public void testPushTableState() {
        Table table = mock(Table.class);
        stateManager.pushTableState(table);
        assertEquals(ODTHandlerTableState.class, stateManager.getCurrentState().getClass());
    }

    /**
     * Tests that a state is appropriately disposed when popped from the stack.
     */
    @Test
    public void testPopStateDispose() {
        final ODTHandlerState state = mock(ODTHandlerState.class);
        stateManager = new ODTHandlerStateManager() {{
            currentState = state;
        }};
        stateManager.popState();
        verify(state).dispose();
    }

    /**
     * Tests that a state is popped from the stack.
     */
    @Test
    public void testPopState() {
        stateManager.pushDocumentState(mock(TextDocument.class));
        stateManager.pushBlockState(mock(Paragraph.class));
        stateManager.popState();
        assertEquals(ODTHandlerDocumentState.class, stateManager.getCurrentState().getClass());
    }

    /**
     * Tests that the state manager knows when a list label is in the list of states.
     */
    @Test
    public void testProcessingListLabelTrue() {
        stateManager.pushDocumentState(null);
        stateManager.pushListState(null);
        stateManager.pushListLabelState();
        stateManager.pushBlockState(null);
        assertTrue(stateManager.isProcessingListLabel());
    }

    /**
     * Tests that the state manager knows when a list label is not in the list of states.
     */
    @Test
    public void testProcessingListLabelFalse() {
        stateManager.pushDocumentState(null);
        stateManager.pushListState(null);
        assertFalse(stateManager.isProcessingListLabel());
    }
}
