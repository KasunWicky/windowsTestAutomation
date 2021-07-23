package com.Test;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WindowsTestDemo {
	public static WindowsDriver<WebElement> driver;

	@Test
	public void launchApplication() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("app", "C:\\WINDOWS\\system32\\notepad.exe");
		capabilities.setCapability("platformName", "WINDOWS");
		capabilities.setCapability("deviceName", "WINDOWS");
		
		try {
			driver = new WindowsDriver<>(new URL("http://127.0.0.1:4723"), capabilities);
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

		} catch (MalformedURLException e) {
			/**
			 * Handle malformed URL Exception *
			 */
			Assert.fail("Windows app is not launched.\t" + e.getMessage());

		} catch (Exception ex) {
			/**
			 * General Exception
			 */
			Assert.fail("Windows app is not launched.\t" + ex.getMessage());
		}

		driver.findElement(By.name("Text Editor")).click();
		driver.findElement(By.name("Text Editor")).sendKeys("Written By Automated Windows Application Test !!!");
	}

}
