package BYN;

import BYN.Exception.NegativeArgumentException;
import BYN.Exception.NonpositiveArgumentException;
import BYN.Exception.OutofRangeException;
import BYN.Exception.PatternArgumentException;

public class Byn {
    private int value;

    @Override
    public String toString() {
        return "Byn{" +
                "value=" + value +
                '}';
    }

    public Byn(int value) {
        if (value < 0) {
            throw new NegativeArgumentException("byn", value);
        }
        this.value = value;
    }

    public Byn() {
    }

    public Byn(Byn byn) {
        this(byn.value);
    }

    private static int getValidValue(int rubs, int coins) {
        if (rubs < 0) {
            throw new NonpositiveArgumentException("rubs", rubs);
        } else if (coins < 0) {
            throw new NonpositiveArgumentException("coins", coins);
        } else if (coins > 100) {
            throw new OutofRangeException("coins", coins);
        }
        long maxValue = rubs * 100L + coins;
        if (maxValue > (long) Integer.MAX_VALUE) {
            throw new OutofRangeException("rubs", (int) maxValue);
        }
        return (int) maxValue;
    }

    public Byn(int rubs, int coins) {
        this(getValidValue(rubs, coins));
    }

    public static int getValidValue(String strByn) {
        if (!strByn.matches("^\\d+(?:\\.\\d{1,2})?$")) {
            throw new PatternArgumentException(strByn);
        }
        String[] rubs = strByn.split("\\.");
        return getValidValue(Integer.parseInt(rubs[0]), Integer.parseInt(rubs[1]));
    }

    public Byn(String strByn) {
        this(getValidValue(strByn));
    }

    public int getValue() {
        return value;
    }
}



