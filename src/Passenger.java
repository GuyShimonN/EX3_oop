
public class Passenger extends User {

    private String my_tiket;

    public Passenger(String name, Long id, double money, String password) {
        super(name, id,password,money);

    }
    public void buy_tik(Flight flight) throws no_money {
        if(getMoney()>=flight.getPrice()) {
            flight.buy_tiket(this);
            setMoney(getMoney()-flight.getPrice());
            this.my_tiket=flight.toString();
        }
        else throw new no_money("you do not have enough money");
    }


    @Override
    public void update(String message) {
        System.out.println("new message to passenger "+super.getName()+": "+message);
        addNotifcaiton(message);
    }

}

