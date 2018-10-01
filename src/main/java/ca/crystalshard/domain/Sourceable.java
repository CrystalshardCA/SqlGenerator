package ca.crystalshard.domain;

public interface Sourceable<T> extends Queryable<T> {
    Filterable<T> from(TableDefinition... tables);
}
