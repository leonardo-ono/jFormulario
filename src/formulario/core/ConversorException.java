package formulario.core;

/**
 * Conversor Exception.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (27/07/2011)
 */
public class ConversorException extends Exception {

    public ConversorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConversorException(String message) {
        super(message);
    }

    public ConversorException() {
    }

    public ConversorException(Throwable cause) {
        super(cause);
    }
    
}
