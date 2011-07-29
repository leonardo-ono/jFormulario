package formulario.core;

/**
 * Validador Exception.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (27/07/2011)
 */
public class ValidadorException extends Exception {

    public ValidadorException(Throwable cause) {
        super(cause);
    }

    public ValidadorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidadorException(String message) {
        super(message);
    }

    public ValidadorException() {
    }

}
