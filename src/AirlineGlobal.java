import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class AirlineGlobal implements Observable {
    protected Set<Observer> observers_Airline = new HashSet<>();
    protected Set<Employed> Employeds =new HashSet<Employed>();
    protected  Set<AirlineGlobal> subAirline;
    private String name;

   protected   Set<Travelable> allFlight;
   public  AirlineGlobal(String name)
   {
       this.name=name;

   }
   public String getName(){
        return this.name;
    }




    public Collection<Travelable> getAllFlight(){
       return  allFlight;
    }

    @Override
    public void attach(Observer o) {

        for(Travelable flight: allFlight){
            flight.attach(o);
        }
        observers_Airline.add(o);
    }

    @Override
    public void detach(Observer o) {

        for(Travelable flight: allFlight){
            flight.detach(o);
        }
        observers_Airline.remove(o);
    }

    @Override
    public void notifyObservers(Travelable p,String message) {
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
    public Set<Travelable> getLocalTravelable(){
       return allFlight;
    }

     abstract void deleteTravelable(Flight flight);
}