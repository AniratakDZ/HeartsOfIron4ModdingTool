package data.objects.technology.technologyTree;

import data.objects.GameObject;

public class TechnologyOnResearchComplete extends GameObject {

    private TechnologyOnResearchCompleteModifyBuildingResources modifyBuildingResources;

    public TechnologyOnResearchCompleteModifyBuildingResources getModifyBuildingResources() {
        return modifyBuildingResources;
    }

    public void setModifyBuildingResources(TechnologyOnResearchCompleteModifyBuildingResources modifyBuildingResources) {
        this.modifyBuildingResources = modifyBuildingResources;
    }
}
