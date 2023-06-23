package application.views.technologyFolders.actions;

import application.baseObjects.JScrollingList;
import application.baseObjects.actions.ClickAction;
import application.views.technologyFolders.TechnologyFoldersConstants;
import application.views.technologyFolders.TechnologyFoldersView;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static application.views.technologyFolders.TechnologyFoldersConstants.SCROLLING_LIST_FOLDERS;

public class RemoveTechnologyFolderAction extends ClickAction<TechnologyFoldersView> {

    public RemoveTechnologyFolderAction(TechnologyFoldersView view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final JList<String> list = getListFromScrollingList(SCROLLING_LIST_FOLDERS);
        getView().getModel().removeTechnologyFoldersInstanceByName(list.getSelectedValue());
        list.clearSelection();
        getView().updateView();
        new ClearCurrentTechnologyFolderAction(getView()).actionPerformed(e);
    }
}
