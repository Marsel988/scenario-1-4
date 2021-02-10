package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsurancePage {

    public InsurancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(@class,'btn btn-primary btn-large')]")
    public WebElement buttonIssue;

    @FindBy(xpath = "//*[contains(@class, 'online-card-program selected')]")
    public WebElement minCardProgram;
}
