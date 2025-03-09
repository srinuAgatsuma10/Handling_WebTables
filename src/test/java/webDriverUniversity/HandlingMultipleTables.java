package webDriverUniversity;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class HandlingMultipleTables {
	
	/* Test Cases
	 * 1. Read Two tables data into Single Table and print in console.
	 * 2. Print the names who are below age 70
	 * 3. Print First names starts with letter 'J'.
	 **/
	
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://webdriveruniversity.com/Data-Table/index.html#");
//		driver.manage().window().maximize();
	}
	
	@Test(priority =1)
	public void printDataInConsole() {
		
	}
	
	@Test(priority = 2)
	public void ageBelow70() {
		
	}
	
	@Test(priority = 3)
	public void namesWithLetter_J() {
		
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
