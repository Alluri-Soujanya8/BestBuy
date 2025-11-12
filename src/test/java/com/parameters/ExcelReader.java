//package com.parameters;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ExcelReader {
//
//    private static final String FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";
//
//    public List<List<String>> getSheetData(String sheetName) {
//        List<List<String>> sheetData = new ArrayList<>();
//
//        try (FileInputStream fis = new FileInputStream(FILE_PATH);
//             Workbook workbook = new XSSFWorkbook(fis)) {
//
//            Sheet sheet = workbook.getSheet(sheetName);
//            if (sheet == null) {
//                throw new RuntimeException("Sheet '" + sheetName + "' not found in Excel file.");
//            }
//
//            for (Row row : sheet) {
//                List<String> rowData = new ArrayList<>();
//                for (Cell cell : row) {
//                    rowData.add(getCellValue(cell));
//                }
//                sheetData.add(rowData);
//            }
//
//        } catch (IOException e) {
//            throw new RuntimeException("Error reading Excel file: " + e.getMessage(), e);
//        }
//
//        return sheetData;
//    }
//
//    private String getCellValue(Cell cell) {
//        if (cell == null) return "";
//        switch (cell.getCellType()) {
//            case STRING:
//                return cell.getStringCellValue();
//            case NUMERIC:
//                return String.valueOf(cell.getNumericCellValue());
//            case BOOLEAN:
//                return String.valueOf(cell.getBooleanCellValue());
//            case BLANK:
//                return "";
//            default:
//                return cell.toString();
//        }
//    }
//}

 
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
public static String getLocalityByRow(String filePath, int sheetIndex, int rowIndex) {
    try (FileInputStream fis = new FileInputStream(filePath);
         Workbook workbook = new XSSFWorkbook(fis)) {
 
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Row row = sheet.getRow(rowIndex);
        if (row != null) {
            Cell cell = row.getCell(0);
            if (cell != null) {
                return cell.getStringCellValue().trim();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
 
return null;
}
}
