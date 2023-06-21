package data.parsers.technologyFolderAndCategories;

import data.objects.technology.technologyFolderAndCategories.TechnologyFolders;
import data.parsers.BaseParser;

import java.util.List;

public class TechnologyFoldersParser extends BaseParser<TechnologyFolders> {

    private final TechnologyFoldersInstanceParser technologyFoldersInstanceParser = new TechnologyFoldersInstanceParser();

    @Override
    public TechnologyFolders parse(List<String> lines) {

        final TechnologyFolders technologyFolders = new TechnologyFolders();

        for(int i = 0; i < lines.size(); i++) {

            final String tempLine = lines.get(i);

            if(i == 0) {
                continue;
            }

            if(tempLine.contains(" = {")) {
                final int endingPoint = calculateEndingObjectPhase(lines, i, 1);
                final List<String> lineStack = createLineStack(lines, i, endingPoint);
                technologyFolders.getFolderInstances().add(technologyFoldersInstanceParser.parse(lineStack));
                i += lineStack.size() - 1;
            }
        }

        return technologyFolders;
    }
}
