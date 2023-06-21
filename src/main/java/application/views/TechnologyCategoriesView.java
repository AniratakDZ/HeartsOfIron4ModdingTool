package application.views;

import application.models.TechnologyCategoriesModel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.BorderLayout.*;

public class TechnologyCategoriesView extends BaseView {

    private final JList<String> categoryList;
    private final DefaultListModel<String> categoryListModel;
    private final JTextField nameTextfield = new JTextField();

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
        nameLabel.setBounds(310, 0, 40, 25);
        nameTextfield.setBounds(350, 0, 200, 25);
        clearButton.setBounds(200, 200, 100, 25);

        categoryList.addListSelectionListener(new CategoryListSelectionListener());
        addButton.addActionListener(new AddButtonActionListener());

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
        for(String element : ((TechnologyCategoriesModel) getModel()).getCategories()) {
            categoryListModel.addElement(element);
        }
    }

    class CategoryListSelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(!e.getValueIsAdjusting()) {
                final String selectedValue = categoryList.getSelectedValue();
                nameTextfield.setText(selectedValue);
            }
        }
    }

    class AddButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
