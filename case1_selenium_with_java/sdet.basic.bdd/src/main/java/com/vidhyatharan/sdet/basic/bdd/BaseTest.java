package com.vidhyatharan.sdet.basic.bdd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	protected static WebDriver driver;

	public void initializeDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
	}

	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}