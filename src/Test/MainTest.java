
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


class MainTest {
    Main fac;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        fac = new Main();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        fac = null;
    }

    //Checks if factors of positive numbers are calculated correctly
    @org.junit.jupiter.api.Test
    void factorPositiveIntCalculated() {
        ArrayList<Integer> realAnswer = new ArrayList<Integer>(Arrays.asList(1, 2, 5, 10));
        ArrayList<Integer> answer = fac.calculateFactors(10);
        assertEquals(answer, realAnswer);
    }
    //Checks if factors of negative numbers are calculated correctly
    @org.junit.jupiter.api.Test
    void factorNegativeIntCalculated() {
        ArrayList<Integer> realAnswer = new ArrayList<Integer>(Arrays.asList(1, 2, 5, 10,-1, -2, -5, -10));
        ArrayList<Integer> answer = fac.calculateFactors(-10);
        assertEquals(answer, realAnswer);
    }
    //Checks if exception is returned upon passing a string
    @org.junit.jupiter.api.Test
    void factorCalculationException() {
        String str = "a";
        Scanner input = new Scanner(str);
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            fac.listFactors(input);
        });

        String expectedMessage = "This value is not an integer";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}