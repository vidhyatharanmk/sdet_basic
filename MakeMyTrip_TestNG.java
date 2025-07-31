package com.vidhyatharan.sdet_basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class MakeMyTrip_TestNG {

	WebDriver driver;

	public WebDriver openBrowser(String browser, String url) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.get(url);
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	public void clickElement(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		if (element.isDisplayed()) {
			System.out.println("Element is found : " + element.getTagName());
		} else {
			System.out.println("Element is not found : " + element.getTagName());
		}
		element.click();
	}

	public void enterText(String xpath, String text) {
		WebElement element = driver.findElement(By.xpath(xpath));
		if (element.isDisplayed()) {
			System.out.println("Element is found : " + element.getTagName());
		} else {
			System.out.println("Element is not found : " + element.getTagName());
		}
		element.sendKeys(text);
	}

	@BeforeMethod
	@Parameters({ "browser" })
	public void setup(@Optional("chrome") String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Administrator\\Downloads\\chromedriver-win64\\chromedriver.exe");
		}
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Administrator\\Downloads\\geckodriver-v0.36.0-win-aarch64\\geckodriver.exe");
		}

		openBrowser(browser, "https://www.makemytrip.com/");
	}

	@Test(priority = 1)
	public void verifyLogoInFireFox() throws InterruptedException {

		WebElement popup_close = driver.findElement(By.className("commonModal__close"));
		assert popup_close.isDisplayed() : "Popup is not displayed";
		popup_close.click();
		System.out.println("Popup is closed");

		Thread.sleep(5000);
		WebElement logo = driver.findElement(By.cssSelector("a[data-cy='mmtLogo']"));
		assert logo.isDisplayed() : "Logo is not displayed";
	}

	@Test(priority = 2)
	public void flightBookingInChrome() throws InterruptedException {
		WebElement popup_close = driver.findElement(By.className("commonModal__close"));
		assert popup_close.isDisplayed() : "Popup is not displayed";
		popup_close.click();
		System.out.println("Popup is closed");

		clickElement("//a[contains(@href, 'makemytrip.com/flights')]");
		Thread.sleep(5000);

		clickElement("//li[@data-cy='oneWayTrip']");
		Thread.sleep(5000);

		clickElement("//label[@for='fromCity']");
		enterText("//input[@placeholder='From']", "Bengaluru");
		Thread.sleep(5000);
		clickElement("//ul[@role='listbox']//li[1]");

		clickElement("//label[@for='toCity']");
		enterText("//input[@placeholder='To']", "New Delhi");
		Thread.sleep(5000);
		clickElement("//ul[@role='listbox']//li[1]");

		driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
		Thread.sleep(5000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
