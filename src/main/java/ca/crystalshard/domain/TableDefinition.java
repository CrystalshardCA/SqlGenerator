package ca.crystalshard.domain;

import java.util.Optional;

public interface TableDefinition {
    String getTableName();
    Optional<String> getTableAlias();
}
