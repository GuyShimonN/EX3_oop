import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Passnger p = new Passnger("guy",123465);
        Airline airline = new Airline("airline");
        Flight flight =new Flight(3000.0,15325,airline.getName(),"orel","daniel",50,"12:00","6:00","31/08/1999",2500);
        Subairline subairline = new Subairline("elal");
        Subairline subairline1 =airline.addSubAirline("israel");
        System.out.println(airline.getName());
        System.out.println(subairline1.getName());
        Flight g=airline.creatFlight(1000.0,5325,airline.getName(),"TjLV","USA",50,"12:00","6:00","31/08/1999",2500);
        airline.addFlight(flight);
        Flight a=subairline1.creatFlight(1000.0,5325,subairline1.getName(),"TLV","USA",50,"12:00","6:00","31/08/1999",2500);

        g.buy_tiket(p);
        System.out.println(g.getNum_of_tiket());
        System.out.println(g.isAvailable());
       Subairline th= subairline1.addSubAirline("thorkish");
      Flight w=  th.creatFlight(2000.0,65325,airline.getName(),"igap","USA",10,"12:00","6:00","31/08/1999",30000);
        Set<Flight> l = airline.getAllFlight();
        for (Flight fly : l){
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