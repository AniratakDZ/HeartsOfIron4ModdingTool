package application.views.technologyCategories.actions;

import application.baseObjects.actions.ClickAction;
import application.views.technologyCategories.TechnologyCategoriesView;

import java.awt.event.ActionEvent;

public class ClearCurrentTechnologyCategoryAction extends ClickAction<TechnologyCategoriesView> {

    public ClearCurrentTechnologyCategoryAction(TechnologyCategoriesView view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getView().categoryList.clearSelection();
        getView().nameTextfield.setText("");
    }
}
