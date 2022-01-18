import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Double.isNaN;

//Even though I am in Trondheim, I still use this UI as it was accepted.
/**
 * Represents the text based user interface of the application.
 * This class makes use of the Scanner-class to get input from the
 * user via the standard console.
 *
 * To be used by the students in Ålesund and Gjøvik (IDATA1001/IDATG1001)
 *
 * @author 10071
 * @version 1.0
 */
public class LongJumpUI {
    private LongJumpResultRegister jumpRegister;
    private static final String VERSION = "v1.0-SNAPSHOT";

    String[] menuItems
            = {
                "1. Register a long jump result",
                "2. List all results",
                "3. Show all results by a given athlete",
                "4. Show the best result",
                "5. Calculate the avarage result"
            };

    // Constants defining the different menu options, to be used in the
    // switch-case.
    private static final int ADD_RESULT = 1;
    private static final int LIST_ALL_RESULTS = 2;
    private static final int SHOW_RESULT_BY_ATHLETE = 3;
    private static final int SHOW_BEST_RESULT = 4;
    private static final int CALCULATE_AVERAGE_RESULT = 5;
    private static final int EXIT = 6;

    /**
     * Creates an instance of the LongJumpUI User interface.
     */
    public LongJumpUI() {
        jumpRegister = new LongJumpResultRegister();
    }

    /**
     * Creates test data for the client
     */
    private void testData() {
        jumpRegister.addNewLongJump(101, "Navn Navnesen", 7.3f, true, LocalTime.now());
        jumpRegister.addNewLongJump(102, "Tore Toresen", 6.5f, true, LocalTime.now());
        jumpRegister.addNewLongJump(103, "Ola Nordmann", 8.2f, true, LocalTime.now());
        jumpRegister.addNewLongJump(104, "Johnny Johnson", 5.8f, true, LocalTime.now());
        jumpRegister.addNewLongJump(105, "Jonas Jones", 4.7f, true, LocalTime.now());
        jumpRegister.addNewLongJump(106, "Tim Tom", 5.4f, true, LocalTime.now());
    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user. Continues until the user decides to exit the application.
     */
    void start() {

        boolean quit = false;

        while (!quit) {
            int menuSelection = this.getMenuChoice();
            switch (menuSelection) {
                case ADD_RESULT:
                    registerNewLongJump();
                    break;

                case LIST_ALL_RESULTS:
                    listAllResults();
                    break;

                case SHOW_RESULT_BY_ATHLETE:
                    showResultsFromJumper();
                    break;

                case SHOW_BEST_RESULT:
                    showBestResult();
                    break;

                case CALCULATE_AVERAGE_RESULT:
                    showAverageResult();
                    break;

                case EXIT:
                    System.out.println("\nThank you for using the Long Jump Application "
                            + VERSION + ". Bye!\n");
                    quit = true;
                    break;

                default:
                    System.out.println(
                            "\nERROR: Please provide a number between 1 and " + this.menuItems.length + "..\n");
            }
        }
    }

    /**
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items..
     * The method returns the input from the user. If the input from the user is
     * invalid, 0 is returned.
     *
     * @return the menu number (between 1 and max menu item number) provided by
     * the user.
     */
    private int getMenuChoice() {
        int menuSelection = 0;

        System.out.println("\n**** Long Jump Results Tool " + VERSION + " ****\n");
        for (String menuItem : menuItems) {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = menuItems.length + 1;
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): ");

        Scanner reader = new Scanner(System.in);
        if (reader.hasNextInt()) {
            menuSelection = reader.nextInt();
        } else {
            System.out.println("You must enter a number, not text");
        }
        return menuSelection;
    }

    /**
     * The main start method of the application.
     *
     * @param args Commandline arguments as an array of String
     */
    public static void main(String[] args) {
        LongJumpUI longJumpUI = new LongJumpUI();
        longJumpUI.testData();
        longJumpUI.start();
    }

    //For better cohesion, I have decided to make a separate method for creating the time
    //I also decided to use LocalTime.now and LocalTime.of as I believe this gives the user less of an opportunity to give wrong inputs compared to LocalTime.parse.
    //LocalTime.of vs LocalTime.parse also allows me to not use seconds in the input of time, something I see as unnecessary data in this case.
    private LocalTime timeCreator() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Did the jump occur right now: Y");
        System.out.println("If not enter: Any other character");
        char ans = sc.next().toUpperCase().charAt(0);
        if (ans == 'Y') return LocalTime.now();
        else {
            System.out.println("Enter the hour as a number between 0 and 23");
            int hour;
            if (sc.hasNextInt()) {
                hour = sc.nextInt();
            } else {
                System.out.println("You must enter a number, not text");
                System.out.println("The time has been set to the current time");
                return LocalTime.now();
            }
            System.out.println("Enter the minute as a number between 0 and 59");
            int minute;
            if (sc.hasNextInt()) {
                minute = sc.nextInt();
            } else {
                System.out.println("You must enter a number, not text");
                System.out.println("The time has been set to the current time");
                return LocalTime.now();
            }
            return LocalTime.of(hour, minute);
        }
    }

    private void registerNewLongJump() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the start number of the jumper");
        int startNumber;
        if (sc.hasNextInt()) {
            startNumber = sc.nextInt();
        } else {
            System.out.println("You must enter a number, not text");
            return;
        }
        sc.nextLine();
        System.out.println("Enter the name of the jumper");
        String jumperName = sc.nextLine();
        System.out.println("Enter the length of the jump");
        float result;
        if (sc.hasNextFloat()) {
            result = sc.nextFloat();
        } else {
            System.out.println("You must enter a number, not text");
            return;
        }
        sc.nextLine();
        System.out.println("Was the jump legal? [Y/N]");
        char ans = sc.next().toUpperCase().charAt(0);
        boolean legalJump;
        if (ans == 'Y') {
            legalJump = true;
        }
        else if (ans == 'N') {
            legalJump = false;
        }
        else {
            System.out.println("Please enter Y or N");
            return;
        }
        System.out.println("Enter the time of the jump");
        LocalTime time = timeCreator();
        try {
            if (jumpRegister.addNewLongJump(startNumber, jumperName, result, legalJump, time))
                System.out.println("Successfully added new jump");
            else {
                System.out.println("This jump already exist");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    //By using iterable in the register, I only have to iterate through the instance of the register, and not a specified list or map.
    private void listAllResults() {
        for (LongJumpResult jump: jumpRegister) System.out.println(jump);
    }

    private void showResultsFromJumper() {
        ArrayList<LongJumpResult> jumperResults;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the start number to check: ");
        int startNumber;
        if (sc.hasNextInt()) {
            startNumber = sc.nextInt();
        } else {
            System.out.println("You must enter a number, not text");
            return;
        }
        try {
            jumperResults = jumpRegister.findAllUserResults(startNumber);
            if (jumperResults.size() == 0) System.out.println("There have been no registered results for this athlete.");
            else {
                for (LongJumpResult jump: jumperResults) System.out.println(jump);
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void showBestResult() {
        if (jumpRegister.longestJump() != null) System.out.println("The best result was: \n" + jumpRegister.longestJump());
        else System.out.println("There are no registered jumps");
    }

    private void showAverageResult() {
        double average = jumpRegister.findAverageJumpLength();
        //As I use double I have to check if it is a NaN, something I do with the java.lang.double package.
        if (!(isNaN(average))) System.out.println("The average result rounded to 2 decimals was: \n" + String.format("%.2f", jumpRegister.findAverageJumpLength()) + "m");
        else System.out.println("There was no registered jumps");
    }
}
