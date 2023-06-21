package data.parsers.technology.technologyTree;

import data.objects.technology.technologyTree.TechnologyFolderPosition;
import data.parsers.BaseParser;

import java.util.List;

import static java.lang.Integer.parseInt;

public class TechnologyFolderPositionParser extends BaseParser<TechnologyFolderPosition> {

    public static String X = "x";
    public static String Y = "y";

    @Override
    public TechnologyFolderPosition parse(List<String> lines) {

        final TechnologyFolderPosition technologyFolderPosition = new TechnologyFolderPosition();

        for(int i = 0; i < lines.size(); i++) {

            final String tempLine = lines.get(i);

            if(tempLine.contains(X)) {
                technologyFolderPosition.setX(parseInt(replaceTabulatorAndFreeEqualSign(tempLine, X, 4)));
                continue;
            }

            if(tempLine.contains(Y)) {
                technologyFolderPosition.setY(parseInt(replaceTabulatorAndFreeEqualSign(tempLine, Y, 4)));
            }
        }

        return technologyFolderPosition;
    }
}
