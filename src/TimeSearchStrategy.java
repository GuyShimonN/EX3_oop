import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class TimeSearchStrategy implements SearchStrategy {
//    @Override
//    public Set<Flight> search(Set<Flight> flights, SearchCriteria criteria) {
//        return flights.stream()
//                .filter(flight -> flight.getDepart_time().isAfter(criteria.getDepartureTime()))
//                .collect(Collectors.toSet());
//    }
    private LocalDateTime time;
    public TimeSearchStrategy(LocalDateTime localDateTime){
        this.time=localDateTime;
    }

    @Override
    public Set<Flight> search(Set<Flight> flights) {

        return flights.stream()
                .filter(flight -> flight.getDepart_time().isAfter(time)).collect(Collectors.toSet());

    }
}