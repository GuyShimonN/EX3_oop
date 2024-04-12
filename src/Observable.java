public interface Observable {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers(Travelable flight,String message);
}
