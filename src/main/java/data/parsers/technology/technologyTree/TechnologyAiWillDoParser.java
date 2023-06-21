package data.parsers.technology.technologyTree;

import data.objects.technology.technologyTree.TechnologyAiWillDo;
import data.parsers.BaseParser;

import java.util.List;

import static java.lang.Double.parseDouble;

public class TechnologyAiWillDoParser extends BaseParser<TechnologyAiWillDo> {

    public static String FACTOR = "factor";
    public static String MODIFIER = "modifier";

    private final TechnologyAiWillDoModifierParser technologyAiWillDoModifierParser = new TechnologyAiWillDoModifierParser();

    @Override
    public TechnologyAiWillDo parse(List<String> lines) {

        final TechnologyAiWillDo technologyAiWillDo = new TechnologyAiWillDo();

        for(int i = 0; i < lines.size(); i++) {

            final String tempLine = lines.get(i);

            if(tempLine.contains(FACTOR)) {
                technologyAiWillDo.setFactor(parseDouble(replaceTabulatorAndFreeEqualSign(tempLine, FACTOR, 2)));
                continue;
            }

            if(tempLine.contains(MODIFIER)) {
                final int endingPoint = calculateEndingObjectPhase(lines, i, 3);
                final List<String> lineStack = createLineStack(lines, i, endingPoint);
                technologyAiWillDo.getModifier().add(technologyAiWillDoModifierParser.parse(lineStack));
                i += lineStack.size() - 1;
            }
        }

        return technologyAiWillDo;
    }
}
