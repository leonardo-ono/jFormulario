package formulario.core.conversor;

import formulario.core.Conversor;
import formulario.core.ConversorException;

/**
 * Conversor padrão para objeto Short.
 * 
 * Diferenca eh que no objeto Short, "" representa null
 * enquanto no primitivo representa 0.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (28/07/2011)
 */
public class ConversorShort implements Conversor {

    @Override
    public String getAsString(Object objeto) throws ConversorException {
        if (objeto == null) return null;
        return objeto.toString();
    }

    @Override
    public Object getAsObject(String valor) throws ConversorException {
        Short s = 0;
        if (valor.trim().equals("")) return null;
        try {
            s = Short.valueOf(valor);
        }
        catch (Exception ex) {
            throw new ConversorException("Valor \"" + valor + "\" é invalido !");
        }
        return s;
    }
    
}
