//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
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