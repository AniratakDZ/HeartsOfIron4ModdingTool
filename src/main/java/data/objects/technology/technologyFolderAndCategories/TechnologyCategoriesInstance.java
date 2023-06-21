package data.objects.technology.technologyFolderAndCategories;

import data.objects.GameObject;

import java.util.ArrayList;
import java.util.List;

public class TechnologyCategoriesInstance extends GameObject {

    private List<String> categories;

    public TechnologyCategoriesInstance() {
        categories = new ArrayList<>();

    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
