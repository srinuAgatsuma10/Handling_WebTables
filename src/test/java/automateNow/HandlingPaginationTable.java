package automateNow;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
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
		for(int i =1;i<3;i++) {
			if(i>1) {
				WebElement next =driver.findElement(By.xpath("//nav[@aria-label='pagination']//button[@data-dt-idx="+i+"]"));
				mywait.until(ExpectedConditions.elementToBeClickable(next)).click();
			}
			
			List<WebElement> countries = driver.findElements(By.xpath("//table[@id='tablepress-1']//tbody//tr//td[2]"));
			for(WebElement country : countries) {
				System.out.println(country.getText());
			}
		}
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
