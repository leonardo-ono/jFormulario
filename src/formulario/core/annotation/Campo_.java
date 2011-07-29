package formulario.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotação Campo.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (26/07/2011)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface Campo_ {
    
    public String idDoFormulario() default "";
    public String nomeDeExibicao();
    public Parametro_[] parametros() default {};
    public Componente_[] componentes() default {};
    
}
