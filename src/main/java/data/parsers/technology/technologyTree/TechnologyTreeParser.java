package data.parsers.technology.technologyTree;

import data.objects.technology.technologyTree.TechnologyTree;
import data.parsers.BaseParser;

import java.util.List;

public class TechnologyTreeParser extends BaseParser<TechnologyTree> {

    private final TechnologyParser technologyParser = new TechnologyParser();

    @Override
    public TechnologyTree parse(List<String> lines) {

        final TechnologyTree technologyTree = new TechnologyTree();

        int tempIndex = 0;

        for(int i = 0; i < lines.size(); i++) {

            final String tempLine = lines.get(i);

            if(i == 0){
                continue;
            }

            if(tempIndex == i && tempIndex != 0) {
                System.out.println("ERROR");
            }

            tempIndex = i;

            if(tempLine.contains(" = {")) {
                int endingPoint = calculateEndingObjectPhase(lines, i, 1);
                final List<String> lineStack = createLineStack(lines, i, endingPoint);
                technologyTree.getTechnologies().add(technologyParser.parse(lineStack));
                i += lineStack.size() - 1;
            }
        }

        return technologyTree;
    }
}
