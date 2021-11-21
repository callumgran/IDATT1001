import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class ArrangementRegister {
    public final ArrayList<Arrangement> events;

    /**
     * This method is a constructor and uses "this." because the class is immutable and the variables
     * must be defined for this instance of each method.
     */

    public ArrangementRegister() {
        this.events = new ArrayList<Arrangement>();
    }

    /**
     * This method creates a new event for this instance of the register and returns the event that has
     * been created.
     * @param name
     * @param place
     * @param organiser
     * @param eventType
     * @param date
     * @return
     */

    public Arrangement newEvent(String name, String place, String organiser, String eventType, double date) {
        int key = this.events.size();
        Arrangement event = new Arrangement(key, name, place, organiser, eventType, date);
        this.events.add(event);
        return event;
    }

    /**
     * This method finds events at a user defined place using the parameter shown under.
     * It then returns all events at said place and if none are found it returns a message.
     * @param place
     * @return
     */
    public ArrayList<Arrangement> eventsPlace(String place) {
        ArrayList<Arrangement> placeArray = new ArrayList<Arrangement>();
        String lowerCase = place.toLowerCase();
        System.out.println(place);
        int teller = 0;
        for (int i = 0; i < this.events.size(); i++) {
            if (this.events.get(i).getPlace().toLowerCase().equals(lowerCase)) {
                placeArray.add(this.events.get(i));
                teller++;
            }
        }
        if (teller == 0) {
            System.out.println("There were no events at this place: " + place);
        }
        return placeArray;
    }

    /**
     * This method finds events on a user defined date using the parameter shown under.
     * It then returns all events on said date and if none are found it returns a message.
     * @param date
     * @return
     */
    public ArrayList<Arrangement> eventsDate(double date) {
        ArrayList<Arrangement> dateArray = new ArrayList<Arrangement>();
        int teller = 0;
        for (int i = 0; i < this.events.size(); i++) {
            double eventDate = this.events.get(i).getDate();
            if (eventDate == date) {
                dateArray.add(this.events.get(i));
                teller++;
            }
        }
        if (teller == 0) {
            System.out.println("There were no events on this date: " + date);
        }
        return dateArray;
    }

    /**
     * This method finds events between 2 user defined dates using the parameters shown under.
     * It then returns all events between said dates and if none are found it returns a message.
     * @param date1
     * @param date2
     * @return
     */
    public ArrayList<Arrangement> eventsBetweenDates(long date1, long date2) {
        int teller = 0;
        ArrayList<Arrangement> dateArray = new ArrayList<Arrangement>();
        for (int i = 0; i < this.events.size(); i++) {
            int eventDate = (int)Math.floor(this.events.get(i).getDate() / 10000);
            if (eventDate >= (int)date1 && eventDate <= (int)date2) {
                dateArray.add(this.events.get(i));
                teller++;
            }
        }
        if (teller == 0) {
            System.out.println("There were no events between: " + date1 + " and " + date2);
        }
        return dateArray;
    }

    /**
     * These methods use the collection method to sort events using the comparator method.
     * These methods do not return anything as it is a void.
     */
    public void eventSortByDate() {
        Collections.sort(this.events, Comparator.comparingDouble(Arrangement::getDate));
    }

    public void eventSortByPlace() {
        Collections.sort(this.events, Comparator.comparing(Arrangement::getPlace));
    }

    public void eventSortByType() {
        Collections.sort(this.events, Comparator.comparing(Arrangement::getEventType));
    }
}