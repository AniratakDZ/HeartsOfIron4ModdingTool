package data.objects.technology.technologyTree;

import data.objects.GameObject;

import java.util.ArrayList;
import java.util.List;

public class TechnologyAiWillDoModifierOr extends GameObject {

    private List<String> tags;
    private String oil;
    private String aluminium;
    private String rubber;
    private String tungsten;
    private String steel;
    private String chromium;

    public TechnologyAiWillDoModifierOr() {
        tags = new ArrayList<>();
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getOil() {
        return oil;
    }

    public void setOil(String oil) {
        this.oil = oil;
    }

    public String getAluminium() {
        return aluminium;
    }

    public void setAluminium(String aluminium) {
        this.aluminium = aluminium;
    }

    public String getRubber() {
        return rubber;
    }

    public void setRubber(String rubber) {
        this.rubber = rubber;
    }

    public String getTungsten() {
        return tungsten;
    }

    public void setTungsten(String tungsten) {
        this.tungsten = tungsten;
    }

    public String getSteel() {
        return steel;
    }

    public void setSteel(String steel) {
        this.steel = steel;
    }

    public String getChromium() {
        return chromium;
    }

    public void setChromium(String chromium) {
        this.chromium = chromium;
    }
}
