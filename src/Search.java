import java.time.LocalDateTime;
import java.util.Set;

public class Search {
    public Set<Flight> search(char a, Set<Flight> g,LocalDateTime b, Long dis){
       if (a=='T'||a=='t') {
           TimeSearchStrategy q =new TimeSearchStrategy(b);
           return q.search(g);
       }
        if (a=='D'||a=='d') {
            SerchByDistans q =new SerchByDistans(dis);
            return q.search(g);
        }
        if (a=='P'||a=='p') {
            PriceSearchStrategy q =new PriceSearchStrategy(dis);
            return q.search(g);
        }
        return null;
    }
}
