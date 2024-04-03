import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static LocalDate today = LocalDate.now();
    public static LocalDateTime today_ = LocalDateTime.now();

    public static void main(String[] args) {

        Passnger p = new Passnger("guy", 123456789L, 1234L, "1234");
        Airline airline = new Airline("airline");
        Flight flight = new Flight(3000.0, 15325, airline.getName(), "orel", "daniel", 50, 2024, 6, 30, 20, 30, 1, 7, 12, 25, 500);
        Airline subairline = new Airline("elal");
        Airline subairline1 = airline.addSubAirline("israel");
        System.out.println(airline.getName());
        System.out.println(subairline1.getName());
        Flight g = airline.creatFlight(1000.0, 5325, airline.getName(), "TjLV", "USA", 50, 2024, 6, 3, 20, 30, 4, 6, 12, 25, 12500);
        airline.addFlight(flight);
        Flight a = subairline1.creatFlight(1500.0, 5325, subairline1.getName(), "TLV", "USA", 50, 2022, 6, 1, 20, 30, 2, 6, 12, 25, 9500);

        g.buy_tiket(p);
        System.out.println(g.getNum_of_tiket());
        System.out.println(g.isAvailable());
        Airline th = subairline1.addSubAirline("thorkish");
        Flight w = th.creatFlight(2000.0, 65325, airline.getName(), "igap", "USA", 50, 2024, 6, 5, 20, 30, 6, 6, 12, 25, 5500);
        Set<Flight> l = airline.getAllFlight();
        for (Flight fly : l) {
            System.out.println(fly.getFrom());
            fly.print();
        }
        System.out.println("\n" + "\n");
        Set<Flight> gu = new HashSet<>();
        TimeSearchStrategy t = new TimeSearchStrategy(today_);
        gu =t.search(airline.getAllFlight());
        for (Flight fly : gu){
            System.out.println(fly.getFrom());
            fly.print();
        }
        System.out.println("\n" + "\n");
        SerchByDistans or = new SerchByDistans(9500);
        gu = or.search(airline.getAllFlight());
        for (Flight fly : gu) {
            System.out.println(fly.getFrom());
            fly.print();
        }
        System.out.println("\n" + "\n");
        PriceSearchStrategy di = new PriceSearchStrategy(2501);
        gu = di.search(airline.getAllFlight());
        for (Flight fly : gu) {
            System.out.println(fly.getFrom());
            fly.print();
        }
    }
}
/*

// Strategy Pattern
public interface SearchStrategy {
    List<Flight> search(List<Flight> flights, String criteria);
}

public class SearchByPrice implements SearchStrategy {
    @Override
    public List<Flight> search(List<Flight> flights, String criteria) {
        // יישום חיפוש לפי מחיר
    }
}

// Composite Pattern
public abstract class AirlineComponent {
    public void add(AirlineComponent component) {
        throw new UnsupportedOperationException();
    }

    public void remove(AirlineComponent component) {
        throw new UnsupportedOperationException();
    }

    public List<Flight> getFlights() {
        throw new UnsupportedOperationException();
    }
}

public class Airline extends AirlineComponent {
    private List<AirlineComponent> components = new ArrayList<>();

    @Override
    public void add(AirlineComponent component) {
        components.add(component);
    }

    @Override
    public List<Flight> getFlights() {
        // קבלת כל הטיסות מכל הרכיבים
    }
}

public class Flight extends AirlineComponent {
    private String flightNumber;
    // נתונים נוספים על הטיסה
}

// Observer Pattern
public interface Observer {
    void update(String message);
}

public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String message);
}

public class FlightUpdateManager implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

public class Passenger implements Observer {
    @Override
    public void update(String message) {
        // פעולה בתגובה לעדכון
    }
}

 */