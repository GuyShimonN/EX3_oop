import java.util.HashSet;
import java.util.Set;

public abstract class AirlineGlobal {
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
    }
    void removeChild(AirlineGlobal child){
        this.subAirline.remove(child);
    }
    void addFlight(Flight flight){
        this.allFlight.add(flight);
    }
    void removeFlight(Flight flight){
        this.allFlight.remove(flight);
    }
    public Set<Flight> getAllFlight(){
       return allFlight;
    }
    public Airline addSubAirline(String name){
        Airline p = new Airline(name);
      this.subAirline.add(p);
      return p;
    }
    public Flight creatFlight(Double price,long numFlight,String owner,String from,String to,int num_of_tiket,int year_of_depart,int month_of_depart,int day_of_depart,int hours_depart,int Minute_depart,int day_arrival,int month_arrival,int hours_Arrival,int Minute_Arrival,double Distans){
       Flight p = new Flight(price, numFlight, owner, from, to, num_of_tiket, year_of_depart, month_of_depart, day_of_depart, hours_depart, Minute_depart, day_arrival, month_arrival, hours_Arrival, Minute_Arrival, Distans);
       this.allFlight.add(p);
       return p;
    }

}