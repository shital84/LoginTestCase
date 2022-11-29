package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import base.BaseTest;
import utilities.ReadXLSdata;

public class LoginTestCase extends BaseTest {
	
	@Test(dataProviderClass=ReadXLSdata.class,dataProvider="logindata")
	public static void loginTest(String username, String password) throws InterruptedException {
		
	
		driver.findElement(By.linkText(loc.getProperty("login_link"))).click();
		driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys(username);
		driver.findElement(By.id(loc.getProperty("password_field"))).sendKeys(password);
		Thread.sleep(4000);
		driver.findElement(By.xpath(loc.getProperty("login_btn"))).click();
		Thread.sleep(8000);
		Assert.assertEquals("Home - Hudl",driver.getTitle());
		
	}

	
	
}
