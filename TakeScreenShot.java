package com.fp.testutil;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.fp.base.TestBase;

public class TakeScreenShot extends TestBase {

	public static String screenshotpath;

	public static void captureScreenshotOnFailure(String methodName) throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {

			// Create unique file name and store in under screenshot folder of root
			// directory
			screenshotpath = System.getProperty("user.dir") + "\\TakeScreenShot\\Failed\\" + methodName + ".png";

			// Copy the file to destination
			FileHandler.copy(scrFile, new File(screenshotpath));
			System.out.println(screenshotpath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public static void captureScreenshotOnSucess(String methodName) throws IOException {

		// Take screen shot and store it in volatile memory with reference name scrFile
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {

			// Create unique file name and store in under screenshot folder of root
			// directory
			screenshotpath = System.getProperty("user.dir") + "\\TakeScreenShot\\Passed\\" + methodName + ".png";

			// Copy the file to destination
			FileHandler.copy(scrFile, new File(screenshotpath));
			System.out.println(screenshotpath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public static void takeScreenShotOnFailure(String methodName) {
		// TODO Auto-generated method stub
		
	}

}
