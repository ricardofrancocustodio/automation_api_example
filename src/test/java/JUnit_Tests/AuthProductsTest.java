package JUnit_Tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.*;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthProductsTest {

    private final AuthProducts _authProducts = new AuthProducts();
    private final Products _products = new Products();

    public AuthProductsTest() throws IOException {
         final AuthLogin _authLogin = new AuthLogin();
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

    }

    @Test
    @Order(2)
    public void testUnauthorizedAccess() throws IOException {

    }

    @Test
    @Order(3)
    public void testCheckHTTPBody() throws IOException {


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
