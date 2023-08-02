package dev.swapi.clients;

import dev.swapi.models.Person;
import dev.swapi.models.Results;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

/**
 * Client for interaction with the "/people" endpoint
 */
public class PeopleClient  extends BaseApiClient implements ResultsCollector<Person> {

    @Override
    public Results<Person> getResults() {
        return getResults(apiUrl + "people/");
    }

    @SuppressWarnings(value = "all")
    @Override
    public Results<Person> getResults(String url) {
        return RestAssured
                .given(requestSpecification)
                .when()
                .get(url)
                .then()
                .extract().as(new TypeRef<Results<Person>>() {});
    }

    public Person getPerson(int id) {
        var url = apiUrl + "people/" + id;
        return RestAssured
                .given(requestSpecification)
                .when()
                .get(url)
                .then()
                .extract().as(Person.class);
    }
}
