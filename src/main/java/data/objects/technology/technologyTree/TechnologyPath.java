package data.objects.technology.technologyTree;

import data.objects.GameObject;

public class TechnologyPath extends GameObject {

    private String leadsToTech;
    private int researchCostCoefficient;

    public String getLeadsToTech() {
        return leadsToTech;
    }

    public void setLeadsToTech(String leadsToTech) {
        this.leadsToTech = leadsToTech;
    }

    public int getResearchCostCoefficient() {
        return researchCostCoefficient;
    }

    public void setResearchCostCoefficient(int researchCostCoefficient) {
        this.researchCostCoefficient = researchCostCoefficient;
    }
}
