package data.converters;

import java.util.List;

public class TechnologyTreeConverter extends BaseConverter {

    @Override
    public List<String> convert(List<String> lines) {
        final List<String> filteredLines = removeSpacesTabulatorsAndBlankLines(lines);

        int currentDepth = 0;

        for (int i = 0; i < filteredLines.size(); i++) {

            String tempLine = filteredLines.get(i);

            String testLine = createTabulatorString(currentDepth);

            if(tempLine.contains("position")) {
                String positionValue = tempLine.substring(tempLine.indexOf("{"), tempLine.indexOf("}") + 1);
                String positionKey = tempLine.replace(positionValue, "");
                lines.set(i, positionKey + "{");
                currentDepth++;
                testLine = createTabulatorString(currentDepth);
                String filteredPositionValue = positionValue.replace("{ ", "").replace("} ", "").replace(" = ", "=");
                String[] positionValues = filteredPositionValue.split(" ");
                lines.add(i + 1, testLine + positionValues[0].replace("=", " = "));
                lines.add(i + 2, testLine + positionValues[1].replace("=", " = "));
                currentDepth--;
                testLine = createTabulatorString(currentDepth);
                lines.add(i + 3, testLine + "}");
                i += 3;
                continue;
            }

            if(tempLine.contains("NOT") && tempLine.contains("{") && tempLine.contains("}")) {
                String positionValue = tempLine.substring(tempLine.indexOf("{"), tempLine.indexOf("}") + 1);
                positionValue = positionValue.replace("{", "").replace("}", "");
                lines.set(i, createTabulatorString(4) + "NOT = {");
                currentDepth++;
                testLine = createTabulatorString(currentDepth);
                lines.add(i + 1, testLine + positionValue.replace("=", " = "));
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

            lines.set(i, testLine + tempLine.replace("=", " = ").replace(">", " > ").replace("<", " < "));
        }

        return filteredLines;
    }

    private List<String> removeSpacesTabulatorsAndBlankLines(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            String tempLine = lines.get(i);

            if(tempLine.contains("position")) {
                continue;
            }

            if(tempLine.contains("has_dlc")) {
                continue;
            }

            lines.set(i, lines.get(i).replace("\t", "").replace(" ", ""));


            if(tempLine.contains("#")) {
                lines.remove(tempLine);
                i --;
            }

            if (lines.get(i).isEmpty()) {
                lines.remove(i);
                i--;
            }
        }

        return lines;
    }
}
