package data.objects.technology.technologyTree;

import data.objects.GameObject;

import java.util.ArrayList;
import java.util.List;

public class TechnologyCategories extends GameObject {

    private List<String> categorieNames;

    public TechnologyCategories() {
        categorieNames = new ArrayList<>();
    }

    public List<String> getCategorieNames() {
        return categorieNames;
    }

    public void setCategorieNames(List<String> categorieNames) {
        this.categorieNames = categorieNames;
    }
}
