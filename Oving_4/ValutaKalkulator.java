package Oving_4;

import java.util.*;

public class ValutaKalkulator {
    public static void main(String[] args) {
        char valg = '\0';
        int fraEllerTil = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Din valuta er Norske Kroner");
        System.out.println("\n");
        System.out.println("1. Nok til Dollar");
        System.out.println("2. Nok til Euro");
        System.out.println("3. Nok til Sek");
        System.out.println("4. Exit");

        do {
            System.out.println("=============================================================");
            System.out.println("Velg en oppgave");
            System.out.println("=============================================================");
            valg = scanner.next().charAt(0);
            System.out.println("\n");
            float pengeSum;
            float pengerEtterOmgjoering;
            Valuta USD = new Valuta(8.66f, "USD");
            Valuta EURO = new Valuta(10.28f, "EURO");
            Valuta SEK = new Valuta(0.99f, "SEK");

            switch(valg){
                case '1': 
                    System.out.println("Tast 1 for Dollar til Nok");
                    System.out.println("Tast 2 for Nok til Dollar");
                    fraEllerTil = scanner.nextInt();
                    System.out.println("--------------------------------------");
                    System.out.println("Amerikanske Dollar");
                    System.out.println("--------------------------------------");
                    pengeSum = scanner.nextFloat();
                    if (fraEllerTil == 1) {
                        USD.pengerTilNok(pengeSum);
                        pengerEtterOmgjoering = USD.hentSum();
                        System.out.println(pengeSum + " usd = " + pengerEtterOmgjoering  + " nok");

                    }
                    else if (fraEllerTil == 2) {
                        USD.pengerFraNok(pengeSum);
                        pengerEtterOmgjoering = USD.hentSum();
                        System.out.println(pengeSum + " nok = " + pengerEtterOmgjoering  + " usd");
                    }
                    System.out.println("\n");
                    break;
                
                case '2': 
                    System.out.println("Tast 1 for EURO til Nok");
                    System.out.println("Tast 2 for Nok til EURO");
                    fraEllerTil = scanner.nextInt();
                    System.out.println("--------------------------------------");
                    System.out.println("EURO");
                    System.out.println("--------------------------------------");
                    pengeSum = scanner.nextFloat();
                    if (fraEllerTil == 1) {
                        EURO.pengerTilNok(pengeSum);
                        pengerEtterOmgjoering = EURO.hentSum();
                        System.out.println(pengeSum + " euro = " + pengerEtterOmgjoering  + " nok");

                    }
                    else if (fraEllerTil == 2) {
                        EURO.pengerFraNok(pengeSum);
                        pengerEtterOmgjoering = EURO.hentSum();
                        System.out.println(pengeSum + " nok = " + pengerEtterOmgjoering  + " euro");
                    }
                    else {
                        System.out.println("Ugyldig valg, prøv igjen.");
                    }
                    System.out.println("\n");
                    break;

                case '3': 
                    System.out.println("Tast 1 for SEK til Nok");
                    System.out.println("Tast 2 for Nok til SEK");
                    fraEllerTil = scanner.nextInt();
                    System.out.println("--------------------------------------");
                    System.out.println("Svenske Kroner");
                    System.out.println("--------------------------------------");
                    pengeSum = scanner.nextFloat();
                    if (fraEllerTil == 1) {
                        SEK.pengerTilNok(pengeSum);
                        pengerEtterOmgjoering = SEK.hentSum();
                        System.out.println(pengeSum + " sek = " + pengerEtterOmgjoering  + " nok");

                    }
                    else if (fraEllerTil == 2) {
                        SEK.pengerFraNok(pengeSum);
                        pengerEtterOmgjoering = SEK.hentSum();
                        System.out.println(pengeSum + " nok = " + pengerEtterOmgjoering  + " sek");
                    }
                    System.out.println("\n");
                    break;

                case '4': 
                    System.out.println("--------------------------------------");
                    System.out.println("\n");
                    break;

                default:
                    System.out.println("Ugyldig valg! Vennligst prøv igjen igjen.");
                    break;
            }
        }
        while(valg != '4');
            System.out.println("Takk for at du brukte vår tjeneste!");
    }
}