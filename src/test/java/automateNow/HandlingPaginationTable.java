package automateNow;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingPaginationTable {

	/*Test Cases
	 * 1) Print all countries.
	 * 2) Print population of whose country name starts with 'B'.
	 * 3) Print sum of total population of all countries in the table.
	 */
	
	
	/* In this webpage the page navigator of pagination table is not working may be it's bug. So I've followed
	 Dropdown approach to read values in single time.*/
	
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
		// Click On Drop down
		WebElement myDrp = driver.findElement(By.xpath("//select[@id='dt-length-0']"));
		Select st = new Select(myDrp);
		st.selectByVisibleText("25");

		List<WebElement> countries = driver.findElements(By.xpath("//table[@id='tablepress-1']//tbody//tr//td[2]"));
		for (WebElement country : countries) {
			System.out.println(country.getText());
		}
	}

	@Test
	public void contriesWithB() {
		// Click On Drop down
		WebElement myDrp = driver.findElement(By.xpath("//select[@id='dt-length-0']"));
		Select st = new Select(myDrp);
		st.selectByVisibleText("25");

		List<WebElement> countries = driver.findElements(By.xpath("//table[@id='tablepress-1']//tbody//tr//td[2]"));
		for (int i = 0; i < countries.size(); i++) {
			String nation = countries.get(i).getText();
			if (nation.startsWith("B")) {
				String population = driver
						.findElement(By.xpath("//table[@id='tablepress-1']//tbody//tr[" + i + "]//td[3]")).getText();
				System.out.println(nation + "\t" + population);
			}
		}

	}

	@Test
	public void sumOfTotalPopulation() {

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
