import java.lang.Math;
import java.util.Random;
import java.util.Arrays;

public class BetterSlot {

    public int[] pullTheLever() {

        int[] values = new int[5];

        for (int i = 0; i < values.length; i++) {
            values[i] = new Random().nextInt(51);
        }
        return values;
    }

    public int payOff(int[] values) {
        int payout = 0;
        int pairs = 0;
        boolean triples = false;
        boolean fours = false;

        Arrays.sort(values);

        // Rules 1 to 5
        // Rule 5
        for (int i = 1; i < values.length; i++) {
            if (values[i] == values[i - 1]) {
                pairs++;
            }
        }

        // Rule 3 and 4
        if (pairs != 0) {
            payout = 10;
            for (int i = 1; i < (values.length-1); i++) {
                if ((values[i - 1] == values[i]) && (values[i] == values[i + 1])) {
                    triples = true;
                }
            }
        }

        // Rule 2
        if (triples == true) {
            payout = 100;
            if (pairs == 2) {
                payout = 5000;
            }
            if ((values[0] == values[1]) || (values[3] == values[4])) {
                fours = true;
            }
        }

        // Rule 1
        if (fours == true) {
            payout = 10000;
            if ((values[0] == values[1]) && (values[3] == values[4])) {
                payout = 1000000;
            }
        }

        // Rules 6, 7 and 8
        // Rule 6
        boolean foundPerfectSquare = false;

        int ps = 0;

        while ((!foundPerfectSquare) && (ps != 5)) {
            double squareRoot = Math.sqrt(values[ps]);
            if ((squareRoot - Math.floor(squareRoot)) == 0) {
                foundPerfectSquare = true;
                payout += 7;
            }
            ps++;
        }

        // Rule 7
        boolean foundFortyTwo = false;
        int ft = 0;

        while ((!foundFortyTwo) && (ft != 5)) {
            if (values[ft] == 42) {
                foundFortyTwo = true;
                payout += 2;
            }
            ft++;
        }

        // Rule 8
        boolean powerOfTwo = false;
        int pt = 0;

        while ((!powerOfTwo) && (pt != 5)) {
            if (values[pt] % 2 == 0) {
                powerOfTwo = true;
                payout += 3;
            }
            pt++;
        }

        return payout;
    }

    public void main() {

    }
}