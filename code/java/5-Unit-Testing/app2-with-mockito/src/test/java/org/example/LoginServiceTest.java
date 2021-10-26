package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import  static org.junit.jupiter.api.Assertions.*;

public class LoginServiceTest {

    private LoginService loginService;
    private  UserRepository userRepositoryMock;

    @BeforeEach
    public void init(){
        userRepositoryMock= Mockito.mock(UserRepository.class);
        loginService=new LoginService(userRepositoryMock); // team-2
    }

    @BeforeEach
    public void recordMock(){
        // record mock with expected method calls
        Mockito.when(userRepositoryMock.findUser("foo"))
                .thenReturn(new User("foo","bar"));
    }


    @Test
    @DisplayName("username cannot be empty")
    public void emptyUserName(){
        InvalidInputException exception=assertThrows(InvalidInputException.class,()->{
            loginService.doLogin("","bar");
        });
        assertEquals("username cannot be empty",exception.getMessage());
    }

    @Test
    @DisplayName("password cannot be empty")
    public void emptyPassword(){
        InvalidInputException exception=assertThrows(InvalidInputException.class,()->{
            loginService.doLogin("foo","");
        });
        assertEquals("password cannot be empty",exception.getMessage());
    }

    @Test
    @DisplayName("valid username and password")
    public void validUsernameAndPassword(){
        assertTrue(loginService.doLogin("foo","bar"));
    }


    @Test
    @DisplayName("invalid username and password")
    public void invalidUsernameAndPassword() {
        assertFalse(loginService.doLogin("foo","barbar"));
    }



}
