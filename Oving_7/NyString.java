package Oving_7;

public final class NyString {
    private final String nyString;

    public NyString(String string) {
        nyString = string;
    }

    public String getNyString() {
        return nyString;
    }

    public NyString forkorting(NyString string) {
        String[] splittet = string.nyString.split(" ");
        String forkortet = "";
        for (int i = 0; i < splittet.length; i++) {
            forkortet += Character.toString(splittet[i].charAt(0));
        }
        return new NyString(forkortet);
    }

    public NyString fjerneBokstav(NyString string) {
        String output = "";
        String stringen = string.nyString;
        String lowerCase = stringen.toLowerCase();
        int counter = 0;
        for (int i = 0; i < lowerCase.length(); i++) {
            if (lowerCase.charAt(i) == 'e') {
                counter++;
            }
        }
        int[] getIndex = new int[counter];
        for (int i = 0; i < counter; i++) {
            if (i > 0) {
                if (getIndex[i-1] + 1 > 0) {

                }
                getIndex[i] = lowerCase.indexOf("e", (getIndex[i-1] + 1));
            }
            else {
                getIndex[i] = lowerCase.indexOf("e");
            }
            System.out.println(getIndex[i] + " er plasseringen til e");
        }

        for (int i = 0; i < getIndex.length; i++) {
            if (i > 0) {
                if (i == getIndex.length - 1) {
                    output += stringen.substring((getIndex[i] + 1));
                }
                else {
                    output += stringen.substring((getIndex[i] + 1), getIndex[i + 1]);
                }
            }
            else if (getIndex[i] == 0){
                if (getIndex.length == 1) {
                    output += stringen.substring(getIndex[i] + 1);
                }
                else {
                    output += stringen.substring(getIndex[i] + 1, getIndex[i + 1]);
                }
            }
            else {
                if (getIndex.length == 1) {
                    output += stringen.substring(0, getIndex[i]) + stringen.substring(getIndex[i] + 1);

                }
                else {
                    output += stringen.substring(0, getIndex[i]) + stringen.substring(getIndex[i] + 1, getIndex[i + 1]);
                }
            }
        }

        return new NyString(output);
    }

    public String toString() {
        return nyString.toString();
    }
}