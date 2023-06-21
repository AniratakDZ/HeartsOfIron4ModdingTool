package data.parsers.technology.technologyTree;

import data.objects.technology.technologyTree.TechnologyAiResearchWeights;
import data.parsers.BaseParser;

import java.util.List;

import static java.lang.Double.parseDouble;

public class TechnologyAiResearchWeightsParser extends BaseParser<TechnologyAiResearchWeights> {

    public static String OFFENSIVE = "offensive";
    public static String DEFENSIVE = "defensive";
    public static String OIL = "oil";
    public static String RUBBER = "rubber";

    @Override
    public TechnologyAiResearchWeights parse(List<String> lines) {

        final TechnologyAiResearchWeights technologyAiResearchWeights = new TechnologyAiResearchWeights();

        for(int i = 0; i < lines.size(); i++) {

            final String tempLine = lines.get(i);

            if(tempLine.contains(OFFENSIVE)) {
                technologyAiResearchWeights.setOffensive(parseDouble(replaceTabulatorAndFreeEqualSign(tempLine, OFFENSIVE, 3)));
                continue;
            }

            if(tempLine.contains(DEFENSIVE)) {
                technologyAiResearchWeights.setDefensive(parseDouble(replaceTabulatorAndFreeEqualSign(tempLine, DEFENSIVE, 3)));
                continue;
            }

            if(tempLine.contains(OIL)) {
                technologyAiResearchWeights.setOil(parseDouble(replaceTabulatorAndFreeEqualSign(tempLine, OIL, 3)));
                continue;
            }

            if(tempLine.contains(RUBBER)) {
                technologyAiResearchWeights.setRubber(parseDouble(replaceTabulatorAndFreeEqualSign(tempLine, RUBBER, 3)));
            }
        }

        return technologyAiResearchWeights;
    }
}
