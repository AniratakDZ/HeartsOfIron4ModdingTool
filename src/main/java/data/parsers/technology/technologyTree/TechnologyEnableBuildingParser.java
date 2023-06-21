package data.parsers.technology.technologyTree;

import data.objects.technology.technologyTree.TechnologyEnableBuilding;
import data.parsers.BaseParser;

import java.util.List;

import static java.lang.Integer.parseInt;

public class TechnologyEnableBuildingParser extends BaseParser<TechnologyEnableBuilding> {

    public static String BUILDING = "building";
    public static String LEVEL = "level";

    @Override
    public TechnologyEnableBuilding parse(List<String> lines) {

        final TechnologyEnableBuilding technologyEnableBuilding = new TechnologyEnableBuilding();

        for(int i = 0; i < lines.size(); i++) {

            final String tempLine = lines.get(i);

            if(tempLine.contains(BUILDING)) {
                technologyEnableBuilding.setBuilding(replaceTabulatorAndFreeEqualSign(tempLine, BUILDING, 3));
                continue;
            }

            if(tempLine.contains(LEVEL)) {
                technologyEnableBuilding.setLevel(parseInt(replaceTabulatorAndFreeEqualSign(tempLine, LEVEL, 3)));
            }
        }

        return technologyEnableBuilding;
    }
}
