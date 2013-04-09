package com.seitenbau.testdatadsl.dbunitdemo.dsl1;

import groovy.lang.Binding;
import groovy.lang.ExpandoMetaClass;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.codehaus.groovy.control.CompilerConfiguration;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;

import com.seitenbau.testdatadsl.dbunitdemo.IDataSetProvider;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.BeaufsichtigtTable.RowBuilder_Beaufsichtigt;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.BesuchtTable.RowBuilder_Besucht;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.DBUnitDemoDataSet;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.IsttutorTable.RowBuilder_Isttutor;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.LehrveranstaltungTable.RowBuilder_Lehrveranstaltung;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.ProfessorTable.RowBuilder_Professor;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.PruefungTable.RowBuilder_Pruefung;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.SchreibtTable.RowBuilder_Schreibt;
import com.seitenbau.testdatadsl.dbunitdemo.sbtesting.StudentTable.RowBuilder_Student;

public class GroovyDataSetProvider implements IDataSetProvider {

	private final IDataSet dataset;

	public GroovyDataSetProvider() {
		ExpandoMetaClass.enableGlobally();
		dataset = createDataSet();
	}

	@SuppressWarnings("unchecked")
	private <T> T getValue(Binding binding, Object variable, Class<T> clazz) {
		if (variable instanceof String) {
			final String name = (String) variable;
			return (T) binding.getVariable(name);
		} else {
			return (T) variable;
		}
	}

	private IDataSet createDataSet() {
		final DBUnitDemoDataSet result = new DBUnitDemoDataSet();

		final DslBinding binding = new DslBinding();
		try {
			runDsl("dsl.txt", binding);
		} catch (Exception e) {
			return null;
		}

		for (Professor professor : binding.getProfessoren()) {
			RowBuilder_Professor row = result.table_Professor.insertRow();
			row.nextId();
			row.setName(professor.getName());
			professor.setId(row.getId());

			if (professor.getLeitet() != null) {
				for (Object o : professor.getLeitet()) {
					Lehrveranstaltung lv = getValue(binding, o,
							Lehrveranstaltung.class);

					RowBuilder_Lehrveranstaltung lrow = result.table_Lehrveranstaltung
							.insertRow();
					lrow.nextId();
					lrow.setProfessorId(row.getId());
					lrow.setName(lv.getName());

					lv.setId(lrow.getId());
				}
			}
		}

		for (Student student : binding.getStudenten()) {
			RowBuilder_Student row = result.table_Student.insertRow();
			row.setMatrikelnummer(student.getMatrikelnummer());
			row.setName(student.getName());
		}

		for (Pruefung pruefung : binding.getPruefungen()) {
			RowBuilder_Pruefung row = result.table_Pruefung.insertRow();
			row.nextId();
			row.setTyp(pruefung.getTyp());
			Lehrveranstaltung lv = getValue(binding,
					pruefung.getPrueftStoffVon(), Lehrveranstaltung.class);
			row.setLehrveranstaltungId(lv.getId());

			pruefung.setId(row.getId());
		}

		// Relations
		for (Professor professor : binding.getProfessoren()) {
			if (professor.getBeaufsichtigt() != null) {
				for (Object o : professor.getBeaufsichtigt()) {
					Pruefung pruefung = getValue(binding, o, Pruefung.class);

					RowBuilder_Beaufsichtigt row = result.table_Beaufsichtigt
							.insertRow();
					row.setPruefungId(pruefung.getId());
					row.setProfessorId(professor.getId());
				}
			}
		}

		for (Student student : binding.getStudenten()) {
			if (student.getBesucht() != null) {
				for (Object o : student.getBesucht()) {
					Lehrveranstaltung lv = getValue(binding, o,
							Lehrveranstaltung.class);
					RowBuilder_Besucht row = result.table_Besucht.insertRow();
					row.setStudentId(student.getMatrikelnummer());
					row.setLehrveranstaltungId(lv.getId());
				}
			}

			if (student.getIsttutor() != null) {
				for (Object o : student.getIsttutor()) {
					Lehrveranstaltung lv = getValue(binding, o,
							Lehrveranstaltung.class);

					RowBuilder_Isttutor row = result.table_Isttutor
							.insertRow();
					row.setStudentId(student.getMatrikelnummer());
					row.setLehrveranstaltungId(lv.getId());
				}
			}

			if (student.getSchreibt() != null) {
				for (Object o : student.getSchreibt()) {
					Pruefung p = getValue(binding, o, Pruefung.class);

					RowBuilder_Schreibt row = result.table_Schreibt
							.insertRow();
					row.setStudentId(student.getMatrikelnummer());
					row.setPruefungId(p.getId());
				}
			}
		}

		return result.createDBUnitDataSet();
	}

	public IDataSet getDataSet() throws DataSetException {
		if (dataset == null) throw new DataSetException("Error in Groovy Data Set");
		return dataset;
	}

	private Object runDsl(String file, DslBinding binding) throws Exception {
		InputStream s = this.getClass().getResourceAsStream(file);
		CompilerConfiguration conf = new CompilerConfiguration();
		conf.setScriptBaseClass(DslDefinition.class.getName());
		GroovyShell gs = new GroovyShell(binding, conf);
		Script script = gs.parse(new InputStreamReader(s));
		return script.run();
	}
}
