package JUnit_Tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CalculatorTests {

    private final Calculator _calculator = new Calculator();

    @Test
    public void testAddMethod(){
        int addResult = _calculator.add(2,2);
        //Assert.assertEquals(4, addResult);
        Assertions.assertEquals(4, addResult);
    }

}
