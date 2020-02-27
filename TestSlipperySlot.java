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

    @Test
    public void testFortyTwoOne() {
        int[] fortyTwoOne = new int[]{3, 5, 6, 7, 42};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(fortyTwoOne) == 2);
    }

    @Test
    public void testFortyTwoTwo() {
        int[] fortyTwoOne = new int[]{40, 41, 42, 43, 44};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(fortyTwoOne) == 2);
    }

    @Test
    public void testOnlyOnePairAndFortyTwoOne() {
        int[] pairAndFortyTwoOne = new int[]{3, 5, 7, 42, 42};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(pairAndFortyTwoOne) == 12);
    }

    @Test
    public void testOnlyOnePairAndFortyTwoTwo() {
        int[] pairAndFortyTwoTwo = new int[]{46, 41, 7, 7, 42};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(pairAndFortyTwoTwo) == 12);
    }

    @Test
    public void testAllFortyTwo() {
        int[] allFortyTwo = new int[]{42, 42, 42, 42, 42};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(allFortyTwo) == 1000002);
    }

    @Test
    public void testPerfectSquareOne() {
        int[] perfectOne = new int[]{40, 41, 43, 44, 49};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(perfectOne) == 7);
    }

    @Test
    public void testPerfectSquareTwo() {
        int[] perfectTwo = new int[]{3, 9, 27, 36, 49};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(perfectTwo) == 7);
    }

    @Test
    public void testPerfectSquareAndPair() {
        int[] perfectAndPair = new int[]{9,9,11,13,14};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(perfectAndPair) == 17);
    }

    @Test
    public void testAllSamePerfectSquare() {
        int[] allSamePerfect = new int[]{49, 49, 49, 49, 49};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(allSamePerfect) == 1000007);
    }

    @Test
    public void testPowerOfTwoOne() {
        int[] powerOne = new int[]{3, 8, 11, 32, 33};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(powerOne) == 3);
    }

    @Test
    public void testPowerOfTwoTwo() {
        int[] powerTwo = new int[]{30, 31, 32, 33, 34};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(powerTwo) == 3);
    }

    @Test
    public void testAllSamePowerOfTwo() {
        int[] allPower = new int[]{8, 8, 8, 8, 8};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(allPower) == 1000003);
    }

    @Test
    public void testAllSamePerfectSquareAndPowerOfTwo() {
        int[] allSamePerfect = new int[]{4, 4, 4, 4, 4};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(allSamePerfect) == 1000010);
    }

    @Test
    public void testFortyTwoAndPerfectSquareAndPowerOfTwo() {
        int[] fortyTwoOne = new int[]{1, 4, 16, 42, 49};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(fortyTwoOne) == 12);
    }

    @Test (timeout = 15)
    public void testTimeout() {
        // Running payoff 50X to test timeout
        for (int i = 0; i < 51; i++) {
            int[] random = new int[]{1, 4, 16, 42, 49};
            SlipperySlot test = new SlipperySlot();
            test.pullTheLever();
            test.payOff(random);
        }
    }
}