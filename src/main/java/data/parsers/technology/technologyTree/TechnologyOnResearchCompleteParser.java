package data.parsers.technology.technologyTree;

import data.objects.technology.technologyTree.TechnologyOnResearchComplete;
import data.parsers.BaseParser;

import java.util.List;

public class TechnologyOnResearchCompleteParser extends BaseParser<TechnologyOnResearchComplete> {

    public static final String MODIFY_BUILDING_RESOURCES = "modify_building_resources";

    private final TechnologyOnResearchCompleteModifyBuildingResourcesParser technologyOnResearchCompleteModifyBuildingResourcesParser = new TechnologyOnResearchCompleteModifyBuildingResourcesParser();

    @Override
    public TechnologyOnResearchComplete parse(List<String> lines) {

        final TechnologyOnResearchComplete technologyOnResearchComplete = new TechnologyOnResearchComplete();

        for(int i = 0; i < lines.size(); i++) {

            final String tempLine = lines.get(i);

            if(tempLine.contains(MODIFY_BUILDING_RESOURCES)) {
                final int endingPoint = calculateEndingObjectPhase(lines, i, 3);
                final List<String> lineStack = createLineStack(lines, i, endingPoint);
                technologyOnResearchComplete.setModifyBuildingResources(technologyOnResearchCompleteModifyBuildingResourcesParser.parse(lineStack));
                i += lineStack.size() - 1;
            }
        }

        return technologyOnResearchComplete;
    }
}
