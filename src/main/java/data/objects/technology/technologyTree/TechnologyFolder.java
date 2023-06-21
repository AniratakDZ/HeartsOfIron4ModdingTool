package data.objects.technology.technologyTree;

import data.objects.GameObject;

public class TechnologyFolder extends GameObject {

    private String name;
    private TechnologyFolderPosition position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TechnologyFolderPosition getPosition() {
        return position;
    }

    public void setPosition(TechnologyFolderPosition position) {
        this.position = position;
    }
}