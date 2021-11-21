package Oving_3;

import java.util.*;

public class PrimTallSjekker {
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Skriv inn et tall");
        int tallIn = in.nextInt();
        int teller = 0;
        for (int i = 2; i<tallIn; i++) {
            if (tallIn % i == 0) {
                teller++;
            } 
        }
        if (teller > 0 || tallIn == 1) {
            System.out.println("Tallet " + tallIn + " er ikke et primtall");
        }
        else {
            System.out.println("Tallet " + tallIn + " er et primtall");
        }
    }
}