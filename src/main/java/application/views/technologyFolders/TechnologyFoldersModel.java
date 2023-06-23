package application.views.technologyFolders;

import application.baseObjects.BaseModel;
import data.objects.technology.technologyFolderAndCategories.TechnologyFolders;
import data.objects.technology.technologyFolderAndCategories.TechnologyFoldersInstance;

import java.util.List;
import java.util.stream.Collectors;

public class TechnologyFoldersModel extends BaseModel {

    private TechnologyFolders technologyFolders;

    public TechnologyFolders getTechnologyFolders() {
        return technologyFolders;
    }

    public void setTechnologyFolders(TechnologyFolders technologyFolders) {
        this.technologyFolders = technologyFolders;
    }

    public TechnologyFoldersInstance getTechnologyFoldersInstanceByName(String name) {
        return getAllTechnologyFoldesInstances().stream().filter(e -> e.getName().equals(name)).collect(Collectors.toList()).get(0);
    }

    public void removeTechnologyFoldersInstanceByName(String name) {
        final TechnologyFoldersInstance technologyFoldersInstance = getTechnologyFoldersInstanceByName(name);
        getAllTechnologyFoldesInstances().remove(technologyFoldersInstance);
    }

    public void addTechnologyFoldersInstance(TechnologyFoldersInstance technologyFoldersInstance) {
        getAllTechnologyFoldesInstances().add(technologyFoldersInstance);
    }

    public void updateTechnologyFoldersInstance(String name, TechnologyFoldersInstance technologyFoldersInstance) {
        final List<TechnologyFoldersInstance> instances = getAllTechnologyFoldesInstances();
        final List<String> instanceNames = getAllTechnologyFoldesInstances().stream().map(TechnologyFoldersInstance::getName).collect(Collectors.toList());
        instances.set(instanceNames.indexOf(name), technologyFoldersInstance);
    }

    private List<TechnologyFoldersInstance> getAllTechnologyFoldesInstances() {
        return getTechnologyFolders().getFolderInstances();
    }
}