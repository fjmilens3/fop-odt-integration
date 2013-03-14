package com.fjmilens3.fop.opendocument.states;

/**
 * {@link ODTHandlerState} representing the state where a list label is being processed in a document.  Since custom
 * list labels are not yet supported, this particular subclass doesn't do much.  At the moment the primary role of this
 * state is to suppress processing of child elements of a list label.
 *
 * @author Frederick John Milens III
 */
final class ODTHandlerListLabelState extends ODTHandlerState {

    /**
     * Constructor.
     *
     * @param parent The parent state.
     */
    public ODTHandlerListLabelState(ODTHandlerState parent) {
        super(parent);
    }

    /**
     * Returns true to indicate that this is a list label state.
     *
     * @return true
     */
    @Override
    public boolean isListLabelState() {
        return true;
    }
}
