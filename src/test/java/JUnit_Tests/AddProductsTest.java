package JUnit_Tests;


import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.*;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddProductsTest {

    public AddProductsTest() throws IOException {
    }

    AddProducts _addProducts = new AddProducts("https://dummyjson.com/products/add");

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
    public void testGet_statusResponse(){
        Assert.assertEquals(201, _addProducts.get_statusResponse());
        Assert.assertNotEquals(200, _addProducts.get_statusResponse() );
        Assert.assertNotEquals(400, _addProducts.get_statusResponse() );
        Assert.assertNotEquals(401, _addProducts.get_statusResponse() );
        Assert.assertNotEquals(500, _addProducts.get_statusResponse() );

    }

    @Test
    @Order(2)
    public void testGet_idRecorded(){
        Assert.assertEquals(101, _addProducts.get_idRecorded());
        Assert.assertNotEquals(100, _addProducts.get_idRecorded() );
        Assert.assertNotEquals(-1, _addProducts.get_idRecorded() );
        Assert.assertNotEquals(0, _addProducts.get_idRecorded() );
        Assert.assertNotEquals(102, _addProducts.get_idRecorded() );
    }

    @Test
    @Order(3)
    public void testGet_title(){
        Assert.assertEquals("Perfume Oil", _addProducts.get_title());
        Assert.assertNotEquals("Perfume Oil ", _addProducts.get_title() );
        Assert.assertNotEquals(" Perfume Oil", _addProducts.get_title() );
        Assert.assertNotEquals(" Perfume Oil ", _addProducts.get_title() );
        Assert.assertNotEquals("PerfumeOil", _addProducts.get_title() );
    }

    @Test
    @Order(4)
    public void testGet_price(){
        Assert.assertEquals(13.0, _addProducts.get_price(), 0 );
        Assert.assertEquals(13.00, _addProducts.get_price(),0 );

        Assert.assertNotEquals(1.30, _addProducts.get_price() );
        Assert.assertNotEquals( 0, _addProducts.get_price() );
        Assert.assertNotEquals(13, _addProducts.get_price() );
        Assert.assertNotEquals(0.13, _addProducts.get_price() );
        Assert.assertNotEquals(0.0, _addProducts.get_price() );
        Assert.assertNotEquals(130, _addProducts.get_price() );

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
