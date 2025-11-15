package com.parameters;

import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	//	
	//	public String getCellData(int row, int col) throws Exception {
	//    	String excelPath = "C:\\training modules\\JavaSelenium\\BestBuy\\src\\test\\resources\\ExcelData\\petsexcel.xlsx";
	//        FileInputStream fis = new FileInputStream(excelPath);
	//        Workbook workbook = new XSSFWorkbook(fis);
	//        Sheet sheet = workbook.getSheetAt(0);
	//        String data = sheet.getRow(row).getCell(col).getStringCellValue();
	//        workbook.close();
	//        return data;
	//    }
	// 
	//    public String getBrand(int row) throws Exception {
	//        return getCellData(row, 0); // Column 0 for Brand
	//    }
	// 
	//    public String getProductName(int row) throws Exception {
	//        return getCellData(row, 1); // Column 1 for product name
	//    }
	private String excelPath;
	XSSFWorkbook wb;
	XSSFSheet sh ;

	public ExcelReader(String excelPath) {
		this.excelPath = excelPath;
	}
	
//
//	// Read all non-empty cells in a given row
//	
//	 public List<String> getColumnData(int sheetNo, int colIndex) throws Exception {
//	        List<String> columnData = new ArrayList<>();
//	        try (FileInputStream fis = new FileInputStream(excelPath);
//	             Workbook workbook = new XSSFWorkbook(fis)) {
//	            Sheet sheet = workbook.getSheetAt(sheetNo);
//	            for (Row row : sheet) {
//	                Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//	                String value = cell.toString().trim();
//	                if (!value.isEmpty()) {
//	                    columnData.add(value);
//	                }
//	            }
//	        }
//
//	        return columnData;
//	}
	public List<String> getRowData(int rowIndex, int sheetNo) throws Exception {
	    List<String> rowData = new ArrayList<>();
	    try (FileInputStream fis = new FileInputStream(excelPath);
	         Workbook workbook = new XSSFWorkbook(fis)) {
	        Sheet sheet = workbook.getSheetAt(sheetNo);
	        Row row = sheet.getRow(rowIndex);
	        if (row != null) {
	            for (Cell cell : row) {
	                String value = cell.toString().trim();
	                if (!value.isEmpty()) {
	                    rowData.add(value);
	                }
	            }
	        }
	    }
	    return rowData;
	}
	
	public List<String> getRowColData(int sheet, int row) throws Exception {
	    List<String> rowData = new ArrayList<>();
	    try (FileInputStream fis = new FileInputStream(excelPath);
	         Workbook workbook = new XSSFWorkbook(fis)) {
	        Sheet sheet1 = workbook.getSheetAt(sheet);
	        Row row1 = sheet1.getRow(row);
	        if (row1 != null) {
	            for (Cell cell : row1) {
	                String value = cell.toString().trim();
	                if (!value.isEmpty()) {
	                    rowData.add(value);
	                }
	            }
	        }
	    }
	    return rowData;
	}
}



