import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

class Airline extends AirlineGlobal {




    public Airline(String name) {
        super(name);
        super.subAirline = new HashSet<AirlineGlobal>();
        super.allFlight = new HashSet<Travelable>();

    }

    public Travelable creatFlight(Double price,String numFlight,AirlineGlobal owner,String from,String to,int num_of_tiket,int year_of_depart,int month_of_depart,int day_of_depart,int hours_depart,int Minute_depart,int day_arrival,int month_arrival,int hours_Arrival,int Minute_Arrival,double Distans ,int year_arrival){
        Travelable p = new Flight(price, numFlight, owner, from, to, num_of_tiket, year_of_depart, month_of_depart, day_of_depart, hours_depart, Minute_depart, day_arrival, month_arrival, hours_Arrival, Minute_Arrival, Distans,year_arrival);
        if (p.isAvailable()) {
            super.allFlight.add(p);
            notifyObservers(p, "New Flight" + p.toString());
            for (Observer observer : observers_Airline) {
                p.attach(observer);
            }
            for (Observer observer : Employeds) {
                p.attach(observer);
            }
        }
        return p;
    }
    @Override
    public Collection< Travelable> getAllFlight() {
        if (getSubAirline().isEmpty()) return super.getAllFlight();
        Set<Travelable> allfly_and_Sub = new HashSet<Travelable>();
        for (AirlineGlobal airline : getSubAirline()) {
            allfly_and_Sub.addAll(airline.getAllFlight());
        }
        allfly_and_Sub.addAll(super.getAllFlight());

        return allfly_and_Sub;
    }
    public Set<AirlineGlobal> getSubAirline(){
        return subAirline;
    }
   public void addChild(AirlineGlobal child) {
       this.subAirline.add(child);
       notifyObservers(null, super.getName() + " buy " + child.getName());

       for (Observer t : observers_Airline) {
           child.attach(t);
       }
       for (Observer t : Employeds) {
           child.attach(t);
       }
   }
    void deleteTravelable(Flight flight){
        for (Passenger passenger:flight.getPassengers()){
            flight.cancel_tiket(passenger);
        }
        this.allFlight.remove(flight);
        notifyObservers(flight,"the flight "+flight.getNumTravelabe()+" cancel");
        flight.notifyObservers_for_passnger(flight,"Please note the flight"+flight.getNumTravelabe()+" has been canceled and you will receive a refund ");
        Main.NumFlight.remove(flight.getNumTravelabe());
        flight=null;
    }
        public void removeChild(AirlineGlobal child){
            this.subAirline.remove(child);
        }
    public Airline creatSubairline(String name){
        Airline p = new Airline(name);


        this.subAirline.add(p);
        for (Observer t: observers_Airline ) {
            p.attach(t);
        }
        return p;
    }
    @Override
    public String getName() {
        return super.getName();
    }
    @Override
    public void attach(Observer o) {
        for (AirlineGlobal airline : getSubAirline()) {
            airline.attach(o);
        }
        for(Travelable flight: getAllFlight()){
            flight.attach(o);
        }
        observers_Airline.add(o);
    }
    @Override
    public void detach(Observer o) {
        for (AirlineGlobal airline : getSubAirline()) {
            airline.detach(o);
        }
        for(Travelable flight: getAllFlight()){
            flight.detach(o);
        }
        observers_Airline.remove(o);
    }


    }




