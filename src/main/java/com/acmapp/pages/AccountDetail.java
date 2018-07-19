package com.acmapp.pages;

import com.acmapp.base.DriverAction;

import io.appium.java_client.android.AndroidDriver;

public class AccountDetail extends DriverAction{
  
    private static final String encryptedKey = "//android.widget.EditText[contains(@resource-id,\'com.gcox.wallet.staging:id/detail_editText_key\')]";
    private static final String copyBtn = "//android.widget.TextView[contains(@resource-id,\'com.gcox.wallet.staging:id/detail_textView_keyCopy\')]";
    private static final String passPhraseField = "//android.widget.EditText[contains(@resource-id,\'com.gcox.wallet.staging:id/detail_editText_passphrase\')]";
    private static final String passPhraseHiddenBtn = "//android.widget.EditText[contains(@resource-id,\'com.gcox.wallet.staging:id/text_input_password_toggle\')]";
    private static final String checkBox = "//android.widget.CheckBox[contains(@resource-id,\'com.gcox.wallet.staging:id/detail_checked_backup\')]";
    private static final String saveBtn = "//android.widget.Button[contains(@resource-id,\'com.gcox.wallet.staging:id/detail_button_save\')]";
    private static final String walletNameField = "//android.widget.EditText[contains(@resource-id,\'com.gcox.wallet.staging:id/detail_editText_name\')]";
    private static final String backBtn = "//android.widget.ImageButton[content-desc='Navigate up')]";
    private static final String cancelBtn = "//android.widget.Button[contains(@resource-id,\'com.gcox.wallet.staging:id/detail_button_cancel\')]";
    //private static final String verifySuccess = "//android.widget.FrameLayout[contains(@resource-id,\'com.gcox.wallet.staging:id/home_nav_exchange;\')]";

    public AccountDetail(AndroidDriver driver) {
    	super(driver);
    	DriverAction.waitElementPresent(encryptedKey);
    }
    
    //Get Encrypted Key
    public static String getEncryptedKey() {
    	return DriverAction.getText(encryptedKey);
    }
    
    //Set Wallet Name
    public void setWalletName(String name) {
    	DriverAction.sendKeys(walletNameField, name);
    }
    
   //Click Eye Button on PassPhrase
    public void clickEyeBtnPassPhrase() {
    	DriverAction.clickElement(passPhraseHiddenBtn);
    }
    
    //Get PassPhrase
    public static String getPassPhrase() {
    	return DriverAction.getText(passPhraseField);
    }
    
    //Tick Checkbox I have backup my Encrypted Key and passphrase
    public void clickCheckBox() {
    	DriverAction.clickElement(checkBox);
    }
    
    //Click Cancel Button
    public void clickCancelBtn() {
    	DriverAction.clickElement(cancelBtn);
    }
    
    //Click Save Button
    public void clickSaveBtn() {
    	DriverAction.clickElement(saveBtn);
    }
    
    //Click Back Button
    public void clickBackBtn() {
    	DriverAction.clickElement(backBtn);
    }
    
    //Click Copy Button
    public void clickCopyBtn() {
    	DriverAction.clickElement(copyBtn);
    }
    
    public void CompleteAccountDetailAction(String walletName) {
    	this.setWalletName(walletName);
    	this.swipeScreenDown();
    	this.clickCheckBox();
    	
    }
}
