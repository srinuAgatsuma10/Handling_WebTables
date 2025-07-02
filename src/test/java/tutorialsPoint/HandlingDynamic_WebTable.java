package tutorialsPoint;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingDynamic_WebTable {
	
	WebDriver driver;
	
	@BeforeClass
	public void SetUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));;
		driver.get("");
		driver.manage().window().maximize();
	}
	
	@Test
	public void dynamicTable() {
		
	}
	
	@AfterClass
	public void tearDown() {
		
	}
}
