package data.parsers.technology.technologyTree;

import data.objects.technology.technologyTree.TechnologyAllowBranch;
import data.parsers.BaseParser;

import java.util.List;

public class TechnologyAllowBranchParser extends BaseParser<TechnologyAllowBranch> {

    public static String HAS_DLC = "has_dlc";

    @Override
    public TechnologyAllowBranch parse(List<String> lines) {

        final TechnologyAllowBranch technologyAllowBranch = new TechnologyAllowBranch();

        for(int i = 0; i < lines.size(); i++) {

            final String tempLine = lines.get(i);

            if(tempLine.contains(HAS_DLC)) {
                technologyAllowBranch.setHasDlc(replaceTabulatorAndFreeEqualSign(tempLine, HAS_DLC, 3));
            }
        }

        return technologyAllowBranch;
    }
}
