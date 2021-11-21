package Oving_8;

import java.util.GregorianCalendar;

public class ArbTaker {
    GregorianCalendar kalender = new GregorianCalendar();
    private Person personalia;
    private int arbtakernr;
    private int ansettelsesaar;
    private double maanedsloenn;
    private double skatteprosent;

    public ArbTaker(Person nyPersonalia, int nyArbtakernr, int nyAnsettelsesaar, double nyMaanedsloenn, double nySkatteprosent) {
        this.personalia = nyPersonalia;
        this.arbtakernr = nyArbtakernr;
        this.ansettelsesaar = nyAnsettelsesaar;
        this.maanedsloenn = nyMaanedsloenn;
        this.skatteprosent = nySkatteprosent;
    }

    public double getMaanedsloenn() {

        return maanedsloenn;
    }

    public double getSkatteprosent() {

        return skatteprosent;
    }

    public Person getPersonalia() {

        return personalia;
    }

    public int getAnsettelsesaar() {

        return ansettelsesaar;
    }

    public void setManedslonn(double nyLonn) {
        this.maanedsloenn = nyLonn;
    }
    public void setSkatteprosent(double nySkatteprosent) {
        this.skatteprosent = nySkatteprosent;
    }

    public double getSkattPerManed() {
        double skatt = this.getMaanedsloenn() * (this.getSkatteprosent() / 100);
        return skatt;
    }
    public double getBruttoLonnAar() {
        double bruttoLonn = this.getMaanedsloenn() * 12;
        return bruttoLonn;
    }
    public double getSkattPerAar() {
        double tiManeder = this.getSkattPerManed() * 10;
        double skattetrekk = tiManeder + (this.getSkattPerManed() * 0.5);
        return skattetrekk;
    }
    public String getNavn() {
        String navn = this.getPersonalia().getsName() + ", " + this.getPersonalia().getfName();
        return navn;
    }
    public int getAlder() {
        int aarNa = kalender.get(java.util.Calendar.YEAR);
        int alder = aarNa - this.getPersonalia().getbDay();
        return alder;
    }
    public int getAarAnsatt() {
        int aarNa = kalender.get(java.util.Calendar.YEAR);
        int aarAnsatt = aarNa - this.getAnsettelsesaar();
        return aarAnsatt;
    }
    public boolean getAnsattMerEnn(int antallAar) {
        boolean merEnn = false;
        if (this.getAarAnsatt() >= antallAar) {
            merEnn = true;
        }
        return merEnn;
    }
}
