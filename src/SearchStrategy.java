import java.util.Set;

public interface SearchStrategy {
    Set<Flight> search(Set<Flight> flights);
}
