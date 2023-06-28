package application.views.technologyIndustry.actions;

import application.baseObjects.actions.ClickAction;
import application.views.technologyIndustry.TechnologyIndustryView;
import data.objects.technology.technologyTree.TechnologyEnableBuilding;

import java.awt.event.ActionEvent;

import static application.views.technologyIndustry.TechnologyIndustryConstants.*;
import static java.lang.String.valueOf;

public class ActivateEnableBuildingFieldsAction extends ClickAction<TechnologyIndustryView> {

    public ActivateEnableBuildingFieldsAction(TechnologyIndustryView view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final boolean isChecked = getCheckbox(CHECKBOX_ENABLE_BUILDING).isSelected();
        if(isChecked) {
            getCombobox(COMBOBOX_ENABLE_BUILDING_BUILDINGS).setEnabled(true);
            getTextfield(TEXTFIELD_BUILDING_LEVEL).setEnabled(true);
            final TechnologyEnableBuilding technologyEnableBuilding = getView().getModel().getTechnologyByName(getListFromScrollingList(SCROLLING_LIST_TECHNOLOGIES).getSelectedValue()).getEnableBuilding();
            if(technologyEnableBuilding != null) {
                getCombobox(COMBOBOX_ENABLE_BUILDING_BUILDINGS).setSelectedItem(technologyEnableBuilding.getBuilding());
                getTextfield(TEXTFIELD_BUILDING_LEVEL).setText(valueOf(technologyEnableBuilding.getLevel()));
            }
        } else {
            getCombobox(COMBOBOX_ENABLE_BUILDING_BUILDINGS).setEnabled(false);
            getCombobox(COMBOBOX_ENABLE_BUILDING_BUILDINGS).setSelectedItem("");
            getTextfield(TEXTFIELD_BUILDING_LEVEL).setEnabled(false);
            getTextfield(TEXTFIELD_BUILDING_LEVEL).setText("");
        }
    }
}
