package data.objects.technology.technologyTree;

import data.objects.GameObject;

import java.util.ArrayList;
import java.util.List;

public class TechnologyAiWillDo extends GameObject {

    private double factor;
    private List<TechnologyAiWillDoModifier> modifier;

    public TechnologyAiWillDo() {
        modifier = new ArrayList<>();
    }

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    public List<TechnologyAiWillDoModifier> getModifier() {
        return modifier;
    }

    public void setModifier(List<TechnologyAiWillDoModifier> modifier) {
        this.modifier = modifier;
    }
}
