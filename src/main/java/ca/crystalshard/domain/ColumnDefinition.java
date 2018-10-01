package ca.crystalshard.domain;

import java.util.Optional;

public interface ColumnDefinition {
    Optional<String> getTableName();
    String getColumnName();
    Optional<String> getColumnAlias();
}
