package com.fjmilens3.fop.opendocument.states;

import org.odftoolkit.simple.text.list.List;
import org.odftoolkit.simple.text.list.ListItem;

/**
 * {@link ODTHandlerState} for the state when a list is being processed in the document.
 *
 * @author Frederick John Milens III
 */
final class ODTHandlerListState extends ODTHandlerState {

    /**
     * The {@link List} associated with this particular state.
     */
    private List list;

    /**
     * Constructor.
     *
     * @param parent The parent state.
     * @param list The list associated with this particular state.
     */
    public ODTHandlerListState(ODTHandlerState parent, List list) {
        super(parent);
        this.list = list;
    }

    /**
     * Returns true to indicate that this is a list state.
     *
     * @return true
     */
    @Override
    public boolean isListState() {
        return true;
    }

    /**
     * Returns true to indicate that this state can create new list items.
     *
     * @return true
     */
    @Override
    public boolean isListItemFactory() {
        return true;
    }

    /**
     * Returns a new list item created from this list.
     *
     * @return The new {@link ListItem}.
     */
    @Override
    public ListItem newListItem() {
        return list.addItem((String) null);
    }
}
