package com.acmapp.testscripts;

import org.testng.annotations.Test;

import com.acmapp.base.EnvironmentSetup;
import com.acmapp.pages.AccountDetail;
import com.acmapp.pages.CreateNewWallet;
import com.acmapp.pages.LoginBySavedWallet;

public class testCreateNewWallet extends EnvironmentSetup{
	@Test
	public void f() throws InterruptedException {
		Thread.sleep(5000);
		LoginBySavedWallet navigate = new LoginBySavedWallet(driver);
		navigate.clickCreateNewWallet();
		CreateNewWallet register = new CreateNewWallet(driver);
		register.GenerateNewWalletAction("123456", "123456");
		
		AccountDetail account = new AccountDetail(driver);
		account.CompleteAccountDetailAction("nhan van");
		Thread.sleep(10000);
	}
}
