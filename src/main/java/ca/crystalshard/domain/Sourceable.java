package ca.crystalshard.domain;

public interface Sourceable extends Queryable {
    Filterable from(TableDefinition... tables);
}
