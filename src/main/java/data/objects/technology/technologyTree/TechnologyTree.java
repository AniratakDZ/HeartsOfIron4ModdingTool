package data.objects.technology.technologyTree;

import data.objects.GameObject;

import java.util.ArrayList;
import java.util.List;

public class TechnologyTree extends GameObject {

    private List<Technology> technologies;

    public TechnologyTree() {
        technologies = new ArrayList<>();
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }
}
