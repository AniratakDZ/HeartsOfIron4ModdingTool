package data.objects.technology.technologyTree;

import data.objects.GameObject;

public class TechnologyOnResearchCompleteModifyBuildingResources extends GameObject {

    private String building;
    private String resource;
    private int amount;

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
