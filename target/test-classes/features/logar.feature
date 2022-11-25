#language: pt

@regressao
Funcionalidade: Administração

    Esquema do Cenario: POST - Logar
    Dado que realize um post na rota signin com o body: "<payload>"
    Quando verifico o status code: <code>
    Então verifico o body da resposta: "<bodyResposta>"
        Exemplos:
        |payload            |code|bodyResposta       |
        |usuario valido um  |200 |usuario valido um  |
        |usuario valido dois|200 |usuario valido dois|


    Esquema do Cenario: POST - Login inválido
        Dado que realize um post na rota signin com o body: "<payload>"
        Quando verifico o status code: <code>
        Exemplos:
            |payload          |code|
            |usuario sem email|401 |
            |usuario sem senha|401 |

