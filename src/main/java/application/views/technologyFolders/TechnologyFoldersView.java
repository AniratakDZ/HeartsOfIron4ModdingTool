package application.views.technologyFolders;

import application.baseObjects.BaseView;
import application.views.technologyFolders.actions.*;
import data.DataManager;
import data.objects.technology.technologyFolderAndCategories.TechnologyFoldersInstance;
import data.objects.technology.technologyFolderAndCategories.TechnologyFoldersInstanceAvailable;
import data.objects.technology.technologyFolderAndCategories.TechnologyFoldersInstanceAvailableNot;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class TechnologyFoldersView extends BaseView<TechnologyFoldersModel> {

    public final JList<String> folderList;
    public final DefaultListModel<String> folderListModel;
    public final JTextField nameTextField;
    public final JComboBox<String> ledgerComboBox;
    public final JCheckBox doctrineCheckbox;
    public final JCheckBox availableConditionCheckbox;
    public final JComboBox<String> availableConditionHasDlcComboBox;
    public final JCheckBox conditionNotCheckbox;
    public final JComboBox<String> conditionNotHasDlcComboBox;
    public final JLabel availableConditionHasDlcLabel;
    public final JLabel conditionNotLabel;
    public final JLabel conditionNotHasDlcLabel;

    public TechnologyFoldersView(TechnologyFoldersModel model) {
        super(model);
        this.setModel(model);

        folderListModel = new DefaultListModel<>();
        folderList = new JList<>(folderListModel);
        nameTextField = new JTextField();
        ledgerComboBox = new JComboBox<>();
        doctrineCheckbox = new JCheckBox();
        availableConditionCheckbox = new JCheckBox();
        availableConditionHasDlcComboBox = new JComboBox<>();
        conditionNotCheckbox = new JCheckBox();
        conditionNotHasDlcComboBox = new JComboBox<>();

        ledgerComboBox.addItem("");
        ledgerComboBox.addItem("army");
        ledgerComboBox.addItem("air");
        ledgerComboBox.addItem("navy");
        ledgerComboBox.addItem("civilian");

        final List<String> dlcs = new ArrayList<>(asList("", "\"No Step Back\"", "\"By Blood Alone\"", "\"Man the Guns\""));
        for(String dlc : dlcs) {
            availableConditionHasDlcComboBox.addItem(dlc);
            conditionNotHasDlcComboBox.addItem(dlc);
        }

        JScrollPane scrollPane = new JScrollPane(folderList);
        JButton addButton = new JButton("+");
        JButton removeButton = new JButton("-");
        JButton clearButton = new JButton("C");
        JLabel nameLabel = new JLabel("Name: ");
        JLabel ledgerLabel = new JLabel("Technologie Typ: ");
        JLabel doctrineLabel = new JLabel("Doktrin: ");
        JLabel availableConditionLabel = new JLabel("Verfügbar wenn: ");
        availableConditionHasDlcLabel = new JLabel("DLC: ");
        conditionNotLabel = new JLabel("Nicht verfügbar wenn: ");
        conditionNotHasDlcLabel = new JLabel("DLC: ");

        setLayout(null);

        scrollPane.setBounds(0, 0, 300, 200);
        addButton.setBounds(0, 200, 100, 25);
        removeButton.setBounds(100, 200, 100, 25);
        clearButton.setBounds(200, 200, 100, 25);
        nameLabel.setBounds(300, 0, 100, 25);
        nameTextField.setBounds(400, 0, 175, 25);
        ledgerLabel.setBounds(300, 25, 100, 25);
        ledgerComboBox.setBounds(400, 25, 175, 25);
        doctrineLabel.setBounds(300, 50, 100, 25);
        doctrineCheckbox.setBounds(397, 37, 50, 50);
        availableConditionLabel.setBounds(300, 75, 100, 25);
        availableConditionCheckbox.setBounds(397, 62, 50, 50);
        availableConditionHasDlcLabel.setBounds(300, 100, 100, 25);
        availableConditionHasDlcComboBox.setBounds(400, 100, 175, 25);
        conditionNotLabel.setBounds(300, 125, 100, 25);
        conditionNotCheckbox.setBounds(397, 112, 50, 50);
        conditionNotHasDlcLabel.setBounds(300, 150, 100, 25);
        conditionNotHasDlcComboBox.setBounds(400, 150, 175, 25);

        availableConditionHasDlcLabel.setVisible(false);
        availableConditionHasDlcComboBox.setVisible(false);
        conditionNotLabel.setVisible(false);
        conditionNotCheckbox.setVisible(false);
        conditionNotHasDlcLabel.setVisible(false);
        conditionNotHasDlcComboBox.setVisible(false);

        folderList.addListSelectionListener(new SelectFolderAction(this));
        addButton.addActionListener(new AddTechnologyFolderAction(this));
        clearButton.addActionListener(new ClearCurrentTechnologyFolderAction(this));
        removeButton.addActionListener(new RemoveTechnologyFolderAction(this));
        availableConditionCheckbox.addActionListener(new CheckAvailableConditionAction(this));
        conditionNotCheckbox.addActionListener(new CheckNotConditionAction(this));

        add(scrollPane);
        add(addButton);
        add(removeButton);
        add(clearButton);
        add(nameLabel);
        add(nameTextField);
        add(ledgerLabel);
        add(ledgerComboBox);
        add(doctrineLabel);
        add(doctrineCheckbox);
        add(availableConditionLabel);
        add(availableConditionCheckbox);
        add(availableConditionHasDlcLabel);
        add(availableConditionHasDlcComboBox);
        add(conditionNotLabel);
        add(conditionNotCheckbox);
        add(conditionNotHasDlcLabel);
        add(conditionNotHasDlcComboBox);
    }

    @Override
    public void updateView() {
        folderListModel.removeAllElements();
        final List<String> folderNames = getModel().getTechnologyFolders().getFolderInstances().stream().map(TechnologyFoldersInstance::getName).collect(Collectors.toList());;
        for(String element : folderNames) {
            folderListModel.addElement(element);
        }
        DataManager.getTechnologyFolderAndCategories().setFolders(getModel().getTechnologyFolders());
    }
}