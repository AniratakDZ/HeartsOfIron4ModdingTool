package application.views.technologyCategories.actions;

import application.baseObjects.actions.ListAction;
import application.views.technologyCategories.TechnologyCategoriesView;

import javax.swing.event.ListSelectionEvent;

public class SelectCategoryAction extends ListAction<TechnologyCategoriesView> {

    public SelectCategoryAction(TechnologyCategoriesView view) {
        super(view);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()) {
            final String selectedValue = getView().categoryList.getSelectedValue();
            getView().nameTextfield.setText(selectedValue);
        }
    }
}
