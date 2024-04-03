import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SerchByDistans implements SearchStrategy {
    private double maxDistance;

    public SerchByDistans(double maxDistance) {
        this.maxDistance = maxDistance;
    }

    @Override
    public Set<Flight> search(Set<Flight> flights) {
        Set<Flight> filteredFlights = new HashSet<>();
        for (Flight flight : flights) {
            if (flight.getDistans() <= maxDistance) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }
}