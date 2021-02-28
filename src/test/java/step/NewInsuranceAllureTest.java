package step;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.InsuranceCatalogPage;
import pages.IssuePage;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;



public class NewInsuranceAllureTest extends BaseSteps {

    @Test
    @Title("Страхование для путешественников")
    public void testInsurance(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        MainSteps mainSteps = new MainSteps();
        InsuranceCatalogSteps insuranceCatalogSteps = new InsuranceCatalogSteps();
        InsuranceSteps insuranceSteps = new InsuranceSteps();
        IssueSteps issueSteps = new IssueSteps();

        HashMap<String, String> fields = new HashMap<>();
        fields.put("Фамилия застрахованного","Иванов");
        fields.put("Имя застрахованного","Иван");
        fields.put("Дата рождения застрахованного","20.09.1996");
        fields.put("Фамилия","Иванов");
        fields.put("Имя","Иван");
        fields.put("Отчество","Иванович");
        fields.put("Дата рождения","20.09.1997");
        fields.put("Серия паспорта","1234");
        fields.put("Номер паспорта","567890");
        fields.put("Дата выдачи","20.12.19");
        fields.put("Кем выдан","УФМС РОССИИ");

        mainSteps.buttonCloseCookie();
        mainSteps.selectMainMenu("Страхование");
        mainSteps.selectInsuranceMenu("Перейти в каталог");

        wait.until(ExpectedConditions.visibilityOf(new InsuranceCatalogPage().titleTravel));
        insuranceCatalogSteps.sendButtonTravel();
        insuranceSteps.issueButton();

        issueSteps.stepFillFields(fields);
        issueSteps.selectSexManOrWoman("Женский");
        issueSteps.buttonContinue();

        wait.until(ExpectedConditions.visibilityOf(new IssuePage().phoneError));
        wait.until(ExpectedConditions.visibilityOf(new IssuePage().emailError));
        wait.until(ExpectedConditions.visibilityOf(new IssuePage().repeatEmailError));
        wait.until(ExpectedConditions.visibilityOf(new IssuePage().errorTitle));

    }
}
