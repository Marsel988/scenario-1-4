package OldTests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import static org.junit.Assert.assertEquals;

public class InsuranceTest extends BaseSteps {

    @Test
    @Ignore
    public void testInsurance() throws InterruptedException {
        driver.get(baseUrl);
        // Закрытие cookie
        driver.findElement(By.xpath("//*[text()='Закрыть']")).click();
        // Нажать на – Страхование
        driver.findElement(By.xpath("//li[contains(@class, 'kitt-top-menu')]//*[contains(text(), 'Страхование')]//span")).click();

        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        // Нажать на – Перейти в каталог
        WebElement buttonCatalog = driver.findElement(By.xpath("//*[contains(text(),'Перейти в каталог')]"));
        wait.until(ExpectedConditions.visibilityOf(buttonCatalog)).click();
        // Нажать на – Оформить Онлайн
        WebElement title = driver.findElement(By.xpath("//h3[contains(text(),'Страхование для путешественников')]"));
        wait.until(ExpectedConditions.visibilityOf(title));
        assertEquals("Страхование для путешественников",title.getText());
        driver.findElement(By.xpath("//h3[contains(text(),'Страхование для путешественников')]/../../..//*[contains(text(),'Оформить онлайн')]")).click();
        // На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
        WebElement title1 = driver.findElement(By.xpath("//h2[contains(text(), 'Страхование путешественников')]"));
        wait.until(ExpectedConditions.visibilityOf(title1));
        assertEquals("Страхование путешественников",title1.getText());
        // На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
        WebElement minField = driver.findElement(By.xpath("//*[contains(@class, 'online-card-program selected')]"));
        wait.until(ExpectedConditions.visibilityOf(minField));
        // Нажать Оформить
        WebElement buttonOnline = driver.findElement(By.xpath("//*[contains(@class,'btn btn-primary btn-large')]"));
        wait.until(ExpectedConditions.visibilityOf(buttonOnline)).click();

        // Заполнение полей
        fillField(By.id("surname_vzr_ins_0"), "Иванов");
        fillField(By.id("name_vzr_ins_0"), "Иван");
        fillField(By.id("birthDate_vzr_ins_0"), "20.09.1997");
        driver.findElement(By.xpath("//html")).click();
        fillField(By.id("person_lastName"), "Иванов");
        fillField(By.id("person_firstName"), "Иван");
        fillField(By.id("person_middleName"), "Иванович");
        fillField(By.id("person_birthDate"), "20.09.1997");
        WebElement person_birthDate = driver.findElement(By.id("person_birthDate"));
        person_birthDate.sendKeys(Keys.TAB);
        driver.findElement(By.xpath("//*[contains(text(), 'Мужской')]")).click();
        fillField(By.id("passportSeries"), "1234");
        fillField(By.id("passportNumber"), "567890");
        fillField(By.id("documentDate"), "20.12.2019");
        WebElement documentDate = driver.findElement(By.id("documentDate"));
        documentDate.sendKeys(Keys.TAB);
        fillField(By.id("documentIssue"), "УФМС РОССИИ");

        assertEquals("Иванов", driver.findElement(By.id("surname_vzr_ins_0")).getAttribute("value"));
        assertEquals("Иван", driver.findElement(By.id("name_vzr_ins_0")).getAttribute("value"));
        assertEquals("20.09.1997", driver.findElement(By.id("birthDate_vzr_ins_0")).getAttribute("value"));
        assertEquals("Иванов", driver.findElement(By.id("person_lastName")).getAttribute("value"));
        assertEquals("Иван", driver.findElement(By.id("person_firstName")).getAttribute("value"));
        assertEquals("Иванович", driver.findElement(By.id("person_middleName")).getAttribute("value"));
        assertEquals("20.09.1997", driver.findElement(By.id("person_birthDate")).getAttribute("value"));
        assertEquals("1234", driver.findElement(By.id("passportSeries")).getAttribute("value"));
        assertEquals("567890", driver.findElement(By.id("passportNumber")).getAttribute("value"));
        assertEquals("20.12.2019", driver.findElement(By.id("documentDate")).getAttribute("value"));
        assertEquals("УФМС РОССИИ", driver.findElement(By.id("documentIssue")).getAttribute("value"));

        driver.findElement(By.xpath("//*[contains(text(),'Продолжить')]")).click();

        //Проверка на ошибку
        WebElement errorMessage = driver.findElement(By.xpath("//*[contains(@role,'alert-form')]"));
        assertEquals("При заполнении данных произошла ошибка", errorMessage.getText());
        WebElement errorTitle1 = driver.findElement(By.xpath("//*[contains(@name, 'phone')]//*[contains(text(),'Поле не заполнено.')]"));
        assertEquals("Поле не заполнено.", errorTitle1.getText());
        WebElement errorTitle2 = driver.findElement(By.xpath("//*[contains(@name, 'email')]//*[contains(text(),'Поле не заполнено.')]"));
        assertEquals("Поле не заполнено.", errorTitle2.getText());
        WebElement errorTitle3 = driver.findElement(By.xpath("//*[contains(@name, 'repeatEmail')]//*[contains(text(),'Поле не заполнено.')]"));
        assertEquals("Поле не заполнено.", errorTitle3.getText());
    }
}
