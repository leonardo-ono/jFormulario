package formulario.core;

import formulario.core.annotation.Campo_;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe Campo.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (26/07/2011)
 */
public class Campo { 

    private String nome;
    private Object entidade;
    private String nomeDeExibicao;
    protected Map<String, String> parametros;
    private List<Componente> componentes;
    private Formulario formulario;
    private Campo_ campo_;
    private Field field;

    public Campo() {
        componentes = new ArrayList<Componente>();
        parametros = new HashMap<String, String>();
    }
    
    public Campo(Formulario formulario, String nome
            , String nomeDeExibicao, Object entidade) {
        
        this.formulario = formulario;
        this.nome = nome;
        this.nomeDeExibicao = nomeDeExibicao;
        this.entidade = entidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Object getEntidade() {
        return entidade;
    }

    public void setEntidade(Object entidade) {
        this.entidade = entidade;
    }

    public String getNomeDeExibicao() {
        return nomeDeExibicao;
    }

    public void setNomeDeExibicao(String nomeDeExibicao) {
        this.nomeDeExibicao = nomeDeExibicao;
    }

    public Object getValor() {
        Object valor;
        try {
            valor = field.get(entidade);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return valor;
    }

    public void setValor(Object valor) {
        try {
            field.set(entidade, valor);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        
        // TODO se for o mesmo valor nao atualizar
        // Avisa todos componentes associados que este modelo foi atualizado
        for (Componente componente : componentes) {
            componente.valorDoModelFoiAlterado();
        }
    }

    public Map<String, String> getParametros() {
        return parametros;
    }

    public void setParametros(Map<String, String> parametros) {
        this.parametros = parametros;
    }

    public List<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }
    
    public Componente getComponente() {
        for (Componente componente : componentes) {
            if (componente.getParaFormulariosDoTipo()
                .contains(formulario.getTipo())
                || ( componente.getParaFormulariosDoTipo().isEmpty() 
                    && formulario.getTipo().equals(""))) return componente;
        }
        return null;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public Campo_ getCampo_() {
        return campo_;
    }

    public void setCampo_(Campo_ campo_) {
        this.campo_ = campo_;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "Campo{" + "nome=" + nome + ", nomeDeExibicao=" 
                + nomeDeExibicao + ", entidade=" + entidade 
                + ", parametros=" + parametros + ", componente="
                + getComponente() + ", componentes=" 
                + componentes + '}';
    }
    
}
