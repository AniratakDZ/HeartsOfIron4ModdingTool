package application.views.technologyIndustry.actions;

import application.baseObjects.actions.ListAction;
import application.views.technologyIndustry.TechnologyIndustryView;

import javax.swing.event.ListSelectionEvent;

import static application.views.technologyIndustry.TechnologyIndustryConstants.*;

public class SelectCategoryAction extends ListAction<TechnologyIndustryView> {

    public SelectCategoryAction(TechnologyIndustryView view) {
        super(view);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()) {
            final int selectedIndex = getScrollingList(SCROLLING_LIST_CATEGORIES).getList().getSelectedIndex();
            if(selectedIndex >= 0) {
                getCombobox(COMBOBOX_CATEGORIES).setSelectedItem(getListFromScrollingList(SCROLLING_LIST_CATEGORIES).getSelectedValue());
            } else {
                getCombobox(COMBOBOX_CATEGORIES).setSelectedItem("");
            }
        }
    }
}