import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class Hometask_Lecture4 {

    public static void main(String[] args) {
         Hometask_Login login = new Hometask_Login();
        WebDriver driver = login.getInitFirefox();
        Actions builder = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);

        WebEventListener listener = new WebEventListener();
        eventDriver.register(listener);
        eventDriver.manage().window().maximize();
        /*
            Login Admin Panel
         */
        login.Login(eventDriver);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='subtab-AdminCatalog']")));
        WebElement catalouge = eventDriver.findElement(By.xpath("//*[@id='subtab-AdminCatalog']/a"));
        builder.moveToElement(catalouge).click().build().perform();
        WebElement products = eventDriver.findElement(By.xpath("//*[@id='subtab-AdminProducts']/a"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='subtab-AdminProducts']")));
        builder.moveToElement(products).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("page-header-desc-configuration-add")));
        WebElement add_product = eventDriver.findElement(By.id("page-header-desc-configuration-add"));
        wait.until(ExpectedConditions.elementToBeClickable(add_product));
        add_product.click();

        WebElement product_name = eventDriver.findElement(By.id("form_step1_name_1"));
        product_name.sendKeys(generateString());
        WebElement product_quantity = eventDriver.findElement(By.xpath("//*[@id=\"form_step1_qty_0_shortcut\"]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"form_step1_qty_0_shortcut\"]")));
        int quantity =  (int )(Math.random() * 100 + 1);
        product_quantity.sendKeys(String.valueOf(quantity));

        double price =  (double) (Math.random() * 100.0 + 0.1);
        WebElement product_price = eventDriver.findElement(By.id("form_step1_price_shortcut"));
        product_price.sendKeys(String.valueOf(price));

        eventDriver.findElement(By.cssSelector("#form > div.product-footer > div.col-lg-5 > div")).click();

        eventDriver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

    }

    public static String generateString() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;
    }

}
