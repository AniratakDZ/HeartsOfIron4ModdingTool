package application.views.technologyFolders.actions;

import application.baseObjects.actions.ClickAction;
import application.views.technologyFolders.TechnologyFoldersView;

import java.awt.event.ActionEvent;

public class CheckNotConditionAction extends ClickAction<TechnologyFoldersView> {

    public CheckNotConditionAction(TechnologyFoldersView view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(getView().conditionNotCheckbox.isSelected()) {
            getView().conditionNotHasDlcLabel.setVisible(true);
            getView().conditionNotHasDlcComboBox.setVisible(true);
        } else {
            getView().conditionNotHasDlcLabel.setVisible(false);
            getView().conditionNotHasDlcComboBox.setVisible(false);
        }
    }
}
