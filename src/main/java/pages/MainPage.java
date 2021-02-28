package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage {

    @FindBy(xpath = "//*[text()='Закрыть']")
    public WebElement buttonCookieClose;

    @FindBy(xpath = "//*[contains(@class, 'kitt-top-menu__list')]")
    WebElement mainMenu;

    @FindBy(xpath = "//li/*[(text()='Страхование')]/..//ul")
    WebElement insuranceMenu;

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMainMenu(String name) {
        mainMenu.findElement(By.xpath(".//*[contains(text(), '" + name + "')]//span")).click();
    }

    public void selectInsuranceMenu(String name) {
        insuranceMenu.findElement(By.xpath(".//*[contains(text(),'" + name + "')]")).click();
    }
}
