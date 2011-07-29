package main;

import formulario.core.annotation.Campo_;

/**
 * Classe cliente para testar o framework jFormulario.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (26/07/2011)
 */
public class Cliente {
    
    @IdDoClienteParaGenerico
    @IdDoClienteParaCadastroDeCliente
    @IdDoClienteParaEmissaoDeComandaDeSaida
    @Campo_(nomeDeExibicao="Outro componente")
    private long id;

    @Campo_(nomeDeExibicao="Nome")
    private String nome;
    
    @Campo_(nomeDeExibicao="Idade")
    private int idade;

    public Cliente() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" 
                + nome + ", idade=" + idade + '}';
    }
    
}

