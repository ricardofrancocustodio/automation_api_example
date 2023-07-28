package JUnit_Tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.*;

import java.io.IOException;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthLoginTest {

    private final AuthLogin _authLogin = new AuthLogin();

    public AuthLoginTest() throws IOException {
    }

    @BeforeAll
    public static void setupClass(){
        //System.out.println("Before All");
    }

    @BeforeEach
    public void setUp(){
        //System.out.println("Before Each");
    }


    /**
     * Test Cases
     */

    @Test
    @Order(1)
    public void testCheckHTTPHeader(){
        Assert.assertEquals("application/json; charset=utf-8", _authLogin.checkHTTPHeader());
        Assert.assertNotEquals("text/html; charset=utf-8", _authLogin.checkHTTPHeader());
        Assert.assertNotEquals("application/xhtml+xml; charset=utf-8", _authLogin.checkHTTPHeader());
        Assert.assertNotEquals("application/x-www-form-urlencoded; charset=utf-8", _authLogin.checkHTTPHeader());
    }

    @Test
    @Order(2)
    public void testCheckHTTPBody() throws IOException {
        Assert.assertTrue(_authLogin.checkHTTPBody());

    }

    /**
     * End of Test Cases
     *
     */

    @AfterEach
    public void afterEach(){
        //System.out.println("After Each");
    }

    @AfterAll
    public static void AfterAll(){
        //System.out.println("AfterAll");
    }



}
