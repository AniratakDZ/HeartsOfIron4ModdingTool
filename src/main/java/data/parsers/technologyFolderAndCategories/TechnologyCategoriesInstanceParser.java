package data.parsers.technologyFolderAndCategories;

import data.objects.technology.technologyFolderAndCategories.TechnologyCategoriesInstance;
import data.parsers.BaseParser;

import java.util.List;

public class TechnologyCategoriesInstanceParser extends BaseParser<TechnologyCategoriesInstance> {

    @Override
    public TechnologyCategoriesInstance parse(List<String> lines) {

        final TechnologyCategoriesInstance technologyCategoriesInstance = new TechnologyCategoriesInstance();

        for(int i = 0; i < lines.size(); i++) {

            final String tempLine = lines.get(i);

            if(i == 0 || tempLine.contains("}")) {
                continue;
            }

            technologyCategoriesInstance.getCategories().add(tempLine.replace("\t", ""));
        }

        return technologyCategoriesInstance;
    }
}
