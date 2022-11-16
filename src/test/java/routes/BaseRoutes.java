package routes;

import config.Configuracoes;
import org.aeonbits.owner.ConfigFactory;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class BaseRoutes {

    public void setUp(){
        Configuracoes configuracoes = ConfigFactory.create(Configuracoes.class);
        baseURI = configuracoes.baseURI();
        basePath = configuracoes.basePath();


    }


}
