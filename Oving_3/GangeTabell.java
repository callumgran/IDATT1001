package Oving_3;

import java.util.*;

public class GangeTabell {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Skriv inn to tall");
        int tall1 = in.nextInt();
        int tall2 = in.nextInt();
        int tall3;
        if (tall1 > tall2) {
            tall3 = tall2;
            tall2 = tall1;
            tall1 = tall3;
        }
        for (int i = tall1; i<=tall2; i++) {
            System.out.println(i + " gangen:");
            for(int j = 1; j<11; j++) {
                System.out.println(i + " * " + j + " = " + i*j);
            }
        }
    }
}