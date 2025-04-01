package automateNow;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		driver.get("https://practice-automation.com/tables/");
		driver.manage().window().minimize();
	}
	
	@Test
	public void itemsInTable() {
		List<WebElement> items = driver.findElements(By.xpath("//figure[@class='wp-block-table']//table//tbody//tr//td[1]"));
		for(WebElement item : items) {
			System.out.println(item.getText());
		}
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
