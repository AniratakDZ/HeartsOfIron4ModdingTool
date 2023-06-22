package application.baseObjects.actions;

import application.baseObjects.BaseView;

import javax.swing.event.ListSelectionListener;

public abstract class ListAction<T extends BaseView> extends BaseAction<T> implements ListSelectionListener {
    public ListAction(T view) {
        super(view);
    }
}
