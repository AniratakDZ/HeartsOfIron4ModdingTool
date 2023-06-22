package application.views.technologyFolders.actions;

import application.baseObjects.actions.ClickAction;
import application.views.technologyFolders.TechnologyFoldersView;

import java.awt.event.ActionEvent;

public class CheckAvailableConditionAction extends ClickAction<TechnologyFoldersView> {

    public CheckAvailableConditionAction(TechnologyFoldersView view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(getView().availableConditionCheckbox.isSelected()) {
            getView().availableConditionHasDlcLabel.setVisible(true);
            getView().availableConditionHasDlcComboBox.setVisible(true);
            getView().conditionNotLabel.setVisible(true);
            getView().conditionNotCheckbox.setVisible(true);
        } else {
            getView().availableConditionHasDlcLabel.setVisible(false);
            getView().availableConditionHasDlcComboBox.setVisible(false);
            getView().conditionNotLabel.setVisible(false);
            getView().conditionNotCheckbox.setVisible(false);
        }
    }
}
