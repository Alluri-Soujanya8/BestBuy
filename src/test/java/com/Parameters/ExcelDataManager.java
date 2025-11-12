//package com.Parameters;
//
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class ExcelDataManager {
//
//	private static List<Map<String, String>> excelData;
//    private static AtomicInteger rowCounter = new AtomicInteger(0);
//
//
//	static {
//		String filePath = "src/test/resources/ExcelData/Top Deals - Scenario Outline.xlsx";
//		excelData = ExcelReader.readExcel(filePath);
//		if (excelData.isEmpty()) 
//		{
//            throw new RuntimeException("Excel data is empty! Check file path or sheet content.");
//        }
//
//	}
//	
//	public static Map<String, String> getNextRow() 
//	{
//		int index = rowCounter.getAndIncrement();
//		if (index >= excelData.size()) 
//		{
//			throw new RuntimeException("No more rows available in Excel!");
//		}
//		return excelData.get(index);
//	}
//
//	public static Map<String, String> getRowByName(String columnName, String matchValue) 
//	{
//        for (Map<String, String> row : excelData) 
//        {
//            if (row.containsKey(columnName) && row.get(columnName).equalsIgnoreCase(matchValue)) 
//            {
//                return row;
//            }
//        }
//        throw new RuntimeException("Row with " + columnName + " = " + matchValue + " not found in Excel!");
//    }
//}