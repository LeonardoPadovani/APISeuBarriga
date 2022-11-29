package steps;

import io.cucumber.java.hu.De;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.Test;
import routes.Logar;

import java.io.IOException;

public class logarSteps {
    Logar logar = new Logar();


    @Dado("que realize um post na rota signin com o body: {string}")
    public void que_realize_um_post_na_rota_signin_com_o_body(String payload) throws IOException {
        logar.postLogar(payload);
    }

    @Quando("verifico o status code: {int}")
    public void verifico_o_status_code(Integer code) {
        logar.validarStatusCode(code);
    }

    @Entao("verifico o body da resposta: {string}")
    public void verifico_o_body_da_resposta(String payload) throws IOException {
        logar.validarBodyResponse(payload);
    }

}
