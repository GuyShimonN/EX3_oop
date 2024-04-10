import java.util.HashSet;
import java.util.Set;

public abstract class AirlineGlobal implements Observable {
    private Set<Observer> observers_Airline = new HashSet<>();
    private Set<Employed> Employeds =new HashSet<Employed>();

    private String name;
    private Set<AirlineGlobal> subAirline;
   private  Set<Flight> allFlight;
   public  AirlineGlobal(String name)
   {
       this.name=name;
       this.subAirline = new HashSet<AirlineGlobal>();
       this.allFlight = new HashSet<Flight>();
   }
   public String getName(){
        return this.name;
    }
   public Set<AirlineGlobal> getSubAirline(){
        return subAirline;
   }
    void addChild(AirlineGlobal child){
        this.subAirline.add(child);
        notifyObservers(null,this.name+" buy "+child.name);
        for (Observer t: observers_Airline ) {
            child.attach(t);
        }

    }
    void removeChild(AirlineGlobal child){
        this.subAirline.remove(child);
    }
    void addFlight(Flight flight){
        this.allFlight.add(flight);
        notifyObservers(flight,"New flight: "+flight.toString());
    }
    void removeFlight(Flight flight){
        this.allFlight.remove(flight);
    }
    public Set<Flight> getAllFlight(){
       return allFlight;
    }
    public Airline creatSubairline(String name){
        Airline p = new Airline(name);
      this.subAirline.add(p);
      for (Observer t: observers_Airline ) {
          p.attach(t);
      }
      return p;
    }
    public Flight creatFlight(Double price,long numFlight,AirlineGlobal owner,String from,String to,int num_of_tiket,int year_of_depart,int month_of_depart,int day_of_depart,int hours_depart,int Minute_depart,int day_arrival,int month_arrival,int hours_Arrival,int Minute_Arrival,double Distans){
       Flight p = new Flight(price, numFlight, owner, from, to, num_of_tiket, year_of_depart, month_of_depart, day_of_depart, hours_depart, Minute_depart, day_arrival, month_arrival, hours_Arrival, Minute_Arrival, Distans);
       this.allFlight.add(p);
        notifyObservers(p,"New Flight"+p.toString());
       return p;
    }
    @Override
    public void attach(Observer o) {
        for (AirlineGlobal airline : getSubAirline()) {
         airline.attach(o);
        }
        for(Flight flight: allFlight){
            flight.attach(o);
        }
        observers_Airline.add(o);
    }

    @Override
    public void detach(Observer o) {
        for (AirlineGlobal airline : getSubAirline()) {
            airline.detach(o);
        }
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
       Employed p =new Employed(name,id,money,password);
       this.Employeds.add(p);
      attach(p);
       return p;
    }

}