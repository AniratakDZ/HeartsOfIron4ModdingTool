package application.views.technologyFolders.actions;

import application.baseObjects.actions.ListAction;
import application.views.technologyFolders.TechnologyFoldersView;
import data.objects.technology.technologyFolderAndCategories.TechnologyFoldersInstance;
import data.objects.technology.technologyFolderAndCategories.TechnologyFoldersInstanceAvailable;
import data.objects.technology.technologyFolderAndCategories.TechnologyFoldersInstanceAvailableNot;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;

import static application.views.technologyFolders.TechnologyFoldersConstants.*;

public class SelectFolderAction extends ListAction<TechnologyFoldersView> {

    public SelectFolderAction(TechnologyFoldersView view) {
        super(view);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        final JList<String> scrollingList = getListFromScrollingList(SCROLLING_LIST_FOLDERS);
        if(!e.getValueIsAdjusting() && scrollingList.getSelectedValue() != null) {
            final TechnologyFoldersInstance technologyFoldersInstance = getView().getModel().getTechnologyFoldersInstanceByName(scrollingList.getSelectedValue());
            getTextfield(TEXTFIELD_NAME).setText(technologyFoldersInstance.getName());
            getCombobox(COMBOBOX_LEDGER).setSelectedItem(technologyFoldersInstance.getLedger());
            getCheckbox(CHECKBOX_DOCTRINE).setSelected(technologyFoldersInstance.isDoctrine());
            final TechnologyFoldersInstanceAvailable available = technologyFoldersInstance.getAvailable();
            final boolean isAvailable = available != null;
            final JComboBox<String> availableCombobox = getCombobox(COMBOBOX_AVAILABLE_CONDITION_HAS_DLC);
            final JComboBox<String> notHasDlcCombobox = getCombobox(COMBOBOX_CONDITION_NOT_HAS_DLC);
            final JCheckBox availableCondition = getCheckbox(CHECKBOX_AVAILABLE_CONDITION);
            final JCheckBox notCondition = getCheckbox(CHECKBOX_NOT_CONDITION);
            if(isAvailable) {
                availableCondition.setSelected(isAvailable);
                final String availableHasDlc = available.getHasDlc();
                if(availableHasDlc != null) {
                    availableCombobox.setSelectedItem(availableHasDlc);
                } else {
                    availableCombobox.setSelectedItem("");
                }
                final TechnologyFoldersInstanceAvailableNot not = available.getNot();
                new CheckAvailableConditionAction(getView()).actionPerformed(null);
                if(not != null) {
                    notCondition.setSelected(true);
                    final String notHasDlc = not.getHasDlc();
                    if(notHasDlc != null) {
                        notHasDlcCombobox.setSelectedItem(notHasDlc);
                    } else {
                        notHasDlcCombobox.setSelectedItem("");
                    }
                    new CheckNotConditionAction(getView()).actionPerformed(null);
                } else {
                    notHasDlcCombobox.setSelectedItem("");
                    notCondition.setSelected(false);
                }
            } else {
                availableCondition.setSelected(false);
                availableCombobox.setSelectedItem("");
                notCondition.setSelected(false);
                notHasDlcCombobox.setSelectedItem("");
            }
        }
    }
}
