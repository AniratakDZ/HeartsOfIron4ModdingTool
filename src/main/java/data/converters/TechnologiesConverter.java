package data.converters;

import java.util.List;

public class TechnologiesConverter extends BaseConverter {

    @Override
    public List<String> convert(List<String> lines) {

        int currentDepth = 0;

        final List<String> filteredLines = removeSpacesTabulatorsAndBlankLines(lines);

        for(int i = 0; i < filteredLines.size(); i++) {

            String tempLine = lines.get(i);

            String testLine = createTabulatorString(currentDepth);

            if(tempLine.contains("has_dlc")) {
                tempLine = tempLine.replace("\t", "");
            }

            if(tempLine.contains("available") && !tempLine.equals("available={")) {
                final String availableString = "available = { ";
                lines.set(i, testLine + availableString);
                final String subString = tempLine.replace(availableString, "");
                currentDepth++;
                testLine = createTabulatorString(currentDepth);
                final String notString = "NOT = { ";
                lines.add(i + 1, testLine + notString);
                currentDepth++;
                testLine = createTabulatorString(currentDepth);
                final String hasDlcString = subString.replace(notString, "").replace(" } }", "");
                lines.add(i + 2, testLine + hasDlcString);
                currentDepth--;
                testLine = createTabulatorString(currentDepth);
                lines.add(i + 3, testLine + "}");
                currentDepth--;
                testLine = createTabulatorString(currentDepth);
                lines.add(i + 4, testLine + "}");
                i += 4;
                continue;
            }

            if(tempLine.contains("not")) {
                final String notString = "NOT = { ";
                lines.set(i, testLine + notString);
                final String subString = tempLine.replace(notString, "").replace("not = { ", "").replace(" }", "");
                currentDepth++;
                testLine = createTabulatorString(currentDepth);
                lines.add(i + 1, testLine + subString);
                currentDepth--;
                testLine = createTabulatorString(currentDepth);
                lines.add(i + 2, testLine + "}");
                i += 2;
                continue;
            }

            if (tempLine.endsWith("={")) {
                currentDepth++;
                lines.set(i, testLine + tempLine.replace("={", " = {"));
                continue;
            }

            if (tempLine.equals("}")) {
                currentDepth--;
                testLine = createTabulatorString(currentDepth);
                lines.set(i, testLine + "}");
                continue;
            }

            lines.set(i, testLine + tempLine.replace(" = ", "=").replace("=", " = ").replace(">", " > ").replace("<", " < "));
        }

        return filteredLines;
    }

    private List<String> removeSpacesTabulatorsAndBlankLines(List<String> lines) {

        lines.removeIf(line -> line.contains("#"));

        for (int i = 0; i < lines.size(); i++) {
            String tempLine = lines.get(i);

            if(tempLine.contains("has_dlc")) {
                continue;
            }

            lines.set(i, lines.get(i).replace("\t", "").replace(" ", ""));

            if (lines.get(i).isEmpty()) {
                lines.remove(i);
                i--;
            }
        }

        return lines;
    }
}
