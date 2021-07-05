package com.fp.testdata;

public class LoginDataPage {
	
	private static String number;
	private static String password;
	
	public LoginDataPage(){
		ReadExcelFile file;
		try{
			file=new ReadExcelFile();
			Object[][] data=file.ReadDataInExcelFile("C:\\SeleniumProjectHcl\\Hackthon_Test2\\src\\main\\java\\com\\fp\\testdata\\TestDatas.xlsx.LogiDataPage", "sheet1");
			number=data[1][0].toString();
			password=data[1][1].toString();//to get String representation of an object
//			System.out.println(number);
//			System.out.println(password);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public String getNum(){
		return number;
	}
	public String getpass(){
		return password;
	}


}
