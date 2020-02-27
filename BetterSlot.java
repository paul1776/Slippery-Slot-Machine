import java.lang.Math;
import java.util.Random;
import java.util.Arrays;

public class BetterSlot {

    public int[] pullTheLever() {

        int[] values = new int[5];

        for (int i = 0; i < values.length; i++) {
            values[i] = new Random().nextInt(50);
            values[i] += 1;
        }
        return values;
    }

    public int payOff(int[] values) {
        int payout = 0;
        int pairs = 0;
        boolean triples = false;
        boolean fours = false;

        Arrays.sort(values);

        for (int i = 0; i < (values.length-1); i++) {
            if (values[i] == values[i + 1]) {
                pairs++;
            }
        }

        switch (pairs) {
            case 1:
                payout = 10;
                break;
            case 2:
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
                payout = 1000000;
                break;
        }

        // Rule 6
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

        // Rule 7
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

        // Rule 8
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

        return payout;
    }
}