package com.fp.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fp.page.HomePage;
import com.fp.testutil.TestUtil;

public class TestBase 
{
	//	  // Declaring global varaibles
	  public static WebDriver driver;
      public static Properties prop;
      
    HomePage hmePage;
    
	  //Constructor
    public TestBase() {
		
		try {   // try 
			prop = new Properties();   
			FileInputStream fis = new FileInputStream("C:\\SeleniumProjectHcl\\Hackthon_Test2\\src\\main\\java\\com\\fp\\config\\config.properties");   // reading data through config.properties file
			prop.load(fis);  
			
		} catch(FileNotFoundException e) {  //- cache exceptions
			e.printStackTrace();   //printing exceptions
		} catch(IOException e1) {
			e1.printStackTrace();
		} 
		
	}
    
    //Initailization
    public static void initialization() {
		
		String browserName = prop.getProperty("browser"); //Getting browser from config.properties file
		
		if(browserName.equals("chrome")) {    //loading chrome bowser 
			System.setProperty("webdriver.chrome.driver", "\\\\C:\\\\SeleniumDrivers\\\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
//		else if(browserName.equals("FF")){
//			System.setProperty("webdriver.gecko.driver", "\\C:\\SeleniumDrivers\\geckodriver.exe");
//			driver = new FirefoxDriver();
//		}
//		else {
		//System.setProperty("webdriver.ie.driver", "C:\IEBrowserDriver\\IEDriverServer.exe");
		//  driver = new InternetExplorerDriver();
//		}
		
		driver.manage().window().maximize();      //maximizing the window
		driver.manage().deleteAllCookies();         //delete all cookies
		//waits
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);   
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));   //loading url
		
		
	}
    }


