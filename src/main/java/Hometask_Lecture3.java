
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Hometask_Lecture3 {

    public static void main(String[] args) {
        WebDriver driver = Hometask_Login.getInitFirefox();
        Actions builder = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);

        WebEventListener listener = new WebEventListener();
        eventDriver.register(listener);
        /*
            Login Admin Panel
         */

        eventDriver.manage().window().maximize();
        eventDriver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement field_login = eventDriver.findElement(By.name("email"));
        field_login.sendKeys("webinar.test@gmail.com");

        WebElement field_pass = eventDriver.findElement(By.name("passwd"));
        field_pass.sendKeys("Xcg7299bnSmMuRLp9ITw");

        WebElement button = eventDriver.findElement(By.name("submitLogin"));
        button.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//li[@id='subtab-AdminCatalog']")));

        WebElement catalouge = eventDriver.findElement(By.xpath(".//li[@id='subtab-AdminCatalog']/a"));
        builder.moveToElement(catalouge).click().build().perform();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//li[@id='subtab-AdminCategories']")));
        WebElement categories = eventDriver.findElement(By.xpath(".//li[@id='subtab-AdminCategories']/a"));
        categories.click();

        wait.until(ExpectedConditions.visibilityOf(eventDriver.findElement(By.xpath(".//a[@title='Добавить категорию']"))));
        WebElement addCategory = driver.findElement(By.xpath(".//a[@title='Добавить категорию']"));
        addCategory.click();

        wait.until(ExpectedConditions.visibilityOf(eventDriver.findElement(By.cssSelector("#name_1"))));
        WebElement addName = eventDriver.findElement(By.id("name_1"));
        addName.sendKeys("TestCategory");
        WebElement save_button = eventDriver.findElement(By.xpath(".//button[@id='category_form_submit_btn']"));
        save_button.click();

        wait.until(ExpectedConditions.visibilityOf(eventDriver.findElement(By.xpath(".//button[@data-dismiss='alert']"))));
        WebElement input_name = eventDriver.findElement(By.xpath(".//input[@name='categoryFilter_name']"));
        input_name.sendKeys("TestCategory");
        WebElement el = eventDriver.findElement(By.cssSelector("td > *:last-child"));
        WebElement search_button = eventDriver.findElement(By.id("submitFilterButtoncategory"));
        search_button.click();

        //wait.until(ExpectedConditions.visibilityOf(el));
        eventDriver.quit();
    }
}
