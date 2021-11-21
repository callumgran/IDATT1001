package Oving_1;

import java.util.*;

class sekunderTilTid {     
    public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            System.out.print("Skriv inn sekunder: ");
    		int sekunderIn = in.nextInt(); 
            int sekunderUt = sekunderIn % 60;
            int timer = sekunderIn / 60;
            int minutter = timer % 60;
            timer = timer / 60;
            in.close();
            System.out.print( timer + ":" + minutter + ":" + sekunderUt);
    }    
}