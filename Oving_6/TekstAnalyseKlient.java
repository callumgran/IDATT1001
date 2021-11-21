package Oving_6;

import java.util.*;

public class TekstAnalyseKlient {
    public static void main(String[] args) {
        char valg = '\0';
        String tekst;
        Scanner scanner = new Scanner(System.in);
        System.out.println("I dette programmet skriver du inn en tekst og får ut informasjon om tegnene.");
        System.out.println("Skriv inn en tekst her");
        tekst = scanner.nextLine();
        do {
            System.out.println("\n");
            System.out.println("Velg analysering:");
            System.out.println("\n");
            System.out.println("1. Antall forskjellige bokstaver");
            System.out.println("2. Totalt antall tegn");
            System.out.println("3. Prosent av tegn som ikke er bokstaver");
            System.out.println("4. Antall forekomster av en bestemt bokstav");
            System.out.println("5. Den bokstaven som forekommer flest ganger");
            System.out.println("6. Avslutt");
            TekstAnalyse analyse = new TekstAnalyse(tekst);
            valg = scanner.next().charAt(0);
            switch(valg) {
                case '1':
                    System.out.println("Antall forskjellige bokstaver er: " + analyse.diffChars());
                    break;
    
                case '2':
                    System.out.println("Antall forskjellige tegn er: " + analyse.totalChars());
                    break;
                
                case '3':
                    System.out.println("Prosent av tegn som ikke er bokstaver er: " + analyse.percentNotChars() + "%");
                    break;

                case '4':
                    System.out.println("Skriv inn en bokstav du ser etter:");
                    char bokstav = scanner.next().charAt(0);
                    System.out.println("Antall forekomster av bokstaven " + " er: " + analyse.totalSingularChar(bokstav));
                    break;

                case '5':
                    System.out.println("Den bokstaven som forekommer flest ganger er: " + analyse.mostOccurrencesChar());
                    break;
                    
                case '6':
                    System.out.println("--------------------------------------");
                    System.out.println("\n");
                    break;
            }
        }
        while (valg != '6');
                System.out.println("Takk for at du brukte vår tjeneste!");
                scanner.close();
    }
}
