package JUnit_Tests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class Parametrized_UsersTests {
    private int valueA;
    private int valueB;
    private int result;
    //Users _calculator = new Users();


    //constructor
    public Parametrized_UsersTests(int valueA, int valueB, int result){
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
      //  int testCalc = _calculator.add(valueA, valueB);
     //   Assertions.assertEquals(result, testCalc);
    }

}
