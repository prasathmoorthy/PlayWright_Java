package gettingStarted.Actian;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileFindAndReplace {

    public static void main(String[] args) {
        String filePath = "C:\\12.5Automation\\dc.test\\test.data\\JMeter\\Production\\Performance\\DataProfiler_Spark\\Database_DataPrepRules\\30564_Vector_to_JDBC_SQL2022_DataPrepRules_Scenario25.dq.rtc";
        String searchText = "30564_Vector_to_JDBC_Scenario25";
        String replaceText = "30564_Vector_to_JDBC_SQL2022_DataPrepRules_Scenario25";

        try {
            // Perform find and replace
            int replacedCount = findAndReplaceInFile(filePath, searchText, replaceText);
            System.out.println("Find and replace completed successfully!");
            System.out.println("Total replacements: " + replacedCount);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static int findAndReplaceInFile(String filePath, String searchText, String replaceText)
            throws IOException {

        // Read all content from file
        Path path = Paths.get(filePath);
        String content = new String(Files.readAllBytes(path));

        // Count occurrences before replacement
        int occurrenceCount = countOccurrences(content, searchText);

        // Perform find and replace
        String newContent = content.replace(searchText, replaceText);

        // Write back to same file
        Files.write(path, newContent.getBytes());

        System.out.println("Replaced '" + searchText + "' with '" + replaceText + "'");
        System.out.println("Occurrences found: " + occurrenceCount);

        return occurrenceCount;
    }

    /**
     * Count occurrences of a substring in a string
     */
    private static int countOccurrences(String text, String search) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(search, index)) != -1) {
            count++;
            index += search.length();
        }
        return count;
    }
}