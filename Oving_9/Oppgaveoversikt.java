package Oving_9;

import java.util.HashMap;

public class Oppgaveoversikt {
    private HashMap<String, Integer> studenter = new HashMap<String, Integer>();

    public Oppgaveoversikt(Student student) {
        this.studenter.put(student.getNavn(), student.getAntOppg());
    }

    public int antallStudenter() {
        return studenter.size();
    }

    public int oppgaverStudent(String navn) {
        return studenter.get(navn);
    }

    public void nyStudent(Student studenten) {
        studenter.put(studenten.getNavn(), studenten.getAntOppg());
    }

    public void oekOppg(Student studenten, String navn, int oekning) {
        studenten.oekAntOppg(oekning);
        studenter.put(navn, studenten.getAntOppg());
    }

    @Override
    public String toString() {
        String output = "";
        for (String i : studenter.keySet()) {
            output += i + ": " + studenter.get(i) + '\n';
        }
        return output;
    }
}