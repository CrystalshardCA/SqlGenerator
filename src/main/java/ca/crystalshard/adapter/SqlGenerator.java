package ca.crystalshard.adapter;

import ca.crystalshard.domain.ColumnDefinition;
import ca.crystalshard.domain.Selectable;
import ca.crystalshard.domain.Sourceable;

public class SqlGenerator implements Selectable {

    @Override
    public Sourceable select(ColumnDefinition... columns) {
        return null;
    }

    @Override
    public String getSql() {
        return null;
    }
}
