import java.util.ArrayList;

public class Passenger extends User {

    private final ArrayList<String> my_ticket;

    public Passenger(String name, Long id, double money, String password) {
        super(name, id, password, money);
        my_ticket = new ArrayList<String>();

    }

    public void buy_tik(Flight flight) throws no_money {
        if (getConnected()) {
            if (getMoney() >= flight.getPrice()) {
                flight.buy_tiket(this);
                setMoney(getMoney() - flight.getPrice());
                this.my_ticket.add(flight.getNumTravelabe());
            } else throw new no_money("you do not have enough money");
        } else System.out.println("you are not connected please connect first ");
    }

    public void setMy_ticket(String myTiket) {
        my_ticket.remove(myTiket);
    }

    public void cancel_tiket(Flight flight) {
        if (getConnected()) {
            if (my_ticket.contains(flight.getNumTravelabe())) {
                flight.cancel_tiket(this);
            }
        }
        else System.out.println("you are not connected please connect first ");
    }

    @Override
    public void update(String message) {
        System.out.println("new message to passenger " + super.getName() + ": " + message);
        addNotifcaiton(message);
    }

}

