package Oving_5;

import java.util.*;

public class RandomTallIntervall {
    public static void main(String[] args) {
        char valg = '\0';
        Scanner in = new Scanner(System.in);
        System.out.println("I dette i programmer velger du et intervaller og skriver ut 5 tall i intervallet");
        do {
            System.out.println("Velg om du skal ha desimaler eller heltall");
            valg = in.next().charAt(0);
            switch(valg) {
                case '1':
                    System.out.println("Skriv inn start tall");
                    int helTall1 = in.nextInt();
                    System.out.println("Skriv inn slutt tall");
                    int helTall2 = in.nextInt();
                    MinRandom helTallUt = new MinRandom(helTall1, helTall2);
                    System.out.println("Her kommer tallene");
                    System.out.println(helTallUt.nesteHeltall(helTall1, helTall2));
                    System.out.println(helTallUt.nesteHeltall(helTall1, helTall2));
                    System.out.println(helTallUt.nesteHeltall(helTall1, helTall2));
                    System.out.println(helTallUt.nesteHeltall(helTall1, helTall2));
                    System.out.println(helTallUt.nesteHeltall(helTall1, helTall2));
                    break;

                case '2':
                    System.out.println("Skriv inn start tall");
                    int desTall1 = in.nextInt();
                    System.out.println("Skriv inn slutt tall");
                    int desTall2 = in.nextInt();
                    MinRandom desTallUt = new MinRandom(desTall1, desTall2);
                    System.out.println("Her kommer tallene");
                    System.out.println(desTallUt.nesteDesTall(desTall1, desTall2));
                    System.out.println(desTallUt.nesteDesTall(desTall1, desTall2));
                    System.out.println(desTallUt.nesteDesTall(desTall1, desTall2));
                    System.out.println(desTallUt.nesteDesTall(desTall1, desTall2));
                    System.out.println(desTallUt.nesteDesTall(desTall1, desTall2));
                    break;

                case '3':
                    System.out.println("--------------------------------------");
                    System.out.println("\n");
                    break;
            }
        }
        while (valg != '3');
                System.out.println("Takk for at du brukte vår tjeneste!");
    }
        
}
