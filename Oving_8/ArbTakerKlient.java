package Oving_8;

import java.util.*;

public class ArbTakerKlient {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Skriv inn fornavn: "); String fornavn = in.nextLine();
        System.out.print("Skriv inn etternavn: "); String etternavn = in.nextLine();
        System.out.print("Skriv inn fødselsår: "); int fodselsaar = in.nextInt();
        Person person = new Person(fornavn, etternavn, fodselsaar);
        System.out.print("Skriv inn arbeidstakernr: "); int arbtakernr = in.nextInt();
        System.out.print("Skriv inn ansettelsesår: "); int ansettelsesaar = in.nextInt();
        System.out.print("Skriv inn månedslønn: "); double manedslonn = in.nextDouble();
        System.out.print("Skriv inn skatteprosent: "); double skatteprosent = in.nextDouble();
        ArbTaker arbTaker = new ArbTaker(person, arbtakernr, ansettelsesaar, manedslonn, skatteprosent);

        skrivUtAlt(arbTaker);

        while (true) {
            visMeny(arbTaker);
        }
    }

    public static void visMeny(ArbTaker arbTaker) {
        Scanner in = new Scanner(System.in);
        System.out.println("");
        System.out.println("Tast 1 for å endre månedslønnen");
        System.out.println("Tast 2 for å endre skatteprosenten");
        System.out.println("Tast 3 for å skrive ut all data");

        int menyInput = in.nextInt();
        if (menyInput == 1) {
            System.out.print("Skriv inn ny månedslønn: "); double nyLonn = in.nextDouble();
            arbTaker.setManedslonn(nyLonn);
            System.out.println("Ny registrert månedslønn er: " + arbTaker.getMaanedsloenn());
        } else if (menyInput == 2) {
            System.out.print("Skriv inn ny skatteprosent: "); double nySkatteprosent = in.nextDouble();
            arbTaker.setSkatteprosent(nySkatteprosent);
            System.out.println("Ny registrert skatteprosent er: " +  arbTaker.getSkatteprosent());
        } else if (menyInput == 3) {
            skrivUtAlt(arbTaker);
        } else {
            System.out.println("Du må taste inn et tall fra 1-3");
        }
    }

    public static void skrivUtAlt(ArbTaker arbTaker) {
        System.out.println("");
        System.out.println("Data lagt inn:");
        System.out.println("Navn: " + arbTaker.getNavn());
        System.out.println("Alder: " + arbTaker.getAlder());
        System.out.println("Skatt per måned: " + arbTaker.getSkattPerManed());
        System.out.println("Skatt per år: " + arbTaker.getSkattPerAar());
        System.out.println("Bruttolønn per år: " + arbTaker.getBruttoLonnAar());
        System.out.println("År ansatt: " + arbTaker.getAarAnsatt());
        System.out.println("Ansatt mer enn 10 år: " + arbTaker.getAnsattMerEnn(10));
    }
}
