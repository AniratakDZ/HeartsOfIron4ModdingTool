package data;

import data.converters.TechnologiesConverter;
import data.converters.TechnologyTreeConverter;
import data.objects.technology.technologyFolderAndCategories.TechnologyFolderAndCategories;
import data.objects.technology.technologyTree.TechnologyTree;
import data.parsers.technology.technologyTree.TechnologyTreeParser;
import data.parsers.technology.technologyFolderAndCategories.TechnologyFolderAndCategoriesParser;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataManager {

    private static List<TechnologyTree> technologyTrees = new ArrayList<>();
    private static TechnologyFolderAndCategories technologyFolderAndCategories;

    public static void init() {
        technologyTrees = initializeTechnologyTrees();
        technologyFolderAndCategories = new TechnologyFolderAndCategoriesParser().parse(new TechnologiesConverter().convert(FileUtils.readLines("00_technology.txt")));
    }

    private static List<TechnologyTree> initializeTechnologyTrees() {
        final List<String> technologyTreeNames = new ArrayList<>(Arrays.asList("air_doctrine.txt", "air_techs.txt", "artillery.txt", "bba_air_techs.txt",
                "electronic_mechanical_engineering.txt", "industry.txt", "infantry.txt", "land_doctrine.txt", "MTG_naval.txt", "MTG_naval_Support.txt",
                "naval_doctrine.txt", "NSB_armor.txt", "support.txt"));
        final List<TechnologyTree> technologyTreeList = new ArrayList<>();
        for(String technologyTreeName : technologyTreeNames) {
            technologyTreeList.add(new TechnologyTreeParser().parse(new TechnologyTreeConverter().convert(FileUtils.readLines("technologies/" + technologyTreeName))));
            System.out.println("Parsed " + technologyTreeName);
        }
        return technologyTreeList;
    }

    public static List<TechnologyTree> getTechnologyTrees() {
        return technologyTrees;
    }

    public static void setTechnologyTrees(List<TechnologyTree> technologyTrees) {
        DataManager.technologyTrees = technologyTrees;
    }

    public static TechnologyFolderAndCategories getTechnologyFolderAndCategories() {
        return technologyFolderAndCategories;
    }

    public static void setTechnologyFolderAndCategories(TechnologyFolderAndCategories technologyFolderAndCategories) {
        DataManager.technologyFolderAndCategories = technologyFolderAndCategories;
    }
}
