import java.util.Scanner;
import java.util.Arrays;

/**
 * The type Mushroom client.
 */
public class MushroomClient {

    private final MushroomRegistry mushroomRegistry;

    private final Scanner input;

    private final int LIST_ALL_MUSHROOMS = 1;
    private final int LIST_ALL_EDIBLE = 2;
    private final int FIND_MUSHROOM = 3;
    private final int ADD_MUSHROOM = 4;
    private final int EXIT = 5;

    /**
     * Instantiates a new Mushroom client.
     */
    public MushroomClient(){
        mushroomRegistry = new MushroomRegistry();
        input = new Scanner(System.in);
    }

    /**
     * Test data.
     */
    public void testData() {
        mushroomRegistry.addSpecies("Rød Fluesopp", "Rød sopp med hvite prikker.", true);
        mushroomRegistry.addSpecies("Fleinsopp", "Hvit/brun sopp med lang skrukkete stilk.", false);
        mushroomRegistry.addSpecies("Steinsopp", "Stor brun sopp med lys stilk.", false);
        mushroomRegistry.addSpecies("Kantarell", "Weird squiggly bugger.", false);
        mushroomRegistry.addSpecies("Hvit Fluesopp", "Helt hvit spiss sopp.", true);
    }

    /**
     * Register new species.
     */
    public void registerNewSpecies() {
        System.out.println("Enter mushroom name: ");
        String mushroomName = input.next();
        input.nextLine();

        System.out.println("Enter mushroom description: ");
        String mushroomDesc = input.nextLine();

        System.out.println("Is the mushroom poisonous: true or false");
        boolean poisonous = input.nextBoolean();

        boolean isAdded = mushroomRegistry.addSpecies(mushroomName, mushroomDesc, poisonous);
        if (isAdded) {
            System.out.println("Mushroom added.");
        } else {
            System.out.println("Mushroom not added.");
        }
    }

    /**
     * Gets all species.
     */
    public void getAllSpecies() {
        for (MushroomSpecies mushroomSpecies : mushroomRegistry.getSpecies()) {
            System.out.println(mushroomSpecies);
        }
    }

    /**
     * Gets non poisonous mushrooms.
     */
    public void getNonPoisonousMushrooms() {
        String list = Arrays.toString(mushroomRegistry.edibleMushrooms().toArray()).replace("[", "").replace("]", "").replace(",", "");
        System.out.println(list);
    }

    /**
     * Search mushrooms by desc.
     */
    public void searchMushroomsByDesc() {
        System.out.println("Enter string to search for: ");
        String search = input.next();
        input.nextLine();
        String list = Arrays.toString(mushroomRegistry.searchedShroom(search).toArray()).replace("[", "").replace("]", "").replace(",", "");
        System.out.println(list);
    }

    private void showMenu() {
        int menuChoice = 0;

        System.out.println("\n***** Mushroom Register Application v0.1 *****\n");
        System.out.println("1. List all mushrooms");
        System.out.println("2. List all edible mushrooms");
        System.out.println("3. Search for mushrooms by description");
        System.out.println("4. Add new mushroom");
        System.out.println("5. Quit");
        System.out.println("\nPlease enter a number between 1 and 5.");

        if (input.hasNextInt()) {
            menuChoice = input.nextInt();
        } else {
            System.out.println("You must enter a number, not text");
        }

        switch (menuChoice) {
            case LIST_ALL_MUSHROOMS:
                getAllSpecies();
                break;
            case LIST_ALL_EDIBLE:
                getNonPoisonousMushrooms();
                break;
            case FIND_MUSHROOM:
                searchMushroomsByDesc();
                break;
            case ADD_MUSHROOM:
                registerNewSpecies();
                break;
            case EXIT:
                System.out.println("Thank you for using the mushroom register app!\n");
                System.exit(0);
                break;
            default:
                System.out.println("Unrecognized menu choice selected..");
                break;
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        MushroomClient MushroomClient = new MushroomClient();
        MushroomClient.testData();

        while (true) {
            MushroomClient.showMenu();
        }
    }
}
