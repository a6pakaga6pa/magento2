package pages_admin;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminMainPage {

    private WebDriver driver;
    private By dashboardPlace = By.id("menu-magento-backend-dashboard");
    private By salesPlace = By.id("menu-magento-sales-sales");
    private By cataloguePlace = By.id("menu-magento-catalog-catalog");
    private By customersPlace = By.id("menu-magento-customer-customer");
    private By marketingPlace = By.id("menu-magento-backend-marketing");
    private By storesPlace = By.id("menu-magento-backend-stores");
    private By systemPlace = By.id("menu-magento-backend-system");

    public AdminMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void pressDashboards(){
        driver.findElement(dashboardPlace).click();
    }

    public void pressSales(){
        driver.findElement(salesPlace).click();
    }

    public void pressCatalogue(){
        driver.findElement(cataloguePlace).click();
    }

    public ProductsPage pressProducts(){
        driver.findElement(By.xpath("//li[@class='item-catalog-products    level-2']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
        .until(ExpectedConditions.textToBe(By.className("page-title"),"Products"));

        return new ProductsPage(driver);
    }

    public void pressCustomers(){
        driver.findElement(customersPlace).click();
    }

    public void pressMarketing(){
        driver.findElement(marketingPlace).click();
    }

    public void pressStores(){
        driver.findElement(storesPlace).click();
    }

    public void pressSystem(){
        driver.findElement(systemPlace).click();
    }


}
