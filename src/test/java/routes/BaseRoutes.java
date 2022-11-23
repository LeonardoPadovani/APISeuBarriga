package routes;

import config.Configuracoes;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.aeonbits.owner.ConfigFactory;


public class BaseRoutes {

    public static RequestSpecification getRequestSpec() {
        Configuracoes configuracoes = ConfigFactory.create(Configuracoes.class);
        return new RequestSpecBuilder()
                .setBaseUri(configuracoes.baseURI())
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }


}
