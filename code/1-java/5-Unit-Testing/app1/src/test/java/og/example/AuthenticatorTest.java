package og.example;

import org.example.Authenticator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*; // import all static members from class

// Junit TestFixture

public class AuthenticatorTest {

    Authenticator authenticator;

      // Arrange 
    @BeforeAll
    public static void beforeAll(){
        // E.g Load External Drivers
        System.out.println("beforeAll()");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("afterAll()");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("beforeEach()");
        // init
        authenticator=new Authenticator();
    }

    @AfterEach
    public void afterEach(){
        System.out.println("afterEach()");
        // cleanup
    }

    // Act & Assert
    @Test
    public void successAuthTest(){
        System.out.println("successAuthTest");
        // Test-data
        String username="foo";
        String password="secret";
        boolean actual=authenticator.authenticate(username,password);
        assertTrue(actual);
    }
    @Test
    public void failAuthTest(){
        // Test-data
        System.out.println("failAuthTest");
        String username="foo";
        String password="invalid";
        boolean actual=authenticator.authenticate(username,password);
        assertFalse(actual);
    }



}
