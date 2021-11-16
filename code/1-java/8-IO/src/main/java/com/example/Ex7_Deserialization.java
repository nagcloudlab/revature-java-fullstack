package com.example;

import com.example.model.UserSession;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ex7_Deserialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream("usersession.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Object object = ois.readObject();
        UserSession userSession = (UserSession) object;

        System.out.println(userSession);


    }

}
