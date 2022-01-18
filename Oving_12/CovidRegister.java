import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The type Covid register.
 * @Author uid
 */
public class CovidRegister implements Iterable<CovidLocationStats> {
    private ArrayList<CovidLocationStats> covidRegister;

    /**
     * Instantiates a new Covid register.
     */
    public CovidRegister() {
        covidRegister = new ArrayList<>();
    }

    /**
     * Add covid locations stats to the register.
     *
     * @param date     the date
     * @param country  the country
     * @param infected the infected
     * @param deaths   the deaths
     * @return true if successful, false if already exists.
     */
    public boolean addCovidLocationsStats(LocalDate date, String country, int infected, int deaths) {
        CovidLocationStats newCase = new CovidLocationStats(date, country, infected, deaths);
        if (covidRegister.contains(newCase)) return false;
        return covidRegister.add(newCase);
    }

    /**
     * Finds the first case on the date given.
     *
     * @param date the date specified by user.
     * @return the first covid location stats on that date.
     * @throws IllegalArgumentException if date is null, returns illegal argument exception.
     */
    public CovidLocationStats findCaseOnDate(LocalDate date) throws IllegalArgumentException{
        if (date == null) throw new IllegalArgumentException("You have not entered a date");
        for(CovidLocationStats covidCase: covidRegister) {
            if(covidCase.getDate().equals(date)) return new CovidLocationStats(covidCase);
        }
        return null;
    }

    /**
     * Find cases after date as an arraylist.
     *
     * @param date the start date to search after.
     * @return arraylist with all cases after the date.
     * @throws IllegalArgumentException the illegal argument exception
     */
    public ArrayList<CovidLocationStats> findCasesAfterDate(LocalDate date) throws IllegalArgumentException{
        ArrayList<CovidLocationStats> casesAfterDate = new ArrayList<>();
        if (date == null) throw new IllegalArgumentException("You have not entered a date");
        for(CovidLocationStats covidCase: covidRegister) {
            if(covidCase.getDate().isAfter(date)) casesAfterDate.add(new CovidLocationStats(covidCase));
        }
        return casesAfterDate;
    }

    /**
     * Gets all covid cases as an iterator.
     *
     * @return an iterator with a deepcopy of the Arraylist covidRegister.
     */
    public Iterator<CovidLocationStats> iterator() {
        ArrayList<CovidLocationStats> covidRegisterCopy = new ArrayList<>();
        for (CovidLocationStats covidCase: covidRegister) {
            covidRegisterCopy.add(new CovidLocationStats(covidCase));
        }
        return covidRegisterCopy.iterator();
    }

    /**
     * Total covid registrations as an integer.
     *
     * @return the amount of registrations as an int.
     */
    public int totalCovidRegistrations() {
        return covidRegister.size();
    }

    /**
     * Total infected or deaths in a country as an integer.
     *
     * @param searchCountry the country specified by the user.
     * @param choice char cointaining the choice of data to fetch.
     * @return total infected in the country as an int.
     * @throws IllegalArgumentException if the country string is empty, returns an illegal argument exception.
     */
    public int getStatsFromCountry(String searchCountry, char choice) throws IllegalArgumentException{
        if (searchCountry.isBlank()) throw new IllegalArgumentException("You have not entered a country");
        int sum = 0;
        for(CovidLocationStats covidCase: covidRegister) {
            if(choice == 'D' && covidCase.getCountry().equals(searchCountry)) sum += covidCase.getDeaths();
            if(choice == 'I' && covidCase.getCountry().equals(searchCountry)) sum += covidCase.getInfected();
        }
        return sum;
    }

    /**
     * Total deaths for all countries as an integer.
     *
     * @return total deaths as an int.
     */
    public int totalDeaths() {
        int sum = 0;
        for(CovidLocationStats covidCase: covidRegister) {
            sum += covidCase.getDeaths();
        }
        return sum;
    }
}