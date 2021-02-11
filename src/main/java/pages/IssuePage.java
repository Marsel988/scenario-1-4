package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static steps.BaseSteps.fillField;

public class IssuePage {

    public IssuePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(text(), 'Мужской')]")
    public WebElement buttonMan;

    @FindBy(xpath = "//*[contains(text(), 'Женский')]")
    public WebElement buttonWoman;

    @FindBy(xpath = "//*[contains(text(),'Продолжить')]")
    public WebElement buttonContinue;

    @FindBy(id = "surname_vzr_ins_0")
    public WebElement firstPersonSurname;

    @FindBy(id = "name_vzr_ins_0")
    public WebElement firstPersonName;

    @FindBy(id = "birthDate_vzr_ins_0")
    public WebElement firstPersonBirthDate;

    @FindBy(id = "person_lastName")
    public WebElement personLastName;

    @FindBy(id = "person_firstName")
    public WebElement personFirstName;

    @FindBy(id = "person_middleName")
    public WebElement personMiddleName;

    @FindBy(id = "person_birthDate")
    public WebElement personBirthDate;

    @FindBy(id = "passportSeries")
    public WebElement passportSeries;

    @FindBy(id = "passportNumber")
    public WebElement passportNumber;

    @FindBy(id = "documentDate")
    public WebElement documentDate;

    @FindBy(id = "documentIssue")
    public WebElement documentIssue;

    @FindBy(xpath = "//*[contains(@name, 'phone')]//*[contains(text(),'Поле не заполнено.')]")
    public WebElement phoneError;

    @FindBy(xpath = "//*[contains(@name, 'email')]//*[contains(text(),'Поле не заполнено.')]")
    public WebElement emailError;

    @FindBy(xpath = "//*[contains(@name, 'repeatEmail')]//*[contains(text(),'Поле не заполнено.')]")
    public WebElement repeatEmailError;

    @FindBy(xpath = "//*[contains(@role,'alert-form')]")
    public WebElement errorTitle;

    public void issueFillField(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия застрахованного":
                fillField(firstPersonSurname, value);
                break;
            case "Имя застрахованного":
                fillField(firstPersonName, value);
                break;
            case "Дата рождения застрахованного":
                fillField(firstPersonBirthDate, value);
                firstPersonBirthDate.sendKeys(Keys.TAB);
                break;
            case "Фамилия":
                fillField(personLastName, value);
                break;
            case "Имя":
                fillField(personFirstName, value);
                break;
            case "Отчество":
                fillField(personMiddleName, value);
                break;
            case "Дата рождения":
                fillField(personBirthDate, value);
                personBirthDate.sendKeys(Keys.TAB);
                break;
            case "Серия паспорта":
                fillField(passportSeries, value);
                break;
            case "Номер паспорта":
                fillField(passportNumber, value);
                break;
            case "Дата выдачи":
                fillField(documentDate, value);
                documentDate.sendKeys(Keys.TAB);
                break;
            case "Кем выдан":
                fillField(documentIssue, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public void selectSex(String sex) {
        switch (sex) {
            case "Мужской":
                buttonMan.click();
                break;
            case "Женский":
                buttonWoman.click();
                break;
            default:
                throw new AssertionError("Поле '" + sex + "' не объявлено на странице");
        }
    }
}