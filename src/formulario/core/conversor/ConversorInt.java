package formulario.core.conversor;

import formulario.core.Conversor;
import formulario.core.ConversorException;

/**
 * Conversor padrão para primitivo int.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (27/07/2011)
 */
public class ConversorInt implements Conversor {

    @Override
    public String getAsString(Object objeto) throws ConversorException {
        if (objeto == null) return "0";
        return objeto.toString();
    }

    @Override
    public Object getAsObject(String valor) throws ConversorException {
        int i = 0;
        if (valor.trim().equals("")) return i;
        try {
            i = Integer.parseInt(valor);
        }
        catch (Exception ex) {
            throw new ConversorException("Valor \"" + valor + "\" é invalido !");
        }
        return i;
    }
    
}
