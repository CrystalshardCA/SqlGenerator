package ca.crystalshard.adapter.tabledefinitions;

import ca.crystalshard.domain.TableDefinition;

import java.util.Optional;

public class StaticTableDefinition implements TableDefinition {

    public static StaticTableDefinition tbl(String tableName) {
        return new StaticTableDefinition(tableName, null);
    }

    private final String tableName;
    private final String tableAlias;

    private StaticTableDefinition(String tableName, String tableAlias) {
        this.tableName = tableName;
        this.tableAlias = tableAlias;
    }

    @Override
    public String getTableName() {
        return this.tableName;
    }

    @Override
    public Optional<String> getTableAlias() {
        return Optional.ofNullable(this.tableAlias);
    }
}
