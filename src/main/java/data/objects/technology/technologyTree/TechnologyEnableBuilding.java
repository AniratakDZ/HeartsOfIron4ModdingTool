package data.objects.technology.technologyTree;

import data.objects.GameObject;

public class TechnologyEnableBuilding extends GameObject {

    private String building;
    private int level;

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
