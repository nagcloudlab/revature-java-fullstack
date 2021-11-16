package org.example;

public class Authenticator {

    public boolean authenticate(String username,String password){
        if(username.equals("foo")&&password.equals("secret"))
            return true;
        else
            return false;
    }

}
