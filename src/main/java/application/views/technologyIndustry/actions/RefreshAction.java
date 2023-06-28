package application.views.technologyIndustry.actions;

import application.baseObjects.actions.ClickAction;
import application.views.technologyIndustry.TechnologyIndustryView;

import java.awt.event.ActionEvent;

public class RefreshAction extends ClickAction<TechnologyIndustryView> {

    public RefreshAction(TechnologyIndustryView view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getView().updateView();
    }
}
