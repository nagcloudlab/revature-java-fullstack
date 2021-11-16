package com.example;

import java.io.*;

public class Ex5_Read_Write_File {

    public static void main(String[] args) {

        File imageFile = new File("/home/nag/Downloads/Diya Sree.jpg");
        try {

            FileInputStream fis = new FileInputStream(imageFile);
            byte[] imageData = new byte[(int) imageFile.length()];
            fis.read(imageData);
            fis.close();

            FileOutputStream fos = new FileOutputStream("diya.jpg");
            fos.write(imageData);
            fos.close();

            System.out.println("image backup complete");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
