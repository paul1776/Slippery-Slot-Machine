package SlipperySlot;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.jupiter.api.*;
import java.util.Random;
import java.util.Arrays;

/**
 * @author Paul-Emmanuel Courtines
 */
public class TestSlipperySlot {

    /** This function makes 20 calls to SlipperySlot function pullTheLever().
     * Tests if an array of 5 values between 1 and 50 is returned.
     * @version 1.0 */
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

    /** This function creates 20 array of 5 identical values between 1 and 50.
     * It checks that return is greater or equal to 1000000.
     * @version 1.0 */
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

    /** Tests return of 10.
     * @version 1.0 */
    @Test
    public void testSimplePairOne() {
        int[] simplePairOne = new int[]{5, 5, 7, 11, 43};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(simplePairOne) == 10);
    }

    /** Tests return of 10.
     * @version 1.0 */
    @Test
    public void testSimplePairTwo() {
        int[] simplePairTwo = new int[]{3, 3, 39, 37, 14};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(simplePairTwo) == 10);
    }

    /** Tests return of 10.
     * @version 1.0 */
    @Test
    public void testTwoPairsOne() {
        int[] twoPairsOne = new int[]{3, 3, 39, 39, 14};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(twoPairsOne) == 10);
    }

    /** Tests return of 10.
     * @version 1.0 */
    @Test
    public void testTwoPairsTwo() {
        int[] twoPairsTwo = new int[]{5, 5, 14, 14, 23};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(twoPairsTwo) == 10);
    }

    /** Tests return of 100.
     * @version 1.0 */
    @Test
    public void testTripleOne() {
        int[] tripleOne = new int[]{39, 39, 14, 39, 41};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(tripleOne) == 100);
    }

    /** Tests return of 100.
     * @version 1.0 */
    @Test
    public void testTripleTwo() {
        int[] tripleTwo = new int[]{3, 3, 3, 37, 14};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(tripleTwo) == 100);
    }

    /** Tests return of 5000.
     * @version 1.0 */
    @Test
    public void testFullHouseOne() {
        int[] fullHouseOne = new int[]{3, 3, 37, 37, 3};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(fullHouseOne) == 5000);
    }

    /** Tests return of 5000.
     * @version 1.0 */
    @Test
    public void testFullHouseTwo() {
        int[] fullHouseTwo = new int[]{23, 7, 23, 23, 7};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(fullHouseTwo) == 5000);
    }

    /** Tests return of 10000.
     * @version 1.0 */
    @Test
    public void testFourOne() {
        int[] fourOne = new int[]{3, 3, 37, 3, 3};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(fourOne) == 10000);
    }

    /** Tests return of 10000.
     * @version 1.0 */
    @Test
    public void testFourTwo() {
        int[] fourTwo = new int[]{23, 7, 23, 23, 23};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(fourTwo) == 10000);
    }

    /** Tests return of 2.
     * @version 1.0 */
    @Test
    public void testFortyTwoOne() {
        int[] fortyTwoOne = new int[]{3, 5, 6, 7, 42};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(fortyTwoOne) == 2);
    }

    /** Tests return of 2.
     * @version 1.0 */
    @Test
    public void testFortyTwoTwo() {
        int[] fortyTwoOne = new int[]{40, 41, 42, 43, 44};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(fortyTwoOne) == 2);
    }

    /** Tests return of 12.
     * @version 1.0 */
    @Test
    public void testFortyTwoAndPair() {
        int[] fortyTwoAndPair = new int[]{3, 5, 7, 42, 42};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(fortyTwoAndPair) == 12);
    }

    /** Tests return of 1000002.
     * @version 1.0 */
    @Test
    public void testAllFortyTwo() {
        int[] allFortyTwo = new int[]{42, 42, 42, 42, 42};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(allFortyTwo) == 1000002);
    }

    /** Tests return of 7.
     * @version 1.0 */
    @Test
    public void testPerfectSquareOne() {
        int[] perfectOne = new int[]{40, 41, 43, 44, 49};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(perfectOne) == 7);
    }

    /** Tests return of 7.
     * @version 1.0 */
    @Test
    public void testPerfectSquareTwo() {
        int[] perfectTwo = new int[]{3, 9, 27, 36, 37};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(perfectTwo) == 7);
    }

    /** Tests return of 17.
     * @version 1.0 */
    @Test
    public void testPerfectSquareAndPair() {
        int[] perfectAndPair = new int[]{9,9,11,13,14};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(perfectAndPair) == 17);
    }

    /** Tests return of 1000007.
     * @version 1.0 */
    @Test
    public void testAllPerfectSquare() {
        int[] allPerfect = new int[]{49, 49, 49, 49, 49};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(allPerfect) == 1000007);
    }

    /** Tests return of 3.
     * @version 1.0 */
    @Test
    public void testPowerTwoOne() {
        int[] powerOne = new int[]{3, 8, 11, 32, 33};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(powerOne) == 3);
    }

    /** Tests return of 3.
     * @version 1.0 */
    @Test
    public void testPowerTwoTwo() {
        int[] powerTwo = new int[]{30, 31, 32, 33, 34};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(powerTwo) == 3);
    }

    /** Tests return of 1000003.
     * @version 1.0 */
    @Test
    public void testAllPowerTwo() {
        int[] allPowerTwo = new int[]{8, 8, 8, 8, 8};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(allPowerTwo) == 1000003);
    }

    /** Tests return of 1000010.
     * @version 1.0 */
    @Test
    public void testAllPerfectSquareAndPowerTwo() {
        int[] allSamePerfect = new int[]{4, 4, 4, 4, 4};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(allSamePerfect) == 1000010);
    }

    /** Tests return of 12.
     * @version 1.0 */
    @Test
    public void testFortyTwoAndPerfectSquareAndPowerTwo() {
        int[] fortyTwoOne = new int[]{1, 4, 16, 42, 49};
        SlipperySlot test = new SlipperySlot();
        assertTrue(test.payOff(fortyTwoOne) == 12);
    }

    /** Makes 10,000 calls to SlipperySlot functions pullTheLever() and payOff().
     * Sets timeout to 42ms, so as to allow correct implementation to pass and fail incorrect ones.
     * @version 1.0 */
    @Test (timeout = 50)
    public void testTimeout() {
        // Running payoff 10000X to test timeout
        for (int i = 0; i < 10001; i++) {
            int[] random = new int[]{1, 4, 16, 42, 49};
            SlipperySlot test = new SlipperySlot();
            test.pullTheLever();
            test.payOff(random);
        }
    }
}