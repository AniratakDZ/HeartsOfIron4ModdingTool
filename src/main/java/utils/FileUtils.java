package utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Objects.requireNonNull;

public class FileUtils {

    public static String FOLDER_GENERATED_SOURCES = "generatedSources";
    public static String FOLDER_CONVERTED = FOLDER_GENERATED_SOURCES + "/converted";

    public static void init() {
        final File generatedSources = new File(FOLDER_GENERATED_SOURCES);
        final File convertedFolder = new File(FOLDER_CONVERTED);
        if(!generatedSources.exists()) {
            generatedSources.mkdir();
        }
        if(!convertedFolder.exists()) {
            convertedFolder.mkdir();
        }
    }

    public static List<String> readLines(String filename) {
        final List<String> lines = new ArrayList<>();

        Scanner scanner = new Scanner(requireNonNull(FileUtils.class.getClassLoader().getResourceAsStream(filename)));

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            lines.add(line);
        }

        scanner.close();
        return lines;
    }

    public static InputStream getFile(String filePath) {
        return FileUtils.class.getClassLoader().getResourceAsStream(filePath);
    }

    public static void createFile(String filePathName, List<String> lines) throws IOException {
        PrintWriter writer = new PrintWriter(filePathName, StandardCharsets.UTF_8);

        for(String line : lines) {
            writer.println(line);
        }

        writer.close();
    }
}
