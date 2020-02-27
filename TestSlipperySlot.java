import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.jupiter.api.*;
import java.util.Random;
import java.util.Arrays;

public class TestSlipperySlot {

    @Test
    public void testLeverPull() {
        SlipperySlot test = new SlipperySlot();
        int[] testLever = new int[5];

        // Produce 20 sets of random integers; verify all are between 1 and 50.
        for (int i = 0; i < 21; i++) {
            testLever = test.pullTheLever();
            assertEquals("The lever pull must produce 5 integers", testLever.length, 5);
            assertTrue(0 < testLever[0] && testLever[0] < 51);
            assertTrue(0 < testLever[1] && testLever[1] < 51);
            assertTrue(0 < testLever[2] && testLever[2] < 51);
            assertTrue(0 < testLever[3] && testLever[3] < 51);
            assertTrue(0 < testLever[4] && testLever[4] < 51);
        }
    }

    @Test
    public void testAllSame() {
        // Produce 20 sets of random identical integers between 1 and 50. Test with payout class.
        for (int i = 0; i < 21; i++) {
            // Generate a random number between 1 and 50.
            int value = new Random().nextInt(50);
            value += 1;

            // Create an array of 5 of them
            int[] testValues = new int[5];
            for (int a = 0; a < 5; a++) {
                testValues[a] = value;
            }

            // Test with payOff class
            SlipperySlot test = new SlipperySlot();
            assertTrue(test.payOff(testValues) >= 1000000);
        }
    }

    /**

    @Test
    public void testAllDifferent() {
        // Produce 20 sets of random non-identical integers between 1 and 50. Test with payout class.
        for (int i = 0; i < 21; i++) {

            // Generate a random number between 1 and 50.
            int value = new Random().nextInt(50);
            value += 1;

            // Create an array of 5 of non-identical random numbers
            int[] testValues = new int[5];

            // check if value within 4 of 50
            if (value < 46) {
                for (int a = 0; a < 5; a++) {
                    testValues[a] = value + a;
                    if (testValues[a] == 42) {
                        int randMin = new Random().nextInt(5);
                        testValues[a] -= randMin;
                    }
                }
            }
            else {
                for (int a = 0; a < 5; a++) {
                    testValues[a] = value - a;
                    if (testValues[a] == 42) {
                        int randMin = new Random().nextInt(5);
                        testValues[a] -= randMin;
                    }
                }
            }

            // Test with payOff class
            SlipperySlot test = new SlipperySlot();
            assertTrue(10 > test.payOff(testValues));
        }
    }
     **/

    @Test
    public void testFortyTwoOne() {
        int[] fortyTwoOne = new int[]{3,5,6,7,42};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(fortyTwoOne) == 2);
    }

    @Test
    public void testFortyTwoTwo() {
        int[] fortyTwoOne = new int[]{40,41,42,43,44};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(fortyTwoOne) == 2);
    }

    @Test
    public void testFortyTwoAndPerfectSquareAndPowerOfTwo() {
        int[] fortyTwoOne = new int[]{1,4,16,42,49};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(fortyTwoOne) == 12);
    }

    @Test
    public void testOnlyOnePairAndFortyTwoOne() {
        int[] pairAndFortyTwo = new int[]{3, 5, 7, 42, 42}
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(fortyTwoOne) == 12);
    }

    @Test
    public void testOnlyOnePairAndFortyTwoTwo() {
        int[] pairAndFortyTwo = new int[]{46, 41, 7, 7, 42}
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(fortyTwoOne) == 12);
    }
}