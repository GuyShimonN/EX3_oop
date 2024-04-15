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

//        guy.buy_tik(flight1);
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
//            System.out.println(fly.getFrom());
//            fly.print();
        }
        ArrayList<Travelable> flights = new ArrayList<>(l);
        // Populate the flights list
        System.out.println("\n" + "\n");
        search.setStrategy(new TimeSearchStrategy(today_));
//        Search searchByTime = new Search(new TimeSearchStrategy(today_));
        ArrayList<Travelable> flightsFilteredByTime = search.execute(flights);
        for (Travelable flight4 : flightsFilteredByTime) {
            System.out.println(flight4.toString());
        }
        System.out.println("\n" + "\n");

//        Search searchByPrice = new Search(new PriceSearchStrategy(10000));
        search.setStrategy(new PriceSearchStrategy(10000));
        ArrayList<Travelable> flightsFilteredByPrice = search.execute(flights);
        System.out.println("search by price show just the flight that the price is less then a 10000 ans sort the flight by price ");
        for (Travelable flight4 : flightsFilteredByPrice) {
            System.out.println(flight4.toString());
        }
        System.out.println("\n" + "\n");

//        Search searchByDistans = new Search(new SerchByDistans(1000));
        search.setStrategy(new SerchByDistans(1000));
        ArrayList<Travelable> flightsFilteredByDistans = search.execute(flights);
        System.out.println("search by distance show just the flight that the distance is more then a 1000 ans sort the flight by distance ");
        for (Travelable flight4 : flightsFilteredByDistans) {
            System.out.println(flight4.toString());
        }

        System.out.println("\n" + "\n");
//        airline.attach(guy);
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
                            Search searchByPrice1 = new Search(new PriceSearchStrategy(num));
                            ArrayList<Travelable> flightsFilteredByPrice1 = searchByPrice1.execute(flights);
                            System.out.println("search by price show just the flight that the price is less then a " + num + " ans sort the flight by price ");
                            for (Travelable flight4 : flightsFilteredByPrice1) {
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
                        Search searchByDistans1 = new Search(new SerchByDistans(1000));
                        ArrayList<Travelable> flightsFilteredByDistans1 = searchByDistans1.execute(flights);
                        System.out.println("search by distance show just the flight that the distance is more then a " + num + " ans sort the flight by distance ");
                        for (Travelable flight4 : flightsFilteredByDistans1) {
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
                        System.out.println("to you wand from now or ander time? for now press 1 and ander time press 2 ");
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
                                ArrayList<Travelable> flightsFilteredByTime1 = search.execute(flights);
                                for (Travelable flight4 : flightsFilteredByTime1) {
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
                        System.out.println("to you wand from now or ander time? for now press 1 and ander time press 2 ");
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


//Search searchByTime = new Search(new TimeSearchStrategy(today_));
//ArrayList<Flight> flightsFilteredByTime = searchByTime.execute(flights);
//        for (Flight flight4:flightsFilteredByTime){
//        System.out.println(flight4.toString());
//        }
//        System.out.println("\n" + "\n");
//
//Search searchByPrice = new Search(new PriceSearchStrategy(10000));
//ArrayList<Flight> flightsFilteredByPrice = searchByPrice.execute(flights);
//        System.out.println("search by price show just the flight that the price is less then a 10000 ans sort the flight by price ");
//        for (Flight flight4:flightsFilteredByPrice){
//        System.out.println(flight4.toString());
//        }
//        System.out.println("\n" + "\n");
//
//Search searchByDistans = new Search(new SerchByDistans(1000));
//ArrayList<Flight> flightsFilteredByDistans = searchByPrice.execute(flights);
//        System.out.println("search by distance show just the flight that the distance is more then a 1000 ans sort the flight by distance ");
//        for (Flight flight4:flightsFilteredByDistans){
//        System.out.println(flight4.toString());
//        }


//        Scanner scanner = new Scanner(System.in);
//        System.out.println("please enter the airport that you wont");
//        Airport = scanner.nextLine();
//        while (true) {
//            System.out.println("Welcome to the Flight Notification System");
//            System.out.println("1. Create a new Airline");
//            System.out.println("2. Create a new Passenger");
////                    System.out.println("3. Update a flight's details");
//            System.out.println("3. Exit");
//            System.out.print("Select an option: ");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline left-over
//
//            switch (choice) {
//                case 1:
//
//                    System.out.println("enter the name of the airline");
//                    String name = scanner.nextLine();
//                    Airline airline = new Airline(name);
//                    airport.put(name, airline);
//                    while (true) {
//                        System.out.println("Welcome to the Airline " + airline.getName() + " System");
//                        System.out.println("1. Create a new SubAirline");
//                        System.out.println("2. Create a new Employed ");
//                        System.out.println("3. Create a new Flight ");
//                        System.out.println("4. to get info about the Airline ");
//                        System.out.println("5. Exit");
//                        System.out.print("Select an option: ");
//                        choice=10;
////                        try {
//                            choice = scanner.nextInt();
//                            scanner.nextLine();
////                        }
////                        catch (NoSuchElementException e){
////                            System.out.println("enter a number");
////                            scanner.close();
////                            scanner = new Scanner(System.in);
////
////                            choice=Integer.parseInt( scanner.next());
////                        }
//
//                        switch (choice) {
//                            case 1:
//                                AirlineGlobal subairlin = creatsubairlin(airline);
////                                continue;
////                                scanner.nextLine();
//                                break;
//                            case 2:
//                                Employed i = crEmployed(airline);
//                                break;
//                            case 3:
//                                Flight flight =crFlight(airline);
//                                break;
//                            case 4:
//                                break;
//                            case 5:
//                                break;
//                            default:
//                                System.out.println("Invalid option, please try again.");
//                        }
//
//                    }
//
//                    // Prompt for flight details and call airline.creatFlight(...)
//
//                case 2:
//
//                    System.out.println("enter a name");
//                    String Name = scanner.nextLine();
//                    System.out.println("enter a ID");
//                    Long id = scanner.nextLong();
//                    System.out.println("enter how mach money to put in yore account ");
//                    String mon = scanner.next();
//                    double money = 0;
//                    try {
//                        money = Double.parseDouble(mon);
//                    } catch (NumberFormatException e) {
//                        System.out.println("its not a number start from begin");
//                        break;
//                    }
//
//                    System.out.println("enter a password you will need to remember the password to connect aging  ");
//                    String password = scanner.next();
//                    Passenger a = new Passenger(Name, id, money, password);
//                    System.out.println(a.toString());
//
//                    // Create a new Passenger or employd and attach to an Observable (Airline or Flight)
//                    break;
////                        case 3:
////                            // Update flight details
////                            System.out.println("Updating flight details.");
////                            // Prompt for which flight to update and the new details, then update
////                            break;
//                case 3:
//                    // Exit
//                    System.out.println("Exiting.");
//                    scanner.close();
//                    return;
//                default:
//                    System.out.println("Invalid option, please try again.");
//            }
//        }
//
//    }
//
//    public static AirlineGlobal creatsubairlin(AirlineGlobal airline) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("enter the name of the subAirline");
//        String name1 = scanner.nextLine();
//        if (airport.containsKey(name1)) return null;
//        Airline p = airline.creatSubairline(name1);
//        airport.put(name1, p);
//        int b = 3;
//        while (b == 3) {
//            System.out.println("do you wont to do sum active with the subAirline ? y(1)/n(2)");
//            b = scanner.nextInt();
//
//            if (b == 1) {
//                while (true) {
//                    System.out.println("Welcome to the Airline " + p.getName() + " System");
//                    System.out.println("1. Create a new SubAirline");
//                    System.out.println("2. Create a new Employed ");
//                    System.out.println("3. Create a new Flight ");
//                    System.out.println("4. to get info about the Airline ");
//                    System.out.println("5. Exit");
//                    System.out.print("Select an option: ");
//                    int choice = scanner.nextInt();
//                    scanner.nextLine();
//                    switch (choice) {
//                        case 1:
//                            creatsubairlin(p);
//                            break;
//                        case 2:
//                            Employed employed = crEmployed(p);
//                            break;
//                        case 3:
//                            Flight flight = crFlight(p);
//                            break;
//                        case 4:
//                            getInfo(p);
//
//                    }
//
//                    break;
//                }
//
//            } else if (b == 2) return p;
//            else b = 3;
//            return p;
//
//        }
//
//        return null;
//    }
//
//    private static void getInfo(Airline p) {
//
//    }
//
//    private static Flight crFlight(Airline p) {
//        Flight flight;
//        boolean a = true;
//        String num;
//        String place;
//        double price;
//        int sum;
//        int year_of_depart;
//        int month_of_depart;
//        int day_of_depart;
//        int hours_of_depart;
//        int minute_depart;
//        int year_arrival;
//        int day_arrival;
//        int month_arrival;
//        int minute_arrival;
//        int hours_arrival;
//        double distans;
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("enter a num of flight in the format (XX999)");
//            num = scanner.nextLine();
//            if (num.matches("[A-Z]{2}\\d{3}")) {
//                if (!NumFlight.contains(num)) {
//                    break;
//                }
//                System.out.println("the number of the flight is already in use");
//            }
//            System.out.println("Error the number of flight must be in the format 2 Capital letter and 3 number");
//        }
//        while (true) {
//            System.out.println("enter the price per ticket");
//            try {
//                price = Double.parseDouble(scanner.next());
//                break;
//            } catch (NumberFormatException e) {
//                System.out.println("please enter the price just a digit");
//            }
//        }
//        while (true) {
//            System.out.println("enter the amuont of ticket");
//            try {
//                sum = Integer.parseInt(scanner.next());
//                break;
//            } catch (NumberFormatException e) {
//                System.out.println("please enter the price just a digit");
//            }
//        }
//
//        while (true) {
//            System.out.println("enter the year of depart flight");
//            try {
//                year_of_depart = Integer.parseInt(scanner.next());
//                if (year_of_depart >= today.getYear()) {
//                    year_arrival = year_of_depart;
//                    break;
//                }
//                System.out.println("The year has already been");
//            } catch (NumberFormatException e) {
//                System.out.println("please enter the year just a digit");
//            }
//        }
//        while (true) {
//            System.out.println("enter the month of depart flight");
//            try {
//                month_of_depart = Integer.parseInt(scanner.next());
//                if (month_of_depart >= today.getMonthValue() && year_of_depart == today.getYear() && month_of_depart <= 12)
//                    break;
//                if (year_of_depart > today.getYear() && month_of_depart <= 12) break;
//                System.out.println("The date has already been");
//            } catch (NumberFormatException e) {
//                System.out.println("please enter the month just a digit");
//            }
//        }
//        while (true) {
//            System.out.println("enter the day of depart flight");
//            try {
//                day_of_depart = Integer.parseInt(scanner.next());
//                if (day_of_depart < 32) {
//                    LocalDate i = LocalDate.of(year_of_depart, month_of_depart, day_of_depart);
//                    if (i.isAfter(today)) break;
//                }
//                System.out.println("The date has already been");
//            } catch (NumberFormatException e) {
//                System.out.println("please enter the day just a digit");
//            }
//        }
//        while (true) {
//            System.out.println("enter the hours of depart flight");
//            try {
//                hours_of_depart = Integer.parseInt(scanner.next());
//                LocalDate i = LocalDate.of(year_of_depart, month_of_depart, day_of_depart);
//                if (i.isEqual(today) && hours_of_depart > today_.getHour() || (i.isAfter(today) && hours_of_depart < 24))
//                    break;
//                System.out.println("The date has already been");
//            } catch (NumberFormatException e) {
//                System.out.println("please enter the day just a digit");
//            }
//        }
//        while (true) {
//            System.out.println("enter the minute of depart flight");
//            try {
//                minute_depart = Integer.parseInt(scanner.next());
//                LocalDate i = LocalDate.of(year_of_depart, month_of_depart, day_of_depart);
//                if (i.isEqual(today) && hours_of_depart > today_.getHour() && minute_depart < 60 || (i.isAfter(today) && minute_depart < 60))
//                    break;
//                System.out.println("The date has already been");
//            } catch (NumberFormatException e) {
//                System.out.println("please enter the day just a digit");
//            }
//        }
//        while (true) {
//            System.out.println("enter the month of arrival flight");
//            try {
//                month_arrival = Integer.parseInt(scanner.next());
//                if (month_arrival >= month_of_depart && month_arrival <= 12) break;
//                if (month_arrival == 1 && minute_depart == 12) {
//                    year_arrival = year_of_depart + 1;
//                    break;
//                }
//                System.out.println("try aging");
//            } catch (NumberFormatException e) {
//                System.out.println("please enter the month just a digit");
//            }
//        }
//        while (true) {
//            System.out.println("enter the day of arrival flight");
//            try {
//                day_arrival = Integer.parseInt(scanner.next());
//                if (day_arrival < 32) {
//                    LocalDate de = LocalDate.of(year_of_depart, month_of_depart, day_of_depart);
//
//                    LocalDate i = LocalDate.of(year_arrival, month_arrival, day_arrival);
//                    if (i.isAfter(de)||i.isEqual(de)) break;
//                }
//                System.out.println("Landing time before departure time");
//            } catch (NumberFormatException e) {
//                System.out.println("please enter the day just a digit");
//            }
//        }
//        LocalDate de = LocalDate.of(year_of_depart, month_of_depart, day_of_depart);
//        LocalDate i = LocalDate.of(year_arrival, month_arrival, day_arrival);
//        while (true) {
//            System.out.println("enter the hours of arrival flight");
//            try {
//                hours_arrival = Integer.parseInt(scanner.next());
//
//                if (i.isEqual(de) && hours_of_depart < hours_arrival || (i.isAfter(de) && hours_arrival < 24)) break;
//                System.out.println("Landing time before departure time");
//            } catch (NumberFormatException e) {
//                System.out.println("please enter the day just a digit");
//            }
//        }
//        while (true) {
//            System.out.println("enter the minute of arrival flight");
//            try {
//                minute_arrival = Integer.parseInt(scanner.next());
//
//                if (i.isEqual(de) && hours_of_depart < minute_arrival && minute_arrival < 60 || (i.isAfter(de) && minute_arrival < 60))
//                    break;
//                System.out.println("The date has already been");
//            } catch (NumberFormatException e) {
//                System.out.println("please enter the day just a digit");
//            }
//        }
//        while (true) {
//            System.out.println("enter the distance in of the flight ");
//            try {
//                distans = Double.parseDouble(scanner.next());
//                break;
//            } catch (NumberFormatException e) {
//                System.out.println("please enter the distance just a digit");
//            }
//        }
//        while (true) {
//            System.out.println("you want to come to " + Airport + " or to lave? to come press 1 to lave press 2 ");
//            try {
//                int to = Integer.parseInt(scanner.next());
//                if (to == 1) {
//                    a = true;
//                    System.out.println("from where do you want to come?");
//                    place = scanner.next();
//                    break;
//                }
//                if  (to==2){
//                    a=false;
//                    System.out.println("to where do you want to go?");
//                    place=scanner.next();
//                    break;
//                }
//            }
//            catch(NumberFormatException e){
//                    System.out.println("please enter the 1 or 2");
//                }
//        }
//            if (a) {
//                 flight = new Flight(price, num, p,Airport,place,sum,year_of_depart,month_of_depart,day_of_depart,hours_of_depart,minute_depart,day_arrival,month_arrival,hours_arrival,minute_arrival,distans,year_arrival );
//            }
//            else {
//                 flight = new Flight(price, num, p,Airport,place,sum,year_of_depart,month_of_depart,day_of_depart,hours_of_depart,minute_depart,day_arrival,month_arrival,hours_arrival,minute_arrival,distans,year_arrival );
//            }
//            int bo;
//            while (true){
//                System.out.println("do you want to see details on the flight? yes press 1, no press 2");
//                bo=scanner.nextInt();
//                if(bo==2)break;
//                if (bo==1){
//                    System.out.println(flight.toString());
//                    break;
//                }
//            }
//
//            scanner.close();
//            return flight;
//        }
//
//
//        public static Employed crEmployed (AirlineGlobal airlin){
//            Scanner scanner = new Scanner(System.in);
//
//            System.out.println("enter a name");
//            String Name = scanner.nextLine();
//            System.out.println("enter a ID");
//            Long id = scanner.nextLong();
//            System.out.println("enter how mach money to put in yore account ");
//            String mon = scanner.next();
//            double money = 0;
//            try {
//                money = Double.parseDouble(mon);
//            } catch (NumberFormatException e) {
//                System.out.println("its not a number start from begin");
//                return null;
//            }
//
//            System.out.println("enter a password you will need to remember the password to connect aging  ");
//            String password = scanner.next();
//            Passenger a = new Passenger(Name, id, money, password);
//            System.out.println(a.toString());
//            System.out.println("do you wont to do active with the employed? y/n");
//            int b = scanner.nextInt();
//            if (b == 3) {
//                System.out.println("work");
//
//                return null;
//            } else return null;
//        }
//    }


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
