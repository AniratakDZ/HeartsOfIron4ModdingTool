package application.views;

import application.models.BaseModel;

import javax.swing.*;

public abstract class BaseView extends JPanel {

    private BaseModel model;

    public BaseView(BaseModel model) {
        this.model = model;
    }

    public abstract void updateView();

    public BaseModel getModel() {
        return model;
    }

    public void setModel(BaseModel model) {
        this.model = model;
    }
}
