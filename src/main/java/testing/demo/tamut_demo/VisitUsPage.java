package testing.demo.tamut_demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VisitUsPage {
	
	private WebDriver driver;
	
	@FindBy(linkText = "Upcoming Events")
	private WebElement upcomingEventsLink;
	
	@FindBy(linkText = "Schedule a Campus Tour")
	private WebElement scheduleCampusTourLink;
	
	@FindBy(linkText = "Virtual Tour")
	private WebElement virtualTourLink;
	
	public VisitUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isUpcomingEventsDisplayed() {
		return upcomingEventsLink.isDisplayed();
	}
	
	public boolean isScheduleCampusTourDisplayed() {
		return scheduleCampusTourLink.isDisplayed();
	}
	
	public boolean isVirtualTourDisplayed() {
		return virtualTourLink.isDisplayed();
	}
	
	public boolean titleContainsVisitUs() {
		return driver.getTitle().contains("Visit Us");
	}
}

