package data.parsers;

import data.objects.GameObject;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseParser<T extends GameObject> {

    public static final String TABULATOR_STRING = "\t";
    public static final String TWO_TABULATOR_STRING = "\t\t";
    public static final String THREE_TABULATOR_STRING = "\t\t\t";
    public static final String FOUR_TABULATOR_STRING = "\t\t\t\t";
    public static final String FIVE_TABULATOR_STRING = "\t\t\t\t\t";
    public static final String SIX_TABULATOR_STRING = "\t\t\t\t\t\t";
    public static final String CLOSING_BRACKET = "}";
    public static final String CLOSING_BRACKET_WITH_EMPTY_SPACE_AFTER = "} ";
    public static final String CLOSING_BRACKET_WITH_EMPTY_SPACE_BEFORE = " }";
    public static final String OPENING_BRACKET = "{";
    public static final String OPENING_BRACKET_WITH_EMPTY_SPACE_AFTER = "{ ";
    public static final String OPENING_BRACKET_WITH_EMPTY_SPACE_BEFORE = " {";
    public static final String EQUAL_SIGN = "=";
    public static final String FREE_EQUAL_SIGN = " " + EQUAL_SIGN + " ";
    public static final String EMPTY_STRING = "";
    public static final String SPACE_STRING = " ";
    public static final String BOOLEAN_YES = "yes";
    public static final String BOOLEAN_NO = "no";

    public abstract T parse(List<String> lines);

    public List<String> createLineStack(List<String> lines, int startingIndex, int endingIndex) {
        final List<String> tempLines = new ArrayList<>();
        for(int i = startingIndex; i <= endingIndex; i++) {
            tempLines.add(lines.get(i));
        }
        return tempLines;
    }

    public int calculateEndingObjectPhase(List<String> lines, int startingIndex, int objectDepth) {
        final String tabulatorString = createTabulatorString(objectDepth);
        for(int i = startingIndex; i < lines.size(); i++) {
            if(lines.get(i).equals(tabulatorString + CLOSING_BRACKET)) {
                return i;
            }
        }
        return 0;
    }

    private String createTabulatorString(int objectDepth) {
        String tabulatorString = "";
        for(int i = 0; i < objectDepth; i++) {
            tabulatorString += TABULATOR_STRING;
        }
        return tabulatorString;
    }

    public int countTabulator(String line) {
        int count = 0;

        for(int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == '\t') {
                count++;
            }
        }

        return count;
    }

    public String replaceTabulatorAndFreeEqualSign(String line, String identifier, int depth) {
        return line.replace(createTabulatorString(depth) + identifier, EMPTY_STRING).replace(FREE_EQUAL_SIGN, EMPTY_STRING);
    }
}