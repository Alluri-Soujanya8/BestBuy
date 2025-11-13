package com.parameters;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;

 
public class ExcelReader {
public static String getLocalityByRow(String filePath, int sheetIndex, int rowIndex) {
	File file = new File(filePath);
   
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



public static String getCellData(Integer int1, Integer int2, int i) throws Exception {
//    String filePath = System.getProperty("C:\\Users\\alluri\\eclipse-workspace\\BestBuy\\src\\test\\resources\\com\\Excel\\TestData.xlsx");
    String filePath ="C:\\Users\\alluri\\eclipse-workspace\\BestBuy\\src\\test\\resources\\com\\Excel\\TestData.xlsx";
	FileInputStream fis = new FileInputStream(filePath);
    Workbook workbook = new XSSFWorkbook(fis);
    Sheet sheet = workbook.getSheetAt(int1);
    Row row = sheet.getRow(int2); // No +1
    if (row == null) {
        throw new RuntimeException("Row " + int2 + " does not exist in sheet " + int1 + ". Available rows: 0 to " + sheet.getLastRowNum());
    }

    Cell cell = row.getCell(0);
    workbook.close();
    return cell.getStringCellValue();
}
}
 
 
