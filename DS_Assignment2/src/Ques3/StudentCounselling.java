package Ques3;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;
import jxl.CellType;

import java.util.ArrayList;
import java.io.FileNotFoundException;

/**
 * This class holds the operations of counseling process.
 * @author Akanksha
 */

public class StudentCounselling 
{

	private static ArrayList<Program> listOfProgram = new ArrayList<>();
	private static ArrayList<StudentAllocation> studentAllocation = new ArrayList<>();

	/**
	 * This function extracts the program details from excel sheet and stores in arraylist
	 * @return true if successful
	 * @throws FileNotFoundException if excel file didn't found
	 * @throws IOException if file no longer is available
	 * @throws BiffException if doesn't recognize the file format
	 */
	static boolean addProgram() throws FileNotFoundException, IOException, BiffException{

		String EXCEL_FILE_LOCATION = "excel/Program.xls";
		Workbook workbook = null;

		workbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));	
		Sheet sheet = workbook.getSheet(0);
		String programName = null;
		int capacity = 0;

		for (int i = 0; i < sheet.getRows(); i++)
		{
			for (int j = 0; j < sheet.getColumns(); j++)
			{
				Cell cell = sheet.getCell(j, i);
				CellType type = cell.getType();
				if (type == CellType.LABEL)
				{
					programName = cell.getContents();
				} 
				else if (type == CellType.NUMBER)
				{
					capacity = Integer.parseInt(cell.getContents());
				}
			}
			Program p = new Program(programName, capacity);
			listOfProgram.add(p);
		}
		return true;
	}

	/**
	 * This function is used to store student in queue from excel sheet
	 * @return true if added successfully
	 * @throws FileNotFoundException if excel file didn't found
	 * @throws IOException if file no longer is available
	 * @throws BiffException if the file format is not recognized
	 */
	static boolean addStudent() throws FileNotFoundException, IOException,  BiffException{

		String EXCEL_FILE_LOCATION = "excel/Student.xls";
		Workbook workbook = null;

		workbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));
		Sheet sheet = workbook.getSheet(0);
		String studentName;
		Student student;
		String[] preference;
		for (int i = 0; i < sheet.getRows(); i++) 
		{
			preference = new String[5];
			Cell name = sheet.getCell(0, i);
			studentName = name.getContents();
			for (int j = 1; j < sheet.getColumns(); j++) 
			{

				Cell cell = sheet.getCell(j, i);
				CellType type = cell.getType();
				if (type == CellType.LABEL)
				{
					preference[j - 1] = cell.getContents();		
				}
			}
			student= new Student(studentName, preference);
			Queue.enQueue(student);
		}
		return true;
	}

	/**
	 * This function store selected students during counseling program in array list
	 * @return true if successfully rendered 
	 * @throws IOException if file no longer is available
	 */
	static boolean allocate() throws IOException
	{
		boolean isAlloted = false;
		int count = 0;

		while (!Queue.checkUnderflow()) 
		{
			count++;
			Student student =  Queue.deQueue();
			isAlloted = false;

			for (int i = 0; i < student.getProgramPreferred().length; i++)
			{
				for (int j = 0; j < listOfProgram.size(); j++) 
				{
					if ((student.getProgramPreferred()[i].equals(listOfProgram.get(j).getProgramName()) && listOfProgram.get(j).getProgramCapacity() > 0))
					{
						studentAllocation.add(new StudentAllocation(student.getStudentName(),student.getProgramPreferred()[i]));
						listOfProgram.get(j).setProgramCapacity(listOfProgram.get(j).getProgramCapacity() - 1);
						isAlloted = true;
						break;
					}
				}
				if (isAlloted) {
					break;
				}
			}
		}
		if(count==0)
			return false;

		return true;
	}

	/**
	 * This is used to write allocated student result in excel sheet
	 * @return true if successfully done
	 * @throws IOException
	 * @throws RowsExceededException if too many rows are targeted at same time 
	 * @throws WriteException base class for RowsExceededException
	 */
	static boolean addToExcel() throws IOException,RowsExceededException,WriteException
	{
		WritableWorkbook workbook = Workbook.createWorkbook(new File("StudentAllocation.xls"));

		WritableSheet wSheet = workbook.createSheet("sheet1", 0);

		for (int i = 0; i < studentAllocation.size(); i++)
		{
			String name = studentAllocation.get(i).getStudentName();
			Label labTemp1 = new Label(0, i, name);
			wSheet.addCell(labTemp1);
			String program = studentAllocation.get(i).getProgramPreferred();
			Label labTemp2 = new Label(1, i, program);
			wSheet.addCell(labTemp2);
		}
		workbook.write();
		workbook.close();
		return true;
	}
	
	public static void main(String[] args) throws IOException, WriteException, BiffException
	{
		addProgram();
		addStudent();	
		allocate();
		addToExcel();
	}
	
}
