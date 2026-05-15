package gettingStarted.Actian;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RenameAndReplaceFile {

    public static void main(String[] args) {
        // ========== CONFIGURATION SECTION ==========
        // Change these values as needed

        // ORIGINAL FILE PATH - The file you want to rename
        String originalFilePath = "C:\\BackUp\\PT\\A_New\\Automation\\FlatFile_ProfilingRules\\30559_UnicodeD_to_UnicodeD_Scenario_6.dq.rtc";

        // NEW FILE NAME - Provide your custom new file name
        String newFileName = "30559_UnicodeD_to_UnicodeD_ProfilingRules_Scenario_6.dq";  // <<< CHANGE THIS TO YOUR DESIRED NAME

        // FIND AND REPLACE VALUES - Text to search and replace in the file
        String searchText = "30559_UnicodeD_to_UnicodeD_Scenario_6";      // Text you want to find
        String replaceText = "30559_UnicodeD_to_UnicodeD_ProfilingRules_Scenario_6";     // Text you want to replace with
        // ==========================================

        try {
            // Step 1: Rename the original file with your custom name
            String newFilePath = renameFile(originalFilePath, newFileName);
            System.out.println("Original file: " + originalFilePath);
            System.out.println("Renamed to: " + newFilePath);
            System.out.println("----------------------------------------");

            // Step 2: Find and replace in the renamed file
            findAndReplaceInFile(newFilePath, searchText, replaceText);
            System.out.println("Find and replace completed!");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Rename file with custom name provided by user
     */
    public static String renameFile(String filePath, String newFileName) throws IOException {
        Path oldPath = Paths.get(filePath);

        if (!Files.exists(oldPath)) {
            throw new IOException("File does not exist: " + filePath);
        }

        String originalFileName = oldPath.getFileName().toString();
        Path newPath = oldPath.resolveSibling(newFileName);

        // Check if file with new name already exists
        if (Files.exists(newPath)) {
            System.out.println("Warning: File '" + newFileName + "' already exists!");
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("_yyyyMMdd_HHmmss"));

            // Add timestamp to avoid overwrite
            int dotIndex = newFileName.lastIndexOf('.');
            if (dotIndex > 0) {
                newFileName = newFileName.substring(0, dotIndex) + timestamp + newFileName.substring(dotIndex);
            } else {
                newFileName = newFileName + timestamp;
            }
            newPath = oldPath.resolveSibling(newFileName);
            System.out.println("Renaming to: " + newFileName + " (to avoid conflict)");
        }

        // Rename the file
        Files.move(oldPath, newPath, StandardCopyOption.REPLACE_EXISTING);

        System.out.println("Original filename: " + originalFileName);
        System.out.println("New filename: " + newFileName);

        return newPath.toString();
    }

    /**
     * Find and replace text in file with detailed output
     */
    public static void findAndReplaceInFile(String filePath, String searchText, String replaceText)
            throws IOException {

        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {
            throw new IOException("File does not exist: " + filePath);
        }

        // Read file content
        String content = new String(Files.readAllBytes(path));

        // Count occurrences before replacement
        int occurrences = countOccurrences(content, searchText);

        if (occurrences > 0) {
            // Perform find and replace
            String newContent = content.replace(searchText, replaceText);
            Files.write(path, newContent.getBytes());

            System.out.println("----------------------------------------");
            System.out.println("Find and Replace Details:");
            System.out.println("  File: " + path.getFileName());
            System.out.println("  Search text: '" + searchText + "'");
            System.out.println("  Replace text: '" + replaceText + "'");
            System.out.println("  Occurrences found: " + occurrences);
            System.out.println("  Replaced: " + occurrences + " time(s)");
        } else {
            System.out.println("----------------------------------------");
            System.out.println("Search text '" + searchText + "' not found in file");
        }
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