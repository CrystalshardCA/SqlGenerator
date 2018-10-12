package ca.crystalshard.domain;

import java.util.Optional;

public interface TableDefinition {
    String getTableName();

    Optional<String> getTableAlias();

    String getStringRepresentation();

    TableDefinition as(String alias);
}
