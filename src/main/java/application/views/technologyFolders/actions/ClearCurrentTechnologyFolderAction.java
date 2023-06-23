package application.views.technologyFolders.actions;

import application.baseObjects.actions.ClickAction;
import application.views.technologyFolders.TechnologyFoldersConstants;
import application.views.technologyFolders.TechnologyFoldersView;

import java.awt.event.ActionEvent;

import static application.views.technologyFolders.TechnologyFoldersConstants.*;

public class ClearCurrentTechnologyFolderAction extends ClickAction<TechnologyFoldersView> {

    public ClearCurrentTechnologyFolderAction(TechnologyFoldersView view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getListFromScrollingList(SCROLLING_LIST_FOLDERS).clearSelection();
        getTextfield(TEXTFIELD_NAME).setText("");
        getCombobox(COMBOBOX_LEDGER).setSelectedItem("");
        getCheckbox(CHECKBOX_DOCTRINE).setSelected(false);
        getCheckbox(CHECKBOX_AVAILABLE_CONDITION).setSelected(false);
        getCombobox(COMBOBOX_AVAILABLE_CONDITION_HAS_DLC).setSelectedItem("");
        getCheckbox(CHECKBOX_NOT_CONDITION).setSelected(false);
        getCombobox(COMBOBOX_CONDITION_NOT_HAS_DLC).setSelectedItem("");
    }
}
