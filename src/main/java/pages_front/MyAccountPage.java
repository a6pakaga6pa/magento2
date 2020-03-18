package pages_front;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage {

    private WebDriver driver;
    private By welcomeMessagePlace = By.xpath("//div[@class='panel header']//span[@class='logged-in'][contains(text(),'Welcome')]");
    private By existingUserMessage = By.xpath("//div[@class='message-error error message']");


    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getWelcomeText(){
        return driver.findElement(welcomeMessagePlace).getText();
    }

    public boolean getError(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(existingUserMessage));
        return error.isDisplayed();
    }
}
