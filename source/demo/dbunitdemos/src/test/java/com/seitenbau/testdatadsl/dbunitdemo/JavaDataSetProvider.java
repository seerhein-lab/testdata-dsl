package com.seitenbau.testdatadsl.dbunitdemo;

import java.text.SimpleDateFormat;

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
			SimpleDateFormat dateFormat = new SimpleDateFormat( "dd.MM.yyyy HH:mm:ss" );
			
			DefaultDataSet dataSet = new DefaultDataSet();

			DefaultTable professor = new DefaultTable(
					"professor",
					new Column[] { 
						new Column("id", DataType.INTEGER),
						new Column("name", DataType.VARCHAR), 
						new Column("vorname", DataType.VARCHAR), 
						new Column("titel", DataType.VARCHAR), 
						new Column("fakultaet", DataType.VARCHAR), 
					}
				);
			professor.addRow(new Object[] { 
						Parameters.Professor.WAESCH_ID,
						"W�sch",
						"J�rgen",
						"Prof. Dr.-Ing.",
						"Informatik",
					});
			professor.addRow(new Object[] { 
						Parameters.Professor.HAASE_ID,
						"Haase",
						"Oliver",
						"Prof. Dr.",
						"Informatik",
					});
			dataSet.addTable(professor);

			DefaultTable lehrveranstaltung = new DefaultTable(
					"lehrveranstaltung", 
					new Column[] {
						new Column("id", DataType.INTEGER),
						new Column("professor_id", DataType.INTEGER),
						new Column("name", DataType.VARCHAR), 
						new Column("sws", DataType.INTEGER),
						new Column("ects", DataType.INTEGER),
					}
				);
			lehrveranstaltung.addRow(new Object[] {
						Parameters.Lehrveranstaltung.VERTEILTE_SYSTEME_ID,
						Parameters.Professor.HAASE_ID, 
						"Verteilte Systeme",
						4,
						5,
					});
			lehrveranstaltung.addRow(new Object[] {
						Parameters.Lehrveranstaltung.DESIGN_PATTERNS_ID,
						Parameters.Professor.HAASE_ID,
						"Concurrency and Design Patterns",
						4,
						3,
					});
			dataSet.addTable(lehrveranstaltung);

			DefaultTable pruefung = new DefaultTable(
					"pruefung", 
					new Column[] {
						new Column("id", DataType.INTEGER),
						new Column("lehrveranstaltung_id", DataType.INTEGER),
						new Column("typ", DataType.VARCHAR), 
						new Column("zeitpunkt", DataType.DATE), 
					}
				);
			pruefung.addRow(new Object[] {
					Parameters.Pruefung.VERTEILTE_SYSTEME_ID,
					Parameters.Lehrveranstaltung.VERTEILTE_SYSTEME_ID, 
					"K90",
					dateFormat.parse("01.04.2013 14:00:00"),
				});
			pruefung.addRow(new Object[] {
					Parameters.Pruefung.DESIGN_PATTERNS_ID,
					Parameters.Lehrveranstaltung.DESIGN_PATTERNS_ID, 
					"M30",
					dateFormat.parse("06.01.2013 12:00:00"),
				});
			dataSet.addTable(pruefung);

			DefaultTable student = new DefaultTable(
					"student", 
					new Column[] {
						new Column("matrikelnummer", DataType.INTEGER),
						new Column("name", DataType.VARCHAR), 
						new Column("vorname", DataType.VARCHAR), 
						new Column("studiengang", DataType.VARCHAR), 
						new Column("semester", DataType.INTEGER), 
						new Column("immatrikuliert_seit", DataType.DATE), 
					}
				);
			
			//dateFormat.parse("01.04.2013 14:00:00"),
			
			student.addRow(new Object[] { 
					Parameters.Student.NIKOLAUS_MOLL_ID,
					"Moll",
					"Nikolaus",
					"MSI",
					4,
					dateFormat.parse("01.09.2011 00:00:00"),
				});
			student.addRow(new Object[] {
					Parameters.Student.MAX_MUSTERMANN_ID,
					"Mustermann",
					"Max",
					"BIT",
					"3",
					dateFormat.parse("01.03.2012 00:00:00"),
				});
			dataSet.addTable(student);

			DefaultTable beaufsichtigt = new DefaultTable(
					"beaufsichtigt",
					new Column[] { 
						new Column("professor_id", DataType.INTEGER),
						new Column("pruefung_id", DataType.INTEGER), 
					}	
				);
			beaufsichtigt.addRow(new Object[] { Parameters.Professor.HAASE_ID,
					Parameters.Pruefung.VERTEILTE_SYSTEME_ID });
			beaufsichtigt.addRow(new Object[] { Parameters.Professor.HAASE_ID,
					Parameters.Pruefung.DESIGN_PATTERNS_ID });
			dataSet.addTable(beaufsichtigt);

			DefaultTable schreibt = new DefaultTable(
					"schreibt", 
					new Column[] {
						new Column("student_id", DataType.INTEGER),
						new Column("pruefung_id", DataType.INTEGER),
					}
				);
			schreibt.addRow(new Object[] { Parameters.Student.NIKOLAUS_MOLL_ID,
					Parameters.Pruefung.VERTEILTE_SYSTEME_ID });
			dataSet.addTable(schreibt);

			DefaultTable besucht = new DefaultTable(
					"besucht",
					new Column[] {
						new Column("student_id", DataType.INTEGER),
						new Column("lehrveranstaltung_id", DataType.INTEGER), 
					}
				);
			besucht.addRow(new Object[] { Parameters.Student.NIKOLAUS_MOLL_ID,
					Parameters.Lehrveranstaltung.VERTEILTE_SYSTEME_ID });
			besucht.addRow(new Object[] { Parameters.Student.MAX_MUSTERMANN_ID,
					Parameters.Lehrveranstaltung.DESIGN_PATTERNS_ID });
			dataSet.addTable(besucht);

			DefaultTable isttutor = new DefaultTable(
					"isttutor", 
					new Column[] {
						new Column("student_id", DataType.INTEGER),
						new Column("lehrveranstaltung_id", DataType.INTEGER), 
					}
				);
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
