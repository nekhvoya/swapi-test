package dev.swapi.models;

import lombok.Data;

import java.util.List;

@Data
public class Results<T> {

    private Integer count;
    private String next;
    private String previous;
    private List<T> results;
}
