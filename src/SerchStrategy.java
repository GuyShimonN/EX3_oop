import java.util.List;

 interface SearchStrategy {
    List<Flight> search(List<Flight> flights, String criteria);
}
