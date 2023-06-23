package application.views.technologyCategories.actions;

import application.baseObjects.actions.ClickAction;
import application.views.technologyCategories.TechnologyCategoriesView;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static application.views.technologyCategories.TechnologyCategoriesConstants.SCROLLING_LIST_CATEGORIES;

public class RemoveTechnologyCategoryAction extends ClickAction<TechnologyCategoriesView> {

    public RemoveTechnologyCategoryAction(TechnologyCategoriesView view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final JList<String> scrollingList = getListFromScrollingList(SCROLLING_LIST_CATEGORIES);
        final String selectedValue = scrollingList.getSelectedValue();
        if(selectedValue != null) {
            getView().getModel().removeCategory(selectedValue);
            scrollingList.clearSelection();
            getView().updateView();
        }
    }
}
