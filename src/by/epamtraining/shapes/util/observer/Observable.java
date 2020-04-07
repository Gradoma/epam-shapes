package by.epamtraining.shapes.util.observer;

public interface Observable {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObserver();
}
