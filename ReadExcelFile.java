package com.fp.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadExcelFile {

	private static ReadExcelFile file=null;
	public static XSSFWorkbook workbook;
	public static void main(String[] args) throws IOException {
	ReadExcelFile objExcelFile = new ReadExcelFile();      
	      objExcelFile.ReadDataInExcelFile("C:\\SeleniumProjectHcl\\Hackthon_Test2\\src\\main\\java\\com\\fp\\testdata\\TestDatas.xlsx", "LoginData.xlsx", "sheet1");
	}
	 public Object[][] ReadDataInExcelFile(String filePath,String fileName,String sheetName) throws IOException{

		    //Create an object of File class to open xlsx file
		    File file =    new File(filePath+"\\"+fileName);

		    //Create an object of FileInputStream class to read excel file
		    FileInputStream inputStream = new FileInputStream(file);
		    Workbook workbook = null;

		    //Find the file extension by splitting file name in substring  and getting only extension name
		    String fileExtensionName = fileName.substring(fileName.indexOf("."));
//		    System.out.println(fileExtensionName);
		    
		    if(fileExtensionName.equals(".xlsx")){
		    workbook = new XSSFWorkbook(inputStream);
		    }
		    else if(fileExtensionName.equals(".xls")){
		        workbook = new HSSFWorkbook(inputStream);
		    }
		    //Read sheet inside the workbook by its name
		    Sheet ws = workbook.getSheet(sheetName);
		    
		    //Find number of rows in excel file
		    int rowCount = ws.getPhysicalNumberOfRows();
		    Object[][]data= new Object[rowCount][2];
		    for (int i = 0; i < rowCount; i++) {
		        Row row = ws.getRow(i);
		        //Create a loop to print cell values in a row
		        for (int j = 0; j < row.getLastCellNum(); j++) {
		        	data[i][j]=row.getCell(j).getStringCellValue();
//		        	System.out.println(data[i][j]);
		        }		        
		    }
			return data; 
		    }
	public Object[][] ReadDataInExcelFile(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}  
}
