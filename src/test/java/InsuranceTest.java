import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class InsuranceTest {

    WebDriver driver;
    String baseUrl;

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void testInsurance() throws InterruptedException {
        // Закрытие cookie
        driver.findElement(By.xpath("//*[text()='Закрыть']")).click();
        // Нажать на – Страхование
        driver.findElement(By.xpath("//li[contains(@class, 'kitt-top-menu')]//*[contains(text(), 'Страхование')]//span")).click();

        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        // Нажать на – Перейти в каталог
        WebElement buttonCatalog = driver.findElement(By.xpath("//*[contains(text(),'Перейти в каталог')]"));
        wait.until(ExpectedConditions.visibilityOf(buttonCatalog)).click();
        // Нажать на – Оформить Онлайн
        WebElement buttonOform = driver.findElement(By.xpath("(//*[contains(@class,'kit-button kit-button_type_main')])[3]"));
        wait.until(ExpectedConditions.visibilityOf(buttonOform)).click();
        // На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
//        WebElement button3 = driver.findElement(By.xpath("//div[contains(@class, 'online-card-program selected')]//div//div"));
//        wait.until(ExpectedConditions.visibilityOf(button3)).click();
        // Нажать Оформить
        driver.findElement(By.xpath("//*[contains(@class,'btn btn-primary btn-large')]")).click();
        // Заполнение полей
        fillField(By.id("surname_vzr_ins_0"), "Иванов");
        fillField(By.id("name_vzr_ins_0"), "Иван");
        fillField(By.id("birthDate_vzr_ins_0"), "20091997");
        fillField(By.id("person_lastName"), "Иванов");
        fillField(By.id("person_firstName"), "Иван");
        fillField(By.id("person_middleName"), "Иванович");
        fillField(By.id("person_birthDate"), "20091997");
        WebElement buttonMan = driver.findElement(By.xpath("//*[contains(text(), 'Мужской')]"));
        wait.until(ExpectedConditions.visibilityOf(buttonMan)).click();
//        driver.findElement(By.xpath("//*[contains(text(), 'Мужской')]")).click();
        fillField(By.id("passportSeries"), "1234");
        fillField(By.id("passportNumber"), "567890");
        fillField(By.id("documentDate"), "20122019");
        fillField(By.id("documentIssue"), "УФМС РОСИИ");


    }


    public void fillField(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    @After
    public void afterTest() {
        driver.quit();
    }
}
