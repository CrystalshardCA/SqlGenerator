package ca.crystalshard.domain;

public interface Selectable extends Queryable {
    Sourceable select(ColumnDefinition... columns);
}
