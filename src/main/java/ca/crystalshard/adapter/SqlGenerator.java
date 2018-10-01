package ca.crystalshard.adapter;

import ca.crystalshard.domain.ColumnDefinition;
import ca.crystalshard.domain.Filterable;
import ca.crystalshard.domain.OrderDefinition;
import ca.crystalshard.domain.Orderable;
import ca.crystalshard.domain.Queryable;
import ca.crystalshard.domain.Selectable;
import ca.crystalshard.domain.Sourceable;
import ca.crystalshard.domain.TableDefinition;
import ca.crystalshard.domain.WhereClause;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SqlGenerator implements Selectable, Sourceable, Filterable, Orderable {

    private final List<ColumnDefinition> columnDefinitions;
    private final List<TableDefinition> tableDefinitions;
    private final List<WhereClause> whereClauses;
    private final List<OrderDefinition> orderDefinitions;

    public SqlGenerator() {
        columnDefinitions = new ArrayList<>();
        tableDefinitions = new ArrayList<>();
        whereClauses = new ArrayList<>();
        orderDefinitions = new ArrayList<>();
    }

    @Override
    public String getSql() {
        StringBuilder sb = new StringBuilder();
        sb.append(getSelect());
        return sb.toString().trim();
    }

    private String getSelect() {
        return String.format("SELECT %s ", String.join(", ", columnDefinitions.stream().map(ColumnDefinition::getStringRepresentation).collect(Collectors.toList())));
    }

    @Override
    public Sourceable select(ColumnDefinition... columns) {
        columnDefinitions.addAll(Arrays.asList(columns));
        return this;
    }

    @Override
    public Filterable from(TableDefinition... tables) {
        tableDefinitions.addAll(Arrays.asList(tables));
        return this;
    }

    @Override
    public Orderable where(WhereClause... whereClauses) {
        this.whereClauses.addAll(Arrays.asList(whereClauses));
        return this;
    }

    @Override
    public Queryable orderby(OrderDefinition... orderDefinitions) {
        this.orderDefinitions.addAll(Arrays.asList(orderDefinitions));
        return this;
    }
}
