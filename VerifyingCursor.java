package com.fp.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fp.base.TestBase;

public class VerifyingCursor extends TestBase {
	@FindBy(xpath="(//div[@class='eFQ30H'])[5]")
    WebElement hoverElectronics;
    
    public VerifyingCursor() {
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }
    
    public void hover() {
        Actions action=new Actions(driver);
        action.moveToElement(hoverElectronics);
        action.build().perform();
        System.out.println("cursor moved to specific tab and it is highlited");

}
}
