package application.baseObjects.actions;

import application.baseObjects.BaseView;
import application.baseObjects.JComboBox;
import application.baseObjects.JScrollingList;
import utils.MapUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Map;

public class ClearAction extends ClickAction {

    public ClearAction(BaseView view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final Map components = getView().getGuiComponents();
        final Collection component = components.values();
        for(Object o : component) {
            if(o instanceof JTextField) {
                ((JTextField) o).setText("");
            } else if(o instanceof JComboBox) {
                ((JComboBox) o).setSelectedItem("");
            } else if(o instanceof JScrollingList) {
                final JScrollingList scrollingList = (JScrollingList) o;
                scrollingList.getList().clearSelection();
                if(!((String) MapUtils.getKey(components, scrollingList)).contains("MAIN")) {
                    scrollingList.getElementsModel().removeAllElements();
                }
            } else if(o instanceof JCheckBox) {
                final JCheckBox checkbox = (JCheckBox) o;
                checkbox.setSelected(false);
                final ActionListener[] listener = checkbox.getActionListeners();
                if(listener.length > 0) {
                    listener[0].actionPerformed(e);
                }
            }
        }
    }
}
