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
import org.codehaus.groovy.ast.MethodNode;
import org.codehaus.groovy.ast.ModuleNode;
import org.codehaus.groovy.ast.PropertyNode;
import org.codehaus.groovy.ast.expr.BinaryExpression;
import org.codehaus.groovy.ast.expr.ConstantExpression;
import org.codehaus.groovy.ast.expr.Expression;
import org.codehaus.groovy.ast.expr.VariableExpression;
import org.codehaus.groovy.ast.stmt.BlockStatement;
import org.codehaus.groovy.ast.stmt.ExpressionStatement;
import org.codehaus.groovy.ast.stmt.Statement;
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
	
	public TestingASTTransformation() {
		expressions = new HashMap<String, List<List<ColumnElement>>>();
	}

	public void visit(ASTNode[] nodes, SourceUnit source) {
		if (nodes != null) {
			for (ASTNode node : nodes) {
				if (node instanceof ModuleNode) {
					//handleModuleNode((ModuleNode) node);
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
}
