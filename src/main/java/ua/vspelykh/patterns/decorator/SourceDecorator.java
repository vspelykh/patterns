package ua.vspelykh.patterns.decorator;

/**
 * Абстрактный класс-декоратор, имеющий ссылку на декорируемый класс
 */
public abstract class SourceDecorator implements Source {

    private final Source source;

    SourceDecorator(Source source) {
        this.source = source;
    }

    @Override
    public String print(String message) {
        return source.print(message);
    }
}
