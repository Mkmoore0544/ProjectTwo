package testing.demo.tamut_demo;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestWomenSearch {
	
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
	public void testWomenSearch() {
		// Step 2: input “Women” in search and enter
		SearchResultsPage resultsPage = mainPage.search("Women");
		
		// 2.a - The link contains “Women tamut” is displayed
		assertTrue(resultsPage.isWomenTamutLinkDisplayed());
		
		// Step 3: Click the first link which contains “Women”
		WomenForAMTexarkanaPage womenPage = resultsPage.clickFirstWomenLink();
		
		// 3.a–3.c
		assertTrue(womenPage.isMakeScholarshipDonationDisplayed());
		assertTrue(womenPage.isJoinWomenDisplayed());
		assertTrue(womenPage.titleIncludesWomenForAMTexarkana());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@AfterClass
	public void tearDownClass() {
		System.out.println("Test Case 4 - Women Search Completed");
	}
}

