package application.baseObjects.actions;

import application.baseObjects.BaseView;

import java.awt.event.ActionListener;

public abstract class ClickAction<T extends BaseView> extends BaseAction<T> implements ActionListener {

    public ClickAction(T view) {
        super(view);
    }
}
