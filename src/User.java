import java.util.ArrayList;

public abstract class User implements Observer {
    private ArrayList<String> notifcation=new ArrayList<String>();
    private String name;
    private String password;
    private long ID;
    private boolean conncted;
    private double money;


    public User(String name, Long id, String password,double money){
        if ((id<19999999)||(id>1000000000))throw new RuntimeException("not valid id");
        if ((password.length()<4)||(password.length()>8))throw new RuntimeException("not valid password");
        this.ID=id;
        this.name=name;
        this.password=password;
        conncted=true;
        this.money=money;
    }
    public void login(Long id,String password){
      if (this.password.equals(password)&&id==this.ID){
          conncted=true;
          System.out.println("you connected");
      }
      else {
          System.out.println("the password or the id is not equal");
      }
    }
    public void logout(){
        conncted=false;
    }
    public boolean getConncted(){return this.conncted;}
    public double getMoney(){if (conncted)return this.money;
        System.out.println("you are not connected please connect first ");return 0;}

    public void setMoney(double money) {
        if(conncted)this.money = money;
        else   System.out.println("you are not connected please connect first ");
    }
    public void addNotifcaiton(String massage){
        this.notifcation.add(massage);
    }
    public void printNotifaction(){
        for (String t :notifcation){
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
