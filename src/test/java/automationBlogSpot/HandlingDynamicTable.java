package automationBlogSpot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

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
	
	@Test
	public void chromCPULoad() {
		//CPU load of Chrome process
		String tableValue = driver.findElement(By.xpath("//table[@id=\"taskTable\"]//tbody//tr[1]//td[5]")).getText();
		String descValue = driver.findElement(By.xpath("")).getText();
		
	}
	
	@Test
	public void firefoxMemorySize() {
		String tableValue = driver.findElement(By.xpath("")).getText();
		String descValue = driver.findElement(By.xpath("")).getText();
	}
	
	@Test
	public void chromeNetworkSpeed() {
		String tableValue = driver.findElement(By.xpath("")).getText();
		String descValue = driver.findElement(By.xpath("")).getText();
	}
	
	@Test
	public void firefoxDiscSpace() {
		String tableValue = driver.findElement(By.xpath("")).getText();
		String descValue = driver.findElement(By.xpath("")).getText();
	}
	
	@Test
	public void testMethod() {
		for(int i =0;i<=5;i++) {
			String headText = driver.findElement(By.xpath("//table[@id=\"taskTable\"]//thead//tr//th["+i+"]")).getText();
			String name = driver.findElement(By.xpath("//table[@id='taskTable']//tbody//tr[1]//td["+i+"]")).getText();
			if(headText.equals("CPU (%)") && name.equals("Chrome")) {
				// Need to Implement...
			}
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
