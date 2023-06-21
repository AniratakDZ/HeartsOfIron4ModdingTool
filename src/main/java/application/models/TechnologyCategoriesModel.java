package application.models;

import java.util.ArrayList;
import java.util.List;

public class TechnologyCategoriesModel extends BaseModel {

    private List<String> categories;

    public TechnologyCategoriesModel() {
        categories = new ArrayList<>();
    }

    public void addCategory(String category) {
        categories.add(category);
    }

    public void removeCategory(String category) {
        categories.remove(category);
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
