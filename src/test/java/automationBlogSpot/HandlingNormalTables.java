package automationBlogSpot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class HandlingNormalTables {
	
	/* Test Cases
	 * 1. Perform Basic operations on table (Get Row and Column Size, Read data from Specific row and column
	 * 2. Read the data form all the rows and columns
	 * 3. Print book names whose author is Mukesh 
	 * 4. Find total price of all books */

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().minimize();
	}

	// 1. Perform Basic operations on table (Get Row and Column Size, Read data from Specific row and column	
	@Test(priority = 1)
	public void basicTableOperations() {

		// 1)Find total number of rows in table
		int row_size = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr")).size();
		System.out.println("No of rows in table :" + row_size);
		// 2)Find total number of columns in a table
		int col_size = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//th")).size();
		System.out.println("No of colomns in table :" + col_size);
		// 3)Read data from specific row and column (ex: 5th row and 1st col)
		String data_roc = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[5]//td[1]")).getText();
		System.out.println("Data in 5th row and 1st col :" + data_roc);
		String data_roc1 = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[3]//td[3]")).getText();
		System.out.println("Data in 3th row and 3st col :" + data_roc1);
	}
	
	
	// 2. Read the data form all the rows and columns
	@Test(priority = 2)
	public void printTableData() {
		
		int row_size = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr")).size();
		int col_size = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//th")).size();
		for (int ro = 2; ro <= row_size; ro++) {
			for (int co = 1; co <= col_size; co++) {
				String table_Data = driver
						.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[" + ro + "]//td[" + co + "]"))
						.getText();
				System.out.print(table_Data + "\t");
			}
			System.out.println();
		}
	}
	
	
	// 3. Print book names whose author is mukesh
	@Test(priority = 3)
	public void getBookAuhter() {
		
		int row_size = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr")).size();
		for (int a = 2; a <= row_size; a++) {
			String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + a + "]//td[2]")).getText();
			if (author.equalsIgnoreCase("mukesh")) {
				String BookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + a + "]//td[1]"))
						.getText();
				System.out.println(BookName);
			}
		}
	}

	
	// 4. Find total price of all books
	@Test(priority = 4)
	public void sumOfAllBooksPrice() {
		
		int row_size = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr")).size();
		int sum = 0;
		for (int b = 2; b <= row_size; b++) {
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + b + "]//td[4]")).getText();
			sum = sum + Integer.parseInt(price);
		}
		System.out.println(sum);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
