package com.oracle.tla.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import org.graalvm.collections.UnmodifiableEconomicSet;

public class StateGeneratorNode extends Node {

  @Child
  private StepPredicateNode action;
  
  public StateGeneratorNode(StepPredicateNode action) {
    this.action = action;
  }

  public UnmodifiableEconomicSet<Object[]> execute(VirtualFrame frame) {
    return null;
  }
}