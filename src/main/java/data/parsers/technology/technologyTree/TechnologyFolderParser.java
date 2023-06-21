package data.parsers.technology.technologyTree;

import data.objects.technology.technologyTree.TechnologyFolder;
import data.parsers.BaseParser;

import java.util.List;

public class TechnologyFolderParser extends BaseParser<TechnologyFolder> {

    public static String NAME = "name";
    public static String POSITION = "position";

    private final TechnologyFolderPositionParser technologyFolderPositionParser = new TechnologyFolderPositionParser();

    @Override
    public TechnologyFolder parse(List<String> lines) {

        final TechnologyFolder technologyFolder = new TechnologyFolder();

        for(int i = 0; i < lines.size(); i++) {

            final String tempLine = lines.get(i);

            if(tempLine.contains(NAME)) {
                technologyFolder.setName(replaceTabulatorAndFreeEqualSign(tempLine, NAME, 3));
                continue;
            }

            if(tempLine.contains(POSITION)) {
                final int endingPoint = calculateEndingObjectPhase(lines, i, 2);
                final List<String> lineStack = createLineStack(lines, i, endingPoint);
                technologyFolder.setPosition(technologyFolderPositionParser.parse(lineStack));
                i += lineStack.size() - 1;
            }
        }

        return technologyFolder;
    }
}
