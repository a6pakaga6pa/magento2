package pages_admin;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    private WebDriver driver;
    private By productsSelector = By.xpath("//button[@class='action-toggle primary add']");
    private By productNamePlace = By.name("product[name]");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void pressChooseProduct(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(productsSelector));
        driver.findElement(productsSelector).click();
    }

    public SimpleProductPage pressSimpleProduct(){
        driver.findElement(By.xpath("//span[@class='item item-default']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.presenceOfElementLocated(productNamePlace));
        return new SimpleProductPage(driver);
    }


}
