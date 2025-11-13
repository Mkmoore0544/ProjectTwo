package testing.demo.tamut_demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlumniPage {
	
	private WebDriver driver;
	
	@FindBy(linkText = "Order Alumni Brick")
	private WebElement orderAlumniBrickLink;
	
	@FindBy(linkText = "Join the Alumni Association")
	private WebElement joinAlumniAssociationLink;
	
	@FindBy(linkText = "Update Alumni Information")
	private WebElement updateAlumniInfoLink;
	
	// The Women for A&M-Texarkana link from Alumni
	@FindBy(xpath = "//a[contains(., 'Women for A&M-Texarkana')]")
	private WebElement womenForAMTexarkanaLink;
	
	public AlumniPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isOrderAlumniBrickDisplayed() {
		return orderAlumniBrickLink.isDisplayed();
	}
	
	public boolean isJoinAlumniAssociationDisplayed() {
		return joinAlumniAssociationLink.isDisplayed();
	}
	
	public boolean isUpdateAlumniInfoDisplayed() {
		return updateAlumniInfoLink.isDisplayed();
	}
	
	public boolean isWomenForAMTexarkanaDisplayed() {
		return womenForAMTexarkanaLink.isDisplayed();
	}
	
	public WomenForAMTexarkanaPage clickWomenForAMTexarkana() {
		womenForAMTexarkanaLink.click();
		return new WomenForAMTexarkanaPage(driver);
	}
}

