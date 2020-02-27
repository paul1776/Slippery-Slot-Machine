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
    public void testFortyTwo() {

    }

    @Test
    public void allSame() {
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
            assertTrue(test.payOff(testValues) > 1000000);
        }
    }

    @Test
    public void thatTest() {
        // Second test
        System.out.println("that");
    }

    void main() {
        System.out.println("Welcome to my Test file");
    }
}