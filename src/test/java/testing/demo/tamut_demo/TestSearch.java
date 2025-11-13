package testing.demo.tamut_demo;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSearch {
	
	private WebDriver driver;
	private MainPage mainPage;
	
	@BeforeClass
	public void setupClass() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	}
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		mainPage = new MainPage(driver);
		mainPage.open();
	}
	
	@Test
	public void testSearchCS() {				
		mainPage.sendKeys2SearchBox("Computer Science");
		
		WebElement csHyberLink = driver.findElement(By.xpath("//a[contains(@href, 'computer-science')]"));
		
		assertTrue(csHyberLink.isDisplayed());

	}
	
	@Test
	public void testSearchBusiness() {		
		mainPage.sendKeys2SearchBox("Business");		
		assertTrue(driver.findElement(By.linkText("Department of Business - Texas A&M Texarkana")).isDisplayed());
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@AfterClass
	public void tearDownClass() {
		System.out.println("Tests Completed");
		
	}
	
	
	

}
