package ca.crystalshard.domain;

import java.util.Optional;

public interface OrderDefinition {
    Optional<String> getTableName();
    String getColumnName();
    String getDirection();
}
