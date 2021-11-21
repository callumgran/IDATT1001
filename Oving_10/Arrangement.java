public final class Arrangement {
    private final int key;
    private final String name;
    private final String place;
    private final String organiser;
    private final String eventType;
    private final double date;

    /**
     * This method is a constructor and uses "this." because the class is immutable and the variables
     * must be defined for this instance of each method.
     * @param key
     * @param name
     * @param place
     * @param organiser
     * @param eventType
     * @param date
     */

    public Arrangement(int key, String name, String place, String organiser, String eventType, double date) {
        this.key = key;
        this.name = name;
        this.place = place;
        this.organiser = organiser;
        this.eventType = eventType;
        this.date = date;
    }

    /**
     * This method returns the key of this arrangement.
     * @return
     */
    public int getKey() {
        return key;
    }

    /**
     * This method returns the name of this arrangement.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the place of this arrangement.
     * @return
     */
    public String getPlace() {
        return place;
    }

    /**
     * This method returns the organiser of this arrangement.
     * @return
     */
    public String getOrganiser() {
        return organiser;
    }

    /**
     * This method returns the type of this arrangement.
     * @return
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * This method returns the date of this arrangement.
     * @return
     */
    public double getDate() {
        return date;
    }

    /**
     * This method returns all the data of this arrangement as a string.
     * @return
     */
    @Override
    public String toString() {
        String formattedDate = String.format("%.1f", this.getDate());
        String date = formattedDate.substring(8, 10) + ":" + formattedDate.substring(10, 12) + " " + formattedDate.substring(6, 8) + "." + formattedDate.substring(4, 6) + "." + formattedDate.substring(0, 4);
        return '\n' + "Arrangement: "+ this.getName() + '\n' +
                "Nummer: " + this.getKey() + '\n' +
                "Sted: " + this.getPlace() + '\n' +
                "Arrangør: " + this.getOrganiser() + '\n' +
                "Type: " + this.getEventType() + '\n' +
                "Dato: " + date + '\n';
    }
}
