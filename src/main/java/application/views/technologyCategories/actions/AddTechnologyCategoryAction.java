package application.views.technologyCategories.actions;

import application.baseObjects.actions.ClickAction;
import application.views.technologyCategories.TechnologyCategoriesView;

import java.awt.event.ActionEvent;

import static application.views.technologyCategories.TechnologyCategoriesConstants.SCROLLING_LIST_CATEGORIES;
import static application.views.technologyCategories.TechnologyCategoriesConstants.TEXTFIELD_NAME;

public class AddTechnologyCategoryAction extends ClickAction<TechnologyCategoriesView> {

    public AddTechnologyCategoryAction(TechnologyCategoriesView view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final String selectedValue = getListFromScrollingList(SCROLLING_LIST_CATEGORIES).getSelectedValue();
        final String newCategoryValue = getTextfield(TEXTFIELD_NAME).getText();
        if(selectedValue != null) {
            getView().getModel().updateCategory(getView().getModel().getCategories().indexOf(selectedValue), newCategoryValue);
            updateView();
            getListFromScrollingList(SCROLLING_LIST_CATEGORIES).setSelectedValue(newCategoryValue, true);
        } else if(!newCategoryValue.isEmpty()) {
            getView().getModel().addCategory(newCategoryValue);
            updateView();
            getListFromScrollingList(SCROLLING_LIST_CATEGORIES).setSelectedValue(newCategoryValue, true);
        }
    }
}