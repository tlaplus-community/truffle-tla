package com.oracle.tla.parser;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oracle.tla.parser.Expr.Binary;
import com.oracle.tla.parser.Expr.FnApply;
import com.oracle.tla.parser.Expr.Grouping;
import com.oracle.tla.parser.Expr.Literal;
import com.oracle.tla.parser.Expr.QuantFn;
import com.oracle.tla.parser.Expr.Ternary;
import com.oracle.tla.parser.Expr.Unary;
import com.oracle.tla.parser.Expr.Variable;
import com.oracle.tla.parser.Expr.Variadic;
import com.oracle.tla.parser.Stmt.OpDef;
import com.oracle.tla.parser.Stmt.Print;
import com.oracle.tla.parser.Stmt.VarDecl;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.TruffleLanguage.ParsingRequest;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.strings.TruffleString;

public class TruffleTranslator implements Expr.Visitor<Node>, Stmt.Visitor<Node> {
  
  private final List<Stmt> units;
  
  public TruffleTranslator(ParsingRequest request) {
    String source = new String(request.getSource().getBytes().toByteArray(), StandardCharsets.UTF_8);
    Scanner s = new Scanner(source);
    List<Token> tokens = s.scanTokens();
    Parser p = new Parser(tokens, false);
    this.units = p.parse();
  }

  public Map<TruffleString, RootCallTarget> translate() {
    Map<TruffleString, RootCallTarget> targets = new HashMap<>();
    for (Stmt unit : this.units) {
      if (unit instanceof Stmt.OpDef opdef) {
        String name = opdef.name.lexeme;
        TruffleString str = new TruffleString(name);
      }
    }
    Node[] nodeUnits = this.units.stream().map(unit -> unit.accept(this)).toArray(Node[]::new);
    return null;
  }

  @Override
  public Node visitVarDeclStmt(VarDecl stmt) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Node visitPrintStmt(Print stmt) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Node visitOpDefStmt(OpDef stmt) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Node visitBinaryExpr(Binary expr) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Node visitQuantFnExpr(QuantFn expr) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Node visitFnApplyExpr(FnApply expr) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Node visitGroupingExpr(Grouping expr) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Node visitLiteralExpr(Literal expr) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Node visitVariableExpr(Variable expr) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Node visitUnaryExpr(Unary expr) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Node visitTernaryExpr(Ternary expr) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Node visitVariadicExpr(Variadic expr) {
    // TODO Auto-generated method stub
    return null;
  }
}
