public class Employed extends Passenger {
    public Employed(String name, Long id, double money, String password) {
        super(name, id,money,password);
    }

    @Override
    public void update(String message) {
        System.out.println("new message to employed "+super.getName()+": "+message);
        addNotifcaiton(message);
    }
  public Flight creat_fFlight(Double price,long numFlight,AirlineGlobal owner,String from,String to,int num_of_tiket,int year_of_depart,int month_of_depart,int day_of_depart,int hours_depart,int Minute_depart,int day_arrival,int month_arrival,int hours_Arrival,int Minute_Arrival,double Distans){

    Flight p = new Flight(price, numFlight,owner,from,to,num_of_tiket, year_of_depart,month_of_depart,day_of_depart,hours_depart,Minute_depart,day_arrival,month_arrival, hours_Arrival,Minute_Arrival,Distans);
    return p;
  }
  public boolean check_avilable(Flight p){
        return p.isAvailable();
  }
  public int check_Num_of_tiket(Flight flight){
        return flight.getNum_of_tiket();
  }
  public void set_depart_time(Flight flight,int year_of_depart,int month_of_depart,int day_of_depart,int hours_depart,int Minute_depart,int hours_arrival,int minute_arrival){
      try {
          flight.setDepart_time( year_of_depart, month_of_depart, day_of_depart, hours_depart, Minute_depart, hours_arrival, minute_arrival);
      } catch (time_rong e) {
          throw new RuntimeException(e);
      }
  }
}
