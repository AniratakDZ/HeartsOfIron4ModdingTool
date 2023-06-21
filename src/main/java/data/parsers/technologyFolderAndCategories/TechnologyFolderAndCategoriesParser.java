package data.parsers.technologyFolderAndCategories;

import data.objects.technology.technologyFolderAndCategories.TechnologyFolderAndCategories;
import data.parsers.BaseParser;

import java.util.List;

public class TechnologyFolderAndCategoriesParser extends BaseParser<TechnologyFolderAndCategories> {

    public static String TECHNOLOGY_CATEGORIES = "technology_categories";
    public static String TECHNOLOGY_FOLDERS = "technology_folders";

    private final TechnologyCategoriesInstanceParser technologyCategoriesInstanceParser = new TechnologyCategoriesInstanceParser();
    private final TechnologyFoldersParser technologyFoldersParser = new TechnologyFoldersParser();

    @Override
    public TechnologyFolderAndCategories parse(List<String> lines) {

        final TechnologyFolderAndCategories technologyFolderAndCategories = new TechnologyFolderAndCategories();

        for(int i = 0; i < lines.size(); i++) {

            final String tempLine = lines.get(i);

            if(tempLine.contains(TECHNOLOGY_CATEGORIES)) {
                final int endingPoint = calculateEndingObjectPhase(lines, i, 0);
                final List<String> lineStack = createLineStack(lines, i, endingPoint);
                technologyFolderAndCategories.setCategories(technologyCategoriesInstanceParser.parse(lineStack));
                i += lineStack.size() - 1;
                continue;
            }

            if(tempLine.contains(TECHNOLOGY_FOLDERS)) {
                final int endingPoint = calculateEndingObjectPhase(lines, i, 0);
                final List<String> lineStack = createLineStack(lines, i, endingPoint);
                technologyFolderAndCategories.setFolders(technologyFoldersParser.parse(lineStack));
                i += lineStack.size() - 1;
            }
        }

        return technologyFolderAndCategories;
    }
}
