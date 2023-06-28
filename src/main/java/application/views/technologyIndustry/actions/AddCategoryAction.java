package application.views.technologyIndustry.actions;

import application.baseObjects.actions.ClickAction;
import application.views.technologyIndustry.TechnologyIndustryConstants;
import application.views.technologyIndustry.TechnologyIndustryView;
import data.objects.technology.technologyTree.Technology;

import java.awt.event.ActionEvent;

import static application.views.technologyIndustry.TechnologyIndustryConstants.*;

public class AddCategoryAction extends ClickAction<TechnologyIndustryView> {

    public AddCategoryAction(TechnologyIndustryView view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final Technology currentTechnology = getView().getModel().getTechnologies().get(getListFromScrollingList(SCROLLING_LIST_TECHNOLOGIES).getSelectedIndex());
        final String newCategory = (String) getCombobox(COMBOBOX_CATEGORIES).getSelectedItem();
        currentTechnology.getCategories().getCategorieNames().add(newCategory);
        updateView();
        getListFromScrollingList(SCROLLING_LIST_CATEGORIES).setSelectedValue(newCategory, true);
    }

    //TODO: Knöpfe ist ok unter der JList und JList sollte nicht direkt bei Auswahl ein selectedItem haben!
}
