package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps{

    @Step("выполнено нажатие на кнопку - Закрыть cookie")
    public void buttonCloseCookie() {
        new MainPage().buttonCookieClose.click();
    }

    @Step("выбран пункт меню {0}")
    public void selectMainMenu(String menuItem) {
        new MainPage().selectMainMenu(menuItem);
    }

    @Step("выбран пункт {0} из меню страхования")
    public void selectInsuranceMenu(String menuItem) {
        new MainPage().selectInsuranceMenu(menuItem);
    }

}
