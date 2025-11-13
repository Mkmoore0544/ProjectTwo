package testing.demo.tamut_demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[contains(@href, '/academic-programs/computer-science')]")
    private WebElement firstComputerScienceLink;

    @FindBy(xpath = "//a[contains(@href, '/alumni/wam/')]")
    private WebElement womenTamutLink;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isComputerScienceLinkDisplayed() {
        return firstComputerScienceLink.isDisplayed();
    }

    public ComputerSciencePage clickFirstComputerScienceLink() {
        firstComputerScienceLink.click();
        return new ComputerSciencePage(driver);
    }

    public boolean isWomenTamutLinkDisplayed() {
        return womenTamutLink.isDisplayed();
    }

    public WomenForAMTexarkanaPage clickFirstWomenLink() {
        womenTamutLink.click();
        return new WomenForAMTexarkanaPage(driver);
    }
}

