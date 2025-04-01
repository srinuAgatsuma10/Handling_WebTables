package automateNow;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingSmapleTable {
	
	/*Test Cases
	 * 1) Get all Items in the table.
	 * 2) Print whole table in Console.
	 * 3) Pint total price of all items.
	 */
	
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().minimize();
	}
	
	@Test
	public void itemsInTable() {
		
	}
	
	@Test
	public void printTable() {
		
	}
	
	@Test
	public void itemsTotalPrice() {
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
