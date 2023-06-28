package utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Objects.requireNonNull;

public class FileUtils {

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

    public static void createFile(String fileName, List<String> lines) throws IOException {
        PrintWriter writer = new PrintWriter(fileName, StandardCharsets.UTF_8);

        for(String line : lines) {
            writer.println(line);
        }

        writer.close();
    }
}
