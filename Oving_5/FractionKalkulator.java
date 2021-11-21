package Oving_5;

import java.util.*;

public class FractionKalkulator {
    public static void main(String[] args) {
        char valg = '\0';
        Scanner in = new Scanner(System.in);
        System.out.println("Lag 2 brøker og kalkuler med de");
        System.out.println("\n");
        System.out.println("1. Addere");
        System.out.println("2. Minus");
        System.out.println("3. Gange");
        System.out.println("4. Dele");
        System.out.println("5. Exit");
        
        do {
            System.out.println("=============================================================");
            System.out.println("Velg en oppgave");
            System.out.println("=============================================================");
            valg = in.next().charAt(0);
            int fractionOneTall1;
            int fractionOneTall2;
            int fractionTwoTall1;
            int fractionTwoTall2;
            System.out.println("\n");
            Fractions fractionOne;
            Fractions fractionTwo;

            switch(valg){
                case '1':
                    System.out.println("Lag brøk 1");
                    System.out.println("Teller1");
                    fractionOneTall1 = in.nextInt();
                    System.out.println("Nevner1");
                    fractionOneTall2 = in.nextInt();
                    System.out.println("Lag brøk 2");
                    System.out.println("Teller2");
                    fractionTwoTall1 = in.nextInt();
                    System.out.println("Nevner2");
                    fractionTwoTall2 = in.nextInt();
                    try {
                        fractionOne = new Fractions(fractionOneTall1, fractionOneTall2);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                        fractionOne = new Fractions(fractionOneTall1);
                    }
                    try {
                        fractionTwo = new Fractions(fractionTwoTall1, fractionTwoTall2);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                        fractionTwo = new Fractions(fractionOneTall1);
                    }
                    fractionOne.addere(fractionTwo);
                    System.out.println(fractionOne);
                    break;
                
                case '2':
                    System.out.println("Lag brøk 1");
                    System.out.println("Teller");
                    fractionOneTall1 = in.nextInt();
                    System.out.println("Nevner");
                    fractionOneTall2 = in.nextInt();
                    System.out.println("Lag brøk 2");
                    System.out.println("Teller");
                    fractionTwoTall1 = in.nextInt();
                    System.out.println("Nevner");
                    fractionTwoTall2 = in.nextInt();
                    try {
                        fractionOne = new Fractions(fractionOneTall1, fractionOneTall2);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                        fractionOne = new Fractions(fractionOneTall1);
                    }
                    try {
                        fractionTwo = new Fractions(fractionTwoTall1, fractionTwoTall2);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                        fractionTwo = new Fractions(fractionOneTall1);
                    }
                    fractionOne.subtrahere(fractionTwo);
                    System.out.println(fractionOne);
                    break;
                
                case '3':
                    System.out.println("Lag brøk 1");
                    System.out.println("Teller");
                    fractionOneTall1 = in.nextInt();
                    System.out.println("Nevner");
                    fractionOneTall2 = in.nextInt();
                    System.out.println("Lag brøk 2");
                    System.out.println("Teller");
                    fractionTwoTall1 = in.nextInt();
                    System.out.println("Nevner");
                    fractionTwoTall2 = in.nextInt();
                    try {
                        fractionOne = new Fractions(fractionOneTall1, fractionOneTall2);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                        fractionOne = new Fractions(fractionOneTall1);
                    }
                    try {
                        fractionTwo = new Fractions(fractionTwoTall1, fractionTwoTall2);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                        fractionTwo = new Fractions(fractionOneTall1);
                    }
                    fractionOne.multiplisere(fractionTwo);
                    System.out.println(fractionOne);
                    break;
                
                case '4':
                    System.out.println("Lag brøk 1");
                    System.out.println("Teller");
                    fractionOneTall1 = in.nextInt();
                    System.out.println("Nevner");
                    fractionOneTall2 = in.nextInt();
                    System.out.println("Lag brøk 2");
                    System.out.println("Teller");
                    fractionTwoTall1 = in.nextInt();
                    System.out.println("Nevner");
                    fractionTwoTall2 = in.nextInt();
                    try {
                        fractionOne = new Fractions(fractionOneTall1, fractionOneTall2);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                        fractionOne = new Fractions(fractionOneTall1);
                    }
                    try {
                        fractionTwo = new Fractions(fractionTwoTall1, fractionTwoTall2);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                        fractionTwo = new Fractions(fractionOneTall1);
                    }
                    fractionOne.dividere(fractionTwo);
                    System.out.println(fractionOne);
                    break;

                case '5': 
                    System.out.println("--------------------------------------");
                    System.out.println("\n");
                    break;

                default:
                    System.out.println("Ugyldig valg! Vennligst prøv igjen igjen.");
                    break;
            }
        }
        while(valg != '5');
            System.out.println("Takk for at du brukte vår tjeneste!");
    }
}