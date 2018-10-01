package ca.crystalshard.domain;

public interface Selectable<T> extends Queryable<T> {
    Sourceable<T> select(ColumnDefinition... columns);
}
