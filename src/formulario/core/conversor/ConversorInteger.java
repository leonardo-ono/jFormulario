package formulario.core.conversor;

import formulario.core.Conversor;
import formulario.core.ConversorException;

/**
 * Conversor padrão para objeto Integer.
 * 
 * Diferenca eh que no objeto Integer, "" representa null
 * enquanto no primitivo representa 0.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (28/07/2011)
 */
public class ConversorInteger implements Conversor {

    @Override
    public String getAsString(Object objeto) throws ConversorException {
        if (objeto == null) return null;
        return objeto.toString();
    }

    @Override
    public Object getAsObject(String valor) throws ConversorException {
        Integer i = 0;
        if (valor.trim().equals("")) return null;
        try {
            i = Integer.valueOf(valor);
        }
        catch (Exception ex) {
            throw new ConversorException("Valor \"" + valor + "\" é invalido !");
        }
        return i;
    }
    
}
