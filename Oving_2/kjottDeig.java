package Oving_2;

import java.util.*;

public class kjottDeig {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("A: Skriv inn pris på kjøttdeigen: ");
        float prisA = in.nextFloat();
        System.out.println("A: Skriv inn vekten på kjøttdeigen: ");
        float vektA = in.nextFloat();
        System.out.println("B: Skriv inn pris på kjøttdeigen: ");
        float prisB = in.nextFloat();
        System.out.println("B: Skriv inn vekten på kjøttdeigen: ");
        float vektB = in.nextFloat();
        float vektIKgA = (vektA/1000);
        float prisPerKgA = prisA/vektIKgA;
        float vektIKgB = (vektB/1000);
        float prisPerKgB = prisB/vektIKgB;
        if (prisPerKgA < prisPerKgB) {
            System.out.println("Kjøttdeig A er billigere enn kjøttdeig B");
        }
        else if (prisPerKgA > prisPerKgB){
            System.out.println("Kjøttdeig B er billigere enn kjøttdeig A");
        }
        else if (prisPerKgA == prisPerKgB) {
            System.out.println("Kjøttdeig A er like dyr som kjøttdeig B");
        }
        else {
            System.out.println("Det har sannsynligvis oppstått en feil");
        }
    }
}