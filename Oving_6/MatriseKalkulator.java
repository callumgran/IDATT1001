package Oving_6;

public final class MatriseKalkulator {
    private int[][] matrise;
    private int[][] svarMatrise;
    private int A;
    private int B;
    private int C;
    private int D;

    public MatriseKalkulator(int[][] matrise, int A, int B, int C, int D) {
        this.matrise = matrise;
        this.svarMatrise = new int[A][D];
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
    }

    public void matriseAddering(MatriseKalkulator matrise) {
        if (A != B || A != C || A != D) {
            System.out.println("Matrise 1 må ha like mange kolonner som matrise 2 har rader.");
        }
        for(int i = 0; i < D; i++) {
            for(int j = 0; j < D; j++) {
                this.matrise[i][j] += matrise.matrise[i][j];
            }
        }
    }

    public void matriseMultiplikasjon(MatriseKalkulator matrise) {
        System.out.println(A + "" + B + "" + C);
        if (C != D) {
            System.out.println("Matrise 1 må ha like mange kolonner som matrise 2 har rader.");
        }
        else {
            for(int i = 0; i < A; i++) {
                for(int j = 0; j < B; j++) {
                    for(int k = 0; k < C; k++) {
                        this.svarMatrise[i][j] += this.matrise[i][k]*matrise.matrise[k][j];      
                    }
                }
            }
        }
        this.matrise = svarMatrise;
    }

    public void matriseTransponere(MatriseKalkulator matrise) {
        int[][] svarMatrise = new int[B][A];
        for (int i = 0; i < A; i++) {
          for (int j = 0; j < B; j++) {
            svarMatrise[j][i] = matrise.matrise[i][j];
          }
        }
        this.matrise = svarMatrise;
    }

    public void matriseTilOutput() {
        System.out.println("Den nye matrisen er: ");
        System.out.println("\n");
        for (int i = 0; i < matrise.length; i++) {
            for (int j = 0; j < matrise[i].length; j++) {
                System.out.print(matrise[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}