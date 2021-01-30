package com.qa.claimspro.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.claimspro.base.BaseClass;

public class LoginTest extends BaseClass {

	public LoginTest logintest;
	public LoginTest() {
		super();
	}	

	@BeforeMethod
	public void setUp() {
		initialization();
		logintest = new LoginTest();
	}

	@Test
	public void close() {
		driver.close();
	}
}
