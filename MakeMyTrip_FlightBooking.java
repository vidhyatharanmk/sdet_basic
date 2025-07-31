package com.vidhyatharan.sdet_basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MakeMyTrip_FlightBooking {

	public static WebDriver openBrowser(String url) {
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}

	public static void clickElement(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		if (element.isDisplayed()) {
			System.out.println("Element is found : " + element.getTagName());
		} else {
			System.out.println("Element is not found : " + element.getTagName());
		}
		element.click();
	}

	public static void enterText(WebDriver driver, String xpath, String text) {
		WebElement element = driver.findElement(By.xpath(xpath));
		if (element.isDisplayed()) {
			System.out.println("Element is found : " + element.getTagName());
		} else {
			System.out.println("Element is not found : " + element.getTagName());
		}
		element.clear();
		element.sendKeys(text);
		element.sendKeys(Keys.ENTER);
	}

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = openBrowser("https://www.makemytrip.com/");

		WebElement popup_close = driver.findElement(By.className("commonModal__close"));
		popup_close.click();
		System.out.println("Popup is closed");
		Thread.sleep(2000);

		clickElement(driver, "//a[contains(@href, 'makemytrip.com/flights')]");
		Thread.sleep(5000);

		clickElement(driver, "//li[@data-cy='oneWayTrip')]");
		Thread.sleep(5000);

		clickElement(driver, "//label[@for='fromCity')]");
		enterText(driver, "//input[@placeholder='From']", "Bengaluru");
		Thread.sleep(5000);
		clickElement(driver, "//ul[@role='listbox'//li[1]");

		clickElement(driver, "//label[@for='toCity')]");
		enterText(driver, "//input[@placeholder='To']", "New Delhi");
		Thread.sleep(5000);
		clickElement(driver, "//ul[@role='listbox'//li[1]");

		driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
		Thread.sleep(5000);

		driver.quit();
	}

}
