package Oving_2;

import java.util.Scanner;

public class skuddAar {
     
    public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            System.out.println("Skriv inn årstall: ");
    		int aarsTall = in.nextInt(); 
            if (aarsTall % 400 == 0) {
                System.out.println(aarsTall + " var et skuddår!");
            }
            else if (aarsTall % 4 == 0  && aarsTall % 100 != 0) {
                System.out.println(aarsTall + " var et skuddår!");
            }
            else {
                System.out.println(aarsTall + " var ikke et skuddår!");
            }
    }
}    