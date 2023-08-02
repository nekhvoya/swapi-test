package dev.swapi.tests;

import dev.swapi.clients.PlanetClient;
import dev.swapi.models.Planet;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlanetsTest {
    @Test
    public void testNumberOfPlanets() {
        var expectedNumberOfPlanets = 60;

        var planetClient = new PlanetClient();
        var planetResults = planetClient.getResults();
        var planets = planetClient.collectAllResults();

        assertThat(planetResults.getCount()).as("Planet count was incorrect").isEqualTo(expectedNumberOfPlanets);
        assertThat(planets)
                .as("Number of returned planets was incorrect")
                .hasSize(expectedNumberOfPlanets);
    }

    @Test
    public void testDorinData() {
        var expectedPlanet = "Dorin";
        var expectedDiameter = "13400";
        var expectedResidentsNumber = 1;

        var planetClient = new PlanetClient();
        var dorin = planetClient.collectAllResults().stream()
                .filter(planet -> ((Planet) planet).getName().equals(expectedPlanet))
                .findFirst()
                .orElseThrow(() ->
                        new AssertionError(String.format("Planet %s was not found in list of returned planets", expectedPlanet)));

        assertThat(dorin.getDiameter())
                .as("Diameter of planet %s was incorrect", expectedPlanet)
                .isEqualTo(expectedDiameter);
        assertThat(dorin.getResidents())
                .as("Number of residents on planet %s was incorrect", expectedPlanet)
                .hasSize(expectedResidentsNumber);
    }
}
