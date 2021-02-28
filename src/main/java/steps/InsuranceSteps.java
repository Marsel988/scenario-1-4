package steps;

import pages.InsuranceCatalogPage;
import pages.InsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class InsuranceSteps extends BaseSteps {

    @Step("выполнено нажатие на кнопку - Оформить")
    public void issueButton() {
        new InsurancePage(driver).buttonIssue.click();
    }

    @Step("сумма страховой защиты выбрана Минимальная")
    public void minFieldSelected() {
        assertTrue("Поле \"сумма страховой защиты выбрана Минимальная\" не отображается на странице",
                new InsurancePage(driver).minCardProgram.isDisplayed());
        }

}

