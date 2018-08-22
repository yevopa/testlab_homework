import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hometask_Login {


    public static void main(String[] args){

        WebDriver driver = getInitFirefox();
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

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement button_info = driver.findElement(By.id("employee_infos"));
        button_info.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement button_logout = driver.findElement(By.id("header_logout"));
        button_logout.click();
        driver.quit();
    }

    public static WebDriver getInitFirefox() {
        System.setProperty("webdriver.gecko.driver", Hometask_Login.class.getResource("geckodriver.exe").getPath());
        return new FirefoxDriver();
    }

}
