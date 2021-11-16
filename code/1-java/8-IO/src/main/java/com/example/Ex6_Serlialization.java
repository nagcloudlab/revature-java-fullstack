package com.example;

import com.example.model.UserSession;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*

    serialization
    ---------------

    a method, by converting any java-obj's structure into byte-stream,
    store in file-system or transfer over network to other java-application


    why we need serialization:


    ==> to keep away passive objects from JVM-memory
    ==> to share java-objects with other java-applications over-network
    ==> to re-use objects in future without re-creating them


    transient keyword
    -------------------

    => to exclude any obj's properties from serialization process.


    e.g

        => any secure fields like passwords
        => any external resource references like db connection , IO streams
        => any field which often changes



 */

public class Ex6_Serlialization {

    public static void main(String[] args) throws IOException {

        UserSession userSession = new UserSession(123, "Nag");

        // You
        FileOutputStream fos = new FileOutputStream("usersession.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(userSession);

        fos.close();


    }

}
