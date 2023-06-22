package data.parsers.technology.technologyFolderAndCategories;

import data.objects.technology.technologyFolderAndCategories.TechnologyFoldersInstance;
import data.parsers.BaseParser;

import java.util.List;

public class TechnologyFoldersInstanceParser extends BaseParser<TechnologyFoldersInstance> {

    public static String LEDGER = "ledger";
    public static String DOCTRINE = "doctrine";
    public static String AVAILABLE = "available";

    private final TechnologyFoldersInstanceAvailableParser technologyFoldersInstanceAvailableParser = new TechnologyFoldersInstanceAvailableParser();

    @Override
    public TechnologyFoldersInstance parse(List<String> lines) {

        final TechnologyFoldersInstance technologyFoldersInstance = new TechnologyFoldersInstance();

        for(int i = 0; i < lines.size(); i++) {

            final String tempLine = lines.get(i);

            if(i == 0) {
                technologyFoldersInstance.setName(tempLine.replace("\t", "").replace(" = {", ""));
                continue;
            }

            if(tempLine.contains(LEDGER)) {
                technologyFoldersInstance.setLedger(replaceTabulatorAndFreeEqualSign(tempLine, LEDGER, 2));
                continue;
            }

            if(tempLine.contains(DOCTRINE)) {
                technologyFoldersInstance.setDoctrine(replaceTabulatorAndFreeEqualSign(tempLine, DOCTRINE, 2).equals("yes"));
                continue;
            }

            if(tempLine.contains(AVAILABLE)) {
                final int endingPoint = calculateEndingObjectPhase(lines, i, 2);
                final List<String> lineStack = createLineStack(lines, i, endingPoint);
                technologyFoldersInstance.setAvailable(technologyFoldersInstanceAvailableParser.parse(lineStack));
                i += lineStack.size() - 1;
            }
        }


        return technologyFoldersInstance;
    }
}
