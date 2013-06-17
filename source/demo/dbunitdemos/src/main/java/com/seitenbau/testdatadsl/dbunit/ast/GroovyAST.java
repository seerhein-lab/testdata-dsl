package com.seitenbau.testdatadsl.dbunit.ast;

import groovy.lang.GroovyShell;

import org.codehaus.groovy.control.CompilerConfiguration;

public class GroovyAST {

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

    System.out.println("=========== CODE ========================");
    System.out.println(CODE);
    System.out.println("=========================================");

    GroovyShell shell = new GroovyShell(config);
    shell.parse(CODE);
  }

}
