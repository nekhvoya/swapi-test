package dev.swapi.clients;

import dev.swapi.config.Configuration;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;

/**
 * Base Api Client, sets initial configurations for api requests.
 */
class BaseApiClient {
    protected final String apiUrl;
    protected final RequestSpecification requestSpecification;

    public BaseApiClient() {
        var configuration = ConfigFactory.create(Configuration.class);
        this.apiUrl = configuration.apiUrl();
        requestSpecification = RestAssured.given()
                .header("Content-Type", "application/json")
                .filter(new RequestLoggingFilter(LogDetail.URI))
                .filter(new RequestLoggingFilter(LogDetail.METHOD))
                .filter(new RequestLoggingFilter(LogDetail.HEADERS))
                .filter(new RequestLoggingFilter(LogDetail.BODY))
                .filter(new ResponseLoggingFilter(LogDetail.HEADERS))
                .filter(new ResponseLoggingFilter(LogDetail.BODY));
    }
}
