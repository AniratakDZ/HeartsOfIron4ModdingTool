package data.objects.technology.technologyTree;

import data.objects.GameObject;

import java.util.ArrayList;
import java.util.List;

public class TechnologyEquipmentBonus extends GameObject {

    private List<TechnologyEquipmentBonusInstance> equipmentBonuses;

    public TechnologyEquipmentBonus() {
        equipmentBonuses = new ArrayList<>();
    }
}
