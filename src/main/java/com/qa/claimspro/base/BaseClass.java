package com.qa.claimspro.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.claimspro.utility.WebListener;

public class BaseClass {

	public static WebDriver driver;
	Properties prop;
	public static WebListener listener;
	public static EventFiringWebDriver eventDriver;

	public BaseClass() {
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream("C:\\Users\\Himanshu.Dubey\\eclipse-workspace\\ClaimsPro\\src\\main\\java\\com\\qa\\claimspro\\config\\config.properties");
			prop.load(file);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32 (2)\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		eventDriver = new EventFiringWebDriver(driver);
		listener = new WebListener();
		eventDriver.register(listener);
		driver = eventDriver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}


}
