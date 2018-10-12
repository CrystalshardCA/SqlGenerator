package ca.crystalshard.adapter;

import ca.crystalshard.domain.Selectable;
import org.junit.Ignore;
import org.junit.Test;

import static ca.crystalshard.adapter.columndefinitions.StaticColumnDefinition.col;
import static ca.crystalshard.adapter.orderdefinitions.StaticOrderDefinition.descending;
import static ca.crystalshard.adapter.tabledefinitions.StaticTableDefinition.tbl;
import static ca.crystalshard.adapter.whereclauses.StaticWhereClause.equal;
import static org.junit.Assert.*;

public class MySqlGeneratorTest {

    @Test
    @Ignore
    public void getSql_shouldReturnExpectedSql() {
        Selectable data = new MySqlGenerator();
        String expected = "" +
                "SELECT one, two, three " +
                "FROM table " +
                "WHERE one = 42 " +
                "ORDER BY two DESC";

        String actual = data
                .select(col("one"), col("two"), col("three"))
                .from(tbl("table"))
                .where(equal("one", "42"))
                .orderby(descending("two"))
                .getSql();

        assertEquals(expected, actual);
    }

    @Test
    public void getSql_shouldReturnStar_whenNoListProvided() {
        Selectable data = new MySqlGenerator();
        String expected = "" +
                "SELECT *";

        String actual = data
                .getSql();

        assertEquals(expected, actual);
    }

    @Test
    public void getSql_shouldReturnColumnList() {
        Selectable data = new MySqlGenerator();
        String expected = "" +
                "SELECT one, two, three";

        String actual = data
                .select(col("one"), col("two"), col("three"))
                .getSql();

        assertEquals(expected, actual);
    }

    @Test
    public void getSql_shouldReturnTableNames_whenTableNamesProvided() {
        Selectable data = new MySqlGenerator();
        String expected = "" +
                "SELECT a.one, a.two, a.three";

        String actual = data
                .select(col("a", "one"), col("a", "two"), col("a", "three"))
                .getSql();

        assertEquals(expected, actual);
    }

    @Test
    public void getSql_shouldReturnAliases_whenAliasesProvided() {
        Selectable data = new MySqlGenerator();
        String expected = "" +
                "SELECT one AS \"first\", two AS \"second\", three AS \"third\"";

        String actual = data
                .select(col("one").as("first"), col("two").as("second"), col("three").as("third"))
                .getSql();

        assertEquals(expected, actual);
    }

    @Test
    public void getSql_shouldReturnTables() {
        Selectable data = new MySqlGenerator();
        String expected = "" +
                "SELECT * " +
                "FROM table";

        String actual = data
                .select()
                .from(tbl("table"))
                .getSql();

        assertEquals(expected, actual);
    }

    @Test
    public void getSql_shouldReturnTables_whenMultipleTables() {
        Selectable data = new MySqlGenerator();
        String expected = "" +
                "SELECT * " +
                "FROM table, table2";

        String actual = data
                .select()
                .from(tbl("table"), tbl("table2"))
                .getSql();

        assertEquals(expected, actual);
    }

    @Test
    public void getSql_shouldReturnTableAliases() {
        Selectable data = new MySqlGenerator();
        String expected = "" +
                "SELECT * " +
                "FROM table a, table2 b";

        String actual = data
                .select()
                .from(tbl("table").as("a"), tbl("table2").as("b"))
                .getSql();

        assertEquals(expected, actual);
    }

}