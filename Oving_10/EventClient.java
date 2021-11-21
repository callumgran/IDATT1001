import java.util.Scanner;

public class EventClient {
    public static void main(String[] args) {
        char k;
        ArrangementRegister registry = new ArrangementRegister();
        Scanner in = new Scanner(System.in);
        registry.newEvent("Jahn Teigen Appreciation", "At Jahn", "Jahn Teigen", "Party", 201903261900l);
        registry.newEvent("John Carew Appreciation", "West Ham Stadium", "John Carew", "Football", 201207191900l);
        registry.newEvent("Tore Tang Parade", "Stavanger", "Mods", "Parade", 198111191300l);
        registry.newEvent("Ari Behn Prayer", "Oslo", "God", "Prayer", 202112241200l);

        do {
            System.out.println("Enter a number between 1 and 8");
            System.out.println("1: Register new event");
            System.out.println("2: Find events at place");
            System.out.println("3: Find events on date");
            System.out.println("4: Find events between dates");
            System.out.println("5: Sort events by date");
            System.out.println("6: Sort events by place");
            System.out.println("7: Sort events by type");
            System.out.println("8: Exit");
            k = in.next().charAt(0);
            System.out.println('\n');
            switch (k) {
                case '1':
                    in.nextLine();
                    System.out.println("Name: ");
                    String name = in.nextLine();
                    System.out.println("Place: ");
                    String place = in.nextLine();
                    System.out.println("Organiser: ");
                    String organiser = in.nextLine();
                    System.out.println("Type of Event: ");
                    String eventType = in.nextLine();
                    System.out.println("Date (YYYYMMDDHHMM): ");
                    double date = in.nextDouble();
                    Arrangement newEvent = registry.newEvent(name, place, organiser, eventType, date);
                    registry.events.add(newEvent);
                    System.out.print(registry.events);
                    break;

                case '2':
                    in.nextLine();
                    System.out.println("Place: ");
                    String eventPlace = in.nextLine();
                    System.out.println(registry.eventsPlace(eventPlace));
                    break;

                case '3':
                    in.nextLine();
                    System.out.println("Date: ");
                    double eventDate = in.nextDouble();
                    registry.eventsDate(eventDate);
                    System.out.println(registry.eventsDate(eventDate));
                    break;

                case '4':
                    in.nextLine();
                    System.out.println("Date 1: ");
                    long date1 = in.nextLong();
                    System.out.println("Date 2: ");
                    long date2 = in.nextLong();
                    System.out.println(registry.eventsBetweenDates(date1, date2));
                    break;

                case '5':
                    registry.eventSortByDate();
                    System.out.println(registry.events);
                    break;

                case '6':
                    registry.eventSortByPlace();
                    System.out.println(registry.events);
                    break;

                case '7':
                    registry.eventSortByType();
                    System.out.println(registry.events);
                    break;

                default:
                    System.out.println("Invalid grade - must enter 1,2,3,4,5,6,7 or 8");
                    System.out.println();
                    break;
            }
            System.out.println();
        }
        while(k != '8');
    }
}
