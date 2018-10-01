package ca.crystalshard.domain;

public interface Filterable<T> extends Queryable<T> {
    Orderable<T> where(WhereClause... whereClauses);
}
