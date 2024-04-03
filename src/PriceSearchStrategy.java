import java.util.HashSet;
import java.util.Set;

public class PriceSearchStrategy implements SearchStrategy {
    private double maxPrice;

    public PriceSearchStrategy(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public Set<Flight> search(Set<Flight> flights) {
        Set<Flight> filteredFlights = new HashSet<>();
        for (Flight flight : flights) {
            if (flight.getPrice() <= maxPrice) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }
}
