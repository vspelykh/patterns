package ua.vspelykh.patterns.decorator;

/**
 * Имплементация декооратора, который выполняет простую функцию, после чего делегирует работу декорируемому классу
 */
public class CamelSourceDecorator extends SourceDecorator {

    public CamelSourceDecorator(Source source) {
        super(source);
    }

    @Override
    public String print(String message) {
        return super.print(toCamel(message));
    }

    private String toCamel(String message) {
        return message.substring(0, 1).toUpperCase() + message.substring(1);
    }
}
