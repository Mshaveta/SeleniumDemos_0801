package TestNGDemo.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*
 * FileReader- char form
 */
public class XlsReader {
	private Workbook wb;
	private Sheet sheet;
	private FileInputStream fis;
	private Row row;

	public XlsReader(String wbkPath) throws IOException {
		try {
			fis = new FileInputStream(wbkPath);//bytes 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		wb = new XSSFWorkbook(fis);

	}

	public int getRowCount(String sheetName) {
		sheet = wb.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();// 4
		int firstRow = sheet.getFirstRowNum();// 0
		int ttlRowCount = (lastRow - firstRow) + 1;// 4-0
		return ttlRowCount;
	}

	public int getCellCount() {
		row = sheet.getRow(0);
		int lastCell = row.getLastCellNum();// 1+1
		System.out.println(lastCell);
		int firstCell = row.getFirstCellNum();

		int ttlCellCount = lastCell - firstCell;
		return ttlCellCount;
	}

	public void getCellData(int row, int col) {
		sheet.getRow(row);
	}

	public String getCellData(String sheetName, int row, int col) {
		Sheet sh = wb.getSheet(sheetName);
		Row rowRef = sh.getRow(row);
		Cell cellRef = rowRef.getCell(col);
		String cellData = cellRef.getStringCellValue();
		return cellData;
	}

	public static void main(String[] args) throws IOException {
		// Step1: Fetch WorkBook Filepath
		String wbkPath = System.getProperty("user.dir") + "\\src\\testData\\testData.xlsx";
		// Step2: Create an object of XlsReader Class
		XlsReader xlr = new XlsReader(wbkPath);

		// S3: Row Count
		int rCount = xlr.getRowCount("Login");

		System.out.println("Total Rows - " + rCount);

		// S4: Cell Count
		int cCount = xlr.getCellCount();
		System.out.println("Total Cols - " + cCount);

		// create an String 2D Array
		String[][] testData = new String[rCount - 1][cCount];// 4*2

		// Read cell Data
		for (int row = 1; row < rCount; row++) {
			for (int cell = 0; cell < cCount; cell++) {
				testData[row - 1][cell] = xlr.getCellData("Login", row, cell);// 10,11,20,21

			}

		}
	}

}
