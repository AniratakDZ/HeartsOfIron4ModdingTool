package application.views.technologyIndustry;

import application.baseObjects.JComboBox;
import application.baseObjects.ScrollingView;
import application.baseObjects.actions.ClearAction;
import application.views.technologyIndustry.actions.*;
import data.DataManager;
import data.objects.technology.technologyTree.Technology;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TechnologyIndustryView extends ScrollingView<TechnologyIndustryModel> implements TechnologyIndustryConstants {

    public TechnologyIndustryView(TechnologyIndustryModel model) {
        super(model);

        //ScrollingPane Initialization
        addCategory(CATEGORY_GENERAL);
        addSSingletonTextfield(CATEGORY_GENERAL, TEXTFIELD_LOCAL_RESOURCES_FACTOR, LABEL_LOCAL_RESOURCES_FACTOR, "Local Resources Factor");

        addCategory(CATEGORY_POLITICS);

        addCategory(CATEGORY_DIPLOMACY);

        addCategory(CATEGORY_AUTONOMY);

        addCategory(CATEGORY_GOVERNMENTS_IN_EXILE);

        addCategory(CATEGORY_EQUIPMENT);
        addSSingletonTextfield(CATEGORY_EQUIPMENT, TEXTFIELD_PRODUCTION_FACTORY_MAX_EFFICIENCY_FACTOR, LABEL_PRODUCTION_FACTORY_MAX_EFFICIENCY_FACTOR, "Production Factory Max Efficiency Factor");
        addSSingletonTextfield(CATEGORY_EQUIPMENT, TEXTFIELD_PRODUCTION_FACTORY_EFFICIENCY_GAIN_FACTOR, LABEL_PRODUCTION_FACTORY_EFFICIENCY_GAIN_FACTOR, "Production Efficiency Gain Factor");
        addSSingletonTextfield(CATEGORY_EQUIPMENT, TEXTFIELD_EQUIPMENT_CONVERSION_SPEED, LABEL_EQUIPMENT_CONVERSION_SPEED, "Equipment Conversion Speed");
        addSSingletonTextfield(CATEGORY_EQUIPMENT, TEXTFIELD_PRODUCTION_FACTORY_START_EFFICIENCY_FACTOR, LABEL_PRODUCTION_FACTORY_START_EFFICIENCY_FACTOR, "Production Factory Start Efficiency Factor");

        addCategory(CATEGORY_FUEL_AND_SUPPLY);
        addSSingletonTextfield(CATEGORY_FUEL_AND_SUPPLY, TEXTFIELD_FUEL_GAIN_FACTOR, LABEL_FUEL_GAIN_FACTOR, "Fuel Gain Factor");
        addSSingletonTextfield(CATEGORY_FUEL_AND_SUPPLY, TEXTFIELD_FUEL_GAIN_FROM_STATE, LABEL_FUEL_GAIN_FROM_STATE, "Fuel Gain From State");

        addCategory(CATEGORY_BUILDINGS);
        addSSingletonTextfield(CATEGORY_BUILDINGS, TEXTFIELD_LINE_CHANGE_PRODUCTION_EFFICIENCY_FACTOR, LABEL_LINE_CHANGE_PRODUCTION_EFFICIENCY_FACTOR, "Line Change Production Efficiency Factor");
        addSSingletonTextfield(CATEGORY_BUILDINGS, TEXTFIELD_INDUSTRIAL_CAPACITY_FACTORY, LABEL_INDUSTRIAL_CAPACITY_FACTORY, "Industrial Capacity Factory");
        addSSingletonTextfield(CATEGORY_BUILDINGS, TEXTFIELD_INDUSTRIAL_CAPACITY_DOCKYARD, LABEL_INDUSTRIAL_CAPACITY_DOCKYARD, "Industrial Capacity Dockyard");
        addSSingletonTextfield(CATEGORY_BUILDINGS, TEXTFIELD_GLOBAL_BUILDING_SLOTS_FACTOR, LABEL_GLOBAL_BUILDING_SLOTS_FACTOR, "Global Building Slots Factor");
        addSSingletonTextfield(CATEGORY_BUILDINGS, TEXTFIELD_INDUSTRY_AIR_DAMAGE_FACTOR, LABEL_INDUSTRY_AIR_DAMAGE_FACTOR, "Industry Air Damage Factor");
        addSSingletonTextfield(CATEGORY_BUILDINGS, TEXTFIELD_PRODUCTION_SPEED_BUILDINGS_FACTOR, LABEL_PRODUCTION_SPEED_BUILDINGS_FACTOR, "Production Speed Buildings Factor");
        addSSingletonTextfield(CATEGORY_BUILDINGS, TEXTFIELD_INDUSTRY_REPAIR_FACTOR, LABEL_INDUSTRY_REPAIR_FACTOR, "Industry Repair Factor");

        addCategory(CATEGORY_RESISTANCE_AND_COMPLIANCE);

        addCategory(CATEGORY_INTELLIGENCE);

        addCategory(CATEGORY_OPERATIVES);

        addCategory(CATEGORY_AI);

        addCategory(CATEGORY_MILITARY_OUTSIDE_OF_COMBAT);

        addCategory(CATEGORY_UNIT_LEADERS);

        addCategory(CATEGORY_GENERAL_COMBAT);

        addCategory(CATEGORY_LAND_COMBAT);

        addCategory(CATEGORY_NAVAL_INVASIONS);

        addCategory(CATEGORY_NAVAL_COMBAT);

        addCategory(CATEGORY_CARRIERS_AND_THEIR_PLANES);

        addCategory(CATEGORY_AIR_COMBAT);

        addCategory(CATEGORY_TARGETED_MODIFIERS);

        //MainPane Initialization

        /*addScrollingList(SCROLLING_LIST_TECHNOLOGIES, 5, 25);
        addScrollingList(SCROLLING_LIST_PATHS, 815, 25);
        addScrollingList(SCROLLING_LIST_CATEGORIES, 815, 275);

        addTextfield(TEXTFIELD_NAME, 560, 0);
        addTextfield(TEXTFIELD_RESEARCH_COST, 560, 25);
        addTextfield(TEXTFIELD_START_YEAR, 560, 50);
        addTextfield(TEXTFIELD_PRODUCTION_FACTORY_MAX_EFFICIENCY_FACTOR, 560, 100);
        addTextfield(TEXTFIELD_LINE_CHANGE_PRODUCTION_EFFICIENCY_FACTOR, 560, 125);
        addTextfield(TEXTFIELD_PRODUCTION_FACTORY_EFFICIENCY_GAIN_FACTOR, 560, 150);
        addTextfield(TEXTFIELD_EQUIPMENT_CONVERSION_SPEED, 560, 175);
        addTextfield(TEXTFIELD_INDUSTRIAL_CAPACITY_FACTORY, 560, 200);
        addTextfield(TEXTFIELD_INDUSTRIAL_CAPACITY_DOCKYARD, 560, 225);
        addTextfield(TEXTFIELD_GLOBAL_BUILDING_SLOTS_FACTOR, 560, 250);
        addTextfield(TEXTFIELD_PRODUCTION_FACTORY_START_EFFICIENCY_FACTOR, 560, 275);
        addTextfield(TEXTFIELD_INDUSTRY_AIR_DAMAGE_FACTOR, 560, 300);
        addTextfield(TEXTFIELD_FUEL_GAIN_FACTOR, 560, 325);
        addTextfield(TEXTFIELD_FUEL_GAIN_FROM_STATE, 560, 350);
        addTextfield(TEXTFIELD_PRODUCTION_SPEED_BUILDINGS_FACTOR, 560, 375);
        addTextfield(TEXTFIELD_INDUSTRY_REPAIR_FACTOR, 560, 400);
        addTextfield(TEXTFIELD_LOCAL_RESOURCES_FACTOR, 560, 425);
        addTextfield(TEXTFIELD_COORDINATE_X, 560, 450);
        addTextfield(TEXTFIELD_COORDINATE_Y, 560, 475);
        addTextfield(TEXTFIELD_RESEARCH_COST_COEFF, 1370, 50);
        addTextfield(TEXTFIELD_BUILDING_LEVEL, 560, 600, true);
        addTextfield(TEXTFIELD_AMOUNT, 560, 725, true);

        addCheckBox(CHECKBOX_SHOW_EFFECT_AS_DESC, 557, 75);
        addCheckBox(CHECKBOX_XOR, 557, 500);
        addCheckBox(CHECKBOX_ENABLE_BUILDING, 557, 550);
        addCheckBox(CHECKBOX_ON_RESEARCH_COMPLETE, 557, 625);
        addCheckBox(CHECKBOX_MODIFIY_BUILDING_RESOURCES, 557, 650, true);

        addComboBox(COMBOBOX_TECHNOLOGIES, 1370, 25);
        addComboBox(COMBOBOX_CATEGORIES, 1370, 275);
        addComboBox(COMBOBOX_XOR_TECHNOLOGIES, 560, 525, true);
        addComboBox(COMBOBOX_ENABLE_BUILDING_BUILDINGS, 560, 575, true);
        addComboBox(COMBOBOX_MODIFIY_BUILDING_BUILDINGS, 560, 675, true);
        addComboBox(COMBOBOX_RESOURCES, 560, 700, true);

        addButton(BUTTON_ADD_TECHNOLOGY, "+",5, 225);
        addButton(BUTTON_REMOVE_TECHNOLOGY, "-", 105, 225);
        addButton(BUTTON_CLEAR_TECHNOLOGY, "C", 205, 225);
        addButton(BUTTON_REFRESH_TECHNOLOGY, "R", 5, 250);
        addButton(BUTTON_ADD_PATH, "+", 815, 225);
        addButton(BUTTON_REMOVE_PATH, "-", 915, 225);
        addButton(BUTTON_CLEAR_PATH, "C", 1015, 225);
        addButton(BUTTON_ADD_CATEGORY, "+", 815, 475);
        addButton(BUTTON_REMOVE_CATEGORY, "-", 915, 475);
        addButton(BUTTON_CLEAR_CATEGORY, "C", 1015, 475);

        addListAction(SCROLLING_LIST_TECHNOLOGIES, new SelectTechnologyAction(this));
        addListAction(SCROLLING_LIST_PATHS, new SelectPathAction(this));
        addListAction(SCROLLING_LIST_CATEGORIES, new SelectCategoryAction(this));

        addClickAction(BUTTON_ADD_CATEGORY, new AddCategoryAction(this));
        addClickAction(BUTTON_CLEAR_TECHNOLOGY, new ClearAction(this));
        addClickAction(BUTTON_REFRESH_TECHNOLOGY, new RefreshAction(this));
        addClickAction(CHECKBOX_XOR, new ActivateXORFieldsAction(this));
        addClickAction(CHECKBOX_ENABLE_BUILDING, new ActivateEnableBuildingFieldsAction(this));
        addClickAction(CHECKBOX_ON_RESEARCH_COMPLETE, new ActivateOnResearchCompleteFieldsAction(this));
        addClickAction(CHECKBOX_MODIFIY_BUILDING_RESOURCES, new ActivateModifyBuildingResourcesFieldsAction(this));*/
        updateGUI();
    }

    public void updateView() {
        /*final List<String> buildingData = Arrays.asList("fuel_silo", "synthetic_refinery");
        final List<String> resourceData = Arrays.asList("oil", "steel", "tungsten", "aluminium", "chromium", "rubber", "fuel");
        final int index = getListFromScrollingList(SCROLLING_LIST_TECHNOLOGIES).getSelectedIndex();
        final int categoryIndex = getComboBox(COMBOBOX_CATEGORIES).getSelectedIndex();
        final int technologyIndex = getComboBox(COMBOBOX_XOR_TECHNOLOGIES).getSelectedIndex();
        final int buildingIndex = getComboBox(COMBOBOX_ENABLE_BUILDING_BUILDINGS).getSelectedIndex();
        final int buildingModifyIndex = getComboBox(COMBOBOX_MODIFIY_BUILDING_BUILDINGS).getSelectedIndex();
        final int resourceIndex = getComboBox(COMBOBOX_RESOURCES).getSelectedIndex();
        getScrollingList(SCROLLING_LIST_TECHNOLOGIES).updateElements(getModel().getTechnologies().stream().map(Technology::getName).collect(Collectors.toList()));
        getListFromScrollingList(SCROLLING_LIST_TECHNOLOGIES).setSelectedIndex(index);
        fillCombobox(COMBOBOX_TECHNOLOGIES, getModel().getTechnologies().stream().map(Technology::getName).collect(Collectors.toList()));
        fillCombobox(COMBOBOX_CATEGORIES, DataManager.getTechnologyFolderAndCategories().getCategories().getCategories());
        fillCombobox(COMBOBOX_XOR_TECHNOLOGIES, getModel().getTechnologies().stream().map(Technology::getName).collect(Collectors.toList()));
        fillCombobox(COMBOBOX_ENABLE_BUILDING_BUILDINGS, buildingData);
        fillCombobox(COMBOBOX_MODIFIY_BUILDING_BUILDINGS, buildingData);
        fillCombobox(COMBOBOX_RESOURCES, resourceData);
        getComboBox(COMBOBOX_CATEGORIES).setSelectedIndex(categoryIndex);
        getComboBox(COMBOBOX_XOR_TECHNOLOGIES).setSelectedIndex(technologyIndex);
        getComboBox(COMBOBOX_ENABLE_BUILDING_BUILDINGS).setSelectedIndex(buildingIndex);
        getComboBox(COMBOBOX_MODIFIY_BUILDING_BUILDINGS).setSelectedIndex(buildingModifyIndex);
        getComboBox(COMBOBOX_RESOURCES).setSelectedIndex(resourceIndex);
        DataManager.getTechnologyTree().setTechnologies(getModel().getTechnologies());*/
    }
}