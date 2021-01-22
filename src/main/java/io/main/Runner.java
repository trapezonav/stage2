package io.main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        File originFile = new File(args[0]);

        if (originFile.isFile()) {
            showFileInfo(originFile);
        }

        if (originFile.isDirectory()) {
            writeToTxtStructureOfFoldersAndFiles(originFile);
        }
    }

    public static void showFileInfo(File file) {
        int folderCount = 0;
        int fileCount = 0;
        int allFileSymbols = 0;

        System.out.println("It's a  file");
        ArrayList<String> strings = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            bufferedReader.lines().forEach(strings::add);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String string : strings) {
            if (string.startsWith("-")) {
                folderCount++;
            } else {
                fileCount++;
                allFileSymbols += string.trim().length();
            }
        }
        float averageNumberOfSymbols = 0;
        float averageNumberOfFilesInDirectories;

        if (fileCount > 0) {
            averageNumberOfSymbols = (float) allFileSymbols / fileCount;
        }

        averageNumberOfFilesInDirectories = (float) fileCount / (folderCount + 1);


        System.out.println("Folders - " + folderCount);
        System.out.println("Files - " + fileCount);
        System.out.println("Average number of fileCount in directories - " + averageNumberOfFilesInDirectories);
        System.out.println("Average number of symbols in file - " + averageNumberOfSymbols);
    }

    public static void writeToTxtStructureOfFoldersAndFiles(File file) {
        System.out.println("It's a directory");
        File dir = new File("src/main/resources/mainTask/");
        if (!dir.exists()) {
            dir.mkdir();
        }
        File listOfAllFiles = new File("src/main/resources/mainTask/listOfAllFiles.txt");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(listOfAllFiles))) {
            writeAllFilesInDirectory(file, bufferedWriter, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAllFilesInDirectory(File file, BufferedWriter writer, int depth) throws IOException {
        char[] spacesArr = new char[depth];
        Arrays.fill(spacesArr, ' ');
        String spaces = new String(spacesArr);
        char[] dashArr = new char[depth];
        Arrays.fill(dashArr, '-');
        String dashes = new String(dashArr);
        for (File file1 : file.listFiles()) {
            if (file1.isDirectory()) {
                writer.write(dashes + file1.getName());
                writer.newLine();
                writeAllFilesInDirectory(file1, writer, depth + 1);
            } else {
                writer.write(spaces + file1.getName());
                writer.newLine();
            }
        }
    }
}