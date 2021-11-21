package Oving_7;

public class StringOperations {
    String string = "";
    int counter;
    public final String ALPHABET = "abcdefghijklmnopqrstuvwxyzæøå";
    public final String SKILLETEGN = "[.!:?]+";

    public StringOperations(String string) {
        string = this.string;
    }

    public int finnOrd(String string) {
        System.out.println(string);
        String[] ord = string.split(" ");
        return ord.length;
    }

    public float gjennomSnittlig(String string) {
        String lowercase = string.toLowerCase();
        String[] splitString = lowercase.split(" ");
        counter = 0;
        for (int i = 0; i < lowercase.length(); i++) {
            char c = lowercase.charAt(i);
            if (ALPHABET.indexOf(c) != -1) {
                counter++;
            }
        }
        return ((float) counter/splitString.length);
    }

    public float finnOrdPeriode(String string) {
        String[] periode = string.split(SKILLETEGN);
        String[] ord = string.split(" ");
        int totalOrd = ord.length;
        return ((float)totalOrd/periode.length);   
    }

    public String byttOrd(String string, String ord1, String ord2) {
        String nyString = string.replaceAll(ord1, ord2);
        return nyString;
    }

    public String orginalSetning(String string) {
        return string;
    }

    public String storSkrift(String string) {
        string = string.toUpperCase();
        return string;
    }
}


