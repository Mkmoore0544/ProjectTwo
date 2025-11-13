package testing.demo.tamut_demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcademicsPage {
	
	private WebDriver driver;
	
	@FindBy(linkText = "Undergraduate Programs")
	private WebElement undergraduateProgramsLink;
	
	@FindBy(linkText = "Graduate Programs")
	private WebElement graduateProgramsLink;
	
	@FindBy(linkText = "Doctorate Program")
	private WebElement doctorateProgramLink;
	
	@FindBy(linkText = "Online Programs")
	private WebElement onlineProgramsLink;

	// FIXED locator for Computer Science "Learn More"
	@FindBy(xpath = "//a[contains(@href, 'computer-science/index.html')]")
	private WebElement csLearnMoreLink;
	
	public AcademicsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isUndergraduateProgramsDisplayed() {
		return undergraduateProgramsLink.isDisplayed();
	}
	
	public boolean isGraduateProgramsDisplayed() {
		return graduateProgramsLink.isDisplayed();
	}
	
	public boolean isDoctorateProgramDisplayed() {
		return doctorateProgramLink.isDisplayed();
	}
	
	public boolean isOnlineProgramsDisplayed() {
		return onlineProgramsLink.isDisplayed();
	}
	
	public ComputerSciencePage clickComputerScienceLearnMore() {
		csLearnMoreLink.click();
		return new ComputerSciencePage(driver);
	}
}


