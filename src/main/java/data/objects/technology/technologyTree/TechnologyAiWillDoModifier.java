package data.objects.technology.technologyTree;

import data.objects.GameObject;

public class TechnologyAiWillDoModifier extends GameObject {

    private double factor;
    private String date;
    private TechnologyAiWillDoModifierNot not;
    private String tag;
    private String hasTech;
    private String isResearchingTechnology;
    private String oil;
    private String numOfMilitaryFactories;
    private String numOfNavalFactories;
    private boolean hasWar;
    private boolean isMajor;
    private TechnologyAiWillDoModifierOr or;
    private String rubber;

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public TechnologyAiWillDoModifierNot getNot() {
        return not;
    }

    public void setNot(TechnologyAiWillDoModifierNot not) {
        this.not = not;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getHasTech() {
        return hasTech;
    }

    public void setHasTech(String hasTech) {
        this.hasTech = hasTech;
    }

    public String getIsResearchingTechnology() {
        return isResearchingTechnology;
    }

    public void setIsResearchingTechnology(String isResearchingTechnology) {
        this.isResearchingTechnology = isResearchingTechnology;
    }

    public String getOil() {
        return oil;
    }

    public void setOil(String oil) {
        this.oil = oil;
    }

    public String getNumOfMilitaryFactories() {
        return numOfMilitaryFactories;
    }

    public void setNumOfMilitaryFactories(String numOfMilitaryFactories) {
        this.numOfMilitaryFactories = numOfMilitaryFactories;
    }

    public String getNumOfNavalFactories() {
        return numOfNavalFactories;
    }

    public void setNumOfNavalFactories(String numOfNavalFactories) {
        this.numOfNavalFactories = numOfNavalFactories;
    }

    public boolean isHasWar() {
        return hasWar;
    }

    public void setHasWar(boolean hasWar) {
        this.hasWar = hasWar;
    }

    public boolean isMajor() {
        return isMajor;
    }

    public void setMajor(boolean major) {
        isMajor = major;
    }

    public TechnologyAiWillDoModifierOr getOr() {
        return or;
    }

    public void setOr(TechnologyAiWillDoModifierOr or) {
        this.or = or;
    }

    public String getRubber() {
        return rubber;
    }

    public void setRubber(String rubber) {
        this.rubber = rubber;
    }
}
