package formulario.core.conversor;

import formulario.core.Conversor;
import formulario.core.ConversorException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Conversor padrão para java.util.Date.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (27/07/2011)
 */
public class ConversorDate implements Conversor {
    
    private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    @Override
    public String getAsString(Object objeto) throws ConversorException {
        if (objeto == null) return "";
        Date valor = (Date) objeto;
        String valorEmString = df.format(valor) ;
        return valorEmString;
    }

    @Override
    public Object getAsObject(String valor) throws ConversorException {
        if (valor == null || valor.trim().equals("")) return null;
        Date d = null;
        try {
            d = df.parse(valor);
        }
        catch (Exception ex) {
            throw new ConversorException(
                    "Valor \"" + valor + "\" é invalido ! Precisa estar no formato DD/MM/AAAA.");
        }
        return d;
    }
    
}
