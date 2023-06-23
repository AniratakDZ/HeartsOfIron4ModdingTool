package application.views.technologyFolders.actions;

import application.baseObjects.actions.ClickAction;
import application.views.technologyFolders.TechnologyFoldersConstants;
import application.views.technologyFolders.TechnologyFoldersView;

import java.awt.event.ActionEvent;

import static application.views.technologyFolders.TechnologyFoldersConstants.*;

public class CheckAvailableConditionAction extends ClickAction<TechnologyFoldersView> {

    public CheckAvailableConditionAction(TechnologyFoldersView view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(getCheckbox(CHECKBOX_AVAILABLE_CONDITION).isSelected()) {
            getLabel(LABEL_AVAILABLE_CONDITION_HAS_DLC).setVisible(true);
            getCombobox(COMBOBOX_AVAILABLE_CONDITION_HAS_DLC).setVisible(true);
            getLabel(LABEL_NOT_CONDITION).setVisible(true);
            getCheckbox(CHECKBOX_NOT_CONDITION).setVisible(true);
        } else {
            getLabel(LABEL_AVAILABLE_CONDITION_HAS_DLC).setVisible(false);
            getCombobox(COMBOBOX_AVAILABLE_CONDITION_HAS_DLC).setVisible(false);
            getLabel(LABEL_NOT_CONDITION).setVisible(false);
            getCheckbox(CHECKBOX_NOT_CONDITION).setVisible(false);
        }
    }
}
