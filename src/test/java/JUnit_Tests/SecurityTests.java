package JUnit_Tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SecurityTests {

    @Test
    @Order(1)
    public void testUnauthorizedAccess() throws IOException {
       // Assert.assertEquals(401, _addProducts.unauthorizedAccess("https://dummyjson.com/products/add"));
    }

}