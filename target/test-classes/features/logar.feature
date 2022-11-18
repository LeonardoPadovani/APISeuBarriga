#language: pt

@regressao
Funcionalidade: Administração

    Esquema do Cenario: POST - Logar
    Dado que realize um post na rota signin com o body: "<payload>"
    Quando verifico o status code: <code>
        Exemplos:
        |payload                 |code|
        |criar Usuario Valido Map|200 |



