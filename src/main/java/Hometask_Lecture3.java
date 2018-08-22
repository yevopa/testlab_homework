import javafx.event.EventHandler;
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

        /*
            Login Admin Panel
         */
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement field_login = driver.findElement(By.name("email"));
        field_login.sendKeys("webinar.test@gmail.com");

        WebElement field_pass = driver.findElement(By.name("passwd"));
        field_pass.sendKeys("Xcg7299bnSmMuRLp9ITw");

        WebElement button = driver.findElement(By.name("submitLogin"));
        button.click();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//li[@id='subtab-AdminCatalog']"))));

        WebElement catalouge = driver.findElement(By.xpath(".//li[@id='subtab-AdminCatalog']/a"));
        builder.moveToElement(catalouge).click().build().perform();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//li[@id='subtab-AdminCategories']"))));
        WebElement categories = driver.findElement(By.xpath(".//li[@id='subtab-AdminCategories']/a"));
        categories.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//a[@title='Добавить категорию']"))));
        WebElement addCategory = driver.findElement(By.xpath(".//a[@title='Добавить категорию']"));
        addCategory.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#name_1"))));
        WebElement addName = driver.findElement(By.id("name_1"));
        addName.sendKeys("TestCategory");
        WebElement save_button = driver.findElement(By.xpath(".//button[@id='category_form_submit_btn']"));
        save_button.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//button[@data-dismiss='alert']"))));
        WebElement input_name = driver.findElement(By.xpath(".//input[@name='categoryFilter_name']"));
        input_name.sendKeys("TestCategory");
        WebElement search_button = driver.findElement(By.id("submitFilterButtoncategory"));
        search_button.click();

    }
}
