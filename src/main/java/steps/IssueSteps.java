package steps;

import pages.IssuePage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class IssueSteps extends BaseSteps {
    @Step("поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value) {
        new IssuePage(driver).issueFillField(field, value);
    }

    @Step("заполняются поля")
    public void stepFillFields(HashMap<String, String> fields) {
        fields.forEach(this::stepFillField);
    }

    @Step("выбран {0} пол")
    public void selectSex(String value) {
        new IssuePage(driver).selectSex(value);
    }

    @Step("выполнено нажатие на кнопку - Продолжить")
    public void buttonContinue() {
        new IssuePage(driver).buttonContinue.click();
    }


}
