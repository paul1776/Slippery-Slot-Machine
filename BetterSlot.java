import java.lang.Math;
import java.util.Random;
import java.util.Arrays;

/**
 * @author Paul-Emmanuel Courtines
 */
public class BetterSlot {
    /**
     * This is a function to create the Lever pull functionality.
     * It generates 5 integer values in [0;50].
     * @version 1.0
     * @return int[] values
     */
    public int[] pullTheLever() {

        /** Initialize integer array of size 5 */
        int[] values = new int[5];

        /** Iterate through array to fill it. Use Random utility, finding random number in [0;49]
         * and adding 1. Return values array. */
        for (int i = 0; i < values.length; i++) {
            values[i] = new Random().nextInt(50);
            values[i] += 1;
        }
        return values;
    }

    /**
     * This is a function to generate the slot machine's payoff.
     * It calculates and returns an integer, payout, from a given set of five integers in [0;50].
        * @param values an integer array of size 5 with values in [0;50].
        * @version 1.0
        * @return int payout
     */
    public int payOff(int[] values) {
        /** Create integer payout and sort array using Arrays util */
        int payout = 0;
        Arrays.sort(values);

        /** Initialize pairs (to track # of adjacent equal values) to 0.
         * Iterate through array, finding number of pairs. */
        int pairs = 0;
        for (int i = 0; i < (values.length-1); i++) {
            if (values[i] == values[i + 1]) {
                pairs++;
            }
        }

        /** Based of number of pairs, use switch case to allocate payout. */
        switch (pairs) {
            case 0:
                /** No pairs found. Exit. */
                break;
            case 1:
                /** Only one pair found. Update payout to 10 and exit. */
                payout = 10;
                break;
            case 2:
                /** Two pairs found. Could be a triple or two pairs. Test if there are 3 equal
                 * values in a row. If there are, update payout to 100. Else, update it to 10, and exit. */
                boolean tripleFound = false;
                int i = 0;
                while ((!tripleFound) & (i < values.length-2)) {
                    if ((values[i] == values[i+1]) && (values[i+1] == values[i+2])) {
                        tripleFound = true;
                        payout = 100;
                    }
                    i++;
                }
                if (!tripleFound) {
                    payout = 10;
                }
                break;
            case 3:
                /** Three pairs found. Could be a full house or four-in-a-row. Test if there are 4 equal
                 * values in a row. If there are, update payout to 10000.
                 * Else, update it to 5000, and exit. */
                boolean fourFound = false;
                int a = 0;
                while ((!fourFound) && (a < values.length-3)) {
                    if (values[a] == values[a+1] && (values[a+1] == values[a+2] && values[a+2] == values[a+3])) {
                        fourFound = true;
                        payout = 10000;
                    }
                    a++;
                }
                if (!fourFound) {
                    payout = 5000;
                }
                break;
            case 4:
                /** Four pairs found. 5-in-a-row! Set payout to 1000000 and exit. */
                payout = 1000000;
                break;
        }

        /** Testing rule 6. Iterate through array and test if any values are perfect square.
         * If they are, add 7 to payout. */
        boolean foundPerfectSquare = false;
        int ps = 0;
        while ((!foundPerfectSquare) && (ps < values.length)) {
            double squareRoot = Math.sqrt(values[ps]);
            if ((squareRoot - Math.floor(squareRoot)) == 0) {
                foundPerfectSquare = true;
            }
            ps++;
        }
        if (foundPerfectSquare) {
            payout += 7;
        }

        /** Testing rule 7. Iterate through array and test if any values are 42.
         * If they are, add 2 to payout. */
        boolean foundFortyTwo = false;
        int ft = 0;
        while ((!foundFortyTwo) && (ft < values.length)) {
            if (values[ft] == 42) {
                foundFortyTwo = true;
            }
            ft++;
        }
        if (foundFortyTwo) {
            payout += 2;
        }

        /** Testing rule 8. Iterate through array and test if any values are power of two.
         * If they are, add 3 to payout. */
        boolean foundPowerTwo = false;
        int pt = 0;
        while ((!foundPowerTwo) && (pt < values.length)) {
            if ((values[pt] & values[pt] - 1)==0) {
                foundPowerTwo = true;
            }
            pt++;
        }
        if (foundPowerTwo) {
            payout += 3;
        }

        /** Return payout */
        return payout;
    }
}