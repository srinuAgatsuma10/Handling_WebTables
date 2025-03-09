package webDriverUniversity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class HandlingMultipleTables {

	/* Test Cases
	 * 1. Read Two tables data into Single Table and print in console.
	 * 2. Print the First names who are below age 70
	 * 3. Print First names starts with letter 'J'.
	 **/
	
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
	public void printDataInConsole() {

		String[][] dataArr = new String[6][3];
		int index = 0;

		// Access Table One data
		for (int r = 2; r <= 4; r++) {
			for (int c = 1; c <= 3; c++) {
				dataArr[index][c - 1] = driver
						.findElement(By.xpath(
								"//body[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]//tr[" + r + "]//td[" + c + "]"))
						.getText();
			}
			index++;
		}

		// Access Table Two data
		for (int r = 2; r <= 4; r++) {
			for (int c = 1; c <= 3; c++) {
				dataArr[index][c - 1] = driver
						.findElement(By.xpath(
								"//body[1]/div[1]/div[2]/div[1]/table[2]/tbody[1]//tr[" + r + "]//td[" + c + "]"))
						.getText();
			}
			index++;
		}

		// Print the Final Table
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(dataArr[i][j] + "\t");
			}
			System.out.println();
		}

	}

	@Test(priority = 2)
	public void ageBelow70() {

		String[][] dataArr = new String[6][3];
		int index = 0;

		// Access Table One data
		for (int r = 2; r <= 4; r++) {
			for (int c = 1; c <= 3; c++) {
				dataArr[index][c - 1] = driver
						.findElement(By.xpath(
								"//body[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]//tr[" + r + "]//td[" + c + "]"))
						.getText();
			}
			index++;
		}

		// Access Table Two data
		for (int r = 2; r <= 4; r++) {
			for (int c = 1; c <= 3; c++) {
				dataArr[index][c - 1] = driver
						.findElement(By.xpath(
								"//body[1]/div[1]/div[2]/div[1]/table[2]/tbody[1]//tr[" + r + "]//td[" + c + "]"))
						.getText();
			}
			index++;
		}

		// Print the Results
		for (int i = 0; i < dataArr.length; i++) {
			int age = Integer.parseInt(dataArr[i][2]); // Convert age to integer
			if (age < 70) {
				System.out.println(dataArr[i][0]); // Print first name
			}
		}

	}

	@Test(priority = 3)
	public void namesWithLetter_J() {
		String[][] dataArr = new String[6][3];
		int index = 0;

		// Access Table One data
		for (int r = 2; r <= 4; r++) {
			for (int c = 1; c <= 3; c++) {
				dataArr[index][c - 1] = driver
						.findElement(By.xpath(
								"//body[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]//tr[" + r + "]//td[" + c + "]"))
						.getText();
			}
			index++;
		}

		// Access Table Two data
		for (int r = 2; r <= 4; r++) {
			for (int c = 1; c <= 3; c++) {
				dataArr[index][c - 1] = driver
						.findElement(By.xpath(
								"//body[1]/div[1]/div[2]/div[1]/table[2]/tbody[1]//tr[" + r + "]//td[" + c + "]"))
						.getText();
			}
			index++;
		}

		// Print the Results
		for (int i = 0; i < dataArr.length; i++) {
			String name = dataArr[i][0];
			if (name.startsWith("J")) {
				System.out.println(name);
			}
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
