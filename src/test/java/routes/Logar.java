package routes;

import factories.UsuarioDataFactory;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Usuario;

import java.io.IOException;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class Logar extends BaseRoutes{

    @Test
    public void postLogar() throws IOException {
        this.setUp();
        String teste =
            given()
                .body(UsuarioDataFactory.criarUsuarioValido())
            .when()
                .post("/signin")
            .then()
                .log()
                    .all()
                .extract()
                    .body().asString();

        System.out.println(teste);
    }

    @Test
    public void postLogarSemSenha() throws IOException {
        this.setUp();
            given()
                .body(UsuarioDataFactory.criarUsuarioSemSenha())
            .when()
                .post("/signin")
            .then()
                .statusCode(401)
                .log()
                    .all();

    }

}
