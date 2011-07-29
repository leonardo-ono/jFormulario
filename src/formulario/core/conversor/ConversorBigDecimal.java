package formulario.core.conversor;

import formulario.core.Conversor;
import formulario.core.ConversorException;
import java.math.BigDecimal;

/**
 *
 * @author leo
 */
public class ConversorBigDecimal implements Conversor {

    @Override
    public String getAsString(Object objeto) throws ConversorException {
        if (objeto == null) return "";
        BigDecimal valor = (BigDecimal) objeto;
        String valorEmString 
                = valor.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
        
        valorEmString = valorEmString.replace(".", ",");
        return valorEmString;
    }

    @Override
    public Object getAsObject(String valor) throws ConversorException {
        valor = valor.replace(".", "");
        valor = valor.replace(",", ".");
        if (valor == null || valor.trim().equals("")) return null;
        BigDecimal v = null;
        try {
            v = new BigDecimal(valor);
        }
        catch (Exception ex) {
            throw new ConversorException(
                    "Valor \"" + valor + "\" é invalido !");
        }
        return v;
    }
    
}
