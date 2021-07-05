package com.fp.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fp.base.TestBase;

public class ProductPage extends TestBase {
	 @FindBy(xpath="//div[@class='eFQ30H'][9]")
	    WebElement hoverOnBaby;
	    
	    @FindBy(xpath="(//a[@class='_6WOcW9'])[5]")
	    WebElement hoverOnToys;
	    
	    @FindBy(xpath="(//a[@class='_6WOcW9 _3YpNQe'])[2]")
	    WebElement clickRemoteToys;
	    
	    public  void VerifyingProductPage() {
	    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        PageFactory.initElements(driver, this);
	    }

	 

	    public void remoteControlToy() {
	        Actions action=new Actions(driver);
	        action.moveToElement(hoverOnBaby);
	        action.build().perform();
	        action.moveToElement(hoverOnToys);
	        action.build().perform();
	        action.moveToElement(clickRemoteToys);
	        action.click().build().perform();
	        System.out.println("Able to view products page");
	    
	        
	        
	    }

}
