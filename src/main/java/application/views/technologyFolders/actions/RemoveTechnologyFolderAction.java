package application.views.technologyFolders.actions;

import application.baseObjects.actions.ClickAction;
import application.views.technologyFolders.TechnologyFoldersView;

import java.awt.event.ActionEvent;

public class RemoveTechnologyFolderAction extends ClickAction<TechnologyFoldersView> {

    public RemoveTechnologyFolderAction(TechnologyFoldersView view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getView().getModel().removeTechnologyFoldersInstanceByName(getView().folderList.getSelectedValue());
        getView().folderList.clearSelection();
        getView().updateView();
        new ClearCurrentTechnologyFolderAction(getView()).actionPerformed(e);
    }
}
