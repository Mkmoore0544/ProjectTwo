package testing.demo.tamut_demo;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestComputerScienceSearch {
	
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
	public void testComputerScienceSearchFlow() {
		// Step 2: search “Computer Science”
		SearchResultsPage resultsPage = mainPage.search("Computer Science");
		
		// 2.a - link containing "Computer Science" is displayed
		assertTrue(resultsPage.isComputerScienceLinkDisplayed());
		
		// Step 3: Click the first link which contains “Computer Science”
		ComputerSciencePage csPage = resultsPage.clickFirstComputerScienceLink();
		
		// 3.a–3.c–3.4
		assertTrue(csPage.isAccreditationDisplayed());
		assertTrue(csPage.isFacultyDisplayed());
		assertTrue(csPage.isApplyHereDisplayed());
		assertTrue(csPage.isVisitUsDisplayed());
		
		// Step 4: Click “Visit Us” link
		VisitUsPage visitUsPage = csPage.clickVisitUs();
		
		// 4.a–4.d
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
		System.out.println("Test Case 2 - Computer Science Search Completed");
	}
}

