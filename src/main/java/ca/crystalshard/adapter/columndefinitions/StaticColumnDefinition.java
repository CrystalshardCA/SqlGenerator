package ca.crystalshard.adapter.columndefinitions;

import ca.crystalshard.domain.ColumnDefinition;

import java.util.Optional;

public class StaticColumnDefinition implements ColumnDefinition {

    public static StaticColumnDefinition col(String columnName) {
        return new StaticColumnDefinition(null, columnName, null);
    }

    private final String tableName;
    private final String columnName;
    private final String columnAlias;

    public StaticColumnDefinition(String tableName, String columnName, String columnAlias) {
        this.tableName = tableName;
        this.columnName = columnName;
        this.columnAlias = columnAlias;
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
    public Optional<String> getColumnAlias() {
        return Optional.ofNullable(this.columnAlias);
    }
}
