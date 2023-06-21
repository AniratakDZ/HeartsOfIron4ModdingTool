package data.objects.technology.technologyFolderAndCategories;

import data.objects.GameObject;

import java.util.ArrayList;
import java.util.List;

public class TechnologyFolders extends GameObject {

    private List<TechnologyFoldersInstance> folderInstances;

    public TechnologyFolders() {
        folderInstances = new ArrayList<>();
    }

    public List<TechnologyFoldersInstance> getFolderInstances() {
        return folderInstances;
    }

    public void setFolderInstances(List<TechnologyFoldersInstance> folderInstances) {
        this.folderInstances = folderInstances;
    }
}
