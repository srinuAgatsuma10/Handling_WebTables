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

	/* Test Cases 
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

	@Test(priority = 1, description = "Get all Items in the table.")
	public void itemsInTable() {
		List<WebElement> items = driver
				.findElements(By.xpath("//figure[@class='wp-block-table']//table//tbody//tr//td[1]"));
		for (WebElement item : items) {
			System.out.println(item.getText());
		}
	}

	@Test(priority = 2, description = "Print whole table in Console.")
	public void printTable() {
		int row_size = driver.findElements(By.xpath("//figure[@class='wp-block-table']//table//tbody//tr")).size();
		int col_size = driver.findElements(By.xpath("//figure[@class='wp-block-table']//table//tbody//tr[1]//td"))
				.size();

		for (int row = 1; row <= row_size; row++) {
			for (int col = 1; col <= col_size; col++) {
				String tableData = driver
						.findElement(By.xpath(
								"//figure[@class='wp-block-table']//table//tbody//tr[" + row + "]//td[" + col + "]"))
						.getText();
				System.out.print(tableData + "\t");
			}
			System.out.println();
		}
	}

	@Test(priority = 3, description = "Pint total price of all items.")
	public void itemsTotalPrice() {
		List<WebElement> prices = driver
				.findElements(By.xpath("//figure[@class='wp-block-table']//table//tbody//tr//td[2]"));
		try {
			double sum = 0;
			for (int i = 2; i < prices.size(); i++) {
				double price = Double.parseDouble(prices.get(i).getText().substring(1));
				sum = sum + price;
			}
			System.out.println("The total price of all Items : " + sum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
