package ua.vspelykh.patterns.observer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Наблюдатель
 */
@Slf4j
@Component
public class EmailSubscriber implements Observer {

    @Override
    public String getName() {
        return "emailSubscriber";
    }

    @Override
    public void update(String message) {
        log.info("Sent email about nex update: {}", message);
    }
}
