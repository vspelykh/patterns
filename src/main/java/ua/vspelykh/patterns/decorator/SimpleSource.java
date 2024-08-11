package ua.vspelykh.patterns.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * Простой декорируемый класс, реализующий базовый класс (интерфейс)
 */
@Slf4j
public class SimpleSource implements Source {
    @Override
    public String print(String message) {
        return message;
    }
}
