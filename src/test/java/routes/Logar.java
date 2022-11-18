package routes;

import factories.UsuarioDataFactory;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

import org.junit.Assert;
import org.junit.Test;
import pojos.Usuario;

import java.io.IOException;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class Logar extends BaseRoutes{
Response response;
RequestSpecification req;
ResponseSpecification respec;

    public void postLogar(String payload) throws IOException {
        this.setUp();
             this.response = given()
                .body(UsuarioDataFactory.getUsuario(payload))
            .when()
                .post("/signin")
            .then()
                .assertThat().statusCode(200)
                     .extract().response();
        System.out.println(response.getStatusCode() + "pppppppppppppp");
        System.out.println(response.asString()+ "pppppppppppppp");


    }

    public void validarStatusCode(int statusCode){
        System.out.println(this.response.getStatusCode() + "kkkkkkkkkkkkkkkkk");
        Assert.assertEquals(this.response.getStatusCode(),statusCode);
    }

}
