package io.optional;

import java.io.*;
import java.util.ArrayList;

public class TaskTwo {
    public static void main(String[] args) {
        File file = new File("src/main/resources/Student.java");
        ArrayList<String> strings = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            bufferedReader.lines().forEach(strings::add);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).contains("public")) {
                String string = strings.get(i).replace("public", "private");
                strings.set(i, string);
            }
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (String str : strings) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}