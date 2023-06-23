package application.views.technologyCategories.actions;

import application.baseObjects.actions.ListAction;
import application.views.technologyCategories.TechnologyCategoriesConstants;
import application.views.technologyCategories.TechnologyCategoriesView;

import javax.swing.event.ListSelectionEvent;

import static application.views.technologyCategories.TechnologyCategoriesConstants.SCROLLING_LIST_CATEGORIES;
import static application.views.technologyCategories.TechnologyCategoriesConstants.TEXTFIELD_NAME;

public class SelectCategoryAction extends ListAction<TechnologyCategoriesView> {

    public SelectCategoryAction(TechnologyCategoriesView view) {
        super(view);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()) {
            final String selectedValue = getListFromScrollingList(SCROLLING_LIST_CATEGORIES).getSelectedValue();
            getTextfield(TEXTFIELD_NAME).setText(selectedValue);
        }
    }
}
