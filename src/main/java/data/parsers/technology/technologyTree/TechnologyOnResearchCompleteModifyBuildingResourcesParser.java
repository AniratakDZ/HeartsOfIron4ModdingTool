package data.parsers.technology.technologyTree;

import data.objects.technology.technologyTree.TechnologyOnResearchCompleteModifyBuildingResources;
import data.parsers.BaseParser;

import java.util.List;

import static java.lang.Integer.parseInt;

public class TechnologyOnResearchCompleteModifyBuildingResourcesParser extends BaseParser<TechnologyOnResearchCompleteModifyBuildingResources> {

    public static String BUILDING = "building";
    public static String RESOURCE = "resource";
    public static String AMOUNT = "amount";

    @Override
    public TechnologyOnResearchCompleteModifyBuildingResources parse(List<String> lines) {

        final TechnologyOnResearchCompleteModifyBuildingResources technologyOnResearchCompleteModifyBuildingResources = new TechnologyOnResearchCompleteModifyBuildingResources();

        for(int i = 0; i < lines.size(); i++) {

            final String tempLine = lines.get(i);

            if(tempLine.contains(BUILDING)) {
                technologyOnResearchCompleteModifyBuildingResources.setBuilding(replaceTabulatorAndFreeEqualSign(tempLine, BUILDING, 4));
                continue;
            }

            if(tempLine.contains(RESOURCE)) {
                technologyOnResearchCompleteModifyBuildingResources.setResource(replaceTabulatorAndFreeEqualSign(tempLine, RESOURCE, 4));
                continue;
            }

            if(tempLine.contains(AMOUNT)) {
                technologyOnResearchCompleteModifyBuildingResources.setAmount(parseInt(replaceTabulatorAndFreeEqualSign(tempLine, AMOUNT, 4)));
            }
        }

        return technologyOnResearchCompleteModifyBuildingResources;
    }
}
