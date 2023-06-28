package application.baseObjects.actions;

import application.baseObjects.AbstractView;
import application.baseObjects.BaseModel;
import application.baseObjects.BaseView;
import application.baseObjects.JScrollingList;

import javax.swing.*;

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

    public JList<String> getListFromScrollingList(String id) {
        return getView().getListFromScrollingList(id);
    }

    public JScrollingList getScrollingList(String id) {
        return getView().getScrollingList(id);
    }

    public JButton getButton(String id) {
        return getView().getButton(id);
    }

    public JTextField getTextfield(String id) {
        return getView().getTextfield(id);
    }

    public JCheckBox getCheckbox(String id) {
        return getView().getCheckBox(id);
    }

    public JComboBox<String> getCombobox(String id) {
        return getView().getComboBox(id);
    }

    public JLabel getLabel(String id) {
        return getView().getLabel(id);
    }

    public <M extends BaseModel> M getModel() {
        return (M) getView().getModel();
    }

    public void updateView() {
        getView().updateView();
    }
}
