
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hometask_Lecture3 {

    public static void main(String[] args) {

        Hometask_Login login = new Hometask_Login();
        WebDriver driver = login.getInitFirefox();
        Actions builder = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);

        WebEventListener listener = new WebEventListener();
        eventDriver.register(listener);
        /*
            Login Admin Panel
         */

        login.Login(eventDriver);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//li[@id='subtab-AdminCatalog']")));

        WebElement catalouge = eventDriver.findElement(By.xpath(".//li[@id='subtab-AdminCatalog']/a"));
        builder.moveToElement(catalouge).click().build().perform();
        WebElement categories = eventDriver.findElement(By.xpath(".//li[@id='subtab-AdminCategories']/a"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//li[@id='subtab-AdminCategories']")));
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
        WebElement search_button = eventDriver.findElement(By.id("submitFilterButtoncategory"));
        search_button.click();

        eventDriver.quit();
    }
}
