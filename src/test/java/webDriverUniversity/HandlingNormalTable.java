package webDriverUniversity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingNormalTable {

	/* Test Cases
	 * 1. Read data from specific row and column (ex: 5th row and 1st col)
	 * 2. Read the data form all the rows and columns
	 * 3. Print all Last Names
	 * */
	
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://webdriveruniversity.com/Data-Table/index.html#");
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void readDataFromCell() {
		// Data in 2nd Row and 1nd Column
		String cell_Data1 = driver
				.findElement(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr[2]//td[1]"))
				.getText();
		System.out.println("Data in 2nd Row and 1nd Column :" + cell_Data1);

		// Data in 3nd Row and 2nd Column
		String cell_Data2 = driver
				.findElement(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr[3]//td[2]"))
				.getText();
		System.out.println("Data in 3nd Row and 2nd Column :" + cell_Data2);
	}

	@Test(priority = 2)
	public void printAllDataInTable() {
		System.out.println("FirstName " + "LastName");
		for (int r = 1; r <= 2; r++) {
			for (int c = 1; c <= 2; c++) {
				String table_data = driver.findElement(By.xpath(
						"//table[@class='table table-light traversal-table']//tbody//tr[" + r + "]//td[" + c + "]"))
						.getText();
				System.out.print(table_data + "\t");
			}
			System.out.println();
		}
	}

	@Test(priority = 3)
	public void getLastNames() {
		System.out.println("The last in Table are :");
		for (int i = 1; i <= 2; i++) {
			String lastNames = driver
					.findElement(By
							.xpath("//table[@class='table table-light traversal-table']//tbody//tr[" + i + "]//td[2]"))
					.getText();
			System.out.println(lastNames);
		}
		System.out.println();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
