package data.converters;

import java.util.List;

import static data.parsers.BaseParser.TABULATOR_STRING;

public abstract class BaseConverter {

    public abstract List<String> convert(List<String> lines);

    public String createTabulatorString(int objectDepth) {
        String tabulatorString = "";
        for(int i = 0; i < objectDepth; i++) {
            tabulatorString += TABULATOR_STRING;
        }
        return tabulatorString;
    }
}
