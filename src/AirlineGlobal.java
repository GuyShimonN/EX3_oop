import java.util.HashSet;
import java.util.Set;

public abstract class AirlineGlobal implements Observable {
    protected Set<Observer> observers_Airline = new HashSet<>();
    protected Set<Employed> Employeds =new HashSet<Employed>();

    private String name;

   private  Set<Flight> allFlight;
   public  AirlineGlobal(String name)
   {
       this.name=name;
       this.allFlight = new HashSet<Flight>();
   }
   public String getName(){
        return this.name;
    }



    void deleteFlight(Flight flight){
        for (Passenger passenger:flight.getPassengers()){
            flight.cancel_tiket(passenger);
        }
       this.allFlight.remove(flight);
        notifyObservers(flight,"the flight "+flight.getNumTravelabe()+" cancel");
        flight.notifyObservers_for_passnger(flight,"Please note the flight"+flight.getNumTravelabe()+" has been canceled and you will receive a refund ");
        Main.NumFlight.remove(flight.getNumTravelabe());
        flight=null;
    }
    public Set<Flight> getAllFlight(){
       return allFlight;
    }

    public Flight creatFlight(Double price,String numFlight,AirlineGlobal owner,String from,String to,int num_of_tiket,int year_of_depart,int month_of_depart,int day_of_depart,int hours_depart,int Minute_depart,int day_arrival,int month_arrival,int hours_Arrival,int Minute_Arrival,double Distans ,int year_arrival){
        Flight p = new Flight(price, numFlight, owner, from, to, num_of_tiket, year_of_depart, month_of_depart, day_of_depart, hours_depart, Minute_depart, day_arrival, month_arrival, hours_Arrival, Minute_Arrival, Distans,year_arrival);
       if (p.isAvailable()) {
           this.allFlight.add(p);
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
    public void attach(Observer o) {

        for(Flight flight: allFlight){
            flight.attach(o);
        }
        observers_Airline.add(o);
    }

    @Override
    public void detach(Observer o) {

        for(Flight flight: allFlight){
            flight.detach(o);
        }
        observers_Airline.remove(o);
    }

    @Override
    public void notifyObservers(Flight p,String message) {
        for (Observer observer : observers_Airline) {
            observer.update(message);
        }
    }
    public Employed creatEmployd(String name, Long id, double money, String password){
       Employed p =new Employed(name,id,money,password,this);
       this.Employeds.add(p);
      attach(p);
       return p;
    }
    public Set<Flight>getLocalFlight(){
       return allFlight;
    }

}