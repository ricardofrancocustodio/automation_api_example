package JUnit_Tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.*;


//Create only one instance of the test class and reuse it between tests
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

//To execute the tests in an specific order
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class CalculatorTests {

    private final Calculator _calculator = new Calculator();
    int plusOne = 1;

    @BeforeAll
    public static void setupClass(){
        System.out.println("Before All");
    }

    @BeforeEach
    public void setUp(){
        System.out.println("Before Each");
    }

    @Test
    @Order(2)
    @DisplayName("Testing Add Method")
    public void testAddMethod(){
        int addResult = _calculator.add(2, plusOne + 1);
        //Assert.assertEquals(4, addResult);
        Assertions.assertEquals(4, addResult);
    }

    @Test
    @Order(1)
    public void testAddMethodDiffNumbers(){
        int addResult = _calculator.add(3,2);
        //Assert.assertEquals(4, addResult);
        Assertions.assertEquals(5, addResult);
    }



    @AfterEach
    public void afterEach(){
        System.out.println("After Each");
    }

    @AfterAll
    public static void AfterAll(){
        System.out.println("AfterAll");
    }

}
