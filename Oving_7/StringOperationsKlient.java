package Oving_7;

import java.util.*;

public class StringOperationsKlient {
    public static void main(String[] args) {
        String string;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv inn en tekst streng: ");
        string = scanner.nextLine();
        System.out.println("Skriv inn 2 ord du vil bytte med hverandre i teksten.");
        String ord1 = scanner.nextLine();
        String ord2 = scanner.nextLine();
        scanner.close();
        StringOperations strengen = new StringOperations(string);
        System.out.print("Totalt antall ord: ");
        System.out.println(strengen.finnOrd(string));
        System.out.print("Gjennomsnittlig bokstaver i ord: ");
        System.out.println(strengen.gjennomSnittlig(string));
        System.out.print("Gjennomsnittlig ord periode: ");
        System.out.println(strengen.finnOrdPeriode(string));
        System.out.print("Teksten med ord byttet: ");
        System.out.println(strengen.byttOrd(string, ord1, ord2));
        System.out.print("Orginal teksten: ");
        System.out.println(strengen.orginalSetning(string));
        System.out.print("Teksten i stor skrift: ");
        System.out.println(strengen.storSkrift(string));
    }
}