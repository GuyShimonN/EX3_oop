
public class Passnger extends User {
    private double money;
    private String my_tiket;

    public Passnger(String name, Long id,double money,String password) {
        super(name, id,password);
        this.money=money;
    }
    public void buy_tik(Flight flight) throws no_money {
        if(money>=flight.getPrice()) {
            flight.buy_tiket(this);
            this.money=this.money-flight.getPrice();
            this.my_tiket=flight.toString();
        }
        else throw new no_money("you do not have enough money");
    }


    @Override
    public void update(String message) {

    }
}

