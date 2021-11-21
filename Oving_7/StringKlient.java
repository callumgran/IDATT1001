package Oving_7;

import java.util.*;

public class StringKlient {
    public static void main(String[] args) {
        String string = "";
        Scanner scanner = new Scanner(System.in);
        string = scanner.nextLine();
        NyString nyString = new NyString(string);
        NyString forkortet = nyString.forkorting(nyString);
        NyString fjernetE = nyString.fjerneBokstav(nyString);
        System.out.println(forkortet.toString());
        System.out.println(fjernetE.toString());
        scanner.close();
    }
}
