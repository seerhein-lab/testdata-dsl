package com.seitenbau.testdatadsl.dbunitdemo;

import org.dbunit.dataset.Column;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.DefaultDataSet;
import org.dbunit.dataset.DefaultTable;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.datatype.DataType;

public class JavaDataSetProvider implements IDataSetProvider {

	public interface Parameters {

		interface Professor {
			int WAESCH_ID = 1;
			int HAASE_ID = 2;
		}

		interface Lehrveranstaltung {
			int VERTEILTE_SYSTEME_ID = 1;
			int DESIGN_PATTERNS_ID = 2;
		}

		interface Pruefung {
			int VERTEILTE_SYSTEME_ID = 1;
			int DESIGN_PATTERNS_ID = 2;
		}

		interface Student {
			int NIKOLAUS_MOLL_ID = 287336;
			int MAX_MUSTERMANN_ID = 123456;
		}
	}

	private final IDataSet dataset;
	
	public JavaDataSetProvider() {
		dataset = createDataSet();
	}

	public IDataSet createDataSet() {
		try {
			DefaultDataSet dataSet = new DefaultDataSet();

			DefaultTable professor = new DefaultTable(
					"professor",
						new Column[] { 
							new Column("id", DataType.INTEGER),
							new Column("name", DataType.VARCHAR), 
						}
					);
			professor.addRow(new Object[] { 
						Parameters.Professor.WAESCH_ID,
						"Jürgen Wäsch" 
					});
			professor.addRow(new Object[] { 
						Parameters.Professor.HAASE_ID,
						"Oliver Haase"
					});
			dataSet.addTable(professor);

			DefaultTable lehrveranstaltung = new DefaultTable(
					"lehrveranstaltung", 
						new Column[] {
							new Column("id", DataType.INTEGER),
							new Column("professorid", DataType.INTEGER),
							new Column("name", DataType.VARCHAR), 
						}
					);
			lehrveranstaltung.addRow(new Object[] {
						Parameters.Lehrveranstaltung.VERTEILTE_SYSTEME_ID,
						Parameters.Professor.HAASE_ID, "Verteilte Systeme" 
					});
			lehrveranstaltung.addRow(new Object[] {
						Parameters.Lehrveranstaltung.DESIGN_PATTERNS_ID,
						Parameters.Professor.HAASE_ID,
						"Concurrency and Design Patterns" 
					});
			dataSet.addTable(lehrveranstaltung);

			DefaultTable pruefung = new DefaultTable("pruefung", new Column[] {
					new Column("id", DataType.INTEGER),
					new Column("lehrveranstaltungid", DataType.INTEGER),
					new Column("typ", DataType.VARCHAR), });
			pruefung.addRow(new Object[] {
					Parameters.Pruefung.VERTEILTE_SYSTEME_ID,
					Parameters.Lehrveranstaltung.VERTEILTE_SYSTEME_ID, "K90" });
			pruefung.addRow(new Object[] {
					Parameters.Pruefung.DESIGN_PATTERNS_ID,
					Parameters.Lehrveranstaltung.DESIGN_PATTERNS_ID, "M30" });
			dataSet.addTable(pruefung);

			DefaultTable student = new DefaultTable("student", new Column[] {
					new Column("matrikelnummer", DataType.INTEGER),
					new Column("name", DataType.VARCHAR), });
			student.addRow(new Object[] { Parameters.Student.NIKOLAUS_MOLL_ID,
					"Nikolaus Moll" });
			student.addRow(new Object[] { Parameters.Student.MAX_MUSTERMANN_ID,
					"Max Mustermann" });
			dataSet.addTable(student);

			DefaultTable beaufsichtigt = new DefaultTable("beaufsichtigt",
					new Column[] { new Column("professorid", DataType.INTEGER),
							new Column("pruefungid", DataType.INTEGER), });
			beaufsichtigt.addRow(new Object[] { Parameters.Professor.HAASE_ID,
					Parameters.Pruefung.VERTEILTE_SYSTEME_ID });
			beaufsichtigt.addRow(new Object[] { Parameters.Professor.HAASE_ID,
					Parameters.Pruefung.DESIGN_PATTERNS_ID });
			dataSet.addTable(beaufsichtigt);

			DefaultTable schreibt = new DefaultTable("schreibt", new Column[] {
					new Column("studentid", DataType.INTEGER),
					new Column("pruefungid", DataType.INTEGER), });
			schreibt.addRow(new Object[] { Parameters.Student.NIKOLAUS_MOLL_ID,
					Parameters.Pruefung.VERTEILTE_SYSTEME_ID });
			dataSet.addTable(schreibt);

			DefaultTable besucht = new DefaultTable("besucht", new Column[] {
					new Column("studentid", DataType.INTEGER),
					new Column("lehrveranstaltungid", DataType.INTEGER), });
			besucht.addRow(new Object[] { Parameters.Student.NIKOLAUS_MOLL_ID,
					Parameters.Lehrveranstaltung.VERTEILTE_SYSTEME_ID });
			besucht.addRow(new Object[] { Parameters.Student.MAX_MUSTERMANN_ID,
					Parameters.Lehrveranstaltung.DESIGN_PATTERNS_ID });
			dataSet.addTable(besucht);

			DefaultTable isttutor = new DefaultTable("isttutor", new Column[] {
					new Column("studentid", DataType.INTEGER),
					new Column("lehrveranstaltungid", DataType.INTEGER), });
			isttutor.addRow(new Object[] { Parameters.Student.NIKOLAUS_MOLL_ID,
					Parameters.Lehrveranstaltung.VERTEILTE_SYSTEME_ID });
			dataSet.addTable(isttutor);

			return dataSet;
		} catch (Exception e) {
			return null;
		}

		// sut.deletProf(TestData.Professor.WAESCH_ID);

		// int PROF_HAASE_AUFSICHT_SWS = 1;
		//
		// dataseBuilder.professor.addRow()
		// .id(PROF_HAASE_AUFSICHT_SWS)
		// .name("Haase");
		// dataseBuilder.beaufsichig.addRow()
		// .professorID(PROF_HAASE_AUFSICHT_SWS);
		//
		//
		// // Test
		// sut.deleteProfByName("Haase");
		//
		// dataSetBuilder.professor.findWhere.name("Haase").delete();
		//
		// assertDatabase(dataSetBuilder.build());
	}

	public IDataSet getDataSet() throws DataSetException {
		if (dataset == null) throw new DataSetException("No Java Data Set");
		return dataset;
	}
}
