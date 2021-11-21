package Oving_6;

public class TekstAnalyse {
    String tekst;
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzæøå";
    int [] antallTegn = new int[30];

    public TekstAnalyse(String tekst) {
        this.tekst = tekst.toLowerCase();
        findChars(this.tekst);
    }

    public void findChars(String tekst) {
        for (int i = 0; i < tekst.length(); i++) {
            char c = this.tekst.charAt(i);
            if (ALPHABET.indexOf(c) == -1) {
                antallTegn[29]++;
            }
            else {
                antallTegn[ALPHABET.indexOf(c)]++;
            }
        }
    }
    
    public int diffChars() {
        int diffChars = 0;
        for (int i = 0; i < ALPHABET.length(); i++) {
            if(antallTegn[i] > 0) {
                diffChars++;
            }
        }
        return diffChars;
    }

    public int totalChars() {
        int totalChars = 0;
        for (int i = 0; i < ALPHABET.length(); i++) {
            totalChars += antallTegn[i];
        }
        return totalChars;
    }

    public float percentNotChars(){
        float totalChars = 0;
        for (int i = 0; i < ALPHABET.length() + 1; i++) {
            totalChars += antallTegn[i];
        }
        float notChars = (antallTegn[29]/totalChars) * 100;
        return notChars;
    }

    public int totalSingularChar(char bokstav){
        return antallTegn[ALPHABET.indexOf(bokstav)];
    }

    public String mostOccurrencesChar(){
        int max = 0;
        String mostOccurredChar = "";
        for (int i = 0; i < ALPHABET.length(); i++) {
            if (antallTegn[i] == max) {
                mostOccurredChar += " og " + ALPHABET.charAt(i);
            }
            if (antallTegn[i] > max) {
                max = antallTegn[i];
                mostOccurredChar = ALPHABET.charAt(i) + "";
            }
        }
        return mostOccurredChar + " med " + max + " forekomster";
    }
    
}