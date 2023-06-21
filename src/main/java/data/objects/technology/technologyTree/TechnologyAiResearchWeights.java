package data.objects.technology.technologyTree;

import data.objects.GameObject;

public class TechnologyAiResearchWeights extends GameObject {

    private double offensive;
    private double defensive;
    private double oil;
    private double rubber;

    public double getOffensive() {
        return offensive;
    }

    public void setOffensive(double offensive) {
        this.offensive = offensive;
    }

    public double getDefensive() {
        return defensive;
    }

    public void setDefensive(double defensive) {
        this.defensive = defensive;
    }

    public double getOil() {
        return oil;
    }

    public void setOil(double oil) {
        this.oil = oil;
    }

    public double getRubber() {
        return rubber;
    }

    public void setRubber(double rubber) {
        this.rubber = rubber;
    }
}
