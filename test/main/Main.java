package main;

import formulario.core.Campo;
import formulario.core.Formulario;

/**
 * Classe Main para teste.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 * @since 1.00.00 (26/07/2011)
 */
public class Main {
    
    public static final String TODOS = "";
    public static final String CADASTRO_DE_CLIENTE = "CADASTRO_DE_CLIENTE";
    public static final String EMISSAO_DE_COMANDA_DE_SAIDA = "EMISSAO_DE_COMANDA_DE_SAIDA";
    
    public static final String NOVO = "NOVO";
    public static final String ALTERACAO = "ALTERACAO";
    public static final String CONSULTA = "CONSULTA";

    public static void main(String[] args) { 

        Cliente cliente = new Cliente();
        Formulario formulario = new Formulario(TODOS, cliente, NOVO);
        
        formulario.setTipo(NOVO);
        for (Campo campo : formulario.getCampos()) {
            System.out.println("-> " + campo);
        }

        System.out.println("---- ");

        formulario.setTipo(CONSULTA);
        for (Campo campo : formulario.getCampos()) {
            System.out.println("-> " + campo);
        }
        
    }

}
