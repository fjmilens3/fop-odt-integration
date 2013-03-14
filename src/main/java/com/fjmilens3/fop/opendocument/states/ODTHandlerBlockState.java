package com.fjmilens3.fop.opendocument.states;

import org.odftoolkit.simple.table.Table;
import org.odftoolkit.simple.text.Paragraph;
import org.odftoolkit.simple.text.list.List;

/**
 * {@link ODTHandlerState} used to represent processing a FO block in a document.
 *
 * @author Frederick John Milens III
 */
final class ODTHandlerBlockState extends ODTHandlerState {

    /**
     * The {@link Paragraph} that represents this block.
     */
    private Paragraph paragraph;

    /**
     * Constructor.
     *
     * @param parent    The parent state.
     * @param paragraph The paragraph for this block.
     */
    public ODTHandlerBlockState(ODTHandlerState parent, Paragraph paragraph) {
        super(parent);
        this.paragraph = paragraph;
    }

    /**
     * Returns true to indicate that this is a block state.
     *
     * @return true
     */
    @Override
    public boolean isBlockState() {
        return true;
    }

    /**
     * Returns the paragraph associated with this block.
     *
     * @return true
     */
    @Override
    public Paragraph getParagraph() {
        return paragraph;
    }

    /**
     * Returns true to indicate that a block state can create new paragraphs via parent states.
     *
     * @return true
     */
    @Override
    public boolean isParagraphFactory() {
        return true;
    }

    /**
     * Returns true to indicate that a block state can create new lists via parent states.
     *
     * @return true
     */
    @Override
    public boolean isListFactory() {
        return true;
    }

    /**
     * Returns true to indicate that a block state can create new tables via parent states.
     *
     * @return true
     */
    @Override
    public boolean isTableFactory() {
        return true;
    }

    /**
     * Creates a new {@link Paragraph} using the closest parent state that allows creation of a new paragraph via API.
     *
     * @return The {@link Paragraph}.
     * @throws IllegalStateException If no parent element exists that can create a paragraph.
     */
    @Override
    public Paragraph newParagraph() throws IllegalStateException {
        ODTHandlerState current = getParent();
        while (current != null) {
            if (current.isParagraphFactory()) {
                return current.newParagraph();
            }
            current = current.getParent();
        }
        throw new IllegalStateException("Handler state " + getClass().getSimpleName() + " has no parent element that can create a paragraph.");
    }

    /**
     * Creates a new {@link List} using the closest parent state that allows creation of a new list via API.
     *
     * @return The {@link List}.
     * @throws IllegalStateException If no parent element exists that can create a list.
     */
    @Override
    public List newList() throws IllegalStateException {
        ODTHandlerState current = getParent();
        while (current != null) {
            if (current.isListFactory()) {
                return current.newList();
            }
            current = current.getParent();
        }
        throw new IllegalStateException("Handler state " + getClass().getSimpleName() + " has no parent element that can create a list.");
    }

    /**
     * Creates a new {@link Table} using the closest parent state that allows creation of a new table via API.
     *
     * @return The {@link Table}.
     * @throws IllegalStateException If no parent element exists that can create a table.
     */
    @Override
    public Table newTable() {
        ODTHandlerState current = getParent();
        while (current != null) {
            if (current.isTableFactory()) {
                return current.newTable();
            }
            current = current.getParent();
        }
        throw new IllegalStateException("Handler state " + getClass().getSimpleName() + " has no parent element that can create a table.");
    }
}
