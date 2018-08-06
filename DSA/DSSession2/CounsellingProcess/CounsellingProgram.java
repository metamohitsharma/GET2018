package GET2018.DSA.DSSession2.CounsellingProcess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * This class Allots Programs according to Students position in Queue
 * 
 * @author Mohit Sharma
 *
 */
public class CounsellingProgram {
	ArrayList<Program> programList = new ArrayList<Program>();
	CircularQueue queueOfStudents = new CircularQueue(100);
	int noOfStudents = 0;

	/**
	 * Adds Programs from fileName excelSheet
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public boolean addProgram(String fileName) throws IOException {
		try {
			FileInputStream inputStream = new FileInputStream(fileName);

			// Create Workbook instance holding reference to excel file
			Workbook workbook = new XSSFWorkbook(inputStream);

			// Get first sheet from the workbook
			Sheet firstSheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			Iterator<Row> iterator = firstSheet.iterator();
			while (iterator.hasNext()) {
				Row nextRow = iterator.next();

				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				Program program = new Program();
				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();

					// Reading from columns according to their index
					switch (columnIndex) {
					case 0:
						program.setName((String) nextCell.getStringCellValue());
						break;
					case 1:
						program.setCapacity((int) nextCell.getNumericCellValue());
						break;
					}
				}
				programList.add(program);
			}
			workbook.close();
			inputStream.close();
		} catch (IOException ex) {
			throw new IOException("File Not Found while adding Programs");
		}
		return true;
	}

	/**
	 * Adds Students from fileName excelSheet
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 * @throws QueueException
	 */
	public boolean addStudent(String fileName) throws IOException, QueueException {
		try {
			FileInputStream inputStream = new FileInputStream(fileName);

			// Create Workbook instance holding reference to excel file
			Workbook workbook = new XSSFWorkbook(inputStream);

			// Get first sheet from the workbook
			Sheet firstSheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			Iterator<Row> iterator = firstSheet.iterator();
			while (iterator.hasNext()) {
				Row nextRow = iterator.next();

				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				Student student = new Student();
				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();

					// Reading from columns according to their index
					switch (columnIndex) {
					case 0:
						student.setName((String) nextCell.getStringCellValue());
						break;
					default:
						student.setInterestedProgram((String) nextCell.getStringCellValue());
						break;
					}
				}
				queueOfStudents.enQueue(student);
				noOfStudents++;
			}
			workbook.close();
			inputStream.close();
		} catch (IOException ex) {
			throw new IOException("File Not Found while adding Students");
		}
		return true;
	}

	/**
	 * Allots Programs to Students According to their position in Queue
	 * 
	 * @return
	 * @throws QueueException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public boolean allotPrograms() throws QueueException, FileNotFoundException, IOException {
		ArrayList<SelectedProgram> selectedProgramList = new ArrayList<>();

		// Iterating over Student's Queue(i)
		for (int i = 0; i < noOfStudents; i++) {
			Student student = queueOfStudents.deQueue();

			// Iterating over Student's Choice of programs(j) and the List of Programs(k)
			for (int j = 0, k = 0; j < 5;) {
				if (k == programList.size()) {
					j++;
					k = 0;
				} else if (student.getInterestedProgram().get(j).equals(programList.get(k).getName())
						&& programList.get(k).getCapacity() > 0) {
					selectedProgramList.add(new SelectedProgram(student.getName(), programList.get(k).getName()));
					programList.get(k).setCapacity(programList.get(k).getCapacity() - 1);
					break;
				} else {
					k++;
				}
			}
		}

		// Creating Blank Workbook
		Workbook workbook = new XSSFWorkbook();

		// Creating a Sheet in the Workbook
		Sheet sheet = workbook.createSheet("List of Students");
		int rowCount = 0;
		for (SelectedProgram sp : selectedProgramList) {

			// Creating a new Row
			Row row = sheet.createRow(rowCount);
			writeBook(sp, row);
			rowCount++;
		}

		try (FileOutputStream outputStream = new FileOutputStream(new File("SelectedPrograms.xlsx"))) {
			workbook.write(outputStream);
			outputStream.flush();
			outputStream.close();
			workbook.close();
		}
		return true;
	}

	/**
	 * Writes in Excel Sheet
	 * 
	 * @param sp
	 * @param row
	 */
	private void writeBook(SelectedProgram sp, Row row) {

		// Inserting Name in Column 1
		Cell cell = row.createCell(0);
		cell.setCellValue(sp.getStudentName());

		// Inserting AllotedProgram in Column2
		cell = row.createCell(1);
		cell.setCellValue(sp.getSelectedProgram());
	}
}
