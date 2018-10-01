package ca.crystalshard.adapter.orderdefinitions;

import ca.crystalshard.domain.OrderDefinition;

import java.util.Optional;

public class StaticOrderDefinition implements OrderDefinition {

    public static StaticOrderDefinition descending(String columnName) {
        return new StaticOrderDefinition(null, columnName, "desc");
    }

    private final String tableName;
    private final String columnName;
    private final String direction;

    private StaticOrderDefinition(String tableName, String columnName, String direction) {
        this.tableName = tableName;
        this.columnName = columnName;
        this.direction = direction;
    }

    @Override
    public Optional<String> getTableName() {
        return Optional.ofNullable(this.tableName);
    }

    @Override
    public String getColumnName() {
        return this.columnName;
    }

    @Override
    public String getDirection() {
        return this.direction;
    }
}
