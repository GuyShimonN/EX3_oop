import java.util.ArrayList;

public abstract class User implements Observer {
    private final ArrayList<String> notification =new ArrayList<String>();
    private final String name;
    private final String password;
    private final long ID;
    private boolean connected;
    private double money;


    public User(String name, Long id, String password,double money){
        if ((id<19999999)||(id>1000000000))throw new RuntimeException("not valid id");
        if ((password.length()<4)||(password.length()>8))throw new RuntimeException("not valid password");
        this.ID=id;
        this.name=name;
        this.password=password;
        connected =true;
        this.money=money;
    }
    public void login(Long id,String password){
      if (this.password.equals(password)&&id==this.ID){
          connected =true;
          System.out.println("you connected");
      }
      else {
          System.out.println("the password or the id is not equal");
      }
    }
    public void logout(){
        connected =false;
    }
    public boolean getConnected(){return this.connected;}
    public double getMoney(){if (connected)return this.money;
        System.out.println("you are not connected please connect first ");return 0;}

    public void setMoney(double money) {
        if(connected)this.money = money;
        else   System.out.println("you are not connected please connect first ");
    }
    public void addNotifcaiton(String massage){
        this.notification.add(massage);
    }
    public void printNotifaction(){
        for (String t : notification){
            System.out.println(t);
        }
    }
    public String getName(){
        return this.name;
    }

    protected long getId() {
        return this.ID;
    }
    public String toString(){
        return "the name is "+this.getName()+" the id is "+this.getId()+" the amount of money in the account is "+this.money;
    }
    public ArrayList<Travelable> search(AirlineGlobal airlineGlobal){
        ArrayList<Travelable> arrayList =new ArrayList<>(airlineGlobal.getAllFlight());
        arrayList=Main.serch(arrayList);
        return arrayList;
    }
}
