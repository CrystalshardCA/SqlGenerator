package ca.crystalshard;

import ca.crystalshard.adapter.SqlGenerator;
import ca.crystalshard.domain.Selectable;

import static ca.crystalshard.adapter.columndefinitions.StaticColumnDefinition.col;
import static ca.crystalshard.adapter.orderdefinitions.StaticOrderDefinition.descending;
import static ca.crystalshard.adapter.tabledefinitions.StaticTableDefinition.tbl;
import static ca.crystalshard.adapter.whereclauses.StaticWhereClause.equal;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Selectable data = new SqlGenerator();
        String sql = data
                .select(col("one"), col("two"), col("three"))
                .from(tbl("table"))
                .where(equal("one", "42"))
                .orderby(descending("two"))
                .getSql();
    }

}
