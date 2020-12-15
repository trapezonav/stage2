package io.optional;

import java.io.*;
import java.util.*;

public class TaskOne {
    public static void main(String[] args) {
        File dir = new File("newDir");
        if (!dir.exists()){
            dir.mkdir();
        }

        File file = new File("newDir/firsttask.txt");
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
            while (bufferedReader.ready()) {
                strings.add(bufferedReader.readLine());
            }
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
