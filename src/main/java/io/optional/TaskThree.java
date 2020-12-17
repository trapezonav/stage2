package io.optional;

import java.io.*;

public class TaskThree {
    public static void main(String[] args) {
        File dir = new File("src/main/resources/taskThree/");
        if (!dir.exists()) {
            dir.mkdir();
        }

        File origin = new File("src/main/java/exceptions/Student.java");
        File result = new File("src/main/resources/taskThree/Student.java");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(origin));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(result))){
            String str;
            while ((str = bufferedReader.readLine()) != null){
                str = new StringBuffer(str).reverse().toString();
                System.out.println(str);
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}