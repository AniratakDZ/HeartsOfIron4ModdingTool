package data.parsers.technology.technologyTree;

import data.objects.technology.technologyTree.TechnologyAiWillDoModifierOr;
import data.parsers.BaseParser;

import java.util.List;

public class TechnologyAiWillDoModifierOrParser extends BaseParser<TechnologyAiWillDoModifierOr> {

    public static String TAG = "tag";
    public static String OIL = "oil";
    public static String ALUMINIUM = "aluminium";
    public static String RUBBER = "rubber";
    public static String TUNGSTEN = "tungsten";
    public static String STEEL = "steel";
    public static String CHROMIUM = "chromium";
    public static String NEW_FIELD = "new_field";

    @Override
    public TechnologyAiWillDoModifierOr parse(List<String> lines) {

        final TechnologyAiWillDoModifierOr technologyAiWillDoModifierOr = new TechnologyAiWillDoModifierOr();

        for(int i = 0; i < lines.size(); i++) {

            final String tempLine = lines.get(i);

            if(tempLine.contains(TAG)) {
                technologyAiWillDoModifierOr.getTags().add(replaceTabulatorAndFreeEqualSign(tempLine, TAG, 5));
                continue;
            }

            if(tempLine.contains(OIL)) {
                technologyAiWillDoModifierOr.setOil(replaceTabulatorAndFreeEqualSign(tempLine, OIL, 5));
                continue;
            }

            if(tempLine.contains(ALUMINIUM)) {
                technologyAiWillDoModifierOr.setAluminium(replaceTabulatorAndFreeEqualSign(tempLine, ALUMINIUM, 5));
                continue;
            }

            if(tempLine.contains(RUBBER)) {
                technologyAiWillDoModifierOr.setRubber(replaceTabulatorAndFreeEqualSign(tempLine, RUBBER, 5));
                continue;
            }

            if(tempLine.contains(TUNGSTEN)) {
                technologyAiWillDoModifierOr.setTungsten(replaceTabulatorAndFreeEqualSign(tempLine, TUNGSTEN, 5));
                continue;
            }

            if(tempLine.contains(STEEL)) {
                technologyAiWillDoModifierOr.setSteel(replaceTabulatorAndFreeEqualSign(tempLine, STEEL, 5));
                continue;
            }

            if(tempLine.contains(CHROMIUM)) {
                technologyAiWillDoModifierOr.setChromium(replaceTabulatorAndFreeEqualSign(tempLine, CHROMIUM, 5));
            }
            
            if(tempLine.contains(NEW_FIELD)) {
                technologyAiWillDoModifierOr.setNewField(replaceTabulatorAndFreeEqualSign(tempLine, NEW_FIELD, 5));
            }

        }

        return technologyAiWillDoModifierOr;
    }
}
