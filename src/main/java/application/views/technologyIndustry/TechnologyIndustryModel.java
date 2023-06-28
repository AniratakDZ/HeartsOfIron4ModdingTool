package application.views.technologyIndustry;

import application.baseObjects.BaseModel;
import data.objects.technology.technologyTree.Technology;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TechnologyIndustryModel extends BaseModel {

    private List<Technology> technologies;

    public TechnologyIndustryModel() {
        technologies = new ArrayList<>();
    }

    public Technology getTechnologyByName(String name) {
        return technologies.stream().filter(e -> e.getName().equals(name)).collect(Collectors.toList()).get(0);
    }

    public void addTechnology(Technology technology) {
        technologies.add(technology);
    }

    public void updateTechnology(String name, Technology technology) {
        final Technology existingTechnology = technologies.stream().filter(e -> e.getName().equals(name)).collect(Collectors.toList()).get(0);
        if(existingTechnology != null) {
            technologies.set(technologies.indexOf(existingTechnology), technology);
        }
    }

    public void removeTechnology(Technology technology) {
        technologies.remove(technology);
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }
}