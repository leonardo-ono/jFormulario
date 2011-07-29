package formulario.core;

/**
 * Interface para validador.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (27/07/2011)
 */

public interface Validador {
    
    public abstract void validar(Object valor) throws ValidadorException;
    
}
