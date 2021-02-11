package steps;

import pages.InsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

public class InsuranceSteps extends BaseSteps{

    @Step("выполнено нажатие на кнопку - Оформить")
    public void issueButton(){
        new InsurancePage(driver).buttonIssue.click();
    }
}
