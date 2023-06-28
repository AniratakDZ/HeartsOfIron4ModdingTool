package application.views.technologyIndustry.actions;

import application.baseObjects.actions.ClickAction;
import application.views.technologyIndustry.TechnologyIndustryConstants;
import application.views.technologyIndustry.TechnologyIndustryView;

import java.awt.event.ActionEvent;

import static application.views.technologyIndustry.TechnologyIndustryConstants.CHECKBOX_XOR;
import static application.views.technologyIndustry.TechnologyIndustryConstants.COMBOBOX_XOR_TECHNOLOGIES;

public class ActivateXORFieldsAction extends ClickAction<TechnologyIndustryView> {

    public ActivateXORFieldsAction(TechnologyIndustryView view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final boolean isChecked = getCheckbox(CHECKBOX_XOR).isSelected();
        getCombobox(COMBOBOX_XOR_TECHNOLOGIES).setEnabled(isChecked);
    }
}
