package ua.vspelykh.patterns.decorator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Простой контроллер для проверки.
 * Меняя объект внутри ссылки source, меняем поведение
 */
@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private final Source source = new CamelSourceDecorator(new SimpleSource());

//    private final Source source = new SimpleSource();

    @GetMapping("/msg")
    public String getMessage(@RequestParam String message) {

        return source.print(message);
    }
}
