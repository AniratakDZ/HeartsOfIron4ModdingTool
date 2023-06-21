package data.parsers.technology.technologyTree;

import data.objects.technology.technologyTree.TechnologyPath;
import data.parsers.BaseParser;

import java.util.List;

import static java.lang.Integer.parseInt;

public class TechnologyPathParser extends BaseParser<TechnologyPath> {

    public static String LEADS_TO_TECH = "leads_to_tech";
    public static String RESEARCH_COST_COEFF = "research_cost_coeff";

    @Override
    public TechnologyPath parse(List<String> lines) {

        final TechnologyPath technologyPath = new TechnologyPath();

        for(int i = 0; i < lines.size(); i++) {

            final String tempLine = lines.get(i);

            if (tempLine.contains(LEADS_TO_TECH)) {
                technologyPath.setLeadsToTech(replaceTabulatorAndFreeEqualSign(tempLine, LEADS_TO_TECH, 3));
                continue;
            }

            if(tempLine.contains(RESEARCH_COST_COEFF)) {
                technologyPath.setResearchCostCoefficient(parseInt(replaceTabulatorAndFreeEqualSign(tempLine, RESEARCH_COST_COEFF, 3)));
            }
        }

        return technologyPath;
    }
}
