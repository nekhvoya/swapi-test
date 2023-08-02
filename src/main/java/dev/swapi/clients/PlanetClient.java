package dev.swapi.clients;

import dev.swapi.models.Planet;
import dev.swapi.models.Results;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

/**
 * Client for interaction with the "/planets" endpoint
 */
public class PlanetClient extends BaseApiClient implements ResultsCollector<Planet> {

    @Override
    public Results<Planet> getResults() {
        return getResults(apiUrl + "planets/");
    }

    @SuppressWarnings(value = "all")
    @Override
    public Results<Planet> getResults(String url) {
        return RestAssured
                .given(requestSpecification)
                .header("Content-Type", "application/json")
                .when()
                .get(url)
                .then()
                .extract().as(new TypeRef<Results<Planet>>() {});
    }
}
