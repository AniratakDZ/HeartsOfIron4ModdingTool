package application.views.technologyIndustry.actions;

import application.baseObjects.actions.ClickAction;
import application.views.technologyIndustry.TechnologyIndustryConstants;
import application.views.technologyIndustry.TechnologyIndustryView;

import java.awt.event.ActionEvent;

import static application.views.technologyIndustry.TechnologyIndustryConstants.CHECKBOX_MODIFIY_BUILDING_RESOURCES;
import static application.views.technologyIndustry.TechnologyIndustryConstants.CHECKBOX_ON_RESEARCH_COMPLETE;

public class ActivateOnResearchCompleteFieldsAction extends ClickAction<TechnologyIndustryView> {

    public ActivateOnResearchCompleteFieldsAction(TechnologyIndustryView view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final boolean isChecked = getCheckbox(CHECKBOX_ON_RESEARCH_COMPLETE).isSelected();
        getCheckbox(CHECKBOX_MODIFIY_BUILDING_RESOURCES).setEnabled(isChecked);
    }
}
