import java.util.Scanner;

public class PropertyKlient {
    private final int ADD_PROPERTY = 1;
    private final int LIST_ALL_PROPERTIES = 2;
    private final int FIND_PROPERTY = 3;
    private final int FIND_PROPERTY_LOT_NR = 4;
    private final int CALCULATE_AVERAGE_AREA = 5;
    private final int EXIT = 9;
    public PropertyRegister propertyRegister = new PropertyRegister();

    public static void main(String[] args) {
        PropertyKlient o = new PropertyKlient();
        o.testData();
        o.start();
    }

    public void testData() {
        propertyRegister.propReg(1445, "Gloppen", 77, 631, "", 1017.6f, "Jens Olsen");
        propertyRegister.propReg(1445, "Gloppen", 77, 131, "Syningom", 661.3f, "Nicolay Madsen");
        propertyRegister.propReg(1445, "Gloppen", 75, 19, "Fugletun", 650.6f, "Evilyn Jensen");
        propertyRegister.propReg(1445, "Gloppen", 74, 188, "", 1457.2f, "Karl Ove Bråten");
        propertyRegister.propReg(1445, "Gloppen", 69, 47, "Høiberg", 1339.4f, "Elsa Indregård");
    }

    private int showMenu() {
        int menuChoice = 0;
        System.out.println("\n***** Property Register Application v0.1 *****\n");
        System.out.println("1. Add property");
        System.out.println("2. List all properties");
        System.out.println("3. Search property");
        System.out.println("4. Search property by lot number");
        System.out.println("5. Calculate average area");
        System.out.println("9. Quit");
        System.out.println("\nPlease enter a number between 1 and 9.\n");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            menuChoice = sc.nextInt();
        } else {
            System.out.println("You must enter a number, not text");
        }
        return menuChoice;
    }

    public void start() {
        boolean finished = false;
        Scanner scanner = new Scanner(System.in);
        while (!finished) {
            int menuChoice = showMenu();
            switch (menuChoice) {
                case ADD_PROPERTY:
                    System.out.println("Kommunenummer: ");
                    int kommuneNr = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Kommune Navn: ");
                    String kommuneNavn = scanner.nextLine();
                    System.out.println("Gårdsnummer: ");
                    int gnr = scanner.nextInt();
                    System.out.println("Bruksnummer: ");
                    int bnr = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Bruksnavn: ");
                    String bruksNavn = scanner.nextLine();
                    System.out.println("Areal: ");
                    float areal = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.println("Eiernavn: ");
                    String eierNavn = scanner.nextLine();
                    propertyRegister.propReg(kommuneNr, kommuneNavn, gnr, bnr, bruksNavn, areal, eierNavn);
                    break;

                case LIST_ALL_PROPERTIES:
                    System.out.println("Alle registrerte eiendommer: " + '\n' + propertyRegister);
                    break;

                case FIND_PROPERTY:
                    System.out.println("Skriv inn kommunenummeret til eiendommen: ");
                    int sokKommuneNr = scanner.nextInt();
                    System.out.println("Skriv inn gårdsnummer til eiendommen: ");
                    int sokGnr = scanner.nextInt();
                    System.out.println("Skriv inn bruksnummer til eiendommen: ");
                    int sokBnr = scanner.nextInt();
                    System.out.println(propertyRegister.sokProp(sokKommuneNr, sokGnr, sokBnr));
                    break;
                case FIND_PROPERTY_LOT_NR:
                    System.out.println("Skriv inn gårdsnummer til eiendommen: ");
                    int sokByGnr = scanner.nextInt();
                    System.out.println("Alle registrerte eiendommer med " + sokByGnr + " som gårdsnummer: " + '\n' +propertyRegister.sokPropsByGnr(sokByGnr));
                    break;
                case CALCULATE_AVERAGE_AREA:
                    System.out.println("Gjennomsnittsarealet er :" + '\n' + propertyRegister.avgAreal());
                    break;
                case EXIT:
                    System.out.println("Thank you for using the Properties app!\n");
                    finished = true;
            }
        }
    }
}