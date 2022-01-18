import java.time.LocalDate;
import java.util.Objects;

/**
 * The type Covid location stats.
 *
 * @Author uid
 */
public class CovidLocationStats {
    private final LocalDate date;
    private final String country;
    private final int infected;
    private final int deaths;

    /**
     * Instantiates a new Covid location stats.
     *
     * @param date     the date is a specified date or the date today.
     * @param country  the country of which the data is from, cannot be empty.
     * @param infected the number of infections of the country, cannot be less than 0 or a decimal.
     * @param deaths   the number of deaths of the country, cannot be less than 0 or a decimal.
     * @throws IllegalArgumentException if the user has specified a negative int or has not specified a country, the illegalArgument will be thrown.
     */
    public CovidLocationStats(LocalDate date, String country, int infected, int deaths) throws IllegalArgumentException{
        if (date == null) throw new IllegalArgumentException("The date cannot be null");
        if (country.isBlank()) throw new IllegalArgumentException("You have not specified a country");
        if (infected < 0) throw new IllegalArgumentException("Amount of infected cannot be less than 0");
        if (deaths < 0) throw new IllegalArgumentException("Amount of deaths cannot be less than 0");
        this.date = date;
        this.country = country.toUpperCase();
        this.infected = infected;
        this.deaths = deaths;
    }

    /**
     * Instantiates a new Covid location stats.
     * If the date is empty, this will generate the current date.
     *
     * @param country  the country of which the data is from, cannot be empty.
     * @param infected the number of infections of the country, cannot be less than 0 or a decimal.
     * @param deaths   the number of deaths of the country, cannot be less than 0 or a decimal.
     */
    public CovidLocationStats(String country, int infected, int deaths) {
        this(LocalDate.now(), country, infected, deaths);
    }

    /**
     * Instantiates a new Covid location stats.
     *
     * @param covidLocationStats the covid location stats
     */
    public CovidLocationStats(CovidLocationStats covidLocationStats) {
        this(covidLocationStats.getDate(), covidLocationStats.getCountry(),
                covidLocationStats.getInfected(), covidLocationStats.getDeaths());
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Gets amount of infections.
     *
     * @return the amount infections
     */
    public int getInfected() {
        return infected;
    }

    /**
     * Gets amount of deaths.
     *
     * @return the amount deaths
     */
    public int getDeaths() {
        return deaths;
    }

    /**
     * Override to string method to print object neatly.
     * @return object as string.
     */
    @Override
    public String toString() {
        return "Date: " + getDate() + '\n' +
                "Country: " + getCountry() + '\n' +
                "Infected: " + getInfected() + '\n' +
                "Deaths: " + getDeaths() + '\n';
    }

    /**
     * Equals method to check if the date and country are equal in two objects.
     * @param o a new instance of CovidLocationStats
     * @return true or false based on the Covid Stats already exist for the specified date and country.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CovidLocationStats)) return false;
        CovidLocationStats that = (CovidLocationStats) o;
        return Objects.equals(getDate(), that.getDate()) && Objects.equals(getCountry(), that.getCountry());
    }
}
