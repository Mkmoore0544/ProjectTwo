package testing.demo.tamut_demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

    private WebDriver driver;

    // First result that links to the Computer Science program
    @FindBy(xpath = "//a[contains(@href, '/academic-programs/computer-science')]")
    private WebElement firstComputerScienceLink;

    // First result that links to Women for A&M–Texarkana
    @FindBy(xpath = "//a[contains(@href, '/alumni/wam/')]")
    private WebElement womenTamutLink;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ---- For Test Case 2 ----
    public boolean isComputerScienceLinkDisplayed() {
        return firstComputerScienceLink.isDisplayed();
    }

    public ComputerSciencePage clickFirstComputerScienceLink() {
        firstComputerScienceLink.click();
        return new ComputerSciencePage(driver);
    }

    // ---- For Test Case 4 ----
    public boolean isWomenTamutLinkDisplayed() {
        return womenTamutLink.isDisplayed();
    }

    public WomenForAMTexarkanaPage clickFirstWomenLink() {
        womenTamutLink.click();
        return new WomenForAMTexarkanaPage(driver);
    }
}

