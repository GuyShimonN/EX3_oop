import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static LocalDate today = LocalDate.now();
    public static LocalDateTime today_ = LocalDateTime.now();
    public static String Airport;
    public static ArrayList<String> NumFlight=new ArrayList<>();
    public static int caunt =1;
    public static HashMap<String,AirlineGlobal> airport =new HashMap<>();

            public static void main(String[] args) {

                System.out.println("Welcome to the Flight Notification System");
                Scanner scanner = new Scanner(System.in);
                System.out.println("please enter the airport that you wont");
                Airport=scanner.nextLine();
                while (true) {
                    System.out.println("Welcome to the Flight Notification System");
                    System.out.println("1. Create a new Airline");
                    System.out.println("2. Create a new Passenger");
//                    System.out.println("3. Update a flight's details");
                    System.out.println("3. Exit");
                    System.out.print("Select an option: ");

                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over

                    switch (choice) {
                        case 1:

                            System.out.println("enter the name of the airline");
                            String name = scanner.nextLine();
                            Airline airline =new Airline(name);
                            airport.put(name,airline);
                            while (true){
                                System.out.println("Welcome to the Airline "+airline.getName()+" System");
                                System.out.println("1. Create a new SubAirline");
                                System.out.println("2. Create a new Employed ");
                                System.out.println("3. Create a new Flight ");
                                System.out.println("4. to get info about the Airline ");
                                System.out.println("5. Exit");
                                System.out.print("Select an option: ");
                                choice=scanner.nextInt();
                                scanner.nextLine();
                                switch (choice){
                                    case 1:
                                        Airline subairlin = creatsubairlin(airline);
//                                        System.out.println("enter the name of the subAirline");
//                                        String name1 = scanner.nextLine();
//                                        Airline subairline =airline.creatSubairline(name1);
//                                        airport.put(name1,subairline);
//                                        int b=3;
//                                        while (b==3) {
//                                            System.out.println("do you wont to do sum active with the subAirline ? y(1)/n(2)");
//                                                b = scanner.nextInt();
//
//                                            if (b==1) {
//                                                System.out.println("work");
//
//                                                break;
//                                            }
//                                             else if (b==2)break;
//                                             else b=3;
//                                        }
                                        break;
                                    case 2:
                                        Employed i = crEmployed(airline);

                                    case 3:
                                        break;
                                    case 4:
                                        break;
                                    case 5:
                                        break;
                                    default:
                                        System.out.println("Invalid option, please try again.");
                                }

                            }

                            // Prompt for flight details and call airline.creatFlight(...)

                        case 2:

                            System.out.println("enter a name");
                            String Name =scanner.nextLine();
                            System.out.println("enter a ID");
                            Long id =scanner.nextLong();
                            System.out.println("enter how mach money to put in yore account ");
                            String mon =scanner.next();
                            double money = 0;
                            try {
                                money = Double.parseDouble(mon);
                            } catch (NumberFormatException e) {
                                System.out.println("its not a number start from begin");
                                break;
                            }

                            System.out.println("enter a password you will need to remember the password to connect aging  ");
                            String password =scanner.next();
                            Passenger a = new Passenger(Name,id,money,password);
                            System.out.println(a.toString());

                            // Create a new Passenger or employd and attach to an Observable (Airline or Flight)
                            break;
//                        case 3:
//                            // Update flight details
//                            System.out.println("Updating flight details.");
//                            // Prompt for which flight to update and the new details, then update
//                            break;
                        case 3:
                            // Exit
                            System.out.println("Exiting.");
                            scanner.close();
                            return;
                        default:
                            System.out.println("Invalid option, please try again.");
                    }
                }

            }
            public static Airline creatsubairlin(Airline airline) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("enter the name of the subAirline");
                String name1 = scanner.nextLine();
                if (airport.containsKey(name1)) return null;
                Airline p = airline.creatSubairline(name1);
                airport.put(name1, p);
                int b = 3;
                while (b == 3) {
                    System.out.println("do you wont to do sum active with the subAirline ? y(1)/n(2)");
                    b = scanner.nextInt();

                    if (b == 1) {
                        while (true) {
                            System.out.println("Welcome to the Airline " + p.getName() + " System");
                            System.out.println("1. Create a new SubAirline");
                            System.out.println("2. Create a new Employed ");
                            System.out.println("3. Create a new Flight ");
                            System.out.println("4. to get info about the Airline ");
                            System.out.println("5. Exit");
                            System.out.print("Select an option: ");
                            int choice = scanner.nextInt();
                            scanner.nextLine();
                            switch (choice) {
                                case 1:
                                    creatsubairlin(p);
                                    break;
                                case 2:
                                Employed employed = crEmployed(p);
                                break;
                                case 3:
                                    Flight flight = crFlight(p);
                                    break;
                                case 4:
                                    getInfo(p);
                            }

                            break;
                        }

                    }
                    else if (b == 2) return p;
                    else b = 3;
                    return null;

                }

            return null;
            }

    private static void getInfo(Airline p) {

    }

    private static Flight crFlight(Airline p) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a num of flight");
        String num =scanner.nextLine();
        if(NumFlight.contains(num)){
            System.out.println("the number of the flight is ");
        }
        return null;
    }

    public static Employed crEmployed(AirlineGlobal airlin){
                Scanner scanner = new Scanner(System.in);

                System.out.println("enter a name");
                String Name =scanner.nextLine();
                System.out.println("enter a ID");
                Long id =scanner.nextLong();
                System.out.println("enter how mach money to put in yore account ");
                String mon =scanner.next();
                double money = 0;
                try {
                    money = Double.parseDouble(mon);
                } catch (NumberFormatException e) {
                    System.out.println("its not a number start from begin");
                    return null;
                }

                System.out.println("enter a password you will need to remember the password to connect aging  ");
                String password =scanner.next();
                Passenger a = new Passenger(Name,id,money,password);
                System.out.println(a.toString());
                System.out.println("do you wont to do active with the employed? y/n");
                int b = scanner.nextInt();
                if(b==3){
                    System.out.println("work");

                    return null;
                }
                else return null;
            }
}













//
//        Passenger p = new Passenger("guy", 123456789L, 1234L, "1234");
//        Airline airline = new Airline("airline");
//        employd orit = airline.creatEmployd("orit",209306518L,8000,"1234");
//       Flight b= airline.creatFlight(3000.0, 15325, airline, "orel", "daniel", 50, 2024, 6, 30, 20, 30, 1, 7, 12, 25, 500);
////        Flight flight = new Flight(3000.0, 15325, airline.getName(), "orel", "daniel", 50, 2024, 6, 30, 20, 30, 1, 7, 12, 25, 500);
//        Airline subairline = new Airline("elal");
//        Airline subairline1 = airline.creatSubairline("israel");
////        System.out.println(airline.getName());
////        System.out.println(subairline1.getName());
//        Flight g = airline.creatFlight(1000.0, 5325, airline, "TjLV", "USA", 50, 2024, 6, 3, 20, 30, 4, 6, 12, 25, 12500);
////        airline.addFlight(flight);
//        Flight a = subairline1.creatFlight(1500.0, 5325, subairline1, "TLV", "USA", 50, 2022, 6, 1, 20, 30, 2, 6, 12, 25, 9500);
//
//        g.buy_tiket(p);
//        System.out.println(g.getNum_of_tiket());
//        System.out.println(g.isAvailable());
//        Airline th = subairline1.creatSubairline("thorkish");
//        Flight w = th.creatFlight(2000.0, 65325, airline, "igap", "USA", 50, 2024, 6, 5, 20, 30, 6, 6, 12, 25, 5500);
//        Set<Flight> l = airline.getAllFlight();
//        for (Flight fly : l) {
//            System.out.println(fly.getFrom());
//            fly.print();
//        }
//        System.out.println("\n" + "\n");
//        Set<Flight> gu = new HashSet<>();
//        TimeSearchStrategy t = new TimeSearchStrategy(today_);
//        gu =t.search(airline.getAllFlight());
//        for (Flight fly : gu){
//            System.out.println(fly.getFrom());
//            fly.print();
//        }
//        System.out.println("\n" + "\n");
//        SerchByDistans or = new SerchByDistans(9500);
//        gu = or.search(airline.getAllFlight());
//        for (Flight fly : gu) {
//            System.out.println(fly.getFrom());
//            fly.print();
//        }
//        System.out.println("\n" + "\n");
//        PriceSearchStrategy di = new PriceSearchStrategy(2501);
//        gu = di.search(airline.getAllFlight());
//        for (Flight fly : gu) {
//            System.out.println(fly.getFrom());
//            fly.print();
//        }
//        System.out.println("\n" + "\n");
//        Search loco = new Search();
//        gu = loco.search('p',airline.getAllFlight(),null,2501L);
//        gu = di.search(airline.getAllFlight());
//        for (Flight fly : gu) {
//            System.out.println(fly.getFrom());
//            fly.print();
//        }
//        System.out.println("\n" + "\n");
//        airline.attach(p);
//        orit.set_depart_time(b,2024,8,25,12,20,20,20);
//        System.out.println(b.toString()+"\n  \n");
//        orit.printNotifaction();
//
//




//    }
//
//}
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
