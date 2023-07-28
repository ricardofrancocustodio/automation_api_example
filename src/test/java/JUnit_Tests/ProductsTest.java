package JUnit_Tests;


import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductsTest {

    private final Products _products = new Products();

    public ProductsTest() throws IOException {}

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
    public void testGetProductIDByTitle() {
        int productTitle = _products.getProductIDByTitle("iPhone X");
        Assert.assertEquals(2, productTitle);

        //or
        Assertions.assertEquals(2, productTitle);
    }

    @Test
    @Order(2)
    public void testGetProductTitleByID() {
        String productId = _products.getProductTitleByID(21);
        Assert.assertEquals("- Daal Masoor 500 grams", productId);

        //or
        Assertions.assertEquals("- Daal Masoor 500 grams", productId);
    }

    @Test
    @Order(3)
    public void testGetDiscPercentById() {
        double productDiscPercent = _products.getDiscPercentById(7);
        Assert.assertEquals(4.15, productDiscPercent, 0);

        //or
        Assertions.assertEquals(4.15, productDiscPercent);
    }

    @Test
    @Order(4)
    public void testGetPriceAfterDiscount() {
        double priceAfterDiscount = _products.getPriceAfterDiscount("Oil Free Moisturizer 100ml");
        Assert.assertEquals(34.8, priceAfterDiscount, 0);

        //or
        Assertions.assertEquals(34.8, priceAfterDiscount);
    }

    @Test
    @Order(5)
    public void testGetProductImages() {
        List<String> productImage = _products.getProductImages("Key Holder");
        for(int i=1; i<productImage.size(); i++){

            Assert.assertEquals("\"https://i.dummyjson.com/data/products/30/"+i+".jpg\"", productImage.get(i-1));

            //or
            Assertions.assertEquals("\"https://i.dummyjson.com/data/products/30/"+i+".jpg\"", productImage.get(i-1));
        }

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


