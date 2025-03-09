package automationBlogSpot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingPaginationTables {
		WebDriver driver;
		
		@BeforeClass
		public void setUp() {
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://testautomationpractice.blogspot.com/");
			driver.manage().window().maximize();
		}
		
		@Test
		public void checkThePagesClickCkeckBoxes() throws Exception {
			
			// Click on each page
			System.out.println("ID"+"\t"+"Name"+"\t"+"\t"+"Price");
			System.out.println("---------------------------------");
			
			for(int i = 0;i<=4; i++) {
				if(i>1) {
				driver.findElement(By.xpath("//ul[@id='pagination']//li["+i+"]")).click();
				}
				Thread.sleep(3000);
				// Finding number of rows of a table
				int no_rows = driver.findElements(By.xpath("//div[@class=\"widget-content\"]//table[@id=\"productTable\"]//tbody//tr")).size();
				for(int r = 1;r<no_rows;r++) {
					String id_text = driver.findElement(By.xpath("//div[@class=\"widget-content\"]//table[@id=\"productTable\"]//tbody//tr["+r+"]//td[1]")).getText();
					String name = driver.findElement(By.xpath("//div[@class=\"widget-content\"]//table[@id=\"productTable\"]//tbody//tr["+r+"]//td[2]")).getText();
					String price = driver.findElement(By.xpath("//div[@class=\"widget-content\"]//table[@id=\"productTable\"]//tbody//tr["+r+"]//td[3]")).getText();
					
					System.out.println(id_text+"\t"+name+"\t"+price);
				}
				// Selecting CheckBoxes
				for(int c = 1;c<=5;c++) {
					driver.findElement(By.xpath("//div[@class=\"widget-content\"]//table[@id=\"productTable\"]//tbody//tr["+c+"]//td[4]//input")).click();
				}
			}
		}		
		
		@AfterClass
		public void tearDown() {
			driver.quit();
		}
		
		
}
