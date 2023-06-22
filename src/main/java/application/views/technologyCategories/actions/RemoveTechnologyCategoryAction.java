package application.views.technologyCategories.actions;

import application.baseObjects.actions.ClickAction;
import application.views.technologyCategories.TechnologyCategoriesView;

import java.awt.event.ActionEvent;

public class RemoveTechnologyCategoryAction extends ClickAction<TechnologyCategoriesView> {

    public RemoveTechnologyCategoryAction(TechnologyCategoriesView view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final String selectedValue = getView().categoryList.getSelectedValue();
        if(selectedValue != null) {
            getView().getModel().removeCategory(selectedValue);
            getView().categoryList.clearSelection();
            getView().updateView();
        }
    }
}
