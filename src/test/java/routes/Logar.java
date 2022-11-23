package routes;

import factories.UsuarioDataFactory;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.Assert;

import org.junit.Assert;
import org.junit.Test;
import pojos.Usuario;

import java.io.IOException;
import java.sql.SQLOutput;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

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

    }




}
