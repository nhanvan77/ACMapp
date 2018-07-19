package com.acmapp.pages;


import com.acmapp.base.DriverAction;

import io.appium.java_client.android.AndroidDriver;

public class CreateNewWallet extends DriverAction {
    //Xpath Locator of Create New Wallet page

    private static final String passphraseField = "//android.widget.EditText[contains(@resource-id,\'com.gcox.wallet.staging:id/create_editText_passphrase\')]";
    private static final String confirmPassPhraseField = "//android.widget.EditText[contains(@resource-id,\'com.gcox.wallet.staging:id/create_editText_passphrase2\')]";
    private static final String generateKeyBtn = "//android.widget.Button[contains(@resource-id,\'com.gcox.wallet.staging:id/create_btn_generate\')]";
    //private static final String loginSavedWalletBtn = "//android.widget.TextView[contains(@resource-id,\'com.gcox.wallet.staging:id/create_textView_startLink\')]";
   // private static final String loginEncrytedKey = "//android.widget.TextView[contains(@resource-id,\'com.gcox.wallet.staging:id/login_textView_startLink\')]";
    //private static final String verifySuccess = "//android.widget.Button[contains(@resource-id,\'com.gcox.wallet.staging:id/detail_button_save\')]";

    public CreateNewWallet(AndroidDriver driver) {
    	super(driver);
    	DriverAction.waitElementPresent(generateKeyBtn);
    }
    
    public void setPassPhrase(String value) {
    	DriverAction.sendKeys(passphraseField, value);
    }
    
    public void setConfirmPassPhrase(String value) {
    	DriverAction.sendKeys(confirmPassPhraseField, value);
    }
    
    public void clickGenerateButton() {
    	DriverAction.clickElement(generateKeyBtn);
    }
    
    public void GenerateNewWalletAction(String passPhrase, String confirmPassPhrase) {
    	this.setPassPhrase(passPhrase);
    	this.setConfirmPassPhrase(confirmPassPhrase);
    	this.clickGenerateButton();
    }
    
}
