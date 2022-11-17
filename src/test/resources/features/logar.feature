#language: pt

@regressao
Funcionalidade: Administração

    Esquema do Cenario: POST - Logar
    Dado que realize um post na rota signin com o body: "<payload>"
        Exemplos:
        |payload                      |
        |criar Usuario Valido Map|
        |criar Usuario Sem Senha Map|


