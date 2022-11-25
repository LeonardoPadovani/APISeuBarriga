#language: pt

@regressao
Funcionalidade: POST - Rota Signin

    Esquema do Cenario: POST - Logar com dois usuários válidos
    Dado que realize um post na rota signin com o body: "<payload>"
    Quando verifico o status code: <code>
    Então verifico o body da resposta: "<payload>"
        Exemplos:
        |payload            |code|
        |usuario valido um  |200 |
        |usuario valido dois|200 |


    Esquema do Cenario: POST - Logar com dois usuários inválidos: um sem email e o outro sem senha
        Dado que realize um post na rota signin com o body: "<payload>"
        Quando verifico o status code: <code>
        Exemplos:
            |payload          |code|
            |usuario sem email|401 |
            |usuario sem senha|401 |

