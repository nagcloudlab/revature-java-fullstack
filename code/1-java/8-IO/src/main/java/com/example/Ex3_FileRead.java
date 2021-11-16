package com.example;

import java.io.*;

public class Ex3_FileRead {
    public static void main(String[] args) {

        File notesFile = new File("Notes.txt");
        try (
                FileReader fileReader = new FileReader(notesFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
//                if (!line.isEmpty()) {
                    System.out.println(line);
//                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
