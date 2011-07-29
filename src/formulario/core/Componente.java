package formulario.core;

import formulario.core.annotation.Componente_;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe abstrata Componente.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (26/07/2011)
 */
public abstract class Componente {

    private Campo campo;
    private List<String> paraFormulariosDoTipo;
    private Boolean visivel = null;
    private Boolean desabilitado = null;
    protected Map<String, String> parametros;
    private Componente_ componente_;
    private Formulario formulario;
    private Conversor conversor;
    private Validador validador;
    
    public Componente() {
        paraFormulariosDoTipo = new ArrayList<String>();
        parametros = new HashMap<String, String>();
    }

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    public List<String> getParaFormulariosDoTipo() {
        return paraFormulariosDoTipo;
    }

    public void setParaFormulariosDoTipo(List<String> paraFormulariosDoTipo) {
        this.paraFormulariosDoTipo = paraFormulariosDoTipo;
    }

    public Map<String, String> getParametros() {
        return parametros;
    }

    public void setParametros(Map<String, String> parametros) {
        this.parametros = parametros;
    }
    public Boolean isDesabilitado() {
        if (desabilitado == null) {
            desabilitado = componente_.desabilitado();
        }
        return desabilitado;
    }

    public void setDesabilitado(Boolean desabilitado) {
        this.desabilitado = desabilitado;
    }

    public Boolean isVisivel() {
        if (visivel == null) {
            visivel = componente_.visivel();
        }
        return visivel;
    }

    public void setVisivel(Boolean visivel) {
        this.visivel = visivel;
    }

    public Componente_ getComponente_() {
        return componente_;
    }

    public void setComponente_(Componente_ componente_) {
        this.componente_ = componente_;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    // Obtem o valor do componente
    public String getValor()  {
        return "";
    }
    
    // para setar o valor no componente
    public void atualizarInterface(String valor) {
    }
    
    // Callback para chamar depois que o componente foi
    // criado totalmente. Nao se pode utilizar o construtor
    public void init() {
    }
    
    public void exibirMensagemDeErroDeConversao(String mensagem) {
    }
    
    public void exibirMensagemDeErroDeValidacao(String mensagem) {
    }
    
    public void limparMensagensDeErro() {
        
    }

    public void validar(Object valor) throws ValidadorException {
        
    }
    
    public Conversor getConversor() {
        return conversor;
    }

    public void setConversor(Conversor conversor) {
        this.conversor = conversor;
    }

    public Validador getValidador() {
        return validador;
    }

    public void setValidador(Validador validador) {
        this.validador = validador;
    }
    
    public void valorDoModelFoiAlterado() {
        
    }
    
    @Override
    public String toString() {
        return "Componente{" + "paraFormulariosDoTipo=" + paraFormulariosDoTipo 
                + ", visivel=" + isVisivel() + ", desabilitado=" 
                + isDesabilitado() + ", parametros=" + parametros 
                + ", componente_=" + componente_ + '}';
    }
    
}
