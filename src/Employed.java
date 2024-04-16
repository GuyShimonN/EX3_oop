public class Employed extends Passenger {
    private AirlineGlobal owner;
    public Employed(String name, Long id, double money, String password,AirlineGlobal owner) {
        super(name, id,money,password);
        this.owner=owner;
    }

    @Override
    public void update(String message) {

        System.out.println("new message to employed "+super.getName()+": "+message);
        addNotifcaiton(message);
    }
  public Flight creat_fFlight(Double price,String numFlight,AirlineGlobal owner,String from,String to,int num_of_tiket,int year_of_depart,int month_of_depart,int day_of_depart,int hours_depart,int Minute_depart,int day_arrival,int month_arrival,int hours_Arrival,int Minute_Arrival,double Distans,int year_arrival){
    if (getConncted()) {
        Flight p = new Flight(price, numFlight, owner, from, to, num_of_tiket, year_of_depart, month_of_depart, day_of_depart, hours_depart, Minute_depart, day_arrival, month_arrival, hours_Arrival, Minute_Arrival, Distans, year_arrival);
        return p;
    }
    else   System.out.println("you are not connected please connect first ");
    return null;
  }
  public boolean check_avilable(Flight p){
        return p.isAvailable();
  }
  public int check_Num_of_tiket(Flight flight){
        return flight.getNum_of_tiket();
  }
  public void set_depart_time(Flight flight,int year_of_depart,int month_of_depart,int day_of_depart,int hours_depart,int Minute_depart,int hours_arrival,int minute_arrival,int year_arrival,int month_of_arrival,int day_arrival){
        if(getConncted()) {
            if (owner.getAllFlight().contains(flight)) {
                try {
                    flight.setDepart_time(year_of_depart, month_of_depart, day_of_depart, hours_depart, Minute_depart, hours_arrival, minute_arrival,year_arrival,month_of_arrival,day_arrival);
                } catch (time_rong e) {
                    throw new RuntimeException(e);
                }
            } else System.out.println("you dont have permission to that");

        }
        else   System.out.println("you are not connected please connect first ");
  }
  public void set_avvilabal(Flight flight,boolean v){
        if (getConncted()) {
            if (owner.getAllFlight().contains(flight)) {
                flight.setAvailable(v);
            } else System.out.println("you dont have permission to that");
        }
        else System.out.println("you are not connected please connect first ");
  }
  public void deleteFlight(Flight flight){
        if (owner.getAllFlight().contains(flight)){
            owner.deleteTravelable(flight);
        }
        else System.out.println("you dont have permission to that");
  }
}
