package application.views.technologyCategories.actions;

import application.baseObjects.actions.ClickAction;
import application.views.technologyCategories.TechnologyCategoriesView;

import java.awt.event.ActionEvent;

public class AddTechnologyCategoryAction extends ClickAction<TechnologyCategoriesView> {

    public AddTechnologyCategoryAction(TechnologyCategoriesView view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final String selectedValue = getView().categoryList.getSelectedValue();
        final String newCategoryValue = getView().nameTextfield.getText();
        if(selectedValue != null) {
            getView().getModel().updateCategory(getView().getModel().getCategories().indexOf(selectedValue), newCategoryValue);
            getView().updateView();
            getView().categoryList.setSelectedValue(newCategoryValue, true);
        } else if(!newCategoryValue.isEmpty()) {
            getView().getModel().addCategory(newCategoryValue);
            getView().updateView();
            getView().categoryList.setSelectedValue(newCategoryValue, true);
        }
    }
}