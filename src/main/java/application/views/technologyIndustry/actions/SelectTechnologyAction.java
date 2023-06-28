package application.views.technologyIndustry.actions;

import application.baseObjects.actions.ListAction;
import application.views.technologyIndustry.TechnologyIndustryView;
import data.objects.technology.technologyTree.*;

import javax.swing.event.ListSelectionEvent;

import java.util.ArrayList;
import java.util.List;

import static application.views.technologyIndustry.TechnologyIndustryConstants.*;
import static java.lang.String.valueOf;
import static java.util.List.of;

public class SelectTechnologyAction extends ListAction<TechnologyIndustryView> {

    public SelectTechnologyAction(TechnologyIndustryView view) {
        super(view);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        final String selectedTechnologyName = getListFromScrollingList(SCROLLING_LIST_TECHNOLOGIES).getSelectedValue();
        if (selectedTechnologyName != null) {
            final Technology currentTechnology = getView().getModel().getTechnologyByName(getListFromScrollingList(SCROLLING_LIST_TECHNOLOGIES).getSelectedValue());
            getTextfield(TEXTFIELD_NAME).setText(currentTechnology.getName());
            getTextfield(TEXTFIELD_RESEARCH_COST).setText(valueOf(currentTechnology.getResearchCost()));
            getTextfield(TEXTFIELD_START_YEAR).setText(valueOf(currentTechnology.getStartYear()));
            getCheckbox(CHECKBOX_SHOW_EFFECT_AS_DESC).setSelected(currentTechnology.isShowEffectAsDesc());
            getTextfield(TEXTFIELD_PRODUCTION_FACTORY_MAX_EFFICIENCY_FACTOR).setText(valueOf(currentTechnology.getProductionFactoryMaxEfficiencyFactor()));
            getTextfield(TEXTFIELD_LINE_CHANGE_PRODUCTION_EFFICIENCY_FACTOR).setText(valueOf(currentTechnology.getLineChangeProductionEfficiencyFactor()));
            getTextfield(TEXTFIELD_PRODUCTION_FACTORY_EFFICIENCY_GAIN_FACTOR).setText(valueOf(currentTechnology.getProductionFactoryEfficiencyGainFactor()));
            getTextfield(TEXTFIELD_EQUIPMENT_CONVERSION_SPEED).setText(valueOf(currentTechnology.getEquipmentConversionSpeed()));
            getTextfield(TEXTFIELD_INDUSTRIAL_CAPACITY_FACTORY).setText(valueOf(currentTechnology.getIndustrialCapacityFactory()));
            getTextfield(TEXTFIELD_INDUSTRIAL_CAPACITY_DOCKYARD).setText(valueOf(currentTechnology.getIndustrialCapacityDockyard()));
            getTextfield(TEXTFIELD_GLOBAL_BUILDING_SLOTS_FACTOR).setText(valueOf(currentTechnology.getGlobalBuildingSlotsFactor()));
            getTextfield(TEXTFIELD_PRODUCTION_FACTORY_START_EFFICIENCY_FACTOR).setText(valueOf(currentTechnology.getProductionFactoryStartEfficiencyFactor()));
            getTextfield(TEXTFIELD_INDUSTRY_AIR_DAMAGE_FACTOR).setText(valueOf(currentTechnology.getIndustryAirDamageFactor()));
            getTextfield(TEXTFIELD_FUEL_GAIN_FACTOR).setText(valueOf(currentTechnology.getFuelGainFactor()));
            getTextfield(TEXTFIELD_FUEL_GAIN_FROM_STATE).setText(valueOf(currentTechnology.getFuelGainFactorFromState()));
            getTextfield(TEXTFIELD_PRODUCTION_SPEED_BUILDINGS_FACTOR).setText(valueOf(currentTechnology.getProductionSpeedBuildingsFactor()));
            getTextfield(TEXTFIELD_INDUSTRY_REPAIR_FACTOR).setText(valueOf(currentTechnology.getIndustryRepairFactor()));
            getTextfield(TEXTFIELD_LOCAL_RESOURCES_FACTOR).setText(valueOf(currentTechnology.getLocalResourcesFactor()));
            getTextfield(TEXTFIELD_COORDINATE_X).setText(valueOf(currentTechnology.getFolder().getPosition().getX()));
            getTextfield(TEXTFIELD_COORDINATE_Y).setText(valueOf(currentTechnology.getFolder().getPosition().getY()));
            final List<TechnologyPath> technologyPaths = currentTechnology.getTechnologyPaths();
            final List<String> pathIndexes = new ArrayList<>();
            for (int i = 0; i < technologyPaths.size(); i++) {
                pathIndexes.add(valueOf(i + 1));
            }
            getScrollingList(SCROLLING_LIST_PATHS).updateElements(pathIndexes);
            final List<String> categorieNames = currentTechnology.getCategories().getCategorieNames();
            getScrollingList(SCROLLING_LIST_CATEGORIES).updateElements(categorieNames);
            final TechnologyXOR technologyXOR = currentTechnology.getXor();
            if (technologyXOR != null) {
                getCheckbox(CHECKBOX_XOR).setSelected(true);
                getCombobox(COMBOBOX_XOR_TECHNOLOGIES).setSelectedItem(currentTechnology.getXor().getTechnologies().get(0));
            } else {
                getCheckbox(CHECKBOX_XOR).setSelected(false);
                getCombobox(COMBOBOX_XOR_TECHNOLOGIES).setSelectedItem("");
            }
            new ActivateXORFieldsAction(getView()).actionPerformed(null);
            final TechnologyEnableBuilding technologyEnableBuilding = currentTechnology.getEnableBuilding();
            if(technologyEnableBuilding != null) {
                getCheckbox(CHECKBOX_ENABLE_BUILDING).setSelected(true);
                getCombobox(COMBOBOX_ENABLE_BUILDING_BUILDINGS).setSelectedItem(currentTechnology.getEnableBuilding().getBuilding());
                getTextfield(TEXTFIELD_BUILDING_LEVEL).setText(valueOf(technologyEnableBuilding.getLevel()));
            } else {
                getCheckbox(CHECKBOX_ENABLE_BUILDING).setSelected(false);
                getCombobox(COMBOBOX_ENABLE_BUILDING_BUILDINGS).setSelectedItem("");
                getTextfield(TEXTFIELD_BUILDING_LEVEL).setText("");
            }
            new ActivateEnableBuildingFieldsAction(getView()).actionPerformed(null);
            final TechnologyOnResearchComplete technologyOnResearchComplete = currentTechnology.getOnResearchComplete();
            if(technologyOnResearchComplete != null) {
                getCheckbox(CHECKBOX_ON_RESEARCH_COMPLETE).setSelected(true);
                final TechnologyOnResearchCompleteModifyBuildingResources technologyOnResearchCompleteModifyBuildingResources = technologyOnResearchComplete.getModifyBuildingResources();
                if(technologyOnResearchCompleteModifyBuildingResources != null) {
                    getCheckbox(CHECKBOX_MODIFIY_BUILDING_RESOURCES).setSelected(true);
                    getCombobox(COMBOBOX_MODIFIY_BUILDING_BUILDINGS).setSelectedItem(technologyOnResearchCompleteModifyBuildingResources.getBuilding());
                    getCombobox(COMBOBOX_RESOURCES).setSelectedItem(technologyOnResearchCompleteModifyBuildingResources.getResource());
                    getTextfield(TEXTFIELD_AMOUNT).setText(valueOf(technologyOnResearchCompleteModifyBuildingResources.getAmount()));
                }
            } else {
                getCheckbox(CHECKBOX_ON_RESEARCH_COMPLETE).setSelected(false);
                getCheckbox(CHECKBOX_MODIFIY_BUILDING_RESOURCES).setSelected(false);
                getCombobox(COMBOBOX_MODIFIY_BUILDING_BUILDINGS).setSelectedItem("");
                getCombobox(COMBOBOX_RESOURCES).setSelectedItem("");
                getTextfield(TEXTFIELD_AMOUNT).setText("");
            }
            new ActivateOnResearchCompleteFieldsAction(getView()).actionPerformed(null);
            new ActivateModifyBuildingResourcesFieldsAction(getView()).actionPerformed(null);
        } else {
            getTextfield(TEXTFIELD_NAME).setText("");
            getTextfield(TEXTFIELD_RESEARCH_COST).setText("");
            getTextfield(TEXTFIELD_START_YEAR).setText("");
            getCheckbox(CHECKBOX_SHOW_EFFECT_AS_DESC).setSelected(false);
            getTextfield(TEXTFIELD_PRODUCTION_FACTORY_MAX_EFFICIENCY_FACTOR).setText("");
            getTextfield(TEXTFIELD_LINE_CHANGE_PRODUCTION_EFFICIENCY_FACTOR).setText("");
            getTextfield(TEXTFIELD_PRODUCTION_FACTORY_EFFICIENCY_GAIN_FACTOR).setText("");
            getTextfield(TEXTFIELD_EQUIPMENT_CONVERSION_SPEED).setText("");
            getTextfield(TEXTFIELD_INDUSTRIAL_CAPACITY_FACTORY).setText("");
            getTextfield(TEXTFIELD_INDUSTRIAL_CAPACITY_DOCKYARD).setText("");
            getTextfield(TEXTFIELD_GLOBAL_BUILDING_SLOTS_FACTOR).setText("");
            getTextfield(TEXTFIELD_PRODUCTION_FACTORY_START_EFFICIENCY_FACTOR).setText("");
            getTextfield(TEXTFIELD_INDUSTRY_AIR_DAMAGE_FACTOR).setText("");
            getTextfield(TEXTFIELD_FUEL_GAIN_FACTOR).setText("");
            getTextfield(TEXTFIELD_FUEL_GAIN_FROM_STATE).setText("");
            getTextfield(TEXTFIELD_PRODUCTION_SPEED_BUILDINGS_FACTOR).setText("");
            getTextfield(TEXTFIELD_INDUSTRY_REPAIR_FACTOR).setText("");
            getTextfield(TEXTFIELD_LOCAL_RESOURCES_FACTOR).setText("");
            getTextfield(TEXTFIELD_COORDINATE_X).setText("");
            getTextfield(TEXTFIELD_COORDINATE_Y).setText("");
            getScrollingList(SCROLLING_LIST_CATEGORIES).updateElements(of(""));
            getScrollingList(SCROLLING_LIST_PATHS).updateElements(of(""));
            getListFromScrollingList(SCROLLING_LIST_TECHNOLOGIES).clearSelection();
        }
    }
}