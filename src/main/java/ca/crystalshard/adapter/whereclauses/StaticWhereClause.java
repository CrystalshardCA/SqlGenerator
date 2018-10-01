package ca.crystalshard.adapter.whereclauses;

import ca.crystalshard.domain.WhereClause;

public class StaticWhereClause implements WhereClause {

    public static StaticWhereClause equal(String left, String right) {
        return new StaticWhereClause(left, "=", right);
    }

    private final String leftSide;
    private final String operator;
    private final String rightSide;

    private StaticWhereClause(String leftSide, String operator, String rightSide) {
        this.leftSide = leftSide;
        this.operator = operator;
        this.rightSide = rightSide;
    }

    @Override
    public String getLeftSide() {
        return this.leftSide;
    }

    @Override
    public String getOperator() {
        return this.operator;
    }

    @Override
    public String getRightSide() {
        return this.rightSide;
    }
}
