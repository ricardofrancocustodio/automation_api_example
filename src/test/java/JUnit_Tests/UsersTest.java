package JUnit_Tests;

import com.google.gson.JsonArray;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.*;

import java.io.IOException;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsersTest  {

    private final Users _users = new Users();

    public UsersTest() throws IOException {}


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
    public void testGetUserIDFirstName() {
        int userIDFirstName = _users.getUserIDByFirstName("Terry");
        Assert.assertEquals(1, userIDFirstName);

        //or
        Assertions.assertEquals(1, userIDFirstName);
    }

    @Test
    @Order(2)
    public void testGetUserIDMaidenName() {
        int userIDMaidenName = _users.getUserIDByMaidenName("Wyman");
        Assert.assertEquals(7, userIDMaidenName);

        //or
        Assertions.assertEquals(7, userIDMaidenName);
    }

    @Test
    @Order(3)
    public void testGetUserIDByLastName() {
        int userIDMaidenName = _users.getUserIDByLastName("Abbott");
        Assert.assertEquals(7, userIDMaidenName);

        //or
        Assertions.assertEquals(7, userIDMaidenName);
    }

    @Test
    @Order(4)
    public void testGetUserAddress() {
        String userAddress = _users.getUserAddress(8);
        Assert.assertEquals("5601 West Crocus Drive", userAddress);

        //or
        Assertions.assertEquals("5601 West Crocus Drive", userAddress);
    }

    @Test
    @Order(5)
    public void testGetUserEmailById(){
        String userEmail = _users.getUserEmailById(7);
        Assert.assertEquals("dpettegre6@columbia.edu", userEmail);

        //or
        Assertions.assertEquals("dpettegre6@columbia.edu", userEmail);
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
