package com.oracle.tla.nodes;

public class StatePredicateNode extends Node {
  
  @Child
  public TlaExpressionNode predicate;
  
  public StatePredicateNode(TlaExpressionNode predicate) {
    this.predicate = predicate;
  }
}
