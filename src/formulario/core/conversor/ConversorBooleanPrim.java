package formulario.core.conversor;

import formulario.core.Conversor;
import formulario.core.ConversorException;

/**
 * Conversor padrão para boolean primitivo.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (27/07/2011)
 */
public class ConversorBooleanPrim implements Conversor {

    @Override
    public String getAsString(Object objeto) throws ConversorException {
        return objeto.toString();
    }

    @Override
    public Object getAsObject(String valor) throws ConversorException {
        return Boolean.parseBoolean(valor);
    }
    
}
