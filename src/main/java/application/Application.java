package application;

import application.controller.TechnologyCategoriesController;
import application.models.TechnologyCategoriesModel;
import application.views.TechnologyCategoriesView;
import data.DataManager;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Application extends JFrame {

    private TechnologyCategoriesModel technologyCategoriesModel;
    private TechnologyCategoriesView technologyCategoriesView;
    private TechnologyCategoriesController technologyCategoriesController;

    public Application() {
        technologyCategoriesModel = new TechnologyCategoriesModel();
        technologyCategoriesView = new TechnologyCategoriesView(technologyCategoriesModel);
        technologyCategoriesController = new TechnologyCategoriesController(technologyCategoriesModel, technologyCategoriesView);

        JTabbedPane mainTabbedPane = new JTabbedPane();
        JTabbedPane technologyTabbedPane = new JTabbedPane();

        technologyTabbedPane.addTab("Kategorien", technologyCategoriesView);
        mainTabbedPane.addTab("Technologien", technologyTabbedPane);

        add(mainTabbedPane);

        setTitle("Hearts of Iron 4 Modding Editor v0.0.1");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);

        technologyCategoriesModel.setCategories(DataManager.getTechnologyFolderAndCategories().getCategories().getCategories());
        technologyCategoriesController.initialize();
    }
}