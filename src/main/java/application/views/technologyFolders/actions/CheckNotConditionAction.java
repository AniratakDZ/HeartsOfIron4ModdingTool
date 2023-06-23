package application.views.technologyFolders.actions;

import application.baseObjects.actions.ClickAction;
import application.views.technologyFolders.TechnologyFoldersConstants;
import application.views.technologyFolders.TechnologyFoldersView;

import java.awt.event.ActionEvent;

import static application.views.technologyFolders.TechnologyFoldersConstants.*;

public class CheckNotConditionAction extends ClickAction<TechnologyFoldersView> {

    public CheckNotConditionAction(TechnologyFoldersView view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(getCheckbox(CHECKBOX_NOT_CONDITION).isSelected()) {
            getLabel(LABEL_NOT_CONDITION_HAS_DLC).setVisible(true);
            getCombobox(COMBOBOX_CONDITION_NOT_HAS_DLC).setVisible(true);
        } else {
            getLabel(LABEL_NOT_CONDITION_HAS_DLC).setVisible(false);
            getCombobox(COMBOBOX_CONDITION_NOT_HAS_DLC).setVisible(false);
        }
    }
}
