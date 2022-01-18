import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * The type Covid stats ui text.
 * @Version 1.0
 * @Author uid
 */
public class CovidStatsUIText {
    private final CovidRegister covidRegister;
    // Constants representing the different menu choices
    private static final int ADD_COVID_ENTRY_TO_REGISTER = 1;
    private static final int LIST_ALL_COVID_ENTRIES = 2;
    private static final int FIND_COVID_ENTRY_BY_DATE = 3;
    private static final int FIND_COVID_ENTRY_AFTER_DATE = 4;
    private static final int CALCULATE_TOTAL_INFECTED_BY_COUNTRY = 5;
    private static final int CALCULATE_TOTAL_DEATHS_BY_COUNTRY = 6;
    private static final int GET_TOTAL_AMOUNT_OF_CASES = 7;
    private static final int GET_TOTAL_AMOUNT_OF_DEATHS = 8;
    private static final int EXIT = 9;

    /**
     * Instantiates a new Covid stats ui.
     */
    public CovidStatsUIText() {
        covidRegister = new CovidRegister();
    }

    /**
     * Presents the menu for the user, and awaits input from the user. The menu
     * choice selected by the user is being returned.
     *
     * @return the menu choice by the user as a positive number starting from 1. If 0 is returned, the user has entered a wrong value
     */
    public void testCases() {
        covidRegister.addCovidLocationsStats(LocalDate.now(), "China", 1000, 100);
        covidRegister.addCovidLocationsStats(LocalDate.now(), "USA", 1000, 100);
        covidRegister.addCovidLocationsStats(LocalDate.now(), "Norway", 1000, 100);
        covidRegister.addCovidLocationsStats(LocalDate.now(), "Sweden", 1000, 100);
        covidRegister.addCovidLocationsStats(LocalDate.of(2020, 03, 02), "China", 1000, 100);
        covidRegister.addCovidLocationsStats(LocalDate.of(2019, 12, 24), "USA", 1000, 100);
        covidRegister.addCovidLocationsStats(LocalDate.of(2021, 10, 12), "Norway", 1000, 100);
        covidRegister.addCovidLocationsStats(LocalDate.of(2020, 11, 20), "Sweden", 1000, 100);
    }

    public static void main(String[] args) {
        CovidStatsUIText client = new CovidStatsUIText();
        client.testCases();
        client.start();
    }

    private int showMenu()
    {
        int menuChoice = 0;
        System.out.println("\n***** Covid Statistics Application v0.1 *****\n");
        System.out.println("1. Add a COVID-19 entry");
        System.out.println("2. List all COVID-19 entries");
        System.out.println("3. Find COVID-19 entry by date");
        System.out.println("4. Find all entries after date");
        System.out.println("5. Show the total infected for a country");
        System.out.println("6. Show the total deaths for a country");
        System.out.println("7. Get amount of covid cases");
        System.out.println("8. Get total amount of deaths");
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

    /**
     * Starts the application. This is the main loop of the application,
     * presenting the menu, retrieving the selected menu choice from the user,
     * and executing the selected functionality.
     */
    public void start() {
        boolean finished = false;
// The while-loop will run as long as the user has not selected
// to quit the application
        while (!finished) {
            int menuChoice = this.showMenu();
            switch (menuChoice)
            {
                case ADD_COVID_ENTRY_TO_REGISTER:
                    addNewCovidRegistration();
                    break;
                case LIST_ALL_COVID_ENTRIES:
                    listAllEntries();
                    break;
                case FIND_COVID_ENTRY_BY_DATE:
                    findEntryOnDate();
                    break;
                case FIND_COVID_ENTRY_AFTER_DATE:
                    findEntryAfterDate();
                    break;
                case CALCULATE_TOTAL_INFECTED_BY_COUNTRY:
                    getStatsFromCountry('I');
                    break;
                case CALCULATE_TOTAL_DEATHS_BY_COUNTRY:
                    getStatsFromCountry('D');
                    break;
                case GET_TOTAL_AMOUNT_OF_CASES:
                    getTotalAmountOfCases();
                    break;
                case GET_TOTAL_AMOUNT_OF_DEATHS:
                    getTotalDeaths();
                    break;
                case EXIT:
                    System.out.println("You are wrong for believing in corona");
                    finished = true;
                    break;
                default:
                    System.out.println("Unrecognized menu selected..");
                    break;
            }
        }
    }

    private LocalDate date() {
        Scanner sc = new Scanner(System.in);
        System.out.println("If the date is today enter: Y");
        System.out.println("If not enter: Any other character");
        char ans = sc.next().toUpperCase().charAt(0);
        if (ans == 'Y') return LocalDate.now();
        else {
            System.out.println("Enter the year as YYYY");
            int year = sc.nextInt();
            System.out.println("Enter the month as MM");
            int month = sc.nextInt();
            System.out.println("Enter the day as DD");
            int day = sc.nextInt();
            return LocalDate.of(year, month, day);
        }
    }

    private void addNewCovidRegistration() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the date");
        LocalDate date = date();
        System.out.println("Enter the country name");
        String country = sc.nextLine().trim();
        System.out.println("Enter the amount of infected");
        int infected;
        if (sc.hasNextInt()) {
            infected = sc.nextInt();
        } else {
            System.out.println("You must enter a number, not text");
            return;
        }
        System.out.println("Enter the amount of deaths");
        int deaths;
        if (sc.hasNextInt()) {
            deaths = sc.nextInt();
        } else {
            System.out.println("You must enter a number, not text");
            return;
        }
        try {
            if (covidRegister.addCovidLocationsStats(date, country, infected, deaths))
                System.out.println("Successfully added new stats");
            else {
                System.out.println("These stats already exist");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void listAllEntries() {
        for (CovidLocationStats stats: covidRegister) System.out.println(stats);
    }

    private void findEntryOnDate() {
        LocalDate date = date();
        CovidLocationStats caseOnDate = null;
        try {
            caseOnDate = covidRegister.findCaseOnDate(date);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        if (caseOnDate != null) {
            System.out.println("First case found on: " + date + "\n\n");
            System.out.println(caseOnDate);
        }
        else System.out.println("No cases found on this day");
    }

    private void findEntryAfterDate() {
        LocalDate date = date();
        ArrayList<CovidLocationStats> casesAfterDate = new ArrayList<>();
        try {
            casesAfterDate = covidRegister.findCasesAfterDate(date);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        if(casesAfterDate.size() != 0) {
            System.out.println("All cases after: " + date + "\n\n");
            for (CovidLocationStats covidcase : casesAfterDate) {
                System.out.println(covidcase);
            }
        }
        else {
            System.out.println("No cases found");
        }
    }

    private void getStatsFromCountry(char choice) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the country to check: ");
        String country = sc.nextLine().toUpperCase().trim();
        String statType = "";
        try {
            if (choice == 'I') {
                statType = "infections";
            }
            if (choice == 'D') {
                statType = "deaths";
            }
            int stats = covidRegister.getStatsFromCountry(country, choice);
            if (stats != 0) {
                System.out.println(country + " " + statType + ": " + covidRegister.getStatsFromCountry(country, choice));
            }
            else {
                System.out.println(country + " has had no " + statType);
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void getTotalDeaths() {
        if (covidRegister.totalDeaths() == 0) {
            System.out.println("There have not been any registered deaths");
        }
        else {
            System.out.println("The have been a total of " + covidRegister.totalDeaths() + " deaths.");
        }
    }

    private void getTotalAmountOfCases() {
        if (covidRegister.totalCovidRegistrations() == 0) {
            System.out.println("There have not been any registered cases");
        }
        else {
            System.out.println("The have been a total of " + covidRegister.totalCovidRegistrations() + " registrations.");
        }
    }
}