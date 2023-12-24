package com.qa.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static Object[][] getData(String fileName, String sheet) throws IOException {
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\com\\qa\\testdata\\" + fileName + ".xlsx");

		XSSFWorkbook ExcelWBook = new XSSFWorkbook(file);

		XSSFSheet ExcelWSheet = ExcelWBook.getSheet(sheet);

		int lastRow = ExcelWSheet.getLastRowNum();

		int lastColumn = ExcelWSheet.getRow(0).getLastCellNum();

		Object data[][] = new Object[lastRow][lastColumn];
		DataFormatter formater = new DataFormatter();

		for (int i = 1; i <= lastRow; i++) {
			for (int j = 0; j < lastColumn; j++) {
				String cellData = formater.formatCellValue(ExcelWSheet.getRow(i).getCell(j));
				data[i - 1][j] = cellData;
//				System.out.println(data[i-1][j]);
			}

		}

		ExcelWBook.close();

		return data;
		
		
	}

}