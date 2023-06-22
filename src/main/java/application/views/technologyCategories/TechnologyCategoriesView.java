package application.views.technologyCategories;

import application.baseObjects.BaseView;
import application.views.technologyCategories.actions.AddTechnologyCategoryAction;
import application.views.technologyCategories.actions.ClearCurrentTechnologyCategoryAction;
import application.views.technologyCategories.actions.RemoveTechnologyCategoryAction;
import application.views.technologyCategories.actions.SelectCategoryAction;
import data.DataManager;

import javax.swing.*;

public class TechnologyCategoriesView extends BaseView<TechnologyCategoriesModel> {

    public final JList<String> categoryList;
    public final DefaultListModel<String> categoryListModel;
    public final JTextField nameTextfield = new JTextField();

    public TechnologyCategoriesView(TechnologyCategoriesModel model) {
        super(model);
        this.setModel(model);

        categoryListModel = new DefaultListModel<>();
        categoryList = new JList<>(categoryListModel);

        JScrollPane scrollPane = new JScrollPane(categoryList);
        JButton addButton = new JButton("+");
        JButton removeButton = new JButton("-");
        JButton clearButton = new JButton("C");
        JLabel nameLabel = new JLabel("Name: ");

        setLayout(null);

        scrollPane.setBounds(0, 0, 300, 200);
        addButton.setBounds(0, 200, 100, 25);
        removeButton.setBounds(100, 200, 100, 25);
        nameLabel.setBounds(300, 0, 100, 25);
        nameTextfield.setBounds(400, 0, 175, 25);
        clearButton.setBounds(200, 200, 100, 25);

        categoryList.addListSelectionListener(new SelectCategoryAction(this));
        clearButton.addActionListener(new ClearCurrentTechnologyCategoryAction(this));
        addButton.addActionListener(new AddTechnologyCategoryAction(this));
        removeButton.addActionListener(new RemoveTechnologyCategoryAction(this));

        add(scrollPane);
        add(addButton);
        add(removeButton);
        add(nameLabel);
        add(nameTextfield);
        add(clearButton);
    }

    @Override
    public void updateView() {
        categoryListModel.removeAllElements();
        for(String element : getModel().getCategories()) {
            categoryListModel.addElement(element);
        }
        DataManager.getTechnologyFolderAndCategories().getCategories().setCategories(getModel().getCategories());
    }
}
