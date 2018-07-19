package com.acmapp.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;

public class EnvironmentSetup {
	public static AndroidDriver driver;

	@BeforeTest
	public void setUp() throws MalformedURLException, InterruptedException {
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
		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 
	 }
	 
	 @AfterTest
	 public void tearDown() {
		 System.out.println("Finished test");
		 driver.quit();
	 }

}
