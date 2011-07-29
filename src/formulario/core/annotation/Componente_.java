package formulario.core.annotation;

import formulario.core.Componente;
import formulario.core.Conversor;
import formulario.core.Validador;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Anotação Componente.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (26/07/2011)
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Componente_ {
    
    public String[] paraFormulariosDoTipo() default {};
    public Class<? extends Componente> classe();
    public Class<? extends Conversor> classeDeConversor() default Conversor.class;
    public Class<? extends Validador> classeDeValidador() default Validador.class;
    public boolean desabilitado() default false;
    public boolean visivel() default true;
    public Parametro_[] parametros() default {};
    
}
