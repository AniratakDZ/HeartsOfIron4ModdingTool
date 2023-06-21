package data.objects.technology.technologyTree;

import data.objects.GameObject;

import java.util.ArrayList;
import java.util.List;

public class TechnologyXOR extends GameObject {

    private List<String> technologies;

    public TechnologyXOR() {
        technologies = new ArrayList<>();
    }

    public List<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<String> technologies) {
        this.technologies = technologies;
    }
}
