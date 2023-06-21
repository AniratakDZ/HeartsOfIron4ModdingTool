package application.controller;

import application.models.BaseModel;
import application.views.BaseView;

public abstract class BaseController {

    private BaseModel model;
    private BaseView view;

    public BaseController(BaseModel model, BaseView view) {
        this.model = model;
        this.view = view;
    }

    public void initialize() {
        view.updateView();
    }

    public BaseModel getModel() {
        return model;
    }

    public void setModel(BaseModel model) {
        this.model = model;
    }

    public BaseView getView() {
        return view;
    }

    public void setView(BaseView view) {
        this.view = view;
    }
}
