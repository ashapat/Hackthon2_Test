package com.fp.page;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fp.base.TestBase;

public class AddToCart extends TestBase {
	

	@FindBy(xpath="//input[@name='q']")
	WebElement search;
	@FindBy(xpath="//*[@id='container']/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")
	WebElement selectinglaptop;
	@FindBy(xpath="//*[@id='pincodeInputId']")
	WebElement pincode;
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	WebElement addtocart;
	
	public AddToCart(){
		WebDriver driver = null;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
	}
	
	
	public void addToCart()  {
		search.sendKeys("HPlaptops");
		search.submit();
		selectinglaptop.click();
		Set<String> allwindows=driver.getWindowHandles();
		Object[] windows=allwindows.toArray();
		String window1=windows[0].toString();
		String window2=windows[1].toString();
		driver.switchTo().window(window2);
		pincode.sendKeys("500073");
		pincode.submit();
		addtocart.click();
		

}
}
