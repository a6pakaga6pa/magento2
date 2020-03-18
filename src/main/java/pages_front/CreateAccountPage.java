package pages_front;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateAccountPage {
    private WebDriver driver;

    private By firstName = By.id("firstname");
    private By lastName = By.id("lastname");
    private By newsLetterSubscribe = By.id("is_subscribed");
    private By emailInput = By.id("email_address");
    private By passwordInput = By.xpath("//input[@id=\"password\"]");
    private By passwordConfirm = By.id("password-confirmation");
    private By createAccountButton = By.xpath("//button[@class=\"action submit primary\"]");
    private By welcomeMessagePlace = By.xpath("//div[@class='panel header']//span[@class='logged-in'][contains(text(),'Welcome')]");
    private By existingUserMessage = By.xpath("//div[@class='message-error error message']");

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String username){
        driver.findElement(firstName).sendKeys(username);
    }

    public void setLastName(String secondName){
        driver.findElement(lastName).sendKeys(secondName);
    }

    public void signUpForNewsletter(boolean value){
        if(value){
            driver.findElement(newsLetterSubscribe).click();
        }
    }

    public void setEmail(String email){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void confirmPassword(String password){
        driver.findElement(passwordConfirm).sendKeys(password);
    }

    public MyAccountPage clickCreateAccountButtonSuccess(){
        driver.findElement(createAccountButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessagePlace));
        return new MyAccountPage(driver);
    }



    public MyAccountPage clickCreateAccountButtonError(){
        driver.findElement(createAccountButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(existingUserMessage));
        return new MyAccountPage(driver);
    }





}
