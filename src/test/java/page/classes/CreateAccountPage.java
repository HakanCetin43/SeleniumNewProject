package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage {
    public static WebElement element = null;

    public static WebElement userName(WebDriver driver){
        element = driver.findElement(By.id("MemberName"));
        return element;
    }

    public static WebElement errorMessage(WebDriverWait wait){
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("MemberNameError")));
        return element;
    }
    public static String getErrorText(WebDriverWait wait){
        element = errorMessage(wait);
        return element.getText();
    }
    public static void sendText(WebDriver driver, String text){
        element = userName(driver);
        element.sendKeys(text);
    }
}
