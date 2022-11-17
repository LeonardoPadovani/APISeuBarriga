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

    public void postLogar(String payload) throws IOException {
        this.setUp();
             given()
                .body(UsuarioDataFactory.getUsuario(payload))
            .when()
                .post("/signin")
            .then()
                .statusCode(401)
                .log()
                    .all();

    }

}
