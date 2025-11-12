package com.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static String[] getRowData(int sheetNo, int rowNum) throws IOException {
	    String filePath = "src/test/resources/ExcelData/Top Deals - Scenario Outline.xlsx";
	    FileInputStream file = new FileInputStream(filePath);
	    Workbook workbook = new XSSFWorkbook(file);
	    Sheet sheet = workbook.getSheetAt(sheetNo);
	    DataFormatter formatter = new DataFormatter();

	    // Get header row to determine column count
	    Row headerRow = sheet.getRow(0);
	    int colCount = headerRow.getLastCellNum();

	    // Read target row
	    Row row = sheet.getRow(rowNum);
	    String[] rowData = new String[colCount];
	    for (int j = 0; j < colCount; j++) {
	        Cell cell = (row != null) ? row.getCell(j) : null;
	        rowData[j] = (cell != null) ? formatter.formatCellValue(cell) : "";
	    }

	    workbook.close();
	    file.close();
	    return rowData;
	}

	
}




























//package com.Parameters;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelReader {
//
//    public static String[] getRowData(int sheetNo, int rowNum) throws IOException {
//        String filePath = "src/test/resources/ExcelData/Top Deals - Scenario Outline.xlsx";
//        FileInputStream file = new FileInputStream(filePath);
//        Workbook workbook = new XSSFWorkbook(file);
//        Sheet sheet = workbook.getSheetAt(sheetNo);
//
//        Row row = sheet.getRow(rowNum);
//        int colCount = row.getLastCellNum();
//        String[] rowData = new String[colCount];
//
//        DataFormatter formatter = new DataFormatter();
//        for (int j = 0; j < colCount; j++) {
//            Cell cell = row.getCell(j);
//            rowData[j] = formatter.formatCellValue(cell);
//        }
//
//        workbook.close();
//        file.close();
//        return rowData;
//    }
//}














//package com.Parameters;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Map;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelReader {
//	public static String getCellData(int sheetNo,int rowNum, int colNum) throws IOException {
//		FileInputStream file = new FileInputStream("src/test/resources/ExcelData/Top Deals - Scenario Outline.xlsx");
//		Workbook workbook = new XSSFWorkbook(file);
//		Sheet sheet = workbook.getSheetAt(sheetNo);
//		Row row = sheet.getRow(rowNum);
//		Cell cell = row.getCell(colNum);
//		String value;
//		switch(cell.getCellType()) {
//		case STRING:
//			value = cell.getStringCellValue();
//			break;
//		case NUMERIC:
//			value = String.valueOf((long) cell.getNumericCellValue());
//			break;
//		case BOOLEAN:
//			value = String.valueOf(cell.getBooleanCellValue());
//			break;
//			default:
//				value ="";
//		}
//
//		workbook.close();
//		file.close();
//		return value;
//	}
//}

 















































//package com.Parameters;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.util.*;
//
//public class ExcelReader {
//
//    // Reads Excel and returns List<Map<String, String>> for easy access by column name
//    public static List<Map<String, String>> readExcel(String filePath) {
//        List<Map<String, String>> dataList = new ArrayList<>();
//
//        try (FileInputStream fis = new FileInputStream(filePath);
//             Workbook workbook = new XSSFWorkbook(fis)) {
//
//            Sheet sheet = workbook.getSheetAt(0);
//            DataFormatter formatter = new DataFormatter();
//
//            // Read header row
//            Row headerRow = sheet.getRow(0);
//            int colCount = headerRow.getLastCellNum();
//            List<String> headers = new ArrayList<>();
//            for (int j = 0; j < colCount; j++) {
//                headers.add(formatter.formatCellValue(headerRow.getCell(j)));
//            }
//
//            // Read data rows
//            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//                Row row = sheet.getRow(i);
//                if (row == null) continue;
//
//                Map<String, String> rowData = new LinkedHashMap<>();
//                for (int j = 0; j < colCount; j++) {
//                    String value = formatter.formatCellValue(row.getCell(j));
//                    rowData.put(headers.get(j), value);
//                }
//                dataList.add(rowData);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return dataList;
//    }
//
//    // Get row by matching a column value (e.g., Row Index or Laptop Name)
//    public static Map<String, String> getRowByName(String filePath, String columnName, String matchValue) {
//        List<Map<String, String>> allData = readExcel(filePath);
//        for (Map<String, String> row : allData) {
//            if (row.containsKey(columnName) && row.get(columnName).equalsIgnoreCase(matchValue)) {
//                return row;
//            }
//        }
//        return Collections.emptyMap();
//    }
//}







































//package com.Parameters;
// 
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import java.io.FileInputStream;
//import java.util.ArrayList;
//import java.util.List;
// 
//public class ExcelReader {
// 
//public static List<String[]> readExcel(String filePath) {
//	List<String[]> data = new ArrayList<>();
//	try (FileInputStream fis = new FileInputStream(filePath);
//			Workbook workbook = new XSSFWorkbook(fis)) {
//		Sheet sheet = workbook.getSheetAt(0);
//		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//			Row row = sheet.getRow(i);
//			if (row == null) continue;
//			String[] rowData = new String[row.getLastCellNum()];
//			for (int j = 0; j < row.getLastCellNum(); j++) {
//				Cell cell = row.getCell(j);
//				if (cell == null) {
//					rowData[j] = "";
//				} else if (cell.getCellType() == CellType.NUMERIC) {
// 
// 
//					rowData[j] = String.valueOf((long) cell.getNumericCellValue());
//				} else {
//					rowData[j] = cell.getStringCellValue();
//				}
//			}
//			data.add(rowData);
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	return data;
//}
//}