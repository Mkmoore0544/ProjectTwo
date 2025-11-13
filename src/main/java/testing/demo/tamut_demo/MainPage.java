package testing.demo.tamut_demo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	
	private WebDriver driver;
	private final String URL = "https://tamut.edu";
	
	@FindBy(id = "searchBox")
	private WebElement searchBox;
	
	@FindBy(xpath = "//a[@title = 'About TAMUT']")
	private WebElement aboutMenu;
	
	@FindBy(linkText = "Visit Us")
	private WebElement visitUsItem;
	
	@FindBy(linkText = "Academics")
	private WebElement academicsMenu;
	
	@FindBy(linkText = "Alumni & Friends")
	private WebElement alumniMenu;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void open() {
		driver.get(URL);
	}
	
	// Generic search: returns SearchResultsPage
	public SearchResultsPage search(String searchInput) {
		searchBox.sendKeys(searchInput + Keys.ENTER);
		return new SearchResultsPage(driver);
	}
	
	public void hoverOverAbout() {
		Actions actions = new Actions(driver);
		actions.moveToElement(aboutMenu).perform();
	}
	
	public void clickVisitUsFromAbout() {
		hoverOverAbout();
		visitUsItem.click();
	}
	
	public AcademicsPage goToAcademicsPage() {
		academicsMenu.click();
		return new AcademicsPage(driver);
	}
	
	public AlumniPage goToAlumniPage() {
		alumniMenu.click();
		return new AlumniPage(driver);
	}
}
