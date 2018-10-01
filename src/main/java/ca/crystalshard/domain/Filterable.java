package ca.crystalshard.domain;

public interface Filterable extends Queryable {
    Orderable where(WhereClause... whereClauses);
}
