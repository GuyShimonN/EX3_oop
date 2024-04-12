import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SerchByDistans implements SearchStrategy {
    private double minDistance;

    public SerchByDistans(double maxDistance) {
        this.minDistance = maxDistance;
    }

    @Override
    public ArrayList<Flight> search(ArrayList<Flight> flights) {
        ArrayList<Flight> filteredFlights = flights.stream()
                .filter(flight -> flight.getDistans() <= minDistance)
                .sorted(Comparator.comparingDouble(Flight::getDistans))
                .collect(Collectors.toCollection(ArrayList::new));

        return filteredFlights;
    }
}
