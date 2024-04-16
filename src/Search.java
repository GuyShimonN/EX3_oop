import java.util.ArrayList;

public class Search {
    private SearchStrategy strategy;

    public Search(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public ArrayList<Travelable> execute(ArrayList<Travelable> flights) {
        if (strategy != null) {
            return strategy.search(flights);
        }
        return flights;
    }


    public void setStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }
}
