package data.parsers.technologyFolderAndCategories;

import data.objects.technology.technologyFolderAndCategories.TechnologyFoldersInstanceAvailableNot;
import data.parsers.BaseParser;

import java.util.List;

public class TechnologyFoldersInstanceAvailableNotParser extends BaseParser<TechnologyFoldersInstanceAvailableNot> {

    public static String HAS_DLC = "has_dlc";

    @Override
    public TechnologyFoldersInstanceAvailableNot parse(List<String> lines) {

        final TechnologyFoldersInstanceAvailableNot technologyFoldersInstanceAvailableNot = new TechnologyFoldersInstanceAvailableNot();

        for(int i = 0; i < lines.size(); i++) {

            final String tempLine = lines.get(i);

            if(tempLine.contains(HAS_DLC)) {
                technologyFoldersInstanceAvailableNot.setHasDlc(replaceTabulatorAndFreeEqualSign(tempLine, HAS_DLC, 4));
            }
        }

        return technologyFoldersInstanceAvailableNot;
    }
}
