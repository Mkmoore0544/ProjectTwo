package testing.demo.tamut_demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenForAMTexarkanaPage {
	
	private WebDriver driver;
	
	@FindBy(linkText = "Make a Scholarship Donation")
	private WebElement makeScholarshipDonationLink;
	
	@FindBy(linkText = "Join Women for A&M-Texarkana")
	private WebElement joinWomenLink;
	
	public WomenForAMTexarkanaPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isMakeScholarshipDonationDisplayed() {
		return makeScholarshipDonationLink.isDisplayed();
	}
	
	public boolean isJoinWomenDisplayed() {
		return joinWomenLink.isDisplayed();
	}
	
	public boolean titleIncludesWomenForAMTexarkana() {
		return driver.getTitle().contains("Women for A&M-Texarkana");
	}
}

