package application.views.technologyFolders.actions;

import application.baseObjects.actions.ClickAction;
import application.views.technologyFolders.TechnologyFoldersView;

import java.awt.event.ActionEvent;

public class ClearCurrentTechnologyFolderAction extends ClickAction<TechnologyFoldersView> {

    public ClearCurrentTechnologyFolderAction(TechnologyFoldersView view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getView().folderList.clearSelection();
        getView().nameTextField.setText("");
        getView().ledgerComboBox.setSelectedItem("");
        getView().doctrineCheckbox.setSelected(false);
        getView().availableConditionCheckbox.setSelected(false);
        getView().availableConditionHasDlcComboBox.setSelectedItem("");
        getView().conditionNotCheckbox.setSelected(false);
        getView().conditionNotHasDlcComboBox.setSelectedItem("");
    }
}
