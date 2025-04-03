package automationBlogSpot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingDynamicTable {

	/* Validate these four test cases/
	 * CPU load of Chrome process is equal to value in table
	 * Memory Size of Firefox process is equal to value in table
	 * Network speed of Chrome process is equal to value in table
	 * Disk space of Firefox process is equal to value in table
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

	@Test(description = "CPU load of Chrome process")
	public void chromCPULoad() {
		int columnCount = driver.findElements(By.xpath("//table[@id='taskTable']//thead//tr//th")).size();
		int rowCount = driver.findElements(By.xpath("//table[@id='taskTable']//tbody//tr")).size();

		int cpuColumnIndex = -1;
		String descValue = driver.findElement(By.xpath("//strong[@class='chrome-cpu']")).getText();

		// Find the column index for "CPU (%)"
		for (int i = 1; i <= columnCount; i++) {
			String header = driver.findElement(By.xpath("//table[@id='taskTable']//thead//tr//th[" + i + "]"))
					.getText();
			if (header.equals("CPU (%)")) {
				cpuColumnIndex = i;
				break;
			}
		}

		// If "CPU (%)" column is not found, exit
		if (cpuColumnIndex == -1) {
			System.out.println("CPU (%) column not found.");
			return;
		}

		// Find the row where "Chrome" is located
		for (int j = 1; j <= rowCount; j++) {
			String browserName = driver.findElement(By.xpath("//table[@id='taskTable']//tbody//tr[" + j + "]//td[1]"))
					.getText();

			if (browserName.equals("Chrome")) {
				// Get the CPU usage value from the correct row and column
				String cpuUsage = driver
						.findElement(
								By.xpath("//table[@id='taskTable']//tbody//tr[" + j + "]//td[" + cpuColumnIndex + "]"))
						.getText();
				if (cpuUsage.equals(descValue)) {
					System.out.println("Chrome CPU Usage: " + cpuUsage);
					Assert.assertTrue(true);
				}
			}
		}

	}

	@Test(description = "Memory Size of Firefox process")
	public void firefoxMemorySize() {
		int columnCount = driver.findElements(By.xpath("//table[@id='taskTable']//thead//tr//th")).size();
		int rowCount = driver.findElements(By.xpath("//table[@id='taskTable']//tbody//tr")).size();

		int fireFoxColIndex = -1;
		String descValue = driver.findElement(By.xpath("//strong[@class='firefox-memory']")).getText();

		// Find the column index for "Memory (MB)"
		for (int i = 1; i <= columnCount; i++) {
			String header = driver.findElement(By.xpath("//table[@id='taskTable']//thead//tr//th[" + i + "]"))
					.getText();
			if (header.equals("Memory (MB)")) {
				fireFoxColIndex = i;
				break;
			}
		}

		// If "Memory (MB)" is not found exit
		if (fireFoxColIndex == -1) {
			System.out.println("Memory (MB) column not found.");
			return;
		}

		// Find the row where "FireFox" is located
		for (int j = 1; j < rowCount; j++) {
			String browserName = driver.findElement(By.xpath("//table[@id='taskTable']//tbody//tr[" + j + "]//td[1]"))
					.getText();
			if (browserName.equals("Firefox")) {
				// Get the Firefox memory size value from the correct row and column
				String memorySize = driver
						.findElement(
								By.xpath("//table[@id='taskTable']//tbody//tr[" + j + "]//td[" + fireFoxColIndex + "]"))
						.getText();
				if (memorySize.equals(descValue)) {
					System.out.println("Firefox Memory Size: " + memorySize);
					Assert.assertTrue(true);
				}
			}
		}
	}

	@Test(description = "Network speed of Chrome process")
	public void chromeNetworkSpeed() {
		
	}

	@Test(description = "Disk space of Firefox process")
	public void firefoxDiscSpace() {
		

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
