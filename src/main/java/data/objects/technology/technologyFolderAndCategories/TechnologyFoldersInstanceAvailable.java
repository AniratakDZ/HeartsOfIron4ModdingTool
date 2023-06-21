package data.objects.technology.technologyFolderAndCategories;

import data.objects.GameObject;

public class TechnologyFoldersInstanceAvailable extends GameObject {

    private TechnologyFoldersInstanceAvailableNot not;
    private String hasDlc;

    public TechnologyFoldersInstanceAvailableNot getNot() {
        return not;
    }

    public void setNot(TechnologyFoldersInstanceAvailableNot not) {
        this.not = not;
    }

    public String getHasDlc() {
        return hasDlc;
    }

    public void setHasDlc(String hasDlc) {
        this.hasDlc = hasDlc;
    }
}
