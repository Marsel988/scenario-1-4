package steps;

import gherkin.lexer.Is;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.IssuePage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class IssueSteps{
    @Step("поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value) {
        new IssuePage().issueFillField(field, value);
    }

    @Step("заполняются поля")
    public void stepFillFields(HashMap<String, String> fields) {
        fields.forEach(this::stepFillField);
    }

    @Step("выбран {0} пол")
    public void selectSexManOrWoman(String value) {
        new IssuePage().selectSex(value);
    }

    @Step("выполнено нажатие на кнопку - Продолжить")
    public void buttonContinue() {
        new IssuePage().buttonContinue.click();
    }

    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value){
        String actual = new IssuePage().getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("в поле {0} присутствует сообщение об ошибке {1}")
    public void checkErrorMessageField(String field, String value){
        new IssuePage().checkFieldErrorMessage(field, value);
    }

    @Step("отображается сообщение об ошибке")
    public void checkErrorMessageTitle(){
        assertTrue("Не отображается сообщение об ошибке",
                new IssuePage().errorTitle.isDisplayed());
    }


}
