package Oving_5;

public class MinRandom {
    int nedre;
    int ovre;
    
    public MinRandom(int nedre, int ovre) {
        this.nedre = nedre;
        this.ovre = ovre;
    }

    public int nesteHeltall(int nedre, int ovre) {
        java.util.Random random = new java.util.Random();
        int resultat = random.nextInt(ovre - nedre) + nedre;
        return resultat;
    }

    public double nesteDesTall(double nedre, double ovre) {
        java.util.Random random = new java.util.Random();
        double resultat = (random.nextDouble() * ((ovre - nedre) + nedre));
        return resultat;
    }
}
