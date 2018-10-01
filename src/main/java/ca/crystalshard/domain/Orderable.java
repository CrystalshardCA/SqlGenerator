package ca.crystalshard.domain;

public interface Orderable<T> extends Queryable<T> {
    Queryable<T> orderby(OrderDefinition... orderDefinitions);
}
