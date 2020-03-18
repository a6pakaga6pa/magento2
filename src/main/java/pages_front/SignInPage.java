package pages_front;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage {
    private WebDriver driver;
    private By emailInput = By.name("login[username]");
    private By passwordInput = By.name("login[password]");
    private By signInButton = By.xpath("//fieldset[@class='fieldset login']//button[@id='send2']");
    public String text = "Veronica Costello";
    private By welcomeTextPlace = By.xpath("//div[@class='panel header']//span[@class='logged-in'][contains(text(),'Welcome, " + text + "!')]");

    public SignInPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUserEmail(String email){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setUserPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public LoginedUserPage clickSignInButton(String userName){
        driver.findElement(signInButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='panel header']//span[@class='logged-in'][contains(text(),'Welcome, " + userName + " " + userName + "!')]")));
        return new LoginedUserPage(driver);
    }

}
