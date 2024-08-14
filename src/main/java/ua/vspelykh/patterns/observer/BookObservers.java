package ua.vspelykh.patterns.observer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Все наблюдатели за изменениями, связанные с книгами
 */
@Component
@RequiredArgsConstructor
public class BookObservers {

    private final List<Observer> observers;

    public Observer getObserver(String name) {
        return observers.stream().filter(observer -> observer.getName().equals(name)).findFirst().
                orElseThrow(() -> new RuntimeException("No such observer: " + name));
    }
}
