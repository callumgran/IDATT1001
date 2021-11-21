package Oving_6;

import java.util.*;

public class ImmutableKlient {
    public static void main(String[] args) {
        char valg = '\0';
        int A1;
        int B1;
        int A2;
        int B2;
        Scanner scanner = new Scanner(System.in);
        ImmutabelMatriseKalkulator matrise1;
        ImmutabelMatriseKalkulator matrise2;
        do {
            System.out.println("I dette programmet skal du regne med matriser");
            System.out.println("Lag en A verdi");
            A1 = scanner.nextInt();
            System.out.println("Lag en B verdi");
            B1 = scanner.nextInt();
            System.out.println("Lag AxB matrise 1");
            int[][] matrise1Tall = new int[A1][B1];
            for(int i = 0; i < A1; i++) {
                System.out.println("Ny rad");
                for(int j = 0; j < B1; j++) {
                    matrise1Tall[i][j] += scanner.nextInt();
                }
            }
            System.out.println("Lag en A verdi");
            A2 = scanner.nextInt();
            System.out.println("Lag en B verdi");
            B2 = scanner.nextInt();
            System.out.println("Lag AxB matrise 2");
            int[][] matrise2Tall = new int[A2][B2];
            for(int i = 0; i < A2; i++) {
                System.out.println("Ny rad");
                for(int j = 0; j < B2; j++) {
                   matrise2Tall[i][j] += scanner.nextInt();
                }
            }
            System.out.println("\n");
            System.out.println("Velg utregning:");
            System.out.println("\n");
            System.out.println("1. Addere");
            System.out.println("2. Multiplikasjon");
            System.out.println("3. Invers av den første matrisen");
            System.out.println("4. Avslutt");
            matrise1 = new ImmutabelMatriseKalkulator(matrise1Tall);
            matrise2 = new ImmutabelMatriseKalkulator(matrise2Tall);
            valg = scanner.next().charAt(0);
            
            switch(valg) {
                case '1':
                    ImmutabelMatriseKalkulator svarAddere = matrise1.matriseAddering(matrise1, matrise2, A1, B2, A2, B1);
                    svarAddere.matriseTilOutput(svarAddere, A1, B2);
                    break;
    
                case '2':
                    ImmutabelMatriseKalkulator svarMultiplikasjon = matrise1.matriseMultiplikasjon(matrise1, matrise2, A1, B2, A2, B1);
                    svarMultiplikasjon.matriseTilOutput(svarMultiplikasjon, A1, B2);
                    break;

                case '3':
                    ImmutabelMatriseKalkulator svarTransponere = matrise1.matriseTransponere(matrise1, A1, B1);
                    svarTransponere.matriseTilOutput(svarTransponere, B1, A1);
                    break;
                
                case '4':
                    System.out.println("--------------------------------------");
                    System.out.println("\n");
                    break;
            }
        }
        while (valg != '4');
                System.out.println("Takk for at du brukte vår tjeneste!");
                scanner.close();
    }
}

