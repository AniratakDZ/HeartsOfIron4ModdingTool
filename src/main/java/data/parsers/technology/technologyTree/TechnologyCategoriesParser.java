package data.parsers.technology.technologyTree;

import data.objects.technology.technologyTree.TechnologyCategories;
import data.parsers.BaseParser;

import java.util.List;

public class TechnologyCategoriesParser extends BaseParser<TechnologyCategories> {

    @Override
    public TechnologyCategories parse(List<String> lines) {

        final TechnologyCategories technologyCategories = new TechnologyCategories();

        for(int i = 0; i < lines.size(); i++) {

            final String tempLine = lines.get(i);

            if(i == 0 || tempLine.contains("}")) {
                continue;
            }

            technologyCategories.getCategorieNames().add(tempLine.replace(TABULATOR_STRING, EMPTY_STRING));
        }

        return technologyCategories;
    }
}
