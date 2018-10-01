package ca.crystalshard.domain;

import java.util.List;

public interface Queryable<T> {
    T first();
    List<T> asList();
}

