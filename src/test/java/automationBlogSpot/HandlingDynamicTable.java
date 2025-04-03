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

	@Test(priority = 1, description = "CPU load of Chrome process")
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

	@Test(priority = 2, description = "Memory Size of Firefox process")
	public void firefoxMemorySize() {
		int columnCount = driver.findElements(By.xpath("//table[@id='taskTable']//thead//tr//th")).size();
		int rowCount = driver.findElements(By.xpath("//table[@id='taskTable']//tbody//tr")).size();

		int memorySizeColIndex = -1;
		String descValue = driver.findElement(By.xpath("//strong[@class='firefox-memory']")).getText();

		// Find the column index for "Memory (MB)"
		for (int i = 1; i <= columnCount; i++) {
			String header = driver.findElement(By.xpath("//table[@id='taskTable']//thead//tr//th[" + i + "]"))
					.getText();
			if (header.equals("Memory (MB)")) {
				memorySizeColIndex = i;
				break;
			}
		}

		// If "Memory (MB)" is not found exit
		if (memorySizeColIndex == -1) {
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
						.findElement(By.xpath(
								"//table[@id='taskTable']//tbody//tr[" + j + "]//td[" + memorySizeColIndex + "]"))
						.getText();
				if (memorySize.equals(descValue)) {
					System.out.println("Firefox Memory Size: " + memorySize);
					Assert.assertTrue(true);
				}
			}
		}
	}

	@Test(priority = 3, description = "Network speed of Chrome process")
	public void chromeNetworkSpeed() {
		int columnCount = driver.findElements(By.xpath("//table[@id='taskTable']//thead//tr//th")).size();
		int rowCount = driver.findElements(By.xpath("//table[@id='taskTable']//tbody//tr")).size();

		int networkColIndex = -1;
		String descValue = driver.findElement(By.xpath("//strong[@class='chrome-network']")).getText();

		// Find the column index for "Network (Mbps)"
		for (int i = 1; i < columnCount; i++) {
			String header = driver.findElement(By.xpath("//table[@id='taskTable']//thead//tr//th[" + i + "]"))
					.getText();
			if (header.equals("Network (Mbps)")) {
				networkColIndex = i;
				break;
			}
		}

		// If "Network (Mbps)" is not found exit
		if (networkColIndex == -1) {
			System.out.println("Network (Mbps) column not found");
			return;
		}

		// Find the row where chrome is present
		for (int j = 1; j < rowCount; j++) {
			String browserName = driver.findElement(By.xpath("//table[@id='taskTable']//tbody//tr[" + j + "]//td[1]"))
					.getText();
			if (browserName.equals("chrome")) {
				// Get the Chrome's Network Speed value from the correct row and column
				String networkSpeed = driver
						.findElement(
								By.xpath("//table[@id='taskTable']//tbody//tr[" + j + "]//td[" + networkColIndex + "]"))
						.getText();
				if (networkSpeed.endsWith(descValue)) {
					System.out.println("Network Speed os Chrome : " + networkSpeed);
					Assert.assertTrue(true);
				}
			}
		}
	}

	@Test(priority = 4, description = "Disk space of Firefox process")
	public void firefoxDiscSpace() {
		int columnCount = driver.findElements(By.xpath("//table[@id='taskTable']//thead//tr//th")).size();
		int rowCount = driver.findElements(By.xpath("//table[@id='taskTable']//tbody//tr")).size();

		int discSpaceColIndex = -1;
		String descValue = driver.findElement(By.xpath("//strong[@class='firefox-memory']")).getText();

		// Find the column index for "Disk (MB/s)"
		for (int i = 1; i <= columnCount; i++) {
			String header = driver.findElement(By.xpath("//table[@id='taskTable']//thead//tr//th[" + i + "]"))
					.getText();
			if (header.equals("Disk (MB/s)")) {
				discSpaceColIndex = i;
				break;
			}
		}

		// If "Disk (MB/s)" is not found exit
		if (discSpaceColIndex == -1) {
			System.out.println("Disk (MB/s) column not found.");
			return;
		}

		// Find the row where "FireFox" is located
		for (int j = 1; j < rowCount; j++) {
			String browserName = driver.findElement(By.xpath("//table[@id='taskTable']//tbody//tr[" + j + "]//td[1]"))
					.getText();
			if (browserName.equals("Firefox")) {
				// Get the Firefox disc space value from the correct row and column
				String discSpace = driver
						.findElement(By
								.xpath("//table[@id='taskTable']//tbody//tr[" + j + "]//td[" + discSpaceColIndex + "]"))
						.getText();
				if (discSpace.equals(descValue)) {
					System.out.println("Firefox Memory Size: " + discSpace);
					Assert.assertTrue(true);
				}
			}
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
