package io.optional;

import java.io.*;
import java.util.*;

public class TaskOne {
    public static void main(String[] args) {
        File dir = new File("src/main/resources/taskOne/");
        if (!dir.exists()){
            dir.mkdir();
        }

        File file = new File("src/main/resources/taskOne/taskOne.txt");
        Random random = new Random();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < 10; i++) {
                bufferedWriter.write(random.nextInt(100) + "");
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> strings = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            bufferedReader.lines().forEach(strings::add);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            strings.sort(Comparator.comparingInt(Integer::parseInt));
        }catch (NumberFormatException e){
            e.printStackTrace();
        }

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            for (String string: strings) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
