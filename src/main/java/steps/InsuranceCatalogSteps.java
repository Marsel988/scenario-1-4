package steps;

import pages.InsuranceCatalogPage;
import ru.yandex.qatools.allure.annotations.Step;

public class InsuranceCatalogSteps extends BaseSteps {

    @Step("выполнено нажатие на кнопку - Оформить онлайн (Страхование для путешественников)")
    public void sendButtonTravel() {
        new InsuranceCatalogPage(driver).sendButton.click();
    }

}
