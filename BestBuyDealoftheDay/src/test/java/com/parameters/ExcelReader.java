package com.parameters;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader 
{

    public static String getCellData(String filePath, int sheetIndex, int rowIndex, int colIndex) {
        String cellValue = "";
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            Row row = sheet.getRow(rowIndex);
            Cell cell = row.getCell(colIndex);
            cellValue = cell.getStringCellValue();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cellValue;
    }
}


//public static List<String> getAllProducts(String filePath, int sheetIndex) {
//        List<String> products = new ArrayList<>();
//        try (FileInputStream fis = new FileInputStream(filePath);
//             Workbook workbook = new XSSFWorkbook(fis)) {
//            Sheet sheet = workbook.getSheetAt(sheetIndex);
//            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // skip header
//                Row row = sheet.getRow(i);
//                if (row != null) {
//                    Cell cell = row.getCell(0);
//                    if (cell != null) {
//                        products.add(cell.toString().trim());
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return products;
//    }

//public static String getCellData(int sheetIndex, int rowIndex, int colIndex) throws IOException {
//        FileInputStream fis = new FileInputStream("src\\test\\resources\\ExcelData\\scenariooutline3.xlsx");
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(sheetIndex);
//        Row row = sheet.getRow(rowIndex);
//        Cell cell = row.getCell(colIndex);
//        String data = cell.getStringCellValue();
//        workbook.close();
//        return data;
//    }




//	public static String getProduct(int sheetIndex, int rowIndex) {
//	    try {
//	        FileInputStream file = new FileInputStream(filepath);
//	        Workbook workbook = new XSSFWorkbook(file);
//	        Sheet sheet = workbook.getSheetAt(sheetIndex);
//	        Row row = sheet.getRow(rowIndex);
//	        DataFormatter formatter = new DataFormatter();
////	        String product = formatter.formatCellValue(row.getCell(0)); // Column A
////	        workbook.close();
////	        file.close();
////	        return product;
//	        if (row == null) {
//	            System.out.println("ExcelReader: Row " + rowIndex + " is null");
//	            workbook.close();
//	            file.close();
//	            return null;
//	        }
//
//	        Cell cell = row.getCell(0);
//	        if (cell == null) {
//	            System.out.println("ExcelReader: Cell in row " + rowIndex + " is null");
//	            workbook.close();
//	            file.close();
//	            return null;
//	        }
//
//	        String product = formatter.formatCellValue(cell);
//	        System.out.println("ExcelReader: Read product = " + product);
//	        workbook.close();
//	        file.close();
//	        return product;
//
//	    } catch (Exception e) {
//	        System.out.println("Error reading Excel: " + e.getMessage());
//	        return null;
//	    }
//	}
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
