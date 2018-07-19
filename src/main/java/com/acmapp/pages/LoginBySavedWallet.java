package com.acmapp.pages;

import com.acmapp.base.DriverAction;

import io.appium.java_client.android.AndroidDriver;

public class LoginBySavedWallet extends DriverAction {
	
	public LoginBySavedWallet(AndroidDriver driver) {
		super(driver);
		DriverAction.waitElementPresent(CreateNewWalletBtn);
		
	}
	//Locator xpath
    private static final String CreateNewWalletBtn = "//android.widget.TextView[@text='Create a new wallet']";
	
	public void clickCreateNewWallet() {
		DriverAction.clickElement(CreateNewWalletBtn);
	}
}
