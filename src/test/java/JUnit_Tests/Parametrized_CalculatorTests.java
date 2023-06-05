package JUnit_Tests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class Parametrized_CalculatorTests {
    private int valueA;
    private int valueB;
    private int result;
    Calculator _calculator = new Calculator();


    //constructor
    public Parametrized_CalculatorTests(int valueA, int valueB, int result){
        this.valueA = valueA;
        this.valueB = valueB;
        this.result = result;

    }

   @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {2, 2, 4},
                {4, 4, 8},
                {0, 2, 2},
                {2, 0, 2},
                {0, 0, 0},
                {0, -9, -9},
                {-1, 1, 0},
                {-1, -1, -2}
        });

    }

    @Test
    @NightlyRun
    public void testAddMethod(){
        int testCalc = _calculator.add(valueA, valueB);
        Assertions.assertEquals(result, testCalc);
    }

}
