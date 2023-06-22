package application.views.technologyFolders.actions;

import application.baseObjects.actions.ClickAction;
import application.views.technologyFolders.TechnologyFoldersView;
import data.objects.technology.technologyFolderAndCategories.TechnologyFoldersInstance;
import data.objects.technology.technologyFolderAndCategories.TechnologyFoldersInstanceAvailable;
import data.objects.technology.technologyFolderAndCategories.TechnologyFoldersInstanceAvailableNot;

import java.awt.event.ActionEvent;

public class AddTechnologyFolderAction extends ClickAction<TechnologyFoldersView> {

    public AddTechnologyFolderAction(TechnologyFoldersView view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(getView().folderList.getSelectedValue() != null) {
            getView().getModel().updateTechnologyFoldersInstance(createInstanceWithFieldParameter());
            getView().updateView();
        } else {
            getView().getModel().addTechnologyFoldersInstance(createInstanceWithFieldParameter());
            getView().updateView();
        }
        getView().folderList.setSelectedValue(getView().nameTextField.getText(), true);
    }

    private TechnologyFoldersInstance createInstanceWithFieldParameter() {
        final TechnologyFoldersInstance technologyFoldersInstance = new TechnologyFoldersInstance();
        technologyFoldersInstance.setName(getView().nameTextField.getText());
        technologyFoldersInstance.setDoctrine(getView().doctrineCheckbox.isSelected());
        technologyFoldersInstance.setLedger((String) getView().ledgerComboBox.getSelectedItem());
        if(getView().availableConditionCheckbox.isSelected()) {
            final TechnologyFoldersInstanceAvailable technologyFoldersInstanceAvailable = new TechnologyFoldersInstanceAvailable();
            technologyFoldersInstanceAvailable.setHasDlc((String) getView().availableConditionHasDlcComboBox.getSelectedItem());
            if(getView().conditionNotCheckbox.isSelected()) {
                final TechnologyFoldersInstanceAvailableNot technologyFoldersInstanceAvailableNot = new TechnologyFoldersInstanceAvailableNot();
                technologyFoldersInstanceAvailableNot.setHasDlc((String) getView().conditionNotHasDlcComboBox.getSelectedItem());
                technologyFoldersInstanceAvailable.setNot(technologyFoldersInstanceAvailableNot);
            }
            technologyFoldersInstance.setAvailable(technologyFoldersInstanceAvailable);
        }
        return technologyFoldersInstance;
    }
}
