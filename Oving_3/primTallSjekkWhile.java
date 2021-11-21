package Oving_3;

import java.util.*;

public class primTallSjekkWhile{
    public static void main(String[] args) {
        char valg = '\0';
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("=============================================================");
            System.out.println("Tast 1 for å sjekke om et tall er primtall");
            System.out.println("Tast E for å avslutte programmet");
            System.out.println("=============================================================");
            valg = in.next().charAt(0);
            System.out.println("\n");
            switch(valg) {
                case '1':
                    int teller = 0;
                    System.out.println("Skriv inn et tall");
                    int tallIn = in.nextInt();
                    System.out.println("Programmet sjekker etter primtall");
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
                    break;

                case 'E':
                    System.out.println("-------------------------------------------------------------");
                    break;
            }
        }while (valg != 'E');
            System.out.println("Programmet er avsluttet");
    }
}