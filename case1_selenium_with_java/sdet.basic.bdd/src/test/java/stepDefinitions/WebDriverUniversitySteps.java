
package stepDefinitions;

import com.vidhyatharan.sdet.basic.bdd.BaseTest;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WebDriverUniversitySteps extends BaseTest {
	
	private String activeImageSrc;

	@Given("I launch WebDriverUniversity homepage")
	public void launchPage() {
		initializeDriver();
		driver.get("http://webdriveruniversity.com/index.html");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("WebDriverUniversity page is launched");
	}

	@Then("Page title should be {string}")
	public void verifyTitle(String expectedTitle) {
		System.out.println("Actual page title : " + driver.getTitle());
		System.out.println("Expected page title : " + expectedTitle);
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		System.out.println("Page title is verified");
	}
	
	@When("I click on iframe link")
	public void clickIframeLink() {
		WebElement iframeLink = driver.findElement(By.id("iframe"));
		System.out.println("iframe link found: " + iframeLink.isDisplayed());
		iframeLink.click();
		System.out.println("iframe link is clicked");
	}
	
	@Then("New tab should be opened")
	public void clickNewTab() {
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		System.out.println("Switched to iframe tab");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@And("I verify the image is present")
	public void verifyImage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		System.out.println("Switched to iframe image");

		List<WebElement> images = driver.findElements(By.cssSelector(".carousel-inner img"));
		for (WebElement img : images) {
			System.out.println("Listing carousel image sources: " + img.getAttribute("src"));
		}

		WebElement activeImage = driver.findElement(By.cssSelector(".carousel-inner .item.active img"));
		System.out.println("Carousel active image found: " + activeImage.isDisplayed());
		activeImageSrc = activeImage.getAttribute("src");
		System.out.println("Carousel active image source : " + activeImageSrc);
		Assert.assertTrue(activeImage.isDisplayed(), "Carousel active image is not displayed");
	}
	
	@When("I click on right side arrow")
	public void clickRightArrow() {
		WebElement rightArrow = driver.findElement(By.xpath("//a[@class='right carousel-control']//span"));
		System.out.println("Right side arrow found: " + rightArrow.isDisplayed());
		rightArrow.click();
		System.out.println("Right side arrow is clicked");
	}
	
	@Then("Image should change")
	public void verifyImageChange() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(d -> {
			WebElement newActiveImage = d.findElement(By.cssSelector(".carousel-inner .item.active img"));
			String newSrc = newActiveImage.getAttribute("src");
			return !newSrc.equals(activeImageSrc);
		});
		
		WebElement newActiveImage = driver.findElement(By.cssSelector(".carousel-inner .item.active img"));
		System.out.println("New carousel active image found: " + newActiveImage.isDisplayed());
		String newActiveImageSrc = newActiveImage.getAttribute("src");
		System.out.println("New carousel active image source : " + newActiveImageSrc);
		Assert.assertNotEquals(activeImageSrc, newActiveImageSrc, "Carousel image did not change after clicking right side arrow");
		
		tearDown();
	}
}
