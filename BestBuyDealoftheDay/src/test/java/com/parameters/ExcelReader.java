package com.parameters;
 
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelReader {

    private static String filepath = "src/test/resources/ExcelData/scenariooutline3.xlsx";

	public static String getProduct(int sheetIndex, int rowIndex) {
	    try {
	        FileInputStream file = new FileInputStream(filepath);
	        Workbook workbook = new XSSFWorkbook(file);
	        Sheet sheet = workbook.getSheetAt(sheetIndex);
	        Row row = sheet.getRow(rowIndex);
	        DataFormatter formatter = new DataFormatter();
//	        String product = formatter.formatCellValue(row.getCell(0)); // Column A
//	        workbook.close();
//	        file.close();
//	        return product;
	        if (row == null) {
	            System.out.println("ExcelReader: Row " + rowIndex + " is null");
	            workbook.close();
	            file.close();
	            return null;
	        }

	        Cell cell = row.getCell(0);
	        if (cell == null) {
	            System.out.println("ExcelReader: Cell in row " + rowIndex + " is null");
	            workbook.close();
	            file.close();
	            return null;
	        }

	        String product = formatter.formatCellValue(cell);
	        System.out.println("ExcelReader: Read product = " + product);
	        workbook.close();
	        file.close();
	        return product;

	    } catch (Exception e) {
	        System.out.println("Error reading Excel: " + e.getMessage());
	        return null;
	    }
	}
	//String filePath = "src/test/resources/ExcelData/scenariooutline3.xlsx";
//	public static String[] getProductByRow(String filePath, int sheetNo, int rowNum) throws IOException {
//	    //String filePath = "src/test/resources/ExcelData/scenariooutline3.xlsx";
//	    FileInputStream file = new FileInputStream(filePath);
//	    Workbook workbook = new XSSFWorkbook(file);
//	    Sheet sheet = workbook.getSheetAt(sheetNo);
//	    DataFormatter formatter = new DataFormatter();
// 
//	    // Get header row to determine column count
//	    Row headerRow = sheet.getRow(0);
//	    int colCount = headerRow.getLastCellNum();
// 
//	    // Read target row
//	    Row row = sheet.getRow(rowNum);
//	    String[] rowData = new String[colCount];
//	    for (int j = 0; j < colCount; j++) {
//	        Cell cell = (row != null) ? row.getCell(j) : null;
//	        rowData[j] = (cell != null) ? formatter.formatCellValue(cell) : "";
//	    }
// 
//	    workbook.close();
//	    file.close();
//	    return rowData;
//	}
//	public static String getLocalityByRow(String filePath, int sheetIndex, int rowIndex) {
//		//File file = new File(filePath);
//		
//	   
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

//private Workbook workbook;
//
//    public ExcelReader(String filePath) {
//        try (FileInputStream fis = new FileInputStream(filePath)) {
//            workbook = new XSSFWorkbook(fis);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<List<String>> getAllData(int sheetIndex) {
//        List<List<String>> data = new ArrayList<>();
//        Sheet sheet = workbook.getSheetAt(sheetIndex);
//        for (Row row : sheet) {
//            List<String> rowData = new ArrayList<>();
//            for (Cell cell : row) {
//                rowData.add(cell.toString().trim());
//            }
//            data.add(rowData);
//        }
//        return data;
//    }
//
//    public List<String> getRowData(int sheetIndex, int rowIndex) {
//        List<String> rowData = new ArrayList<>();
//        Sheet sheet = workbook.getSheetAt(sheetIndex);
//        Row row = sheet.getRow(rowIndex);
//        if (row != null) {
//            for (Cell cell : row) {
//                rowData.add(cell.toString().trim());
//            }
//        }
//        return rowData;
//    }
//
//    // Static helper for single cell value
//    public static String getLocalityByRow(String filePath, int sheetIndex, int rowIndex) {
//        try (FileInputStream fis = new FileInputStream(filePath);
//             Workbook workbook = new XSSFWorkbook(fis)) {
//            Sheet sheet = workbook.getSheetAt(sheetIndex);
//            Row row = sheet.getRow(rowIndex);
//            if (row != null && row.getCell(0) != null) {
//                return row.getCell(0).toString().trim();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//
//}
//	private String excelPath;
//	 
//	public ExcelReader(String excelPath) {
//		this.excelPath = excelPath;
//	}
////
////	// Read all non-empty cells in a given row
////	
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
}