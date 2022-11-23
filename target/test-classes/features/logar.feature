#language: pt

@regressao
Funcionalidade: Administração

    Esquema do Cenario: POST - Logar
    Dado que realize um post na rota signin com o body: "<payload>"
    Quando verifico o status code: <code>
    Então verifico o body da resposta: "<bodyResposta>"
        Exemplos:
        |payload       |code|bodyResposta  |
        |usuario valido|200 |usuario valido|


    Esquema do Cenario: POST - Login inválido
        Dado que realize um post na rota signin com o body: "<payload>"
        Quando verifico o status code: <code>
        Exemplos:
            |payload          |code|
            |usuario sem senha|401 |

