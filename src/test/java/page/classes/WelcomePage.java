package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePage {
    public static WebElement element = null;

    public static WebElement createAccountButton(WebDriver driver){
        element = driver.findElement(By.xpath("//section[@class='precis above-fold']//a"));
        return WelcomePage.element;
    }
    public static  void clickOnAccountButton(WebDriver driver){
        element = createAccountButton(driver);
        element.click();
    }
}
