package com.oracle.tla.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExecutableNode;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.RootNode;

public class TlaRootNode extends RootNode {

  @Child
  private StateGeneratorNode init;

  @Child
  private StateGeneratorNode next;
  
  @Child
  private ExecutableNode invariants;

  public TlaRootNode(
      StatePredicateNode init,
      StatePredicateNode next,
      StatePredicateNode... invariants
  ) {
    super(null);
    this.init = new StateGeneratorNode(init);
    this.next = new StateGeneratorNode(next);
    this.invariants = invariants;
  }

  @Override
  @ExplodeLoop
  public Object execute(VirtualFrame frame) {
    
  }
}
