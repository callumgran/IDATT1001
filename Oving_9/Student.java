package Oving_9;

public final class Student {
    private String navn;
    private int antOppg;

    public Student(String navn, int antOppg) {
        this.navn = navn;
        this.antOppg = antOppg;
    }

    public String getNavn() {
        return navn;
    }

    public int getAntOppg() {
        return antOppg;
    }

    public void oekAntOppg(int oekning) {
        antOppg += oekning;
    }

    @Override
    public String toString() {
        return "Navn: " + navn + '\n' + "Antall Oppgaver: " + antOppg;
    }
}
