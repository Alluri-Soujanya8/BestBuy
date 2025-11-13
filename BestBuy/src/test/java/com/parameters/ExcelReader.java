package com.parameters;

import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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

	public ExcelReader(String excelPath) {
		this.excelPath = excelPath;
	}
//
//	// Read all non-empty cells in a given row
//	
	 public List<String> getColumnData(int sheetNo, int colIndex) throws Exception {
	        List<String> columnData = new ArrayList<>();
	        try (FileInputStream fis = new FileInputStream(excelPath);
	             Workbook workbook = new XSSFWorkbook(fis)) {
	            Sheet sheet = workbook.getSheetAt(sheetNo);
	            for (Row row : sheet) {
	                Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	                String value = cell.toString().trim();
	                if (!value.isEmpty()) {
	                    columnData.add(value);
	                }
	            }
	        }

	        return columnData;
	}
}
//	public static String getLocalityByRow(String filePath, int sheetIndex, int rowIndex) {
//	    try (FileInputStream fis = new FileInputStream(filePath);
//	         Workbook workbook = new XSSFWorkbook(fis)) {
//	 
//	        Sheet sheet = workbook.getSheetAt(sheetIndex);
//	        Row row = sheet.getRow(rowIndex);
//	        if (row != null) {
//	            Cell cell = row.getCell(0);
//	            if (cell != null) {
//	                return cell.getStringCellValue().trim();
//	            }
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	 
//	return null;
//	}
//}

//public static List<String[]> readExcelData(String filePath, String sheetName) {
//    List<String[]> data = new ArrayList<>();
//
//    try (FileInputStream fis = new FileInputStream(filePath);
//         Workbook workbook = new XSSFWorkbook(fis)) {
//
//        Sheet sheet = workbook.getSheet(sheetName);
//        if (sheet == null) {
//            System.out.println("Sheet '" + sheetName + "' not found in file: " + filePath);
//            return data;
//        }
//
//        DataFormatter formatter = new DataFormatter();
//
//        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//            Row row = sheet.getRow(i);
//            if (row == null) continue;
//
//            String city = formatter.formatCellValue(row.getCell(0));
//            String budget = formatter.formatCellValue(row.getCell(1));
//
//            // Skip empty rows
//            if (city.isEmpty() && budget.isEmpty()) continue;
//
//            data.add(new String[]{city.trim(), budget.trim()});
//        }
//
//    } catch (IOException e) {
//        System.out.println("Error reading Excel file: " + filePath);
//        e.printStackTrace();
//    }
//
//    return data;
//}


