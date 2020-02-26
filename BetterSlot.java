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

        for (int i = 1; i < values.length; i++) {
            if (values[i] == values[i - 1]) {
                pairs++;
            }
        }

        if (pairs != 0) {
            payout = 10;
            for (int i = 1; i < (values.length-1); i++) {
                if ((values[i - 1] == values[i]) && (values[i] == values[i + 1])) {
                    triples = true;
                }
            }
        }

        if (triples == true) {
            payout = 100;
            if (pairs == 2) {
                payout = 5000;
            }
            if ((values[0] == values[1]) || (values[3] == values[4])) {
                fours = true;
            }
        }

        if (fours == true) {
            payout = 10000;
            if ((values[0] == values[1]) && (values[3] == values[4])) {
                payout = 1000000;
            }
        }

        return payout;
    }
}