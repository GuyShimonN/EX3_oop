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

        ArrayList<Travelable> filteredFlights = flights.stream()
                .filter(flight -> flight.getPrice() <= maxPrice)
                .sorted(Comparator.comparingDouble(Travelable::getPrice))
                .collect(Collectors.toCollection(ArrayList::new));

        return filteredFlights;
    }


}
