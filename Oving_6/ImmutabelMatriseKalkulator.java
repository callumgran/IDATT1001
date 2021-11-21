package Oving_6;

public final class ImmutabelMatriseKalkulator {
    private final int[][] matrise;

    public ImmutabelMatriseKalkulator(int[][] nyMatrise) {
        matrise = nyMatrise;
    }

    public int[][] getMatrise() {
        return matrise;
    }

    public ImmutabelMatriseKalkulator matriseAddering(ImmutabelMatriseKalkulator matrise1, ImmutabelMatriseKalkulator matrise2, int A, int B, int C, int D) {
        if (A != C || B != D) {
            System.out.println("Matrise 1 må være lik Matrise 2");
        }
        int[][] nyMatrise = new int[A][B];
        for(int i = 0; i < D; i++) {
            for(int j = 0; j < D; j++) {
                nyMatrise[i][j] = matrise1.matrise[i][j] + matrise2.matrise[i][j];
            }
        }
        return new ImmutabelMatriseKalkulator(nyMatrise);
    }

    public ImmutabelMatriseKalkulator matriseMultiplikasjon(ImmutabelMatriseKalkulator matrise1, ImmutabelMatriseKalkulator matrise2, int A, int B, int C, int D) {
        int[][] nyMatrise = new int[A][B];
        if (C != D) {
            System.out.println("Matrise 1 må ha like mange kolonner som matrise 2 har rader.");
        }
        else {
            for(int i = 0; i < A; i++) {
                for(int j = 0; j < B; j++) {
                    for(int k = 0; k < C; k++) {
                        nyMatrise[i][j] += matrise1.matrise[i][k] * matrise2.matrise[k][j];      
                    }
                }
            }
        }
        return new ImmutabelMatriseKalkulator(nyMatrise);
    }

    public ImmutabelMatriseKalkulator matriseTransponere(ImmutabelMatriseKalkulator matrise1, int A, int B) {
        int[][] nyMatrise = new int[B][A];
        for (int i = 0; i < A; i++) {
          for (int j = 0; j < B; j++) {
            nyMatrise[j][i] = matrise1.getMatrise()[i][j];
          }
        }
        return new ImmutabelMatriseKalkulator(nyMatrise);
    }
    
    public void matriseTilOutput(ImmutabelMatriseKalkulator svar, int A, int B) {
        System.out.println("Den nye matrisen er: ");
        System.out.println("\n");
        int[][] output = svar.getMatrise();
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
