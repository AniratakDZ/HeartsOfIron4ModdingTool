package application.views.technologyIndustry.actions;

import application.baseObjects.actions.ClickAction;
import application.views.technologyIndustry.TechnologyIndustryConstants;
import application.views.technologyIndustry.TechnologyIndustryView;
import data.objects.technology.technologyTree.TechnologyOnResearchCompleteModifyBuildingResources;

import java.awt.event.ActionEvent;

import static application.views.technologyIndustry.TechnologyIndustryConstants.*;
import static java.lang.String.valueOf;

public class ActivateModifyBuildingResourcesFieldsAction extends ClickAction<TechnologyIndustryView> {

    public ActivateModifyBuildingResourcesFieldsAction(TechnologyIndustryView view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final boolean isChecked = getCheckbox(CHECKBOX_MODIFIY_BUILDING_RESOURCES).isSelected();
        if (isChecked) {
            getCombobox(COMBOBOX_MODIFIY_BUILDING_BUILDINGS).setEnabled(true);
            getCombobox(COMBOBOX_RESOURCES).setEnabled(true);
            getTextfield(TEXTFIELD_AMOUNT).setEnabled(true);
            final TechnologyOnResearchCompleteModifyBuildingResources technologyOnResearchCompleteModifyBuildingResources = getView().getModel().getTechnologyByName(getListFromScrollingList(SCROLLING_LIST_TECHNOLOGIES).getSelectedValue()).getOnResearchComplete().getModifyBuildingResources();
            if (technologyOnResearchCompleteModifyBuildingResources != null) {
                getCombobox(COMBOBOX_MODIFIY_BUILDING_BUILDINGS).setSelectedItem(technologyOnResearchCompleteModifyBuildingResources.getBuilding());
                getCombobox(COMBOBOX_RESOURCES).setSelectedItem(technologyOnResearchCompleteModifyBuildingResources.getResource());
                getTextfield(TEXTFIELD_AMOUNT).setText(valueOf(technologyOnResearchCompleteModifyBuildingResources.getAmount()));
            }

        } else {
            getCombobox(COMBOBOX_MODIFIY_BUILDING_BUILDINGS).setEnabled(false);
            getCombobox(COMBOBOX_MODIFIY_BUILDING_BUILDINGS).setSelectedItem("");
            getCombobox(COMBOBOX_RESOURCES).setEnabled(false);
            getCombobox(COMBOBOX_RESOURCES).setSelectedItem("");
            getTextfield(TEXTFIELD_AMOUNT).setEnabled(false);
            getTextfield(TEXTFIELD_AMOUNT).setText("");
        }
    }
}
