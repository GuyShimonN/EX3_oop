import java.util.ArrayList;

public class Flight {
    private ArrayList<Passnger> passngers;
    private String owner;
    private Double price;
    private long numFlight;
    private int num_of_tiket;
    private String from;
    private String to;
    private String arrive_time;
    private String depart_time;
    private String date;
    private double Distans;
    private boolean available =false;
    public Flight(Double price,long numFlight,String owner,String from,String to,int num_of_tiket,String arive_time,String depart_time,String date,double Distans){
     this.price=price;
     this.numFlight=numFlight;
     this.owner=owner;
     this.from=from;
     this.to=to;
     this.num_of_tiket=num_of_tiket;
     if (num_of_tiket >0 ) this.available=true;
     this.passngers=new ArrayList<Passnger>();
     this.arrive_time =arive_time;
     this.depart_time=depart_time;
     this.date=date;
     this.Distans=Distans;
    }
    public void buy_tiket(Passnger passanger){
        if( (available)&&(num_of_tiket>0) ){
            this.passngers.add(passanger);
            this.num_of_tiket--;
        }
        else System.out.println("no mor tikets left");
    }

    public String getOwner() {
            return owner;
    }

    public long getNumFlight() {
        return numFlight;
    }

    public ArrayList<Passnger> getPassngers() {
        return passngers;
    }

    public boolean isAvailable() {
        return available;
    }

    public Double getPrice() {
        return price;
    }

    public int getNum_of_tiket() {
        return num_of_tiket;
    }

    public String getArrive_time() {
        return arrive_time;
    }

    public String getDate() {
        return date;
    }

    public String getDepart_time() {
        return depart_time;
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

    public void setArrive_time(String arrive_time) {
        this.arrive_time = arrive_time;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDepart_time(String depart_time) {
        this.depart_time = depart_time;
    }

    public void setDistans(double distans) {
        Distans = distans;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setNumFlight(long numFlight) {
        this.numFlight = numFlight;
    }

    public void setNum_of_tiket(int num_of_tiket) {
        this.num_of_tiket = num_of_tiket;
    }
    public void print(){
        System.out.println("the flight: "+this.numFlight+" lave from "+this.from+" to "+this.to+" lave at: "+this.date+" "+this.depart_time+" and arive at "+this.arrive_time+" " +
                "the cost for a tiket is "+this.price+" we left a "+this.num_of_tiket+" tikets and the distans is: "+this.Distans);
    }
}
