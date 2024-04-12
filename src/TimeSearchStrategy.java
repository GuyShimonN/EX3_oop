import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class TimeSearchStrategy implements SearchStrategy {
    private LocalDateTime time;

    public TimeSearchStrategy(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public ArrayList<Travelable> search(ArrayList<Travelable> flights) {
        ArrayList<Travelable> filteredFlights = flights.stream()
                .filter(flight -> flight.getDepart_time().isAfter(time))
                .sorted(Comparator.comparing(Travelable::getDepart_time))
                .collect(Collectors.toCollection(ArrayList::new));

        return filteredFlights;
    }
}
