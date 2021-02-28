package steps;

import pages.InsuranceCatalogPage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class InsuranceCatalogSteps extends BaseSteps {

    @Step("выполнено нажатие на кнопку - Оформить онлайн (Страхование для путешественников)")
    public void sendButtonTravel() {
        new InsuranceCatalogPage(driver).sendButton.click();
    }

    @Step("отображается заголовок - Страхование для путешественников")
    public void visibilityTitle() {
        assertTrue("Поле Страхование для путешественников не отображается на странице",
                new InsuranceCatalogPage(driver).titleTravel.isDisplayed());
    }
}
