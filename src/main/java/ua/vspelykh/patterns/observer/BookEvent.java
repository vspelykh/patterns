package ua.vspelykh.patterns.observer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Событие, которое отслеживается
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEvent {

    private BookOperation operation;
    private Book book;
}
