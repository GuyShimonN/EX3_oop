public interface Observable {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers(Flight flight,String message);
}
