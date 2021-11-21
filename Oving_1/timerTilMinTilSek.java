package Oving_1;

class gjoerOmTilMinTilSek {   
        static double omgjoeringTilSek(double minutter, double timer, double sekunder)   {   
        double sekunder2;
        sekunder2  = 60 * minutter + 3600 * timer + sekunder;    
        System.out.printf("Verdien i sekunder er: " + sekunder2 + " \r\n"); 
        return sekunder2;   
    }    
    public static void main(String args []){   
        int timer = 20;
        int minutter = 40;
        int sekunder1 = 34;   
        omgjoeringTilSek(timer, minutter, sekunder1);   
    }   
}  