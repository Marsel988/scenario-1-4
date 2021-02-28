package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.InsuranceCatalogPage;

import static org.junit.Assert.assertTrue;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    IssueSteps issueSteps = new IssueSteps();
    InsuranceCatalogSteps insuranceCatalogSteps = new InsuranceCatalogSteps();
    BaseSteps baseSteps = new BaseSteps();
    InsuranceSteps insuranceSteps = new InsuranceSteps();

    @When("^пользователь открывает url \"(.+)\"$")
    public void openURL(String URL) {
        switch (URL) {
            case "Сбербанка":
                baseSteps.openBaseURL("sber.url");
                break;
            case "Яндекса":
                baseSteps.openBaseURL("yandex.url");
                break;
            default:
                throw new AssertionError(URL + " не обявлен");
        }
    }

    @When("^пользователь нажимает на кнопку - Закрыть cookie")
    public void clickButton() {
        mainSteps.buttonCloseCookie();
    }

    @When("^пользователь выбирает пункт \"(.+)\" главного меню$")
    public void selectMainMenuItem(String name) {
        mainSteps.selectMainMenu(name);
    }

    @When("^пользователь выбирает пункт \"(.+)\" из меню страхования$")
    public void selectInsuranceMenuItem(String name) {
        mainSteps.selectInsuranceMenu(name);
    }

    @When("^пользователь нажимает на кнопку - Оформить онлайн, Страхование для путешественников$")
    public void selectTravelButton() {
        insuranceCatalogSteps.sendButtonTravel();
    }

    @When("^отображается заголовок  - Страхование для путешественников$")
    public void visivility() {
        insuranceCatalogSteps.visibilityTitle();
    }

    @When("^сумма страховой защиты выбрана Минимальная$")
    public void minSelected() {
        insuranceSteps.minFieldSelected();
    }

    @When("^пользователь нажимает на кнопку - Оформить$")
    public void issueClick() {
        insuranceSteps.issueButton();
    }

    @When("^заполняются поля:$")
    public void fillFields(DataTable fields) {
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> issueSteps.stepFillField(field, value));
    }

    @When("^значения полей равны:$")
    public void checkFillForm(DataTable fields) {
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> issueSteps.checkFillField(field, value));
    }

    @When("^в поле \"(.+)\" присутствует сообщение об ошибке \"(.+)\"$")
    public void checkErrorMessage(String field, String errorMessage) {
        issueSteps.checkErrorMessageField(field, errorMessage);
    }

    @When("^отображается сообщение об ошибке$")
    public void checkErrorTitle() {
        issueSteps.checkErrorMessageTitle();
    }


}
