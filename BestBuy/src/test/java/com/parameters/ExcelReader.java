package com.parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	File f;
	FileInputStream fis ;
	XSSFWorkbook wb;
	 XSSFSheet sh ;
	
//path of file -- parametrized constructor
	public ExcelReader(String filepath)
	{		
		 try {
			 f= new File(filepath);
			fis = new FileInputStream(f);
			wb= new XSSFWorkbook(fis);
			
		} catch (IOException e)
		 {			
			e.printStackTrace();
		}
	}
	//data from cell
	public String getCellData(int sheetno , int row , int col)
	{
		sh = wb.getSheetAt(sheetno);
		

//		 if (sh.getRow(row) == null || sh.getRow(row).getCell(col) == null) {
//		        return ""; // Return empty if row or cell is missing

		
		 DataFormatter formatter = new DataFormatter();
		 String value= formatter.formatCellValue(sh.getRow(row).getCell(col));
		
		//String value=sh.getRow(row).getCell(col).getStringCellValue();
	return value;
	}
	
	//count of rows
	public int getRowcount(int sheetno)
	{
		sh = wb.getSheetAt(sheetno);
		int rows=sh.getLastRowNum();
		return rows;
	}
	
	//count of columns
	public int getColcount(int sheetno)
	{
		sh = wb.getSheetAt(sheetno);
		int cols=sh.getRow(0).getLastCellNum();
		return cols;
	}
 
}

   

