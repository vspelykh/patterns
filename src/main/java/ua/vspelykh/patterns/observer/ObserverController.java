package ua.vspelykh.patterns.observer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Небольшой контроллер для проверки паттерна
 */
@Slf4j
@RestController
@RequestMapping("/api/observer")
@RequiredArgsConstructor
public class ObserverController {

    private final Observable<BookEvent> observable;
    private final BookObservers observers;

    @PostMapping
    public String addObserver(@RequestBody String observerName) {
        log.info("Adding observer {}", observerName);
        Observer observer = observers.getObserver(observerName);
        observable.subscribe(observer);
        return "Successfully added observer " + observerName;
    }

    @DeleteMapping
    public String removeObserver(@RequestBody String observerName) {
        log.info("Removing observer {}", observerName);
        Observer observer = observers.getObserver(observerName);
        observable.unsubscribe(observer);
        return "Successfully removed observer " + observerName;
    }

    @PostMapping("/book")
    public String proceedBookEvent(@RequestBody BookEvent event) {
        log.info("Adding event {}", event);
        observable.handleEvent(event);
        return "Event has been handled";
    }

    @ExceptionHandler
    public String handleException(RuntimeException e) {
        return e.getMessage();
    }
}
