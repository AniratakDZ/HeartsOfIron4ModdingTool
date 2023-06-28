package application.views.technologyIndustry.actions;

import application.baseObjects.actions.ListAction;
import application.views.technologyIndustry.TechnologyIndustryConstants;
import application.views.technologyIndustry.TechnologyIndustryView;
import data.objects.technology.technologyTree.TechnologyPath;

import javax.swing.event.ListSelectionEvent;

import static application.views.technologyIndustry.TechnologyIndustryConstants.*;
import static java.lang.String.valueOf;

public class SelectPathAction extends ListAction<TechnologyIndustryView> {

    public SelectPathAction(TechnologyIndustryView view) {
        super(view);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()) {
            final int selectedIndex = getScrollingList(SCROLLING_LIST_PATHS).getList().getSelectedIndex();
            if(selectedIndex >= 0) {
                final TechnologyPath technologyPath = getView().getModel().getTechnologyByName(getListFromScrollingList(SCROLLING_LIST_TECHNOLOGIES).getSelectedValue()).getTechnologyPaths().get(selectedIndex);
                getTextfield(TEXTFIELD_RESEARCH_COST_COEFF).setText(valueOf(technologyPath.getResearchCostCoefficient()));
                getCombobox(COMBOBOX_TECHNOLOGIES).setSelectedItem(technologyPath.getLeadsToTech());
            } else {
                getTextfield(TEXTFIELD_RESEARCH_COST_COEFF).setText("");
                getCombobox(COMBOBOX_TECHNOLOGIES).setSelectedItem("");
            }
        }
    }
}
