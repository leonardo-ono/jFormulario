package formulario.core.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Anotação Parametro.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (26/07/2011)
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Parametro_ {
    
    public String nome();
    public String valor();
    
}
