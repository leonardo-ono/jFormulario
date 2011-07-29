package formulario.core;

/**
 * Interface para conversor.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (27/07/2011)
 */
public interface Conversor {

    public abstract String getAsString(Object objeto) throws ConversorException;
    public abstract Object getAsObject(String valor) throws ConversorException;
    
}

/*
 *             // --- AQUI VIRIA OS CONVERSORES (STRING)->(OBJ TIPO CORRETO)
            Object v = null;
            Class c = campo.getField().getType();
            if (c.equals(long.class)) {
                try {
                    v = Long.parseLong(campo.getComponente().getValor());
                } catch (Exception ex) {
                    v = 0;
                }
            }
            if (c.equals(String.class)) {
                try {
                    v = campo.getComponente().getValor().toString();
                } catch (Exception ex) {
                    v = "";
                }
            }
            if (c.equals(boolean.class)) {
                try {
                    v = Boolean.valueOf(campo.getComponente().getValor().toString());
                } catch (Exception ex) {
                    v = false;
                }
            }

 */