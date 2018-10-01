package ca.crystalshard.domain;

public interface WhereClause {
    String getLeftSide();
    String getOperator();
    String getRightSide();
}
