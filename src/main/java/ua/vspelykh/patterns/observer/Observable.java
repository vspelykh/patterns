package ua.vspelykh.patterns.observer;

public interface Observable<T> {

    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void handleEvent(T event);
}
