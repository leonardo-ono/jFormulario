package formulario.core.conversor;

import formulario.core.Conversor;
import formulario.core.ConversorException;

/**
 * Conversor padrão para short primitivo.
 * 
 * Diferenca eh que no objeto Short, "" representa null
 * enquanto no primitivo representa 0.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (28/07/2011)
 */
public class ConversorShortPrim implements Conversor {

    @Override
    public String getAsString(Object objeto) throws ConversorException {
        if (objeto == null) return "0";
        return objeto.toString();
    }

    @Override
    public Object getAsObject(String valor) throws ConversorException {
        short s = 0;
        if (valor.trim().equals("")) return s;
        try {
            s = Short.parseShort(valor);
        }
        catch (Exception ex) {
            throw new ConversorException("Valor \"" + valor + "\" é invalido !");
        }
        return s;
    }
    
}
