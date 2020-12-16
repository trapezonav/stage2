package io.optional;

import java.io.*;
import java.util.ArrayList;

public class TaskTwo {
    public static void main(String[] args) {
        File dir = new File("src/main/resources/taskTwo/");
        if (!dir.exists()){
            dir.mkdir();
        }
        File file = new File("src/main/resources/taskTwo/Student.java");
        ArrayList<String> strings = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/exceptions/Student.java"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            bufferedReader.lines().forEach(strings::add);
            for (int i = 0; i < strings.size(); i++) {
                if (strings.get(i).contains("public")){
                    String str = strings.get(i).replace("public","private");
                    strings.set(i,str);
                }
            }
            for (String str: strings) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}