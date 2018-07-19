package com.acmapp.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class DriverAction {
	public static AndroidDriver driver = null;
	public static TouchAction touchAction;
	
	public DriverAction(AndroidDriver driver) {
		DriverAction.driver = driver;
	}
	//GET an Element
	public static WebElement getElement(String locator) {
		WebElement element = null;
		try {
			element = driver.findElement(By.xpath(locator));
			System.out.println("GET Element with locator: "+locator+" SUCCESS");
			
		}catch(Exception e) {		
			System.out.println("GET Element with locator: "+locator+" FAILED");
			e.printStackTrace();
		}
		return element;
	}
	
	//Get multiple Element
	@SuppressWarnings("unchecked")
	public static List<WebElement> getElements(String locator) {
		List<WebElement> element = null;
		try {
			element = driver.findElements(By.xpath(locator));
			System.out.println("GET Element with locator: "+locator+" SUCCESS");
		}catch(Exception e) {
			System.out.println("GET Element with locator: "+locator+" FAILED");
			e.printStackTrace();
		}
		return element;
	}
	
	//CLICK on an Element
	public static void clickElement(String locator) {
		try {
			WebElement element = getElement(locator);
			element.click();
			System.out.println("CLICK Element with locator: "+locator+" SUCCESS");
		} catch(Exception e) {
			System.out.println("CLICK Element with locator: "+locator+" FAILED");
			e.printStackTrace();
		}
	}
	
	public static String getText(String locator) {
		String text = null;
		try {
			WebElement element = getElement(locator);
			text = element.getText();
			System.out.println("GET TEXT Element with locator: "+locator+" SUCCESS");
		} catch(Exception e) {
			System.out.println("G Element with locator: "+locator+" FAILED");
			e.printStackTrace();
		}
		return text;
	}
	
	
	public static void sendKeys(String locator, String key) {
		try {
			WebElement element = getElement(locator);
			element.clear();
			element.sendKeys(key);
			driver.hideKeyboard();
			System.out.println("SEND KEYS to Element with locator: "+locator+" SUCCESS");
		} catch(Exception e) {
			System.out.println("SEND KEYS to Element with locator: "+locator+" FAILED");
			e.printStackTrace();
		}
	}
	
	public static void waitElementPresent(String locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
			System.out.println("WAIT to Element present with locator: "+locator+" SUCCESS");
		}catch (Exception e) {
			System.out.println("WAIT to Element present with locator: "+locator+" FAILED");
			e.printStackTrace();
		}
	}
	
	public static void waitElementPresent(String locator, int time) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
			System.out.println("WAIT to Element present with locator: "+locator+" SUCCESS");
		}catch (Exception e) {
			System.out.println("WAIT to Element present with locator: "+locator+" FAILED");
			e.printStackTrace();
		}
	}
	
	public static void swipeScreen(int startX, int startY, int endX, int endY) {
		touchAction = new TouchAction(driver);
		touchAction.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
	}
	
	public void swipeScreenDown() {
		Dimension size = driver.manage().window().getSize();
		int x1 = (int) (size.width*0.5);
		
		int y1 = (int) (size.height*0.2);
		int y2 = (int) (size.height*0.8);
		
		swipeScreen(x1,y2,x1,y1);
	}
	
}
