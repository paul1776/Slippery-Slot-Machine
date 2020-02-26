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
        System.out.println("The length of values is: ");
        System.out.println(values.length);


        // Rules 1 to 5
        // Rule 5
        for (int i = 0; i < (values.length-1); i++) {
            if (values[i] == values[i + 1]) {
                pairs++;
            }
        }

        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]);
            System.out.print(" ");
        }

        System.out.print("\n");

        System.out.println("Number of pairs");
        System.out.println(pairs);

        // Rule 3 and 4
        if (pairs > 0) {
            System.out.println("Pairs greater than 0");
            payout = 10;
            for (int i = 0; i < (values.length-2); i++) {
                if ((values[i] == values[i+1]) && (values[i+1] == values[i+2])) {
                    System.out.println("We found a triple");
                    triples = true;
                }
            }
        }

        // Rule 2
        if (triples == true) {
            payout = 100;
            if (pairs > 2) {
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

        System.out.println(payout);

        return payout;
    }

    public static void main(String[] args) {

        BetterSlot better = new BetterSlot();

        System.out.println("Pulling the lever now");
        int[] test = new int[]{1, 2, 2, 2, 4};

        System.out.println("Feeding values through payoff");
        better.payOff(test);
    }
}