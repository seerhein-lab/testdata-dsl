package com.seitenbau.testdatadsl.dbunit.simpledsl;

import groovy.lang.Binding;
import groovy.lang.ExpandoMetaClass;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.codehaus.groovy.control.CompilerConfiguration;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;

import com.seitenbau.stu.dbunit.hochschule.BeaufsichtigtTable.RowBuilder_Beaufsichtigt;
import com.seitenbau.stu.dbunit.hochschule.BesuchtTable.RowBuilder_Besucht;
import com.seitenbau.stu.dbunit.hochschule.HochschuleDataSet;
import com.seitenbau.stu.dbunit.hochschule.IsttutorTable.RowBuilder_Isttutor;
import com.seitenbau.stu.dbunit.hochschule.LehrveranstaltungTable.RowBuilder_Lehrveranstaltung;
import com.seitenbau.stu.dbunit.hochschule.ProfessorTable.RowBuilder_Professor;
import com.seitenbau.stu.dbunit.hochschule.PruefungTable.RowBuilder_Pruefung;
import com.seitenbau.stu.dbunit.hochschule.SchreibtTable.RowBuilder_Schreibt;
import com.seitenbau.stu.dbunit.hochschule.StudentTable.RowBuilder_Student;
import com.seitenbau.testdatadsl.dbunit.simpledsl.DslBinding;
import com.seitenbau.testdatadsl.dbunit.simpledsl.DslDefinition;
import com.seitenbau.testdatadsl.dbunit.simpledsl.Lehrveranstaltung;
import com.seitenbau.testdatadsl.dbunit.simpledsl.Professor;
import com.seitenbau.testdatadsl.dbunit.simpledsl.Pruefung;
import com.seitenbau.testdatadsl.dbunit.simpledsl.Student;

public class SimpleDSLDataSetProvider {

	private final IDataSet dataset;

	public SimpleDSLDataSetProvider() {
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
		final HochschuleDataSet result = new HochschuleDataSet() {
		  protected void initDataSet() {
		    final DslBinding binding = new DslBinding();
		    try {
		      runDsl("dsl.txt", binding);
		    } catch (Exception e) {
		      e.printStackTrace();
		      return;
		    }

		    for (Professor professor : binding.getProfessoren()) {
		      RowBuilder_Professor row = table_Professor.insertRow();
		      row.nextId();
		      row.setName(professor.getName());
		      row.setVorname(professor.getVorname());
		      row.setTitel(professor.getTitel());
		      row.setFakultaet(professor.getFakultaet());
		      professor.setId(row.getId());

		      if (professor.getLeitet() != null) {
		        for (Object o : professor.getLeitet()) {
		          Lehrveranstaltung lv = getValue(binding, o,
		              Lehrveranstaltung.class);

		          RowBuilder_Lehrveranstaltung lrow = table_Lehrveranstaltung
		              .insertRow();
		          lrow.nextId();
		          lrow.setProfessorId(row.getId());
		          lrow.setName(lv.getName());
		          lrow.setEcts(lv.getEcts());
		          lrow.setSws(lv.getSws());

		          lv.setId(lrow.getId());
		        }
		      }
		    }

		    for (Student student : binding.getStudenten()) {
		      RowBuilder_Student row = table_Student.insertRow();
		      row.setMatrikelnummer(student.getMatrikelnummer());
		      row.setName(student.getName());
		      row.setVorname(student.getVorname());
		      row.setStudiengang(student.getStudiengang());
		      row.setSemester(student.getSemester());
		      row.setImmatrikuliertSeit(student.getImmatrikuliert_seit());
		    }

		    for (Pruefung pruefung : binding.getPruefungen()) {
		      RowBuilder_Pruefung row = table_Pruefung.insertRow();
		      row.nextId();
		      row.setTyp(pruefung.getTyp());
		      row.setZeitpunkt(pruefung.getZeitpunkt());
		      
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

		          RowBuilder_Beaufsichtigt row = table_Beaufsichtigt
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
		          RowBuilder_Besucht row = table_Besucht.insertRow();
		          row.setStudentId(student.getMatrikelnummer());
		          row.setLehrveranstaltungId(lv.getId());
		        }
		      }

		      if (student.getIsttutor() != null) {
		        for (Object o : student.getIsttutor()) {
		          Lehrveranstaltung lv = getValue(binding, o,
		              Lehrveranstaltung.class);

		          RowBuilder_Isttutor row = table_Isttutor
		              .insertRow();
		          row.setStudentId(student.getMatrikelnummer());
		          row.setLehrveranstaltungId(lv.getId());
		        }
		      }

		      if (student.getSchreibt() != null) {
		        for (Object o : student.getSchreibt()) {
		          Pruefung p = getValue(binding, o, Pruefung.class);

		          RowBuilder_Schreibt row = table_Schreibt
		              .insertRow();
		          row.setStudentId(student.getMatrikelnummer());
		          row.setPruefungId(p.getId());
		        }
		      }
		    }
		  }
		};

		return result.createDBUnitDataSet();
	}

	public IDataSet getDataSet() {
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
