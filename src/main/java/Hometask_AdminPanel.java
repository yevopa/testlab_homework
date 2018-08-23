import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Hometask_AdminPanel {
    public static void main(String[] args) {

        WebDriver driver = Hometask_Login.getInitFirefox();
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
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*
            Dashboard click
         */
        WebElement main_title = driver.findElement(By.className("title"));
        main_title.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String title = driver.findElement(By.className("page-title")).getText();
        System.out.println("Opened chapter: " + title);
        driver.navigate().refresh();

        String curr_page = driver.findElement(By.className("page-title")).getText();
        if (title.equals(curr_page)) {
            System.out.println("The title is " + curr_page);
        } else System.out.println("The page changed!");


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*
            Orders click
         */
        WebElement subtitle1 = driver.findElement(By.cssSelector("a.title.has_submenu"));
        subtitle1.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String title1 = driver.findElement(By.className("page-title")).getText();
        System.out.println("Opened chapter: " + title1);
        driver.navigate().refresh();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String curr_page1 = driver.findElement(By.className("page-title")).getText();
        if (title1.equals(curr_page1)) {
            System.out.println("The title is " + curr_page1);
        } else System.out.println("The page changed!");

        driver.quit();
    }

}
