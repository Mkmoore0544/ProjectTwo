package testing.demo.tamut_demo;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestVisitUsPage {
	
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
	public void testVisitUs() {

		mainPage.clickVisitUsFromAbout();
		
		VisitUsPage visitUsPage = new VisitUsPage(driver);
		
		assertTrue(visitUsPage.isUpcomingEventsDisplayed());
		assertTrue(visitUsPage.isScheduleCampusTourDisplayed());
		assertTrue(visitUsPage.isVirtualTourDisplayed());
		assertTrue(visitUsPage.titleContainsVisitUs());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@AfterClass
	public void tearDownClass() {
		System.out.println("Test Case 1 - Visit Us Completed");
	}
}
