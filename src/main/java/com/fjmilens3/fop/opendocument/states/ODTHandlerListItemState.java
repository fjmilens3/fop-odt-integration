package com.fjmilens3.fop.opendocument.states;

import org.odftoolkit.simple.text.Paragraph;
import org.odftoolkit.simple.text.list.List;
import org.odftoolkit.simple.text.list.ListItem;

/**
 * {@link ODTHandlerState} for the state when a list item is being processed in the document.
 *
 * @author Frederick John Milens III
 */
final class ODTHandlerListItemState extends ODTHandlerState {

    /**
     * The {@link ListItem} associated with this particular state.
     */
    private ListItem listItem;

    /**
     * Constructor.
     *
     * @param parent   The parent state.
     * @param listItem The list item associated with this state.
     */
    public ODTHandlerListItemState(ODTHandlerState parent, ListItem listItem) {
        super(parent);
        this.listItem = listItem;
    }

    /**
     * Returns true to indicate that this state is a list item state.
     *
     * @return true
     */
    @Override
    public boolean isListItemState() {
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
     * Returns true to indicate that this state can create new paragraphs.
     *
     * @return true
     */
    @Override
    public boolean isParagraphFactory() {
        return true;
    }

    /**
     * Returns a new {@link Paragraph} created by this list item
     *
     * @return The {@link Paragraph}.
     */
    @Override
    public Paragraph newParagraph() {
        return Paragraph.getInstanceof(listItem.getOdfElement().newTextPElement());
    }

    /**
     * Returns a new {@link List} created by this list item
     *
     * @return The {@link List}.
     */
    @Override
    public List newList() {
        return listItem.addList();
    }
}
