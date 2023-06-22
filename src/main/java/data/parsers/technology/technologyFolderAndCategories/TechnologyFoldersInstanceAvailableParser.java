package data.parsers.technology.technologyFolderAndCategories;

import data.objects.technology.technologyFolderAndCategories.TechnologyFoldersInstanceAvailable;
import data.parsers.BaseParser;

import java.util.List;

public class TechnologyFoldersInstanceAvailableParser extends BaseParser<TechnologyFoldersInstanceAvailable> {

    public static String NOT = "not";
    public static String NOT2 = "NOT";
    public static String HAS_DLC = "has_dlc";

    private final TechnologyFoldersInstanceAvailableNotParser technologyFoldersInstanceAvailableNotParser = new TechnologyFoldersInstanceAvailableNotParser();

    @Override
    public TechnologyFoldersInstanceAvailable parse(List<String> lines) {

        final TechnologyFoldersInstanceAvailable technologyFoldersInstanceAvailable = new TechnologyFoldersInstanceAvailable();

        for(int i = 0; i < lines.size(); i++) {

            final String tempLine = lines.get(i);

            if(tempLine.contains(HAS_DLC)) {
                technologyFoldersInstanceAvailable.setHasDlc(replaceTabulatorAndFreeEqualSign(tempLine, HAS_DLC, 3));
                continue;
            }

            if(tempLine.contains(NOT) || tempLine.contains(NOT2)) {
                final int endingPoint = calculateEndingObjectPhase(lines, i, 3);
                final List<String> lineStack = createLineStack(lines, i, endingPoint);
                technologyFoldersInstanceAvailable.setNot(technologyFoldersInstanceAvailableNotParser.parse(lineStack));
                i += lineStack.size() - 1;
            }
        }

        return technologyFoldersInstanceAvailable;
    }
}
