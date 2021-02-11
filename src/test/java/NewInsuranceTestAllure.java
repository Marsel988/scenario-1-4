import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;

public class NewInsuranceTestAllure extends BaseSteps {

    @Test
    @Title("Страхование для путешественников")
    public void testInsurance() throws InterruptedException {
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

        insuranceCatalogSteps.sendButtonTravel();
        insuranceSteps.issueButton();
        issueSteps.stepFillFields(fields);
        issueSteps.selectSex("Женский");
        Thread.sleep(10000);
        issueSteps.buttonContinue();

    }
}
