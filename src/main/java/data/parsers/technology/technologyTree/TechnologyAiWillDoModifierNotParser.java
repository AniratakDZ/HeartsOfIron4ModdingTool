package data.parsers.technology.technologyTree;

import data.objects.technology.technologyTree.TechnologyAiWillDoModifierNot;
import data.parsers.BaseParser;

import java.util.List;

public class TechnologyAiWillDoModifierNotParser extends BaseParser<TechnologyAiWillDoModifierNot> {

    public static String HAS_GOVERNMENT = "has_government";
    public static String TAG = "tag";

    @Override
    public TechnologyAiWillDoModifierNot parse(List<String> lines) {

        final TechnologyAiWillDoModifierNot technologyAiWillDoModifierNot = new TechnologyAiWillDoModifierNot();

        for(int i = 0; i < lines.size(); i++) {

            final String tempLine = lines.get(i);

            if(tempLine.contains(HAS_GOVERNMENT)) {
                technologyAiWillDoModifierNot.setHasGovernment(replaceTabulatorAndFreeEqualSign(tempLine, HAS_GOVERNMENT, 5));
                continue;
            }

            if(tempLine.contains(TAG)) {
                technologyAiWillDoModifierNot.setTag(replaceTabulatorAndFreeEqualSign(tempLine, TAG, 5));
            }
        }

        return technologyAiWillDoModifierNot;
    }
}
