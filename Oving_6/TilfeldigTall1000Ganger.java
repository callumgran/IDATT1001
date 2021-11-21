package Oving_6;

import java.util.*;

public class TilfeldigTall1000Ganger {
    
    int interval;

    public TilfeldigTall1000Ganger(int interval) {
        this.interval = interval;
    }

    public int tilfeldigHeltall() {
        java.util.Random random = new java.util.Random();
        int tall = random.nextInt(this.interval);
        return tall;
    }

    public static void main(String[] args) {
        TilfeldigTall1000Ganger nyttTall = new TilfeldigTall1000Ganger(10);
        int[] antall = new int[10000];
        int[] teller = new int[10];
        int tilfeldigTall;
        for (int i = 0; i < 10000; i++) {
            tilfeldigTall = nyttTall.tilfeldigHeltall();
            antall[i] = tilfeldigTall;
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10000; j++) {
                if (antall[j] == i) {
                    teller[i] += 1;
                }
            }
        }
        Arrays.stream(teller).forEach(System.out::println);
    }
}