package dev.swapi.clients;

import dev.swapi.models.Results;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

/**
 * Collects iterable api results.
 * @param <T> result type.
 */
public interface ResultsCollector<T> {

    /**
     * Requests the default (first page) response.
     * @return results of the first page.
     */
    Results<T> getResults();

    /**
     * Requests results by the provided page url.
     * @param url url of the page to collect results from.
     * @return results of the requested page.
     */
    Results<T> getResults(String url);

    /**
     * Iterates all available pages and collects results.
     * @return all collected results from all pages.
     */
    default List<T> collectAllResults() {
        var results = getResults();
        var planets = new ArrayList<>(results.getResults());
        int i = 0;
        while (nonNull(results.getNext()) && i++ < 1000) {
            results = getResults(results.getNext());
            planets.addAll(results.getResults());
        }
        return planets;
    };
}
