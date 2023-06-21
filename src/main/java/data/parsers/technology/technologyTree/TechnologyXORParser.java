package data.parsers.technology.technologyTree;

import data.objects.technology.technologyTree.TechnologyXOR;
import data.parsers.BaseParser;

import java.util.List;

public class TechnologyXORParser extends BaseParser<TechnologyXOR> {

    @Override
    public TechnologyXOR parse(List<String> lines) {

        final TechnologyXOR technologyXOR = new TechnologyXOR();

        for(int i = 0; i < lines.size(); i++) {

            final String tempLine = lines.get(i);

            if(i == 0 || tempLine.contains("}")){
                technologyXOR.getTechnologies().add(tempLine.replace(TABULATOR_STRING, EMPTY_STRING));
            }
        }

        return technologyXOR;
    }
}
