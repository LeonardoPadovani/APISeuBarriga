package steps;

import io.cucumber.java.pt.Dado;
import routes.Logar;

import java.io.IOException;

public class logarSteps {


    @Dado("que realize um post na rota signin com o body: {string}")
    public void que_realize_um_post_na_rota_signin_com_o_body(String payload) throws IOException {
        Logar logar = new Logar();
        logar.postLogar(payload);
        System.out.println("testeste");
    }
}
