package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class DriverUtilities {
	AppiumDriver driver;

	public DriverUtilities(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public void scrollDown() {
		TouchAction action = new TouchAction((PerformsTouchActions) driver);
		PointOption pressOptions = new PointOption();
		action.press(pressOptions.withCoordinates(950, 530)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(pressOptions.withCoordinates(950, 185)).release().perform();
	}

	public void scrollRight() {
		TouchAction action = new TouchAction((PerformsTouchActions) driver);
		PointOption pressOptions = new PointOption();
		action.press(pressOptions.withCoordinates(1000, 600))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(pressOptions.withCoordinates(200, 600)).release().perform();
	}

	public void clickElementByText(String buttonText) {
		driver.findElement(By.xpath("//*[@text='" + buttonText + "']")).click();
	}

	public void clickElementByTextIfExists(String buttonText) {
		if(isTextDisplayed(buttonText)){
			driver.findElement(By.xpath("//*[@text='" + buttonText + "']")).click();
		}
	}

	public String getElementText(String locator) {
		if (locator.contains("//")) {
			return driver.findElement(By.xpath(locator)).getText();
		} else {
			return driver.findElement(By.id(locator)).getText();
		}
	}

	public void clickElementByAccessibilityID(String accessibilityId) {
		driver.findElementByAccessibilityId(accessibilityId).click();
	}

	public boolean isTextDisplayed(String text) {
		try {
			return driver.findElement(By.xpath("//*[@text='" + text + "']")).isDisplayed();
		}
		catch(Exception e){
			return false;
		}
	}

	public boolean isElementDisplayed(String locator) {
		try {
			if (locator.contains("//")) {
				return driver.findElement(By.xpath(locator)).isDisplayed();
			} else {
				return driver.findElement(By.id(locator)).isDisplayed();
			}
		}
		catch(Exception e){
			return false;
		}
	}

}