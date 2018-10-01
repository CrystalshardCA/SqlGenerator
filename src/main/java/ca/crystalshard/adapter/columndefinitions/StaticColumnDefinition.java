package ca.crystalshard.adapter.columndefinitions;

import ca.crystalshard.domain.ColumnDefinition;

import java.util.Optional;

public class StaticColumnDefinition implements ColumnDefinition {

    public static StaticColumnDefinition col(String tableName, String columnName) {
        return new StaticColumnDefinition(tableName, columnName, null);
    }

    public static StaticColumnDefinition col(String columnName) {
        return new StaticColumnDefinition(null, columnName, null);
    }

    private final String tableName;
    private final String columnName;
    private String columnAlias;

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

    @Override
    public String getStringRepresentation() {
        StringBuilder sb = new StringBuilder();
        if (getTableName().isPresent()) {
            sb.append(String.format("%s.", this.tableName));
        }
        sb.append(this.columnName);
        if (getColumnAlias().isPresent()) {
            sb.append(String.format(" AS \"%s\"", this.columnAlias));
        }
        return sb.toString();
    }

    public ColumnDefinition as(String alias) {
        this.columnAlias = alias;
        return this;
    }
}
