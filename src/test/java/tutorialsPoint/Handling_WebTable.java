package tutorialsPoint;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Handling_WebTable {

	/* Test Cases
	 * 1) Print total table in console.
	 * 2) Print sum of the salary.
	 * 3) Delete all records in table using delete icon.
	 */
	
	WebDriver driver;

	@BeforeClass
	public void SetUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php#");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void printTotalTable() {
		int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped mt-3']//tbody//tr")).size();
		int colCount = driver.findElements(By.xpath("//table[@class='table table-striped mt-3']//thead//tr//th"))
				.size();

		for (int i = 1; i <= colCount; i++) {
			String tableHeaders = driver
					.findElement(By.xpath("//table[@class='table table-striped mt-3']//thead//tr//th[" + i + "]"))
					.getText();
			System.out.print(tableHeaders + "\t");
		}
		System.out.println();

		for (int ro = 1; ro <= rowCount; ro++) {
			for (int co = 1; co <= colCount; co++) {
				String table_Data = driver
						.findElement(By.xpath(
								"//table[@class='table table-striped mt-3']//tbody//tr[" + ro + "]//td[" + co + "]"))
						.getText();
				System.out.print(table_Data + "\t");
			}
			System.out.println();
		}

	}

	@Test(priority = 2)
	public void sumOfSalary() {
		int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped mt-3']//tbody//tr")).size();
		int sum = 0;
		for (int i = 1; i <= rowCount; i++) {
			int salary = Integer.parseInt(driver
					.findElement(By.xpath("//table[@class='table table-striped mt-3']//tbody//tr//td[5]")).getText());
			sum = sum + salary;
		}
		System.out.println("The total sum of Salary : "+sum);
	}

	@Test(priority = 3)
	public void deleteRecords() {
		int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped mt-3']//tbody//tr")).size();
		for (int i = 1; i <= rowCount; i++) {
			driver.findElement(By.xpath(
					"//table[@class='table table-striped mt-3']//tbody//tr//td[7]//a[@class=\"delete-wrap confirmdeletebtn\"]"))
					.click();
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
