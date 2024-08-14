package ua.vspelykh.patterns.observer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Publisher.
 * Объект, за которым будем наблюдать
 */
@Slf4j
@Component
public class BookShop implements Observable<BookEvent> {

    private final Map<Integer, Book> availableBooks;
    private final List<Observer> observers;

    public BookShop() {
        this.availableBooks = new HashMap<>();
        this.observers = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void handleEvent(BookEvent event) {
        if (observers.isEmpty()) {
            log.warn("No observers registered");
            throw new RuntimeException("No observers registered");
        }
        if (Objects.requireNonNull(event.getOperation()) == BookOperation.ADD) {
            availableBooks.put(event.getBook().getId(), event.getBook());
            notify(event.getBook() + " is available in our shop now!");
        } else if (event.getOperation() == BookOperation.REMOVE) {
            availableBooks.remove(event.getBook().getId());
            notify(event.getBook() + " is unavailable now!");
        }

    }

    private void notify(String message) {
        observers.forEach(observer -> observer.update(message));
    }
}
