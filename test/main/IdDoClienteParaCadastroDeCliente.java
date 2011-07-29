package main;

import static main.Main.CADASTRO_DE_CLIENTE;
import static main.Main.EMISSAO_DE_COMANDA_DE_SAIDA;

import static main.Main.NOVO;
import static main.Main.ALTERACAO;
import static main.Main.CONSULTA;

import formulario.core.annotation.Campo_;
import formulario.core.annotation.Componente_;
import formulario.core.annotation.Parametro_;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Campo_(nomeDeExibicao = "ID do CADASTRO_DE_CLIENTE",
        
        idDoFormulario=CADASTRO_DE_CLIENTE,
        
parametros = {
    @Parametro_(nome = "conversor", valor = "conversor.ConversorInteger")
},

componentes = {
    
    @Componente_(paraFormulariosDoTipo = { NOVO, ALTERACAO },
    classe = MeuComponenteEdicao.class,
    desabilitado = true,
    visivel = true,
    parametros = {
        @Parametro_(nome = "style", valor = "color: red"),
        @Parametro_(nome = "url", valor = "idComponente.xhtml")
    }),
    
    @Componente_(paraFormulariosDoTipo = { CONSULTA },
    classe = MeuComponenteConsulta.class,
    desabilitado = true,
    visivel = true,
    parametros = {
        @Parametro_(nome = "style", valor = "color: red"),
        @Parametro_(nome = "url", valor = "idComponente.xhtml")
    })
        
})
@Retention(RetentionPolicy.RUNTIME)
@interface IdDoClienteParaCadastroDeCliente {
}

//------------------------------------------------------------------------------

@Campo_(nomeDeExibicao = "ID do EMISSAO_DE_COMANDA_DE_SAIDA",
        
        idDoFormulario=EMISSAO_DE_COMANDA_DE_SAIDA,
        
parametros = {
    @Parametro_(nome = "conversor", valor = "conversor.ConversorInteger")
},

componentes = {
    
    @Componente_(paraFormulariosDoTipo = { NOVO, ALTERACAO },
    classe = MeuComponenteConsulta.class,
    desabilitado = true,
    visivel = true,
    parametros = {
        @Parametro_(nome = "style", valor = "color: red"),
        @Parametro_(nome = "url", valor = "idComponente.xhtml")
    }),
    
    @Componente_(paraFormulariosDoTipo = { CONSULTA },
    classe = MeuComponenteConsulta.class,
    desabilitado = true,
    visivel = true,
    parametros = {
        @Parametro_(nome = "style", valor = "color: red"),
        @Parametro_(nome = "url", valor = "idComponente.xhtml")
    })
        
})
@Retention(RetentionPolicy.RUNTIME)
@interface IdDoClienteParaEmissaoDeComandaDeSaida {
}

//------------------------------------------------------------------------------

@Campo_(nomeDeExibicao = "ID do GENERICO",
        
parametros = {
    @Parametro_(nome = "conversor", valor = "conversor.ConversorInteger")
},

componentes = {
    
    @Componente_(paraFormulariosDoTipo = { NOVO, ALTERACAO },
    classe = MeuComponenteConsulta.class,
    desabilitado = true,
    visivel = true,
    parametros = {
        @Parametro_(nome = "style", valor = "color: red"),
        @Parametro_(nome = "url", valor = "idComponente.xhtml")
    }),
    
    @Componente_(paraFormulariosDoTipo = { CONSULTA },
    classe = MeuComponenteConsulta.class,
    desabilitado = true,
    visivel = true,
    parametros = {
        @Parametro_(nome = "style", valor = "color: red"),
        @Parametro_(nome = "url", valor = "idComponente.xhtml")
    })
        
})
@Retention(RetentionPolicy.RUNTIME)
@interface IdDoClienteParaGenerico {
}
