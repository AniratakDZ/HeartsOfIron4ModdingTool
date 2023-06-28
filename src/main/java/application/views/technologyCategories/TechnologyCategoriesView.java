package application.views.technologyCategories;

import application.baseObjects.BaseView;
import application.baseObjects.actions.ClearAction;
import application.views.technologyCategories.actions.AddTechnologyCategoryAction;
import application.views.technologyCategories.actions.RemoveTechnologyCategoryAction;
import application.views.technologyCategories.actions.SelectCategoryAction;
import data.DataManager;

public class TechnologyCategoriesView extends BaseView<TechnologyCategoriesModel> implements TechnologyCategoriesConstants {

    public TechnologyCategoriesView(TechnologyCategoriesModel model) {
        super(model);
        this.setModel(model);
        setLayout(null);

        addTextfield(TEXTFIELD_NAME, 455, 0);
        addScrollingList(SCROLLING_LIST_CATEGORIES, 0, 0);
        addButton(BUTTON_ADD, "+", 0, 200);
        addButton(BUTTON_REMOVE, "-", 100, 200);
        addButton(BUTTON_CLEAR, "C", 200, 200);
        addLabel(LABEL_NAME, "Name: ", 305, 0);

        addListAction(SCROLLING_LIST_CATEGORIES, new SelectCategoryAction(this));
        addClickAction(BUTTON_ADD, new AddTechnologyCategoryAction(this));
        addClickAction(BUTTON_REMOVE, new RemoveTechnologyCategoryAction(this));
        addClickAction(BUTTON_CLEAR, new ClearAction(this));
    }

    @Override
    public void updateView() {
        getScrollingList(SCROLLING_LIST_CATEGORIES).updateElements(getModel().getCategories());
        DataManager.getTechnologyFolderAndCategories().getCategories().setCategories(getModel().getCategories());
    }
}
