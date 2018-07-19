package com.acmapp.testscripts;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class justtest {

	 

			private static AppiumDriver driver;
			
			public static void main(String[] args) throws MalformedURLException, InterruptedException {
	 
				//Set up desired capabilities and pass the Android app-activity and app-package to Appium
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("BROWSER_NAME", "Android");
				capabilities.setCapability("VERSION", "8.1"); 
				capabilities.setCapability("deviceName","emulator-5556");
				capabilities.setCapability("platformName","Android");
			 
			   
				capabilities.setCapability("appPackage", "com.gcox.wallet.staging");
			// This package name of your app (you can get it from apk info app)
				capabilities.setCapability("appActivity","com.gcox.wallet.features.launcher.LauncherActivity"); // This is Launcher activity of your app (you can get it from apk info app)
				capabilities.setCapability("appWaitActivity","com.gcox.wallet.features.launcher.LauncherActivity");
				//Create RemoteWebDriver instance and connect to the Appium server
			 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
			   driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			   
			  // WebDriverWait wait = new WebDriverWait();
			   Thread.sleep(5000);
			   TouchAction action = new TouchAction(driver);
	
			   driver.findElement(By.xpath("//android.widget.TextView[@text='Create a new wallet']")).click();
	 
		}
	 
	}

