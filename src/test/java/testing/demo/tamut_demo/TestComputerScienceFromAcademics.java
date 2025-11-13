package testing.demo.tamut_demo;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestComputerScienceFromAcademics {
	
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
	public void testComputerScienceFromAcademics() {
		// Step 2: Click “Academics”
		AcademicsPage academicsPage = mainPage.goToAcademicsPage();
		
		// 2.a–2.e
		assertTrue(academicsPage.isUndergraduateProgramsDisplayed());
		assertTrue(academicsPage.isGraduateProgramsDisplayed());
		assertTrue(academicsPage.isDoctorateProgramDisplayed());
		assertTrue(academicsPage.isOnlineProgramsDisplayed());
		
		// Step 3: scroll to “Computer Science” and click "Learn More"
		ComputerSciencePage csPage = academicsPage.clickComputerScienceLearnMore();
		
		// 3.a–3.c–3.4
		assertTrue(csPage.isAccreditationDisplayed());
		assertTrue(csPage.isFacultyDisplayed());
		assertTrue(csPage.isApplyHereDisplayed());
		assertTrue(csPage.isVisitUsDisplayed());
		
		// Step 4: Click “Visit Us”
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
		System.out.println("Test Case 3 - Computer Science from Academics Completed");
	}
}

