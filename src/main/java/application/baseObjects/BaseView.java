package application.baseObjects;

import application.baseObjects.actions.ClickAction;
import application.baseObjects.actions.ListAction;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseView<M extends BaseModel> extends AbstractView implements BaseViewConstants {

    private Map<String, JComponent> guiComponents;

    private M model;

    public BaseView(M model) {
        this.model = model;
        guiComponents = new HashMap<>();
    }

    public JTextField getTextfield(String id) {
        return (JTextField) getComponent(id, TEXTFIELD);
    }

    public JScrollingList getScrollingList(String id) {
        return (JScrollingList) getComponent(id, SCROLLING_LIST);
    }

    public JList<String> getListFromScrollingList(String id) {
        return getScrollingList(id).getList();
    }

    public JLabel getLabel(String id) {
        return (JLabel) getComponent(id, LABEL);
    }

    public JButton getButton(String id) {
        return (JButton) getComponent(id, BUTTON);
    }

    public JCheckBox getCheckBox(String id) {
        return (JCheckBox) getComponent(id, CHECKBOX);
    }

    public JComboBox getComboBox(String id) {
        return (JComboBox) getComponent(id, COMBOBOX);
    }

    public void addComboBox(String id, int x, int y) {
        addComboBox(id, x, y, true, false);
    }

    public void addComboBox(String id, int x, int y, boolean deactivated) {
        addComboBox(id, x, y, true, deactivated);
    }

    public void addComboBox(String id, int x, int y, boolean visibility, boolean deactivated) {
        final JComboBox comboBox = new JComboBox();
        comboBox.setBounds(x, y, 250, 25);
        comboBox.setVisible(visibility);
        comboBox.setEnabled(!deactivated);
        guiComponents.put(id, comboBox);
        this.add(comboBox);
    }

    public void addCheckBox(String id, int x, int y) {
        addCheckBox(id, x, y, true, false);
    }

    public void addCheckBox(String id, int x, int y, boolean deactivated) {
        addCheckBox(id, x, y, true, deactivated);
    }

    public void addCheckBox(String id, int x, int y, boolean visibility, boolean deactivated) {
        final JCheckBox checkBox = new JCheckBox();
        checkBox.setBounds(x, y, 25, 25);
        checkBox.setVisible(visibility);
        checkBox.setEnabled(!deactivated);
        guiComponents.put(id, checkBox);
        this.add(checkBox);
    }

    public void addButton(String id, String text, int x, int y) {
        addButton(id, text, x, y, true);
    }

    public void addButton(String id, String text, int x, int y, boolean visibility) {
        final JButton button = new JButton(text);
        button.setBounds(x, y, 100, 25);
        button.setVisible(visibility);
        guiComponents.put(id, button);
        this.add(button);
    }

    public void addLabel(String id, String text, int x, int y) {
        addLabel(id, text, x, y, true);
    }

    public void addLabel(String id, String text, int x, int y, boolean visibility) {
        final JLabel label = new JLabel(text);
        label.setBounds(x, y, 250, 25);
        label.setVisible(visibility);
        guiComponents.put(id, label);
        this.add(label);
    }

    public void addScrollingList(String id, int x, int y, boolean visibility) {
        final JScrollingList scrollingList = new JScrollingList();
        scrollingList.setBounds(x, y, 300, 200);
        scrollingList.setVisible(visibility);
        guiComponents.put(id, scrollingList);
        this.add(scrollingList);
    }

    public void addScrollingList(String id, int x, int y) {
        addScrollingList(id, x, y, true);
    }

    public void addTextfield(String id, int x, int y, boolean visibility, boolean deactivated) {
        final JTextField textField = new JTextField();
        textField.setBounds(x, y, 250, 25);
        textField.setVisible(visibility);
        textField.setEnabled(!deactivated);
        guiComponents.put(id, textField);
        this.add(textField);
    }

    public void addTextfield(String id, int x, int y) {
        addTextfield(id, x, y,true, false);
    }

    public void addTextfield(String id, int x, int y, boolean deactivated) {
        addTextfield(id, x, y,true, deactivated);
    }

    public <T extends BaseView> void addClickAction(String id, ClickAction<T> action) {
        final JComponent component = getComponent(id);
        if(component instanceof JButton) {
            ((JButton) component).addActionListener(action);
        } else if(component instanceof JCheckBox) {
            ((JCheckBox) component).addActionListener(action);
        }
    }

    public <T extends BaseView> void addListAction(String id, ListAction<T> action) {
        getListFromScrollingList(id).addListSelectionListener(action);
    }

    public void removeComponent(String id) {
        final JComponent component = guiComponents.get(id);
        guiComponents.remove(id);
        this.remove(component);
    }

    private JComponent getComponent(String id, String componentType) {
        final JComponent component = guiComponents.get(id);
        if(component != null) {
            return component;
        } else {
            throw new IllegalArgumentException("Component of type: " + componentType + " with id: " + id + " was not found!");
        }
    }

    private JComponent getComponent(String id) {
        return guiComponents.get(id);
    }

    public M getModel() {
        return model;
    }

    public void setModel(M model) {
        this.model = model;
    }

    public Map<String, JComponent> getGuiComponents() {
        return guiComponents;
    }

    public void setGuiComponents(Map<String, JComponent> guiComponents) {
        this.guiComponents = guiComponents;
    }

    public void fillCombobox(String id, List<String> items) {
        final JComboBox comboBox = getComboBox(id);
        comboBox.removeAllItems();
        comboBox.addItem("");
        for(String item : items) {
            comboBox.addItem(item);
        }
    }
}
