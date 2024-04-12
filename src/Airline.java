import java.util.HashSet;
import java.util.Set;

class Airline extends AirlineGlobal {
    private Set<AirlineGlobal> subAirline;

    // Implement AirlineComponent methods

    public Airline(String name) {
        super(name);
        this.subAirline = new HashSet<AirlineGlobal>();

    }
    @Override
    public Set<Flight> getAllFlight() {
        if (getSubAirline().isEmpty()) return super.getAllFlight();
        Set<Flight> allfly_and_Sub = new HashSet<Flight>();
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
        for(Flight flight: getAllFlight()){
            flight.attach(o);
        }
        observers_Airline.add(o);
    }
    @Override
    public void detach(Observer o) {
        for (AirlineGlobal airline : getSubAirline()) {
            airline.detach(o);
        }
        for(Flight flight: getAllFlight()){
            flight.detach(o);
        }
        observers_Airline.remove(o);
    }


    }




