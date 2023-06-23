package application.baseObjects;

import javax.swing.*;
import java.util.List;

public class JScrollingList extends JScrollPane {

    private JList<String> list;
    private DefaultListModel<String> elementsModel;

    public JScrollingList() {
        elementsModel = new DefaultListModel<>();
        list = new JList<>(elementsModel);
        setViewportView(list);
    }

    public void updateElements(List<String> elements) {
        elementsModel.removeAllElements();
        for(String element : elements) {
            elementsModel.addElement(element);
        }
    }

    public JList<String> getList() {
        return list;
    }

    public void setList(JList<String> list) {
        this.list = list;
    }

    public DefaultListModel<String> getElementsModel() {
        return elementsModel;
    }

    public void setElementsModel(DefaultListModel<String> elementsModel) {
        this.elementsModel = elementsModel;
    }
}
