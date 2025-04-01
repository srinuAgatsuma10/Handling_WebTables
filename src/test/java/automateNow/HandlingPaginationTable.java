package automateNow;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingPaginationTable {
	
	/*Test Cases
	 * 1) Print all countries.
	 * 2) Print population whose country name starts with 'B'.
	 * 3) Print sum of total population of all countries in the table.
	 */
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practice-automation.com/tables/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void allCountries() {
		
	}
	
	@Test
	public void contriesWithB() {
		
	}
	
	@Test
	public void sumOfTotalPopulation() {
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
