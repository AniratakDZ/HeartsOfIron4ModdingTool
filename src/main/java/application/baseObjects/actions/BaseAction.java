package application.baseObjects.actions;

import application.baseObjects.BaseView;

public abstract class BaseAction<T extends BaseView> {

    private T view;

    public BaseAction(T view) {
        this.view = view;
    }

    public T getView() {
        return view;
    }

    public void setView(T view) {
        this.view = view;
    }
}
