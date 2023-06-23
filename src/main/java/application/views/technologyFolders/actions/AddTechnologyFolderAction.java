package application.views.technologyFolders.actions;

import application.baseObjects.actions.ClickAction;
import application.views.technologyFolders.TechnologyFoldersConstants;
import application.views.technologyFolders.TechnologyFoldersView;
import data.objects.technology.technologyFolderAndCategories.TechnologyFoldersInstance;
import data.objects.technology.technologyFolderAndCategories.TechnologyFoldersInstanceAvailable;
import data.objects.technology.technologyFolderAndCategories.TechnologyFoldersInstanceAvailableNot;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static application.views.technologyFolders.TechnologyFoldersConstants.*;

public class AddTechnologyFolderAction extends ClickAction<TechnologyFoldersView> {

    public AddTechnologyFolderAction(TechnologyFoldersView view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final JList<String> foldersList = getListFromScrollingList(SCROLLING_LIST_FOLDERS);
        if(foldersList.getSelectedValue() != null) {
            getView().getModel().updateTechnologyFoldersInstance(foldersList.getSelectedValue(), createInstanceWithFieldParameter());
            updateView();
        } else {
            getView().getModel().addTechnologyFoldersInstance(createInstanceWithFieldParameter());
            updateView();
        }
        getListFromScrollingList(SCROLLING_LIST_FOLDERS).setSelectedValue(getTextfield(TEXTFIELD_NAME).getText(), true);
    }

    private TechnologyFoldersInstance createInstanceWithFieldParameter() {
        final TechnologyFoldersInstance technologyFoldersInstance = new TechnologyFoldersInstance();
        technologyFoldersInstance.setName(getTextfield(TEXTFIELD_NAME).getText());
        technologyFoldersInstance.setDoctrine(getCheckbox(CHECKBOX_DOCTRINE).isSelected());
        technologyFoldersInstance.setLedger((String) getCombobox(COMBOBOX_LEDGER).getSelectedItem());
        if(getCheckbox(CHECKBOX_AVAILABLE_CONDITION).isSelected()) {
            final TechnologyFoldersInstanceAvailable technologyFoldersInstanceAvailable = new TechnologyFoldersInstanceAvailable();
            technologyFoldersInstanceAvailable.setHasDlc((String) getCombobox(COMBOBOX_AVAILABLE_CONDITION_HAS_DLC).getSelectedItem());
            if(getCheckbox(CHECKBOX_NOT_CONDITION).isSelected()) {
                final TechnologyFoldersInstanceAvailableNot technologyFoldersInstanceAvailableNot = new TechnologyFoldersInstanceAvailableNot();
                technologyFoldersInstanceAvailableNot.setHasDlc((String) getCombobox(COMBOBOX_CONDITION_NOT_HAS_DLC).getSelectedItem());
                technologyFoldersInstanceAvailable.setNot(technologyFoldersInstanceAvailableNot);
            }
            technologyFoldersInstance.setAvailable(technologyFoldersInstanceAvailable);
        }
        return technologyFoldersInstance;
    }
}
