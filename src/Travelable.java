import java.time.LocalDateTime;
import java.util.Set;

public interface Travelable extends Observable  {
 void buy_tiket(Passenger passenger);
 void  cancel_tiket(Passenger passenger);
     String getNumTravelabe();
     LocalDateTime getArrive_time();
     LocalDateTime getDepart_time();
     double getDistance();
     String getFrom();
    String getTo();

     void setAvailable(boolean available);
     void setDepart_time(int year_of_depart,int month_of_depart,int day_of_depart,int hours_depart,int Minute_depart,int hours_arrival,int minute_arrival,int year_arrival,int month_of_arrival,int day_arrival)throws time_wrong;
     void setDistance(double distance);
     void setFrom(String from);
     void setNum_of_tickets(int num_of_tickets);
     void Discount(float x);
     Set<Passenger> getPassengers();
     boolean isAvailable();
    Double getPrice();



}
