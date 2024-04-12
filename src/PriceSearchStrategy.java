import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class PriceSearchStrategy implements SearchStrategy {
    private double maxPrice;

    public PriceSearchStrategy(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public ArrayList<Travelable> search(ArrayList<Travelable> flights) {
        // Filter flights where the price is less than or equal to maxPrice
        // Then, sort these flights by their price
        // Finally, collect the results into a new ArrayList
        ArrayList<Travelable> filteredFlights = flights.stream()
                .filter(flight -> flight.getPrice() <= maxPrice)
                .sorted(Comparator.comparingDouble(Travelable::getPrice))
                .collect(Collectors.toCollection(ArrayList::new));

        return filteredFlights;
    }

//    public ArrayList<Flight> search(ArrayList<Flight> flights) {
//        ArrayList<Flight> filteredFlights = flights.stream()
//                .filter(flight -> flight.getPrice() <= maxPrice)
//                .sorted(Comparator.comparingDouble(Flight::getPrice))
//                .collect(Collectors.toCollection(ArrayList::new));
//
//        return filteredFlights;
//    }
}
