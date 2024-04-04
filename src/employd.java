public class employd extends Passnger {
    public employd(String name, Long id,double money,String password) {
        super(name, id,money,password);
    }

    @Override
    public void update(String message) {

    }
  public Flight creat_fFlight(Double price,long numFlight,String owner,String from,String to,int num_of_tiket,int year_of_depart,int month_of_depart,int day_of_depart,int hours_depart,int Minute_depart,int day_arrival,int month_arrival,int hours_Arrival,int Minute_Arrival,double Distans){

    Flight p = new Flight(price, numFlight,owner,from,to,num_of_tiket, year_of_depart,month_of_depart,day_of_depart,hours_depart,Minute_depart,day_arrival,month_arrival, hours_Arrival,Minute_Arrival,Distans);
    return p;
  }
  public boolean check_avilable(Flight p){
        return p.isAvailable();
  }
  public int check_Num_of_tiket(Flight flight){
        return flight.getNum_of_tiket();
  }
  public void set_arrive_time(Flight flight,int year_of_depart,int month_of_depart,int day_of_depart,int hours_depart,int Minute_depart){
      flight.setArrive_time(year_of_depart,month_of_depart,day_of_depart,hours_depart,Minute_depart);
  }
}
