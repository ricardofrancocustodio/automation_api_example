package JUnit_Tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class ParametrizedTest {
    private int input;
    private boolean expected;

    public ParametrizedTest(int input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
//                { 1, true },
//                { 2, false },
//                { 3, true },
//                { 4, false }
                { 1, false },
                { 2, true },
                { 3, false },
                { 4, true }
        });
    }

    @Test
    public void testIsEven() {
        boolean actual = isEven(input);
        assertEquals(expected, actual);
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}

