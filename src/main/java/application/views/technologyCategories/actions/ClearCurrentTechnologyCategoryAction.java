package application.views.technologyCategories.actions;

import application.baseObjects.actions.ClickAction;
import application.views.technologyCategories.TechnologyCategoriesView;

import java.awt.event.ActionEvent;

import static application.views.technologyCategories.TechnologyCategoriesConstants.SCROLLING_LIST_CATEGORIES;
import static application.views.technologyCategories.TechnologyCategoriesConstants.TEXTFIELD_NAME;

public class ClearCurrentTechnologyCategoryAction extends ClickAction<TechnologyCategoriesView> {

    public ClearCurrentTechnologyCategoryAction(TechnologyCategoriesView view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getListFromScrollingList(SCROLLING_LIST_CATEGORIES).clearSelection();
        getTextfield(TEXTFIELD_NAME).setText("");
    }
}
