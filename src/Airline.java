import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Airline extends AirlineGlobal {


    // Implement AirlineComponent methods

    public Airline(String name) {
        super(name);

    }
    @Override
    public Set<Flight> getAllFlight() {
        if (super.getChildren().isEmpty()) return super.getAllFlight();
        Set<Flight> allfly_and_Sub = new HashSet<Flight>();
        for (AirlineGlobal airline : getChildren()) {
            allfly_and_Sub.addAll(airline.getAllFlight());
        }
        allfly_and_Sub.addAll(super.getAllFlight());

        return allfly_and_Sub;
    }
}


