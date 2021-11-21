package Oving_4;

import java.util.*;

public class Spiller {
    int sumPoeng;
    public Random terning = new Random();

    public Spiller(int poeng) {
        sumPoeng = poeng;
    }

    public int kastTerningen() {
        int nySum;

        int n = terning.nextInt(6);
        n += 1;
        if (n == 1) {
            nySum = 0;
        } else if (sumPoeng > 100) {
            nySum = sumPoeng - n;
        } else {
            nySum = sumPoeng + n;
        }
        return nySum;
    }

    public boolean erFerdig() {
        return sumPoeng == 100;
    }
}