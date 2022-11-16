package routes;

import config.Configuracoes;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Before;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class BaseRoutes {


    public void setUp(){
        Configuracoes configuracoes = ConfigFactory.create(Configuracoes.class);
        baseURI = configuracoes.baseURI();
        //basePath = configuracoes.basePath();

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecification = requestSpecBuilder.build();
        enableLoggingOfRequestAndResponseIfValidationFails();


    }


}
