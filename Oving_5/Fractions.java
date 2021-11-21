package Oving_5;

public class Fractions {
    private int teller, nevner;

    public Fractions(int teller, int nevner) {
      if (nevner == 0) {
        throw new IllegalArgumentException("Nevneren kan ikke være lik 0");
      } else {
        this.teller = teller;
        this.nevner = nevner;
      }
    }

    public Fractions(int teller) {
      this.teller = teller;
      this.nevner = 1;
    }

    public void addere(Fractions fractionTwo) {
      this.teller = (this.teller * fractionTwo.nevner) + (fractionTwo.teller * this.nevner);
      this.nevner = (this.nevner * fractionTwo.nevner);
    }

    public void subtrahere(Fractions fractionTwo) {
      this.teller = (this.teller * fractionTwo.nevner) - (fractionTwo.teller * this.nevner);
      this.nevner = (this.nevner * fractionTwo.nevner);
    }

    public void multiplisere(Fractions fractionTwo) {
      this.teller = (this.teller * fractionTwo.teller);
      this.nevner = (this.nevner * fractionTwo.nevner);
    }

    public void dividere(Fractions fractionTwo) {
      this.teller = (this.teller * fractionTwo.nevner);
      this.nevner = (this.nevner * fractionTwo.teller);
    }

    public int getTeller() {
        return this.teller;
    }
  
    public int getNevner() {
      return this.nevner;
    }

    public String toString() {
      return this.getTeller() + "/" + this.getNevner();
    }
}