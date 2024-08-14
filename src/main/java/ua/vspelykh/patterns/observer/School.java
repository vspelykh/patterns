package ua.vspelykh.patterns.observer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Наблюдатель
 */
@Slf4j
@Component
public class School implements Observer {

    @Override
    public String getName() {
        return "school";
    }

    @Override
    public void update(String message) {
        log.info("Notified all pupils about new book: {}", message);
    }
}
