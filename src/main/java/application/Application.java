package application;

import application.views.technologyCategories.TechnologyCategoriesController;
import application.views.technologyFolders.TechnologyFoldersController;
import application.views.technologyCategories.TechnologyCategoriesModel;
import application.views.technologyFolders.TechnologyFoldersModel;
import application.views.technologyCategories.TechnologyCategoriesView;
import application.views.technologyFolders.TechnologyFoldersView;
import application.views.technologyIndustry.TechnologyIndustryController;
import application.views.technologyIndustry.TechnologyIndustryModel;
import application.views.technologyIndustry.TechnologyIndustryView;
import data.DataManager;
import data.objects.technology.technologyFolderAndCategories.TechnologyFoldersInstance;

import javax.swing.*;

import java.util.stream.Collectors;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class Application extends JFrame {

    private TechnologyCategoriesModel technologyCategoriesModel;
    private TechnologyFoldersModel technologyFoldersModel;
    private TechnologyIndustryModel technologyIndustryModel;
    private TechnologyCategoriesView technologyCategoriesView;
    private TechnologyFoldersView technologyFoldersView;
    private TechnologyIndustryView technologyIndustryView;
    private TechnologyCategoriesController technologyCategoriesController;
    private TechnologyFoldersController technologyFoldersController;
    private TechnologyIndustryController technologyIndustryController;

    public Application() {
        technologyCategoriesModel = new TechnologyCategoriesModel();
        technologyCategoriesView = new TechnologyCategoriesView(technologyCategoriesModel);
        technologyCategoriesController = new TechnologyCategoriesController(technologyCategoriesModel, technologyCategoriesView);

        technologyFoldersModel = new TechnologyFoldersModel();
        technologyFoldersView = new TechnologyFoldersView(technologyFoldersModel);
        technologyFoldersController = new TechnologyFoldersController(technologyFoldersModel, technologyFoldersView);

        technologyIndustryModel = new TechnologyIndustryModel();
        technologyIndustryView = new TechnologyIndustryView(technologyIndustryModel);
        technologyIndustryController = new TechnologyIndustryController(technologyIndustryModel, technologyIndustryView);

        JTabbedPane mainTabbedPane = new JTabbedPane();
        JTabbedPane technologyTabbedPane = new JTabbedPane();

        technologyTabbedPane.addTab("Kategorien", technologyCategoriesView);
        technologyTabbedPane.addTab("Ordner", technologyFoldersView);
        technologyTabbedPane.addTab("Industrie", technologyIndustryView);
        mainTabbedPane.addTab("Technologien", technologyTabbedPane);

        add(mainTabbedPane);

        setTitle("Hearts of Iron 4 Modding Editor v0.0.1");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);

        technologyCategoriesModel.setCategories(DataManager.getTechnologyFolderAndCategories().getCategories().getCategories());
        technologyFoldersModel.setTechnologyFolders(DataManager.getTechnologyFolderAndCategories().getFolders());
        //technologyIndustryModel.setTechnologies(DataManager.getTechnologyTree().getTechnologies());
        technologyCategoriesController.initialize();
        technologyFoldersController.initialize();
        technologyIndustryController.initialize();
    }
}