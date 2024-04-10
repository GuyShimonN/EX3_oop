import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Flight implements Observable{
    private Set<Observer> observers = new HashSet<>();
    private Set<Passenger> passengers;
    private Set<Employed> Employeds;
    public static   LocalDate today =LocalDate.now();
    private LocalDateTime date_time_of_flight;
    private LocalDateTime date_time_of_arrive_flight;
    private long time_of_flight;
    private long profit;
    private AirlineGlobal owner;
    private Double price;
    private long numFlight;
    private int num_of_tiket;
    private String from;
    private String to;

    private String info;
    private double Distans;
    private boolean available =false;
    public Flight(Double price,long numFlight,AirlineGlobal owner,String from,String to,int num_of_tiket,int year_of_depart,int month_of_depart,int day_of_depart,int hours_depart,int Minute_depart,int day_arrival,int month_arrival,int hours_Arrival,int Minute_Arrival,double Distans){
     this.price=price;
     this.numFlight=numFlight;
     this.owner=owner;
     this.from=from;
     this.to=to;
     this.num_of_tiket=num_of_tiket;
     if (num_of_tiket >0 ) this.available=true;
     this.passengers =new HashSet<Passenger>();

     this.Distans=Distans;
     this.profit=0;
        LocalDate flightDate = LocalDate.of(year_of_depart, month_of_depart, day_of_depart);
        LocalTime flightTime = LocalTime.of(hours_depart, Minute_depart);
        this.date_time_of_flight =LocalDateTime.of(flightDate, flightTime);
        LocalDate flightDate_arrival = LocalDate.of(year_of_depart, month_arrival, day_arrival);
        LocalTime flightTime_arrival = LocalTime.of(hours_Arrival, Minute_Arrival);
        this.date_time_of_arrive_flight =LocalDateTime.of(flightDate_arrival, flightTime_arrival);
        Duration duration = Duration.between(date_time_of_flight, date_time_of_arrive_flight);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        minutes= minutes+(hours*60);
        this.time_of_flight=minutes;


    }
    public void buy_tiket(Passenger passanger){
        if( (available)&&(num_of_tiket>0) ){
            this.passengers.add(passanger);
            this.num_of_tiket--;
            this.profit+=this.price;
            if (num_of_tiket==0){
                notifyObservers(this,"all tiket is sold out");
            }

        }
        else System.out.println("no mor tikets left");
    }
    public void  cancel_tiket(Passenger passenger){
        if (passenger.getConncted()){
          profit= (long) (profit-price);
          this.passengers.remove(passenger);
          if (!isAvailable())this.available=true;
          num_of_tiket++;
          passenger.setMoney(passenger.getMoney()+this.price);
        }

    }

    public AirlineGlobal getOwner() {
            return owner;
    }

    public long getNumFlight() {
        return numFlight;
    }

//    public ArrayList<Passnger> getPassngers() {
//        return passngers;
//    }

    public boolean isAvailable() {
        if (num_of_tiket >0)return available;
        return false;
    }

    public Double getPrice() {
        return price;
    }

    public int getNum_of_tiket() {
        return num_of_tiket;
    }

    public LocalDateTime getArrive_time() {
        return date_time_of_arrive_flight;
    }

    public LocalDate getDate() {
        return this.date_time_of_flight.toLocalDate();
    }

    public LocalDateTime getDepart_time() {
        return this.date_time_of_flight;
    }

    public double getDistans() {
        return Distans;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    private void setArrive_time(int year_of_depart,int month_of_depart,int day_of_depart,int hours_depart,int Minute_depart) throws time_rong {
        LocalDate flightDate = LocalDate.of(year_of_depart, month_of_depart, day_of_depart);
        LocalTime flightTime = LocalTime.of(hours_depart, Minute_depart);
//        if (flightDate.isBefore(this.date_time_of_flight.toLocalDate())){
//            throw new time_rong("the arrive time is before the depart time");
//        }
//        if(flightDate.equals(this.date_time_of_flight.toLocalDate()) ){
//            if (flightTime.isBefore(this.date_time_of_flight.toLocalTime())){
//                throw new time_rong("the arrive time is before the depart time");
//            }
//        }


    }

    public void setAvailable(boolean available) {
        this.available = available;
        notifyObservers(this,"The tikets for sale now is"+available);

    }



    public void setDepart_time(int year_of_depart,int month_of_depart,int day_of_depart,int hours_depart,int Minute_depart,int hours_arrival,int minute_arrival) throws time_rong {
        LocalDate flightDate = LocalDate.of(year_of_depart, month_of_depart, day_of_depart);
        LocalTime flightTime = LocalTime.of(hours_depart, Minute_depart);
        this.date_time_of_flight =LocalDateTime.of(flightDate, flightTime);
        int month_arrival = this.date_time_of_arrive_flight.getMonthValue()+(this.date_time_of_flight.getMonthValue()-this.date_time_of_arrive_flight.getMonthValue());
        int year =(year_of_depart+(this.date_time_of_arrive_flight.getYear()-year_of_depart));
        int day = (day_of_depart+Math.abs(this.date_time_of_arrive_flight.getDayOfYear()-date_time_of_flight.getDayOfYear()))%7;
        setArrive_time(year,month_arrival,day,hours_arrival,minute_arrival);
        notifyObservers(this,"Pay attention change depart time the new info"+toString());
        notifyObservers_for_passnger(this,"Pay attention change depart time"+toString());
    }

    public void setDistans(double distans) {
        Distans = distans;
        notifyObservers(this,"Pay attention change path the new distans is: "+distans+"and all the info is"+toString());
        notifyObservers_for_passnger(this,"Pay attention change path the new distans is: "+distans);
    }

    public void setFrom(String from) {
        this.from = from;
        notifyObservers_for_passnger(this,"change in the surce destantion you can cansel the flight"+toString());
        notifyObservers(this,"change in the surce destantion "+toString());
    }

    public void setNumFlight(long numFlight) {
        this.numFlight = numFlight;
        notifyObservers_for_passnger(this,"change in the number of flight"+toString());
        notifyObservers(this,"change in the number of flight"+toString());
    }

    public void setNum_of_tiket(int num_of_tiket) {
        this.num_of_tiket = num_of_tiket;
        notifyObservers(this,"Number of tiket left "+this.num_of_tiket+"the info is: "+toString());

    }
    public void print(){
        System.out.println("the flight: "+this.numFlight+" lave from "+this.from+" to "+this.to+" lave at: "+this.date_time_of_flight+" and arive at "+this.date_time_of_arrive_flight+
                "the cost for a tiket is "+this.price+" dollar we left a "+this.num_of_tiket+" tikets and the distans is: "+this.Distans+" the profit is: "+this.profit);

    }
    public void Discount(float x){
        this.price=this.price*(1-(x/100));
        notifyObservers(this,"Discount on the price the new price is: "+this.price+"and the info is: "+toString());
    }
    public String toString(){
        return " the flight: "+this.numFlight+" lave from "+this.from+" to "+this.to+" lave at: "+this.date_time_of_flight+" and arive at "+this.date_time_of_arrive_flight+
                " the cost for a tiket is "+this.price+" dollar we left a "+this.num_of_tiket+" tikets and the distans is: "+this.Distans+" the profit is: "+this.profit;
    }
    public Set<Employed> getEmployds(){
        return this.Employeds;

    }
    public void setEmployds(Employed employds){
        this.Employeds.add(employds);
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Flight flight,String message) {
        for (Observer observer : observers) {
            observer.update("Flight Update: " + message);
        }
    }
    public void notifyObservers_for_passnger(Flight flight,String message) {
        if (observers!=null) {
            for (Observer observer : passengers) {
                observer.update("Flight Update: " + message);
            }
        }
        if (Employeds !=null) {
            for (Observer observer : Employeds) {
                observer.update("Flight Update: " + message);
            }
        }
    }
}
