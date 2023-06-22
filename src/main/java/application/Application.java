package application;

import application.views.technologyCategories.TechnologyCategoriesController;
import application.views.technologyFolders.TechnologyFoldersController;
import application.views.technologyCategories.TechnologyCategoriesModel;
import application.views.technologyFolders.TechnologyFoldersModel;
import application.views.technologyCategories.TechnologyCategoriesView;
import application.views.technologyFolders.TechnologyFoldersView;
import data.DataManager;

import javax.swing.*;

public class Application extends JFrame {

    private TechnologyCategoriesModel technologyCategoriesModel;
    private TechnologyFoldersModel technologyFoldersModel;
    private TechnologyCategoriesView technologyCategoriesView;
    private TechnologyFoldersView technologyFoldersView;
    private TechnologyCategoriesController technologyCategoriesController;
    private TechnologyFoldersController technologyFoldersController;

    public Application() {
        technologyCategoriesModel = new TechnologyCategoriesModel();
        technologyCategoriesView = new TechnologyCategoriesView(technologyCategoriesModel);
        technologyCategoriesController = new TechnologyCategoriesController(technologyCategoriesModel, technologyCategoriesView);

        technologyFoldersModel = new TechnologyFoldersModel();
        technologyFoldersView = new TechnologyFoldersView(technologyFoldersModel);
        technologyFoldersController = new TechnologyFoldersController(technologyFoldersModel, technologyFoldersView);

        JTabbedPane mainTabbedPane = new JTabbedPane();
        JTabbedPane technologyTabbedPane = new JTabbedPane();

        technologyTabbedPane.addTab("Kategorien", technologyCategoriesView);
        technologyTabbedPane.addTab("Ordner", technologyFoldersView);
        mainTabbedPane.addTab("Technologien", technologyTabbedPane);

        add(mainTabbedPane);

        setTitle("Hearts of Iron 4 Modding Editor v0.0.1");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);

        technologyCategoriesModel.setCategories(DataManager.getTechnologyFolderAndCategories().getCategories().getCategories());
        technologyFoldersModel.setTechnologyFolders(DataManager.getTechnologyFolderAndCategories().getFolders());
        technologyCategoriesController.initialize();
        technologyFoldersController.initialize();
    }
}