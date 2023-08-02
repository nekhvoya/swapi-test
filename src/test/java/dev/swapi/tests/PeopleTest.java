package dev.swapi.tests;

import dev.swapi.clients.PeopleClient;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PeopleTest {
    @Test
    public void testNumberOfPeople() {
        var expectedNumberOfPeople = 82;

        var peopleClient = new PeopleClient();
        var peopleResults = peopleClient.getResults();
        var people = peopleClient.collectAllResults();

        assertThat(peopleResults.getCount())
                .as("People count was incorrect")
                .isEqualTo(expectedNumberOfPeople);
        assertThat(people)
                .as("Number of returned people was incorrect")
                .hasSize(expectedNumberOfPeople);
    }

    @Test
    public void testFirstPerson() {
        var expectedPerson = "Luke Skywalker";
        var expectedPersonId = 1;

        var peopleClient = new PeopleClient();
        var firstPerson = peopleClient.getPerson(expectedPersonId);

        assertThat(firstPerson.getName())
                .as("First person name was incorrect")
                .isEqualTo(expectedPerson);
    }
}
