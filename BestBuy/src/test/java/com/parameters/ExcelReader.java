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

        // Read all non-empty cells in a given row
        public List<String> getRowData(int sheetNo, int rowIndex) throws Exception {
            List<String> rowData = new ArrayList<>();
            try (FileInputStream fis = new FileInputStream(excelPath);
                 Workbook workbook = new XSSFWorkbook(fis)) {
                Sheet sheet = workbook.getSheetAt(sheetNo);
                Row row = sheet.getRow(rowIndex);

                for (int colIndex = 0; colIndex < row.getLastCellNum(); colIndex++) {
                    Cell cell = row.getCell(colIndex);
                    if (cell != null && !cell.getStringCellValue().trim().isEmpty()) {
                        rowData.add(cell.getStringCellValue());
                    }
                }
            }
            return rowData;
        }
    }


