package com.seitenbau.testdatadsl.dbunitdemo.groovy;

import groovy.lang.GroovyShell;

import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.customizers.ASTTransformationCustomizer;

public class Groovy {

	private static final String CODE = 
			  "professor:\n"
			+ "REF    || name    | vorname  | titel            | fakultaet    | leitet               | beaufsichtigt\n"
			+ "HAASE  || \"Haase\" | \"Oliver\" | \"Prof. Dr.\"      | \"Informatik\" | VSYS + DPATTERNS + X | P_DPATTERNS\n"
			+ "WAESCH || \"Wäsch\" | \"Jürgen\" | \"Prof. Dr.-Ing.\" | \"Informatik\" | _                    | P_VSYS\n"
			+ "\n" 
			+ "lehrveranstaltung:\n"
			+ "REF       || name                | sws | ects\n"
			+ "VSYS      || \"Verteilte Systeme\" | 4   | 5\n"
			+ "DPATTERNS || \"Design Patterns\"   | 4   | 3\n"
			+ "";

	public static void main(String[] args) {
		CompilerConfiguration config = new CompilerConfiguration();
//		config.addCompilationCustomizers(new ASTTransformationCustomizer(
//				new TestingASTTransformation()));

		// List<ASTNode> nodes = new AstBuilder().buildFromString(CODE);
		// for (ASTNode node : nodes) {
		// System.out.println(node.getText());
		// }
		
		System.out.println("=========== CODE ========================");
		System.out.println(CODE);
		System.out.println("=========================================");

		GroovyShell shell = new GroovyShell(config);
		// shell.evaluate(CODE);
		//shell.parse("class DemoClass { def a = 1; }");
		shell.parse(CODE);
	}

}
