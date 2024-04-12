import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

public interface Travelable extends Observable  {
 void buy_tiket(Passenger passenger);
 void  cancel_tiket(Passenger passenger);
     String getNumTravelabe();
     LocalDateTime getArrive_time();
     LocalDateTime getDepart_time();
     double getDistans();
     String getFrom();
    String getTo();

     void setAvailable(boolean available);
     void setDepart_time(int year_of_depart,int month_of_depart,int day_of_depart,int hours_depart,int Minute_depart,int hours_arrival,int minute_arrival,int year_arrival,int month_of_arrival,int day_arrival)throws time_rong;
     void setDistans(double distans);
     void setFrom(String from);
     void setNum_of_tiket(int num_of_tiket);
     void Discount(float x);
     Set<Passenger> getPassengers();
     boolean isAvailable();
    Double getPrice();



}
