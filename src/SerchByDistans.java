import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SerchByDistans implements SearchStrategy {
    private double minDistance;

    public SerchByDistans(double maxDistance) {
        this.minDistance = maxDistance;
    }

    @Override
    public ArrayList<Travelable> search(ArrayList<Travelable> flights) {
        ArrayList<Travelable> filteredFlights = flights.stream()
                .filter(flight -> flight.getDistance() <= minDistance)
                .sorted(Comparator.comparingDouble(Travelable::getDistance))
                .collect(Collectors.toCollection(ArrayList::new));

        return filteredFlights;
    }
}
