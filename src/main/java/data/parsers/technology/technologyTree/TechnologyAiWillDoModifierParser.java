package data.parsers.technology.technologyTree;

import data.objects.technology.technologyTree.TechnologyAiWillDoModifier;
import data.parsers.BaseParser;

import java.util.List;

import static java.lang.Double.parseDouble;

public class TechnologyAiWillDoModifierParser extends BaseParser<TechnologyAiWillDoModifier> {

    public static String FACTOR = "factor";
    public static String DATE = "date";
    public static String NOT = "NOT";
    public static String HAS_TECH = "has_tech";
    public static String IS_RESEARCHING_TECHNOLOGY = "is_researching_technology";
    public static String OIL = "oil";
    public static String NUM_OF_MILITARY_FACTORIES = "num_of_military_factories";
    public static String NUM_OF_NAVAL_FACTORIES = "num_of_naval_factories";
    public static String HAS_WAR = "has_war";
    public static String IS_MAJOR = "is_major";
    public static String TAG = "tag";
    public static String RUBBER = "rubber";
    public static String OR = "OR";

    private final TechnologyAiWillDoModifierNotParser technologyAiWillDoModifierNotParser = new TechnologyAiWillDoModifierNotParser();
    private final TechnologyAiWillDoModifierOrParser technologyAiWillDoModifierOrParser = new TechnologyAiWillDoModifierOrParser();

    @Override
    public TechnologyAiWillDoModifier parse(List<String> lines) {

        final TechnologyAiWillDoModifier technologyAiWillDoModifier = new TechnologyAiWillDoModifier();

        for(int i = 0; i < lines.size(); i++) {

            final String tempLine = lines.get(i);

            if(tempLine.contains(NUM_OF_MILITARY_FACTORIES)) {
                technologyAiWillDoModifier.setNumOfMilitaryFactories(replaceTabulatorAndFreeEqualSign(tempLine, NUM_OF_MILITARY_FACTORIES, 4));
                continue;
            }

            if(tempLine.contains(NUM_OF_NAVAL_FACTORIES)) {
                technologyAiWillDoModifier.setNumOfNavalFactories(replaceTabulatorAndFreeEqualSign(tempLine, NUM_OF_NAVAL_FACTORIES, 4));
                continue;
            }

            if(tempLine.contains(FACTOR)) {
                technologyAiWillDoModifier.setFactor(parseDouble(replaceTabulatorAndFreeEqualSign(tempLine, FACTOR, 3)));
                continue;
            }

            if(tempLine.contains(DATE)) {
                technologyAiWillDoModifier.setDate(replaceTabulatorAndFreeEqualSign(tempLine, DATE, 3).replace("\t", ""));
                continue;
            }

            if(tempLine.contains(NOT)) {
                final int endingPoint = calculateEndingObjectPhase(lines, i, 4);
                final List<String> lineStack = createLineStack(lines, i, endingPoint);
                technologyAiWillDoModifier.setNot(technologyAiWillDoModifierNotParser.parse(lineStack));
                i += lineStack.size() - 1;
                continue;
            }

            if(tempLine.contains(HAS_TECH)) {
                technologyAiWillDoModifier.setHasTech(replaceTabulatorAndFreeEqualSign(tempLine, HAS_TECH, 4));
                continue;
            }

            if(tempLine.contains(IS_RESEARCHING_TECHNOLOGY)) {
                technologyAiWillDoModifier.setIsResearchingTechnology(replaceTabulatorAndFreeEqualSign(tempLine, IS_RESEARCHING_TECHNOLOGY, 4));
                continue;
            }

            if(tempLine.contains(OIL)) {
                technologyAiWillDoModifier.setOil(replaceTabulatorAndFreeEqualSign(tempLine, OIL, 4));
                continue;
            }

            if(tempLine.contains(HAS_WAR)) {
                technologyAiWillDoModifier.setHasWar(replaceTabulatorAndFreeEqualSign(tempLine, HAS_WAR, 4).equals("yes"));
                continue;
            }

            if(tempLine.contains(IS_MAJOR)) {
                technologyAiWillDoModifier.setMajor(replaceTabulatorAndFreeEqualSign(tempLine, IS_MAJOR, 4).equals("yes"));
                continue;
            }

            if(tempLine.contains(TAG)) {
                technologyAiWillDoModifier.setTag(replaceTabulatorAndFreeEqualSign(tempLine, TAG, 4));
                continue;
            }

            if(tempLine.contains(OR)) {
                final int endingPoint = calculateEndingObjectPhase(lines, i, 4);
                final List<String> lineStack = createLineStack(lines, i, endingPoint);
                technologyAiWillDoModifier.setOr(technologyAiWillDoModifierOrParser.parse(lineStack));
                i += lineStack.size() - 1;
                continue;
            }

            if(tempLine.contains(RUBBER)) {
                technologyAiWillDoModifier.setRubber(replaceTabulatorAndFreeEqualSign(tempLine, RUBBER, 4));
            }
        }

        return technologyAiWillDoModifier;
    }
}
