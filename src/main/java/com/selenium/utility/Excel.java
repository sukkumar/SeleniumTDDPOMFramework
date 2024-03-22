package com.selenium.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	public static String excelPathLoc;
	public  XSSFWorkbook wb;
    public  XSSFSheet sheet;
    public  FileInputStream fis;
    public  FileOutputStream fout;
   
    
    public Excel(String excelPath)
    {
    	excelPathLoc = excelPath;
            try {
                 fis = new FileInputStream(excelPathLoc);
                  wb = new XSSFWorkbook(fis);             
            } 
            catch (Exception e) {
                System.out.println(e.getMessage()); 
            }                   
        }   
    public String readData (String sheetName,int row, int column )
    {
        sheet = wb.getSheet(sheetName);
        String data = sheet.getRow(row).getCell(column).getStringCellValue();
        return data;            
    }
    
	
	public void writeData(String sheetName,int row, int column, String value ) throws IOException {
		fout=new FileOutputStream(excelPathLoc);
		sheet = wb.getSheet(sheetName);
		sheet.getRow(row).createCell(column).setCellValue(value);
		wb.write(fout);		 
		fout.close();
	}
	
	public HashMap<String,String> readData(String sheetName) {
		
		HashMap<String, String> tempData = new HashMap<String,String>();
		tempData.put("name", readData(sheetName,1,0));
		tempData.put("email", readData(sheetName,1,1));
		tempData.put("userName", readData(sheetName,1,2));
		tempData.put("passWord", readData(sheetName,1,3));
				
		return tempData;
		
		
	}
}

