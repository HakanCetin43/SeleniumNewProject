package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.classes.CreateAccountPage;

import java.util.ArrayList;
import java.util.Collections;

public class Outlook_Onboarding{
    public static WebDriver driver;
    public static WebDriverWait wait;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:/Drivers/chromedriver81.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Given("User navigates to Outlook page")
    public void userNavigatesToOutlookPage() {
        driver.navigate().to("https://outlook.live.com/owa/");
        driver.manage().window().maximize();
    }

    @And("User clicks Create account link")
    public void userClicksCreateAccountLink() {
        WebElement createAccountLink = driver.findElement(By.xpath("//div[@class='action']//span[text()='Create free account']"));
        createAccountLink.click();
    }

    @When("User types {string} account name")
    public void userTypesAccountName(String accountNameInput) {
//        WebElement memberName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("MemberName")));
////                driver.findElement(By.id("MemberName"));
//        memberName.sendKeys("xxx");
        CreateAccountPage.sendText(driver, accountNameInput);
    }

    @Then("User should get error message - {string}")
    public void userShouldGetErrorMessage(String errorText) {
//        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("MemberNameError")));
//       System.out.println(error.getText());
        WebElement error = CreateAccountPage.errorMessage(wait);
        String errorTextOnPage = CreateAccountPage.getErrorText(wait);
    }

    @When("User type {string} account name")
    public void userTypeAccountName(String element) {
        WebElement memberName = driver.findElement(By.id("MemberName"));
        memberName.sendKeys("elif_server");
    }
    @And("User tries to proceed")
    public void userTriesToProceed() {
        WebElement next = driver.findElement(By.id("iSignupAction"));
        next.click();
    }

    @Then("User should be landed on the password screen")
    public void userShouldBeLandedOnThePasswordScreen() {
        WebElement passwordInput = driver.findElement(By.id("PasswordInput"));

    }

    @And("User start to create an account with account name: {string}")
    public void userStartToCreateAnAccountWithAccountName(String accountName) {

    }

    @And("I landed on the password screen")
    public void iLandedOnThePasswordScreen() {

    }

    @When("I click on the {string} link")
    public void iClickOnTheLink(String link) {
        String linkLocator = null;
        switch (link){
            case "Microsoft Services Agreement":
                linkLocator = "//a[text()='Microsoft Services Agreement']";
                break;
            case "privacy and cookies":
                linkLocator = "//a[text() = 'privacy and cookies statement.']";
                break;
            default:
                break;
        }
        WebElement linkToClick = driver.findElement(By.xpath(linkLocator));
        linkToClick.click();
    }

    @Then("I should see the {string} tab")
    public void iShouldSeeTheTab(String pageName) {
        String expectedTitle = "";
        switch (pageName){
            case "Microsoft Services Agreement":
                expectedTitle = "Microsoft Services Agreement";
                break;
             case "privacy and cookies":
                 expectedTitle = "Microsoft Privacy Statement – Microsoft privacy";
                 break;
            default:
                break;
        }
        ArrayList<String> tabs = new ArrayList<String>(Collections.singleton(driver.getWindowHandle()));
        String parentWindowHandle = driver.getWindowHandle();
        driver.switchTo().window(tabs.get(1));
        String title = driver.getTitle();
        Assert.assertTrue("title and expected title does not match or you are on the wrong page",
                title.compareTo(expectedTitle) == 0);
        System.out.println(driver.getWindowHandle() + "\n" + parentWindowHandle);
        System.out.println(driver.getTitle());
    }
}
