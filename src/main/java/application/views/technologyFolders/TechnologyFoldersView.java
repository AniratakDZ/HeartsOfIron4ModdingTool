package application.views.technologyFolders;

import application.baseObjects.BaseView;
import application.views.technologyFolders.actions.*;
import data.DataManager;
import data.objects.technology.technologyFolderAndCategories.TechnologyFoldersInstance;

import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TechnologyFoldersView extends BaseView<TechnologyFoldersModel> implements TechnologyFoldersConstants {

    public TechnologyFoldersView(TechnologyFoldersModel model) {
        super(model);
        this.setModel(model);
        setLayout(null);

        addScrollingList(SCROLLING_LIST_FOLDERS, 0, 0);
        addTextfield(TEXTFIELD_NAME,400, 0);
        addComboBox(COMBOBOX_LEDGER, 400, 25);
        addCheckBox(CHECKBOX_DOCTRINE, 397, 50);
        addCheckBox(CHECKBOX_AVAILABLE_CONDITION, 397, 75);
        addComboBox(COMBOBOX_AVAILABLE_CONDITION_HAS_DLC, 400, 100, false);
        addCheckBox(CHECKBOX_NOT_CONDITION, 397, 125, false);
        addComboBox(COMBOBOX_CONDITION_NOT_HAS_DLC, 400, 150, false);
        addButton(BUTTON_ADD, "+", 0, 200);
        addButton(BUTTON_REMOVE, "-", 100, 200);
        addButton(BUTTON_CLEAR, "C", 200, 200);
        addLabel(LABEL_NAME, "Name: ", 300, 0);
        addLabel(LABEL_LEDGER, "Technologie Typ: ", 300, 25);
        addLabel(LABEL_DOCTRINE, "Doktrin: ", 300, 50);
        addLabel(LABEL_AVAILABLE_CONDITION, "Verfügbar wenn: ", 300 ,75);
        addLabel(LABEL_AVAILABLE_CONDITION_HAS_DLC, "DLC: ", 300, 100, false);
        addLabel(LABEL_NOT_CONDITION, "Nicht verfügbar wenn: ", 300 ,125, false);
        addLabel(LABEL_NOT_CONDITION_HAS_DLC, "DLC: ", 300, 150, false);

        final List<String> ledgerData = Arrays.asList("", "army", "air", "navy", "civilian");
        fillCombobox(COMBOBOX_LEDGER, ledgerData);
        final List<String> dlcData = Arrays.asList("", "\"No Step Back\"", "\"By Blood Alone\"", "\"Man the Guns\"");
        fillCombobox(COMBOBOX_CONDITION_NOT_HAS_DLC, dlcData);
        fillCombobox(COMBOBOX_AVAILABLE_CONDITION_HAS_DLC, dlcData);

        addListAction(SCROLLING_LIST_FOLDERS, new SelectFolderAction(this));
        addClickAction(BUTTON_ADD, new AddTechnologyFolderAction(this));
        addClickAction(BUTTON_CLEAR, new ClearCurrentTechnologyFolderAction(this));
        addClickAction(BUTTON_REMOVE, new RemoveTechnologyFolderAction(this));
        addClickAction(CHECKBOX_AVAILABLE_CONDITION, new CheckAvailableConditionAction(this));
        addClickAction(CHECKBOX_NOT_CONDITION, new CheckNotConditionAction(this));
    }

    @Override
    public void updateView() {
        getScrollingList(SCROLLING_LIST_FOLDERS).updateElements(getModel().getTechnologyFolders().getFolderInstances().stream().map(TechnologyFoldersInstance::getName).collect(Collectors.toList()));
        DataManager.getTechnologyFolderAndCategories().setFolders(getModel().getTechnologyFolders());
    }
}