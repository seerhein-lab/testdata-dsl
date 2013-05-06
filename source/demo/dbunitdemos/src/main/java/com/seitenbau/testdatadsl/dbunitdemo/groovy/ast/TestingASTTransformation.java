package com.seitenbau.testdatadsl.dbunitdemo.groovy.ast;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.ConstructorNode;
import org.codehaus.groovy.ast.FieldNode;
import org.codehaus.groovy.ast.GroovyClassVisitor;
import org.codehaus.groovy.ast.GroovyCodeVisitor;
import org.codehaus.groovy.ast.MethodNode;
import org.codehaus.groovy.ast.ModuleNode;
import org.codehaus.groovy.ast.PropertyNode;
import org.codehaus.groovy.ast.expr.ArgumentListExpression;
import org.codehaus.groovy.ast.expr.ArrayExpression;
import org.codehaus.groovy.ast.expr.AttributeExpression;
import org.codehaus.groovy.ast.expr.BinaryExpression;
import org.codehaus.groovy.ast.expr.BitwiseNegationExpression;
import org.codehaus.groovy.ast.expr.BooleanExpression;
import org.codehaus.groovy.ast.expr.CastExpression;
import org.codehaus.groovy.ast.expr.ClassExpression;
import org.codehaus.groovy.ast.expr.ClosureExpression;
import org.codehaus.groovy.ast.expr.ClosureListExpression;
import org.codehaus.groovy.ast.expr.ConstantExpression;
import org.codehaus.groovy.ast.expr.ConstructorCallExpression;
import org.codehaus.groovy.ast.expr.DeclarationExpression;
import org.codehaus.groovy.ast.expr.ElvisOperatorExpression;
import org.codehaus.groovy.ast.expr.Expression;
import org.codehaus.groovy.ast.expr.FieldExpression;
import org.codehaus.groovy.ast.expr.GStringExpression;
import org.codehaus.groovy.ast.expr.ListExpression;
import org.codehaus.groovy.ast.expr.MapEntryExpression;
import org.codehaus.groovy.ast.expr.MapExpression;
import org.codehaus.groovy.ast.expr.MethodCallExpression;
import org.codehaus.groovy.ast.expr.MethodPointerExpression;
import org.codehaus.groovy.ast.expr.NotExpression;
import org.codehaus.groovy.ast.expr.PostfixExpression;
import org.codehaus.groovy.ast.expr.PrefixExpression;
import org.codehaus.groovy.ast.expr.PropertyExpression;
import org.codehaus.groovy.ast.expr.RangeExpression;
import org.codehaus.groovy.ast.expr.SpreadExpression;
import org.codehaus.groovy.ast.expr.SpreadMapExpression;
import org.codehaus.groovy.ast.expr.StaticMethodCallExpression;
import org.codehaus.groovy.ast.expr.TernaryExpression;
import org.codehaus.groovy.ast.expr.TupleExpression;
import org.codehaus.groovy.ast.expr.UnaryMinusExpression;
import org.codehaus.groovy.ast.expr.UnaryPlusExpression;
import org.codehaus.groovy.ast.expr.VariableExpression;
import org.codehaus.groovy.ast.stmt.AssertStatement;
import org.codehaus.groovy.ast.stmt.BlockStatement;
import org.codehaus.groovy.ast.stmt.BreakStatement;
import org.codehaus.groovy.ast.stmt.CaseStatement;
import org.codehaus.groovy.ast.stmt.CatchStatement;
import org.codehaus.groovy.ast.stmt.ContinueStatement;
import org.codehaus.groovy.ast.stmt.DoWhileStatement;
import org.codehaus.groovy.ast.stmt.ExpressionStatement;
import org.codehaus.groovy.ast.stmt.ForStatement;
import org.codehaus.groovy.ast.stmt.IfStatement;
import org.codehaus.groovy.ast.stmt.ReturnStatement;
import org.codehaus.groovy.ast.stmt.Statement;
import org.codehaus.groovy.ast.stmt.SwitchStatement;
import org.codehaus.groovy.ast.stmt.SynchronizedStatement;
import org.codehaus.groovy.ast.stmt.ThrowStatement;
import org.codehaus.groovy.ast.stmt.TryCatchStatement;
import org.codehaus.groovy.ast.stmt.WhileStatement;
import org.codehaus.groovy.classgen.BytecodeExpression;
import org.codehaus.groovy.control.CompilePhase;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.syntax.Types;
import org.codehaus.groovy.transform.ASTTransformation;
import org.codehaus.groovy.transform.GroovyASTTransformation;

@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
public class TestingASTTransformation implements ASTTransformation {
	
	private final Map<String, List<List<ColumnElement>>> expressions;
	private List<List<ColumnElement>> activeTable;
	private int tableColumnCount;
  //private GroovyCodeVisitor visitor = new Visitor();
	
	public TestingASTTransformation() {
		expressions = new HashMap<String, List<List<ColumnElement>>>();
	}

	public void visit(ASTNode[] nodes, SourceUnit source) {
	  try {
  	  if (nodes != null) {
  			for (ASTNode node : nodes) {
  				if (node instanceof ModuleNode) {
  				  //ModuleNode moduleNode = (ModuleNode)node;
  				  //moduleNode.visit(visitor);
  					handleModuleNode((ModuleNode) node);
  				//	node.v
  				}
  			}
  			
  			for (Entry<String, List<List<ColumnElement>>> entry : expressions.entrySet()) {
  				System.out.println("\nTabelle: " + entry.getKey());
  				for (List<ColumnElement> list : entry.getValue()) {
  					for (ColumnElement e : list) {
  						System.out.print(e + " | ");
  					}
  					System.out.println();
  				}
  			}
  		}
	  }
	  catch (Exception e) {
	    // TODO NM improve
	    // incompatible groovy script
	  }
	}

	private void handleModuleNode(ModuleNode node) {
		for (ClassNode classNode : node.getClasses()) {
			handleClassNode(classNode);
		}
	}
	
	private void handleClassNode(ClassNode node) {
		node.visitContents(new GroovyClassVisitor() {

			public void visitClass(ClassNode node) {
			}

			public void visitConstructor(ConstructorNode node) {
			}

			public void visitField(FieldNode node) {
			}

			public void visitMethod(MethodNode node) {
				if ("run".equals(node.getName())) {
					handleStatement(node.getCode());
				}
			}

			public void visitProperty(PropertyNode node) {
			}
			
		});
	}
	
	private void handleStatement(Statement statement) {
		if (statement instanceof BlockStatement) {
			handleBlockStatement((BlockStatement)statement);
		}
		else if (statement instanceof ExpressionStatement) {
			if (statement.getStatementLabel() != null) {
				final String label = statement.getStatementLabel();
				activeTable = expressions.get(label);
				if (activeTable == null) {
					activeTable = new LinkedList<List<ColumnElement>>();
					expressions.put(label, activeTable);
				}
			}
			handleExpression(((ExpressionStatement)statement).getExpression());
		}
	}

	private void handleExpression(Expression expression) {
		if (activeTable == null) {
			throw new IllegalStateException("No table selected");
		}

		List<ColumnElement> list = new LinkedList<ColumnElement>();
		getColumns(expression, list);
		if (activeTable.size() > 0) {
			if (tableColumnCount != list.size()) {
				throw new IllegalStateException("Columns do not match");
			}
		} else {
			tableColumnCount = list.size();
		}
		activeTable.add(list);
	}
	
	private void getColumns(Expression expression, List<ColumnElement> list) {
		if (expression instanceof BinaryExpression) {
			BinaryExpression be = (BinaryExpression)expression;
			
			if (be.getOperation().getType() == Types.DOUBLE_PIPE ||
			    be.getOperation().getType() == Types.PIPE) {
				getColumns(be.getLeftExpression(), list);
				getColumns(be.getRightExpression(), list);
			} else if (be.getOperation().getType() == Types.PLUS) {
				final List<VariableElement> variableList = new LinkedList<VariableElement>();
				getVariableElements(be, variableList);
				list.add(new VariableListElement(variableList));
			}
		} else if (expression instanceof ConstantExpression) {
			ConstantExpression ce = (ConstantExpression)expression;
			list.add(new ValueElement(ce.getValue()));
		} else if (expression instanceof VariableExpression) {
			VariableExpression ve = (VariableExpression)expression;
			if (ve.getName().equals("_")) {
				list.add(new EmptyElement());
			} else {
				list.add(new VariableElement(ve.getName()));
			}
		}
	}

	private void getVariableElements(BinaryExpression expression, List<VariableElement> list) {
		if (expression.getOperation().getType() != Types.PLUS) {
			return;
		}

		addVariableExpression(expression.getLeftExpression(), list);
		addVariableExpression(expression.getRightExpression(), list);
	}
	
	private void addVariableExpression(Expression expression,
			List<VariableElement> list) {
		if (expression instanceof BinaryExpression) {
			getVariableElements((BinaryExpression) expression, list);
		} else if (expression instanceof VariableExpression) {
			VariableExpression ve = (VariableExpression)expression;
			list.add(new VariableElement(ve.getName()));
		}
	}

	private void handleBlockStatement(BlockStatement blockStatement) {
		for (Statement statement : blockStatement.getStatements()) {
			handleStatement(statement);
		}
	}
	
	private class Visitor implements GroovyCodeVisitor {

    public void visitBlockStatement(BlockStatement statement)
    {
      System.out.println("visit");
    }

    public void visitForLoop(ForStatement forLoop)
    {
      System.out.println("visit");
    }

    public void visitWhileLoop(WhileStatement loop)
    {
      System.out.println("visit");
    }

    public void visitDoWhileLoop(DoWhileStatement loop)
    {
      System.out.println("visit");
    }

    public void visitIfElse(IfStatement ifElse)
    {
      System.out.println("visit");
    }

    public void visitExpressionStatement(ExpressionStatement statement)
    {
     System.out.println("ExpressionStatement: " + statement); 
    }

    public void visitReturnStatement(ReturnStatement statement)
    {
      System.out.println("visit");
    }

    public void visitAssertStatement(AssertStatement statement)
    {
      System.out.println("visit");
    }

    public void visitTryCatchFinally(TryCatchStatement finally1)
    {
      System.out.println("visit");
    }

    public void visitSwitch(SwitchStatement statement)
    {
      System.out.println("visit");
    }

    public void visitCaseStatement(CaseStatement statement)
    {
      System.out.println("visit");
    }

    public void visitBreakStatement(BreakStatement statement)
    {
      System.out.println("visit");
    }

    public void visitContinueStatement(ContinueStatement statement)
    {
      System.out.println("visit");
    }

    public void visitThrowStatement(ThrowStatement statement)
    {
      System.out.println("visit");
    }

    public void visitSynchronizedStatement(SynchronizedStatement statement)
    {
      System.out.println("visit");
    }

    public void visitCatchStatement(CatchStatement statement)
    {
      System.out.println("visit");
    }

    public void visitMethodCallExpression(MethodCallExpression call)
    {
      System.out.println("visit");
    }

    public void visitStaticMethodCallExpression(StaticMethodCallExpression expression)
    {
      System.out.println("visit");
    }

    public void visitConstructorCallExpression(ConstructorCallExpression expression)
    {
      System.out.println("visit");
    }

    public void visitTernaryExpression(TernaryExpression expression)
    {
      System.out.println("visit");
    }

    public void visitShortTernaryExpression(ElvisOperatorExpression expression)
    {
      System.out.println("visit");
    }

    public void visitBinaryExpression(BinaryExpression expression)
    {
      System.out.println("BinaryExpression: " + expression);
    }

    public void visitPrefixExpression(PrefixExpression expression)
    {
      System.out.println("visit");
    }

    public void visitPostfixExpression(PostfixExpression expression)
    {
      System.out.println("visit");
    }

    public void visitBooleanExpression(BooleanExpression expression)
    {
      System.out.println("visit");
    }

    public void visitClosureExpression(ClosureExpression expression)
    {
      System.out.println("ClosureExpression: " + expression);
    }

    public void visitTupleExpression(TupleExpression expression)
    {
      System.out.println("visit");
    }

    public void visitMapExpression(MapExpression expression)
    {
      System.out.println("visit");
    }

    public void visitMapEntryExpression(MapEntryExpression expression)
    {
      System.out.println("visit");
    }

    public void visitListExpression(ListExpression expression)
    {
      System.out.println("visit");
    }

    public void visitRangeExpression(RangeExpression expression)
    {
      System.out.println("visit");
    }

    public void visitPropertyExpression(PropertyExpression expression)
    {
      System.out.println("visit");
    }

    public void visitAttributeExpression(AttributeExpression attributeExpression)
    {
      System.out.println("visit");
    }

    public void visitFieldExpression(FieldExpression expression)
    {
      System.out.println("visit");
    }

    public void visitMethodPointerExpression(MethodPointerExpression expression)
    {
      System.out.println("visit");
    }

    public void visitConstantExpression(ConstantExpression expression)
    {
      System.out.println("visit");
    }

    public void visitClassExpression(ClassExpression expression)
    {
      System.out.println("visit");
    }

    public void visitVariableExpression(VariableExpression expression)
    {
      System.out.println("visit");
    }

    public void visitDeclarationExpression(DeclarationExpression expression)
    {
      System.out.println("visit");
    }

    public void visitGStringExpression(GStringExpression expression)
    {
      System.out.println("visit");
    }

    public void visitArrayExpression(ArrayExpression expression)
    {
      System.out.println("visit");
    }

    public void visitSpreadExpression(SpreadExpression expression)
    {
      System.out.println("visit");
    }

    public void visitSpreadMapExpression(SpreadMapExpression expression)
    {
      System.out.println("visit");
    }

    public void visitNotExpression(NotExpression expression)
    {
      System.out.println("visit");
    }

    public void visitUnaryMinusExpression(UnaryMinusExpression expression)
    {
      System.out.println("visit");
    }

    public void visitUnaryPlusExpression(UnaryPlusExpression expression)
    {
      System.out.println("visit");
    }

    public void visitBitwiseNegationExpression(BitwiseNegationExpression expression)
    {
      System.out.println("visit");
    }

    public void visitCastExpression(CastExpression expression)
    {
      System.out.println("visit");
    }

    public void visitArgumentlistExpression(ArgumentListExpression expression)
    {
      System.out.println("visit");
    }

    public void visitClosureListExpression(ClosureListExpression closureListExpression)
    {
      System.out.println("visit");
    }

    public void visitBytecodeExpression(BytecodeExpression expression)
    {
      System.out.println("visit");
    }
	  
	}
}
