import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static LocalDate today = LocalDate.now();
    public static LocalDateTime today_ = LocalDateTime.now();
    public static String Airport = "TLV";
    public static ArrayList<String> NumFlight = new ArrayList<>();

    public static HashMap<String, AirlineGlobal> airport = new HashMap<>();

    public static void main(String[] args) throws no_money {

        System.out.println("Welcome to the Airline System");
        Passenger guy = new Passenger("guy", 123456789L, 1234L, "1234");
        Passenger daniel = new Passenger("daniel", 209301524L, 10000, "0202");
        Passenger Nofar = new Passenger("Nofar", 823456789L, 1234L, "1212");
        Passenger tal = new Passenger("tal", 209301524L, 10000, "1235");

        Airline airline = new Airline("airline");
        Employed orit = airline.creatEmployd("orit", 209306518L, 8000, "1444");
        Flight flight = (Flight) airline.creatFlight(3000.0, "AB325", airline, Airport, "paris", 50, 2024, 6, 30, 20, 30, 1, 7, 12, 25, 500, 2024);

        Airline subairline = new Airline("elal");
        Employed yaron = subairline.creatEmployd("yaron", 209306549L, 20000, "1111");

        airline.addChild(subairline);


        Airline subairline1 = (Airline) subairline.creatSubairline("israel");
        Employed dotan = subairline1.creatEmployd("dotan", 208606513L, 70000, "0000");

        Flight flight1 = (Flight) subairline.creatFlight(1000.0, "AB321", airline, "MIAMI", Airport, 50, 2024, 6, 3, 20, 30, 4, 6, 12, 25, 12500, 2024);
        Flight flight2 = (Flight) subairline1.creatFlight(1500.0, "AZ125", subairline1, "TLV", "USA", 50, 2026, 6, 1, 20, 30, 2, 6, 12, 25, 9500, 2026);
        System.out.println("try to craet a flight whit a use number os flight");
        Flight flight6 = (Flight) subairline.creatFlight(1000.0, "AB321", airline, "MIAMI", Airport, 50, 2024, 6, 3, 20, 30, 4, 6, 12, 25, 12500, 2024);


        airline.attach(daniel);
        subairline1.attach(Nofar);
        subairline.attach(tal);


        System.out.println(flight1.getNum_of_tiket());

        System.out.println(flight1.isAvailable());

        System.out.println("\n");
        Airline subairline2 = (Airline) subairline1.creatSubairline("thorkish");
        Flight flight3 = (Flight) subairline2.creatFlight(2000.0, "MK125", airline, "igap", "USA", 50, 2025, 6, 5, 20, 30, 6, 6, 12, 25, 5500, 2025);
        Set<Travelable> l = (Set<Travelable>) airline.getAllFlight();
        System.out.println("\n print the flight of airline that guy can buy in is money");
        Search search = new Search(new PriceSearchStrategy(guy.getMoney()));
        guy.search( airline);
        guy.buy_tik(flight1);
        System.out.println("work? \n");

        for (Travelable fly : l) {
            System.out.println(fly.toString());
        }
        ArrayList<Travelable> flights = new ArrayList<>(l);
        // Populate the flights list
        System.out.println("\n" + "\n");
        search.setStrategy(new TimeSearchStrategy(today_));
//        Search searchByTime = new Search(new TimeSearchStrategy(today_));
        ArrayList<Travelable> flightsFiltered = search.execute(flights);
        for (Travelable flight4 : flightsFiltered) {
            System.out.println(flight4.toString());
        }
        System.out.println("\n" + "\n");

        search.setStrategy(new PriceSearchStrategy(10000));
       flightsFiltered = search.execute(flights);
        System.out.println("search by price show just the flight that the price is less then a 10000 ans sort the flight by price ");
        for (Travelable flight4 : flightsFiltered) {
            System.out.println(flight4.toString());
        }
        System.out.println("\n" + "\n");

        search.setStrategy(new SerchByDistans(1000));
         flightsFiltered = search.execute(flights);
        System.out.println("search by distance show just the flight that the distance is less then a 1000 and sort the flight by distance ");
        for (Travelable flight4 : flightsFiltered) {
            System.out.println(flight4.toString());
        }

        System.out.println("\n" + "\n");

        daniel.buy_tik(flight);
        orit.set_depart_time(flight, 2024, 8, 25, 12, 20, 20, 20, 2024, 8, 26);
        System.out.println(flight.toString() + "\n  \n");
        orit.printNotifaction();
        System.out.println(flight.toString() + "\n  \n");
        daniel.printNotifaction();
        System.out.println(flight.toString() + "\n  \n");
        flight.Discount(10);
        System.out.println(flight.toString() + "\n  \n");
        flight.print();
        guy.cancel_tiket(flight);
        flight.print();
        orit.set_avvilabal(flight3, false);
        System.out.println("\n");

        yaron.set_avvilabal(flight, false);
        System.out.println("\n delete flight2 ");

        orit.deleteFlight(flight2);
        System.out.println("\n try delete flight ");

        yaron.deleteFlight(flight);
        System.out.println("\n try to change the depart time of flight " + flight.getNumTravelabe());
        yaron.set_depart_time(flight, 2025, 8, 30, 1, 1, 1, 1, 2025, 8, 31);
        System.out.println("\n  change the depart time of flight " + flight.getNumTravelabe());
        orit.set_depart_time(flight, 2025, 8, 30, 1, 1, 1, 1, 2025, 8, 31);
        System.out.println(flight.toString() + "\n  \n");
        daniel.printNotifaction();
        l = airline.getLocalTravelable();
        System.out.println(flight.toString() + "\n print only the the Flight that the company airline creat");
        for (Travelable flight4 : l) {
            System.out.println(l.toString());
        }
        try {
            guy.buy_tik(flight2);
        } catch (no_money e) {
            System.out.println("no money left");
        }
       orit.deleteFlight(flight);
        flights=new ArrayList<>(airline.getAllFlight());
        flightsFiltered =serch(flights);
        for (Travelable flight4 : flightsFiltered) {
            System.out.println(flight4.toString());
        }


    }

    public static ArrayList<Travelable> serch(ArrayList<Travelable> flights) {
        Search search = new Search(new PriceSearchStrategy(1000));
        ArrayList<Travelable> arrayList =new ArrayList<Travelable>();
        try {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Welcome to the search Flight System");
                System.out.println("1. Search by price");
                System.out.println("2. Search by distance");
                System.out.println("3.Search by time");
                System.out.println("4. Exit");
                System.out.print("Select an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                if (choice == 1) {
                    System.out.println("enter the maximum of money that do you ready to pay ");
                    while (true) {
                        try {
                            int num = Integer.parseInt(scanner.next());
                            search.setStrategy(new PriceSearchStrategy(num));
                            arrayList = search.execute(flights);
                            System.out.println("search by price show just the flight that the price is less then a " + num + " ans sort the flight by price ");
                            for (Travelable flight4 : arrayList) {
                                System.out.println(flight4.toString());
                            }
                            System.out.println("\n" + "\n");
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("enter a number");
                        }
                    }
                } else if (choice == 2) {
                    System.out.println("enter the min of distance that do you ready to flight ");
                    try {
                        int num = Integer.parseInt(scanner.next());
                        search.setStrategy(new SerchByDistans(1000));
                        arrayList = search.execute(flights);
                        System.out.println("search by distance show just the flight that the distance is more then a " + num + " ans sort the flight by distance ");
                        for (Travelable flight4 : arrayList) {
                            System.out.println(flight4.toString());
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("enter a number");
                    }
                } else if (choice == 3) {


                    while (true) {
                        boolean a = false;
                        int year_of_depart;
                        int month_of_depart;
                        int day_of_depart;
                        int hours_of_depart;
                        int minute_depart;
                        LocalDate date;
                        LocalTime time;
                        LocalDateTime dateTime = null;
                        System.out.println("do you wand from now or ander time? for now press 1 and ander time press 2 ");
                        while (true) {
                            int choice1 = scanner.nextInt();

                            if (choice1 == 1) {
                                a = true;
                                dateTime = today_;
                            } else if (choice1 == 2) {
                                a = true;
                                while (true) {
                                    System.out.println("enter the year of depart flight");
                                    try {
                                        year_of_depart = Integer.parseInt(scanner.next());
                                        break;
                                    } catch (NumberFormatException e) {
                                        System.out.println("please enter the year just a digit");
                                    }
                                }
                                while (true) {
                                    System.out.println("enter the month of depart flight");
                                    try {
                                        month_of_depart = Integer.parseInt(scanner.next());
                                        break;
                                    } catch (NumberFormatException e) {
                                        System.out.println("please enter the month just a digit");
                                    }
                                }
                                while (true) {
                                    System.out.println("enter the day of depart flight");
                                    try {
                                        day_of_depart = Integer.parseInt(scanner.next());
                                        if (day_of_depart < 32) {
                                            break;
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("please enter the day just a digit");
                                    }
                                }
                                while (true) {
                                    System.out.println("enter the hours of depart flight");
                                    try {
                                        hours_of_depart = Integer.parseInt(scanner.next());
                                        break;
                                    } catch (NumberFormatException e) {
                                        System.out.println("please enter the day just a digit");
                                    }
                                }
                                while (true) {
                                    System.out.println("enter the minute of depart flight");
                                    try {
                                        minute_depart = Integer.parseInt(scanner.next());
                                        break;
                                    } catch (NumberFormatException e) {
                                        System.out.println("please enter the day just a digit");
                                    }
                                }
                                LocalDate date1 = LocalDate.of(year_of_depart, month_of_depart, day_of_depart);
                                LocalTime time1 = LocalTime.of(hours_of_depart, minute_depart);
                                dateTime = LocalDateTime.of(date1, time1);

                            } else
                                System.out.println("please enter 1/2");

                            if (a) {
                                search.setStrategy(new TimeSearchStrategy(dateTime));
                                arrayList = search.execute(flights);
                                for (Travelable flight4 : arrayList) {
                                    System.out.println(flight4.toString());
                                }
                                System.out.println("\n" + "\n");
                                break;
                            }
                        }


                        break;

                    }
                } else if (choice == 4) {
                    break;
                } else System.out.println("please enter 1/2/3");
            }

        } catch (
                Exception e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

}


