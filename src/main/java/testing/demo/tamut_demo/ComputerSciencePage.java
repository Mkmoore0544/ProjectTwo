package testing.demo.tamut_demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputerSciencePage {
	
	private WebDriver driver;
	
	@FindBy(linkText = "Accreditation")
	private WebElement accreditationLink;
	
	@FindBy(linkText = "Faculty")
	private WebElement facultyLink;
	
	@FindBy(linkText = "Apply Here")
	private WebElement applyHereLink;
	
	@FindBy(linkText = "Visit Us")
	private WebElement visitUsLink;
	
	public ComputerSciencePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isAccreditationDisplayed() {
		return accreditationLink.isDisplayed();
	}
	
	public boolean isFacultyDisplayed() {
		return facultyLink.isDisplayed();
	}
	
	public boolean isApplyHereDisplayed() {
		return applyHereLink.isDisplayed();
	}
	
	public boolean isVisitUsDisplayed() {
		return visitUsLink.isDisplayed();
	}
	
	public VisitUsPage clickVisitUs() {
		visitUsLink.click();
		return new VisitUsPage(driver);
	}
}
