package data.objects.technology.technologyFolderAndCategories;

import data.objects.GameObject;

public class TechnologyFoldersInstance extends GameObject {

    private String name;
    private String ledger;
    private boolean doctrine;
    private TechnologyFoldersInstanceAvailable available;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLedger() {
        return ledger;
    }

    public void setLedger(String ledger) {
        this.ledger = ledger;
    }

    public boolean isDoctrine() {
        return doctrine;
    }

    public void setDoctrine(boolean doctrine) {
        this.doctrine = doctrine;
    }

    public TechnologyFoldersInstanceAvailable getAvailable() {
        return available;
    }

    public void setAvailable(TechnologyFoldersInstanceAvailable available) {
        this.available = available;
    }
}
