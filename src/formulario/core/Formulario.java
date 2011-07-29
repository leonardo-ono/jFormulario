package formulario.core;

import formulario.core.annotation.Campo_;
import formulario.core.annotation.Componente_;
import formulario.core.annotation.Parametro_;
import formulario.core.conversor.ConversorBigDecimal;
import formulario.core.conversor.ConversorBoolean;
import formulario.core.conversor.ConversorBooleanPrim;
import formulario.core.conversor.ConversorDate;
import formulario.core.conversor.ConversorInt;
import formulario.core.conversor.ConversorInteger;
import formulario.core.conversor.ConversorLong;
import formulario.core.conversor.ConversorShort;
import formulario.core.conversor.ConversorShortPrim;
import formulario.core.conversor.ConversorString;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe Formulario.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (26/07/2011)
 */
public class Formulario extends Componente {

    private String id;
    private Object entidade;
    private String tipo;
    private List<Campo> campos;

    public Formulario(String id, Object entidade, String tipo) {
        if (tipo == null) {
            throw new NullPointerException("tipo nao pode ser null !");
        }

        this.id = id;
        this.tipo = tipo;
        this.entidade = entidade;
        campos = new ArrayList<Campo>();
        extrairTodosCamposDaEntidade();
    }

    public Object getEntidade() {
        return entidade;
    }

    public void setEntidade(Object entidade) {
        this.entidade = entidade;
    }

    public String getId() {
        return id;
    }

    // Nao adianta ter um setId, ja que todo processamento ocorre no construtor
    //public void setId(String id) {
    //    this.id = id;
    //}
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Campo> getCampos() {
        return campos;
    }

    public void setCampos(List<Campo> campos) {
        this.campos = campos;
    }

    private void extrairTodosCamposDaEntidade() {
        Field[] fields = entidade.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (!(annotation instanceof Campo_)) {
                    for (Annotation a : annotation.annotationType().getDeclaredAnnotations()) {

                        if (a instanceof Campo_) {
                            annotation = a;
                        }
                    }
                }

                if (annotation instanceof Campo_) {
                    Campo_ campo_ = (Campo_) annotation;

                    // Obtem somente os campos deste formulario
                    if (!campo_.idDoFormulario().equals(id)) {
                        continue;
                    }

                    Campo campo = new Campo();
                    campo.setFormulario(this);
                    campo.setCampo_(campo_);
                    campo.setNome(field.getName());
                    campo.setNomeDeExibicao(campo_.nomeDeExibicao());
                    campo.setParametros(extrairTodosParametros(campo_));
                    campo.setField(field);
                    campo.setEntidade(entidade);
                    campos.add(campo);

                    for (Componente_ componente_ : campo_.componentes()) {
                        Componente componente;
                        try {
                            System.out.println("-->" + componente_.classe());
                            componente = componente_.classe().newInstance();

                        } catch (Exception ex) {
                            System.out.println("-->" + componente_);
                            throw new RuntimeException(ex);
                        }
                        componente.setCampo(campo);
                        componente.setFormulario(this);
                        componente.setComponente_(componente_);
                        componente.setParaFormulariosDoTipo(Arrays.asList(
                                componente_.paraFormulariosDoTipo()));

                        componente.setParametros(
                                extrairTodosParametros(componente_));

                        // Conversor
                        vincularConversorAoComponente(
                                componente_, componente, field);

                        // Validador
                        vincularValidadorAoComponente(componente_, componente);

                        campo.getComponentes().add(componente);

                        // callback para iniciar o componente
                        // agora que foi construido totalmente
                        componente.init();
                    }
                }
            }
        }
    }

    private void vincularConversorAoComponente(
            Componente_ componente_, Componente componente, Field field) {

        Conversor conversor;
        if (!componente_.classeDeConversor().equals(Conversor.class)) {
            try {
                conversor = componente_.classeDeConversor().newInstance();

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            componente.setConversor(conversor);
        } else {
            // TODO Vincular um conversor padrao
            if (field.getType().equals(short.class)) {
                componente.setConversor(new ConversorShortPrim());
            }
            if (field.getType().equals(Short.class)) {
                componente.setConversor(new ConversorShort());
            }
            if (field.getType().equals(int.class)) {
                componente.setConversor(new ConversorInt());
            }
            if (field.getType().equals(Integer.class)) {
                componente.setConversor(new ConversorInteger());
            }
            if (field.getType().equals(long.class)) {
                componente.setConversor(new ConversorLong());
            }
            if (field.getType().equals(String.class)) {
                componente.setConversor(new ConversorString());
            }
            if (field.getType().equals(boolean.class)) {
                componente.setConversor(new ConversorBooleanPrim());
            }
            if (field.getType().equals(Boolean.class)) {
                componente.setConversor(new ConversorBoolean());
            }
            if (field.getType().equals(BigDecimal.class)) {
                componente.setConversor(new ConversorBigDecimal());
            }
            if (field.getType().equals(Date.class)) {
                componente.setConversor(new ConversorDate());
            }
        }
    }

    private void vincularValidadorAoComponente(
            Componente_ componente_, Componente componente) {

        if (!componente_.classeDeValidador().equals(Validador.class)) {
            Validador validador;
            try {
                validador = componente_.classeDeValidador().newInstance();

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            componente.setValidador(validador);
        } else {
            // TODO Vincular um validador padrao
        }
    }

    private Map<String, String> extrairTodosParametros(Campo_ campo_) {
        Map<String, String> map = new HashMap<String, String>();
        for (Parametro_ parametro_ : campo_.parametros()) {
            map.put(parametro_.nome(), parametro_.valor());
        }
        return map;
    }

    private Map<String, String> extrairTodosParametros(
            Componente_ componente_) {

        Map<String, String> map = new HashMap<String, String>();
        for (Parametro_ parametro_ : componente_.parametros()) {
            map.put(parametro_.nome(), parametro_.valor());
        }
        return map;
    }

    public void atualizarComponente() {
        for (Campo campo : campos) {
            Componente componente = campo.getComponente();
            if (componente == null) {
                continue;
            }
            componente.limparMensagensDeErro();
            Conversor conversor = componente.getConversor();
            Object objeto = campo.getValor();
            String valor = null;
            if (conversor != null) {
                try {
                    valor = conversor.getAsString(objeto);
                } catch (ConversorException ex) {
                    componente.exibirMensagemDeErroDeConversao(ex.getMessage());
                }
            }
            componente.atualizarInterface(valor);
        }
    }

    public void atualizarModel() {
        for (Campo campo : campos) {
            // if (!campo.isValorAtualizavel()) continue;
            Object objeto = campo.getValor();

            Componente componente = campo.getComponente();
            if (componente == null) {
                continue;
            }
            componente.limparMensagensDeErro();
            Conversor conversor = componente.getConversor();
            try {
                if (conversor != null) {
                    objeto = conversor.getAsObject(componente.getValor());
                }
            } catch (ConversorException ex) {
                componente.exibirMensagemDeErroDeConversao(ex.getMessage());
                continue;
            }
            Validador validador = componente.getValidador();
            try {
                componente.validar(objeto);
                if (validador != null) {
                    validador.validar(objeto);
                }
            } catch (ValidadorException ex) {
                componente.exibirMensagemDeErroDeConversao(ex.getMessage());
                continue;
            }
            campo.setValor(objeto);
        }
    }

    @Override
    public String toString() {
        return "Formulario{" + "id=" + id + ", entidade="
                + entidade + ", tipo=" + tipo + ", campos=" + campos + '}';
    }
}
