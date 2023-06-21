package data.objects.technology.technologyFolderAndCategories;

import data.objects.GameObject;

public class TechnologyFolderAndCategories extends GameObject {

    private TechnologyFolders folders;
    private TechnologyCategoriesInstance categories;

    public TechnologyFolders getFolders() {
        return folders;
    }

    public void setFolders(TechnologyFolders folders) {
        this.folders = folders;
    }

    public TechnologyCategoriesInstance getCategories() {
        return categories;
    }

    public void setCategories(TechnologyCategoriesInstance categories) {
        this.categories = categories;
    }
}
