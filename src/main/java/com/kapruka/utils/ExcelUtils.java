package com.kapruka.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class ExcelUtils {

	// This method will acept path of the excel file and sheet name as parameters
	// and return the data in the form of list
	// of data present in the excel sheet
	public List getRowData(String filePath, String sheetName, int rowNumber) {
		XSSFWorkbook workbook = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet(sheetName);
		List rowData = new ArrayList<>();
		int rows = sheet.getLastRowNum();
		Row row = sheet.getRow(rowNumber);
		int cells = row.getLastCellNum();
		for (int i = 0; i < cells; i++) {
			rowData.add(row.getCell(i).getStringCellValue());
		}

		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rowData;

	}

	// Create a method to read particular column from specified excel file.
	// The path of excel file, sheet name and column number will be provided as the parameter.
	// This method should return List of data present in that column.
	// This list must be of type Objects so that it should accommodate all types of data

	public List getColumnData(String filePath, String sheetName, int columnNumber) {
		XSSFWorkbook workbook = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet(sheetName);
		List columnData = new ArrayList<>();
		int rows = sheet.getLastRowNum();
		for (int i = 0; i <= rows; i++) {
			columnData.add(sheet.getRow(i).getCell(columnNumber).getStringCellValue());
		}

		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return columnData;

	}

}
