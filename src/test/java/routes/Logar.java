package routes;

import factories.UsuarioDataFactory;
import io.restassured.response.Response;
import pojos.Usuario;
import java.io.IOException;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class Logar extends BaseRoutes{
Response response;


    public Response postLogar(String payload) throws IOException {
          this.response = given(getRequestSpec())
                .body(UsuarioDataFactory.getUsuario(payload))
            .when()
                .post("/signin")
            .then().spec(getResponseSpec())
                .extract()
                .response();
          return this.response;
    }

    public void validarStatusCode(int statusCodeEsperado){
        assertThat(this.response.getStatusCode(),equalTo(statusCodeEsperado));
    }

    public void validarBodyResponse(String payload){
       Usuario requestUsuario = UsuarioDataFactory.getUsuario(payload);
       Usuario responseUsuario = this.response.as(Usuario.class);
       assertThat(responseUsuario.getNome(),equalTo(requestUsuario.getNome()));
       assertThat(responseUsuario.getId(),equalTo(requestUsuario.getId()));
       assertThat(responseUsuario.getToken(),hasLength(97));
    }




}
