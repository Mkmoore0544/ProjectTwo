package testing.demo.tamut_demo;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestWomenFromAlumni {
	
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
	public void testWomenFromAlumni() {
		// Step 2: Click “Alumni & Friends”
		AlumniPage alumniPage = mainPage.goToAlumniPage();
		
		// 2.a–2.e
		assertTrue(alumniPage.isOrderAlumniBrickDisplayed());
		assertTrue(alumniPage.isJoinAlumniAssociationDisplayed());
		assertTrue(alumniPage.isUpdateAlumniInfoDisplayed());
		assertTrue(alumniPage.isWomenForAMTexarkanaDisplayed());
		
		// Step 3: Click “Women for A&M–Texarkana”
		WomenForAMTexarkanaPage womenPage = alumniPage.clickWomenForAMTexarkana();
		
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
		System.out.println("Test Case 5 - Women from Alumni Completed");
	}
}

