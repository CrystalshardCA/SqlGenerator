package ca.crystalshard.domain;

public interface Orderable extends Queryable {
    Queryable orderby(OrderDefinition... orderDefinitions);
}
