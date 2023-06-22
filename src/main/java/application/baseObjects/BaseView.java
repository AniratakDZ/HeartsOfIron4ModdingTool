package application.baseObjects;

import javax.swing.*;

public abstract class BaseView<M extends BaseModel> extends JPanel {

    private M model;

    public BaseView(M model) {
        this.model = model;
    }

    public abstract void updateView();

    public M getModel() {
        return model;
    }

    public void setModel(M model) {
        this.model = model;
    }
}
