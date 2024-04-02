import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AirlineGlobal {
    private String name;
    private Set<AirlineGlobal> children;
   private  Set<Flight> allFlight;
   public  AirlineGlobal(String name)
   {
       this.name=name;
       this.children = new HashSet<AirlineGlobal>();
       this.allFlight = new HashSet<Flight>();
   }
   public String getName(){
        return this.name;
    }
   public Set<AirlineGlobal> getChildren(){
        return  children;
   }
    void addChild(AirlineGlobal child){
        this.children.add(child);
    }
    void removeChild(AirlineGlobal child){
        this.children.remove(child);
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
    public Subairline addSubAirline(String name){
      Subairline p = new Subairline(name);
      this.children.add(p);
      return p;
    }
    public Flight creatFlight(Double price,long numFlight,String owner,String from,String to,int num_of_tiket,String arive_time,String depart_time,String date,double Distans){
       Flight p = new Flight(price,numFlight,this.getName(),from,to,num_of_tiket,arive_time,depart_time,date,Distans);
       this.allFlight.add(p);
       return p;
    }

}