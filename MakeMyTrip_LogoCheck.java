package com.vidhyatharan.sdet_basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MakeMyTrip_LogoCheck {
	public static void main(String[] args) throws InterruptedException {
		// System.setProperty("webdriver.gecko.driver",
		// "C:\\Users\\Administrator\\Downloads\\geckodriver-v0.36.0-win-aarch64\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\chromedriver-win64\\chromedriver.exe");

		// WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		WebElement popup_close = driver.findElement(By.className("commonModal__close"));
		popup_close.click();
		Thread.sleep(2000);
		System.out.println("Popup is closed");
		WebElement Logo = driver.findElement(By.cssSelector("a[data-cy='mmtLogo']"));
		if (Logo.isDisplayed()) {
			System.out.println("Logo is displayed");
		} else {
			System.out.println("Logo is not displayed");
		}
		driver.quit();
	}

}
