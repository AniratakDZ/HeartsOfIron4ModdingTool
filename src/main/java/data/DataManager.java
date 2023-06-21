package data;

import data.converters.TechnologiesConverter;
import data.converters.TechnologyTreeConverter;
import data.objects.technology.technologyFolderAndCategories.TechnologyFolderAndCategories;
import data.objects.technology.technologyTree.TechnologyTree;
import data.parsers.technology.technologyTree.TechnologyTreeParser;
import data.parsers.technologyFolderAndCategories.TechnologyFolderAndCategoriesParser;
import utils.FileUtils;

public class DataManager {

    private static TechnologyTree technologyTree;
    private static TechnologyFolderAndCategories technologyFolderAndCategories;

    public static void init() {
        technologyTree = new TechnologyTreeParser().parse(new TechnologyTreeConverter().convert(FileUtils.readLines("industry.txt")));
        technologyFolderAndCategories = new TechnologyFolderAndCategoriesParser().parse(new TechnologiesConverter().convert(FileUtils.readLines("00_technology.txt")));
    }

    public static TechnologyTree getTechnologyTree() {
        return technologyTree;
    }

    public static void setTechnologyTree(TechnologyTree technologyTree) {
        DataManager.technologyTree = technologyTree;
    }

    public static TechnologyFolderAndCategories getTechnologyFolderAndCategories() {
        return technologyFolderAndCategories;
    }

    public static void setTechnologyFolderAndCategories(TechnologyFolderAndCategories technologyFolderAndCategories) {
        DataManager.technologyFolderAndCategories = technologyFolderAndCategories;
    }
}
