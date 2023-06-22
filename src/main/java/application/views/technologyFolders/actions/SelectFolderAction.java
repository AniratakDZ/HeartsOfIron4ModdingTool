package application.views.technologyFolders.actions;

import application.baseObjects.actions.ListAction;
import application.views.technologyFolders.TechnologyFoldersView;
import data.objects.technology.technologyFolderAndCategories.TechnologyFoldersInstance;
import data.objects.technology.technologyFolderAndCategories.TechnologyFoldersInstanceAvailable;
import data.objects.technology.technologyFolderAndCategories.TechnologyFoldersInstanceAvailableNot;

import javax.swing.event.ListSelectionEvent;

public class SelectFolderAction extends ListAction<TechnologyFoldersView> {

    public SelectFolderAction(TechnologyFoldersView view) {
        super(view);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting() && getView().folderList.getSelectedValue() != null) {
            final TechnologyFoldersInstance technologyFoldersInstance = getView().getModel().getTechnologyFoldersInstanceByName(getView().folderList.getSelectedValue());
            getView().nameTextField.setText(technologyFoldersInstance.getName());
            getView().ledgerComboBox.setSelectedItem(technologyFoldersInstance.getLedger());
            getView().doctrineCheckbox.setSelected(technologyFoldersInstance.isDoctrine());
            final TechnologyFoldersInstanceAvailable available = technologyFoldersInstance.getAvailable();
            final boolean isAvailable = available != null;
            if(isAvailable) {
                getView().availableConditionCheckbox.setSelected(isAvailable);
                final String availableHasDlc = available.getHasDlc();
                if(availableHasDlc != null) {
                    getView().availableConditionHasDlcComboBox.setSelectedItem(availableHasDlc);
                } else {
                    getView().availableConditionHasDlcComboBox.setSelectedItem("");
                }
                final TechnologyFoldersInstanceAvailableNot not = available.getNot();
                if(not != null) {
                    getView().conditionNotCheckbox.setSelected(true);
                    final String notHasDlc = not.getHasDlc();
                    if(notHasDlc != null) {
                        getView().conditionNotHasDlcComboBox.setSelectedItem(notHasDlc);
                    } else {
                        getView().conditionNotHasDlcComboBox.setSelectedItem("");
                    }
                } else {
                    getView().conditionNotHasDlcComboBox.setSelectedItem("");
                    getView().conditionNotCheckbox.setSelected(false);
                }
            } else {
                getView().availableConditionCheckbox.setSelected(false);
                getView().availableConditionHasDlcComboBox.setSelectedItem("");
                getView().conditionNotCheckbox.setSelected(false);
                getView().conditionNotHasDlcComboBox.setSelectedItem("");
            }
        }
    }
}
