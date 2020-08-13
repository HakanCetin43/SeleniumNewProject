package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatePasswordPage {
    public static void waitForPresence(WebDriverWait wait){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("PasswordTitle")));
    }
}
