package Oving_9;

public class StudentKlient {
    public static void main(String[] args) {
        Student student = new Student("Callum", 3);
        Oppgaveoversikt oversikt = new Oppgaveoversikt(student);
        System.out.println("Antall studenter: " + oversikt.antallStudenter());
        String navn = "Callum";
        System.out.println("Oppgavene til " + navn + ": " + oversikt.oppgaverStudent(navn));
        Student nyStudent = new Student("Jimmy", 69);
        System.out.println("Øker med 1 ny student Jimmy som har 69 oppg.");
        oversikt.nyStudent(nyStudent);
        System.out.println("Antall studenter: " + oversikt.antallStudenter());
        System.out.println("Øker Jimmy sine oppgaver til 420");
        oversikt.oekOppg(nyStudent, "Jimmy", 351);
        System.out.println("Alle studenter: ");
        System.out.println(oversikt);
    }
}
