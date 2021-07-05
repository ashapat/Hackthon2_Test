package com.fp.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fp.base.TestBase;

public class VerifyLogout extends TestBase {

	@FindBy(xpath="//div[@id='container']//*[@class='zZ3yfL']")
	WebElement mouseover;
	@FindBy(xpath="//div[contains(text(),'Logout')]")
	WebElement logout;
	
	public void VerifyingLogoutOperation(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
	}
	
	public void logout() throws InterruptedException{
		Actions action=new Actions(driver);
        action.moveToElement(mouseover);
        action.build().perform();
        logout.click();
        Thread.sleep(2000);
        System.out.println("Succesfully LoggedOut");
	}

}
