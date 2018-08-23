import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebEventListener implements WebDriverEventListener {

    public void beforeAlertAccept(WebDriver webDriver) {
        System.out.println("Before alert accept.\n");
    }

    public void afterAlertAccept(WebDriver webDriver) {
        System.out.println("After alert accept.\n");
    }

    public void afterAlertDismiss(WebDriver webDriver) {
        System.out.println("After alert dismiss\n");
    }

    public void beforeAlertDismiss(WebDriver webDriver) {
        System.out.println("Before alert dismiss\n");
    }

    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before navigate to page:  '" + url + "'\n");
    }

    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigated to page:  '" + url + "'\n");
    }
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Trying to click on  " + element.toString() + "\n");
    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Already licked on  " + element.toString() + "\n");
    }

    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Value of the  " + webElement.toString()
                + " before any changes made.\n");

    }

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Trying to click on  " + webElement.toString() + "\n");
    }

    public void beforeScript(String s, WebDriver webDriver) {

    }

    public void afterScript(String s, WebDriver webDriver) {

    }

    public void beforeNavigateBack(WebDriver driver) {
        System.out.println("Navigating back to previous page.\n");
    }

    public void afterNavigateBack(WebDriver driver) {
        System.out.println("Navigated back to previous page.\n");
    }

    public void beforeNavigateForward(WebDriver driver) {
        System.out.println("Navigating forward to next page.\n");
    }

    public void afterNavigateForward(WebDriver driver) {
        System.out.println("Navigated forward to next page.\n");
    }

    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    public void onException(Throwable error, WebDriver driver) {
        System.out.println("Exception  " + error + "\n");
    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Trying to find Element By : " + by.toString() + "\n");
    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Found Element By : " + by.toString() + "\n");
    }

}
