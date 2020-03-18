package pages_front;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JacketsPage {

    private WebDriver driver;
    private By size = By.id("option-label-size-152-item-5594");
    private By color = By.id("option-label-color-93-item-5476");
    private By addToCart = By.xpath("//form[@data-product-sku=\"WJ12\"]/button");
    private By successAddMessage = By.xpath("//div[@class='message-success success message']");

    public JacketsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseSize(){
        driver.findElement(size).click();
    }

    public void chooseColor(){
        driver.findElement(color).click();
    }

    public void pressAddToCart(){
        driver.findElement(addToCart).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(1)).
                until(ExpectedConditions.visibilityOfElementLocated(successAddMessage));
    }

    public boolean isMessageDisplayed(){
        return driver.findElement(successAddMessage).isDisplayed();
    }


}
