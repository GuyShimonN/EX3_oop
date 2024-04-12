import java.util.ArrayList;

public class Search {
    private SearchStrategy strategy;

    public Search(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public ArrayList<Flight> execute(ArrayList<Flight> flights) {
        if (strategy != null) {
            return strategy.search(flights);
        }
        return flights; // Return the unfiltered list if no strategy is set
    }

    // Optionally, allow changing the strategy at runtime
    public void setStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }
}
