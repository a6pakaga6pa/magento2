package pages_admin;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleProductPage {
    private WebDriver driver;
    private By productNamePlace = By.name("product[name]");
    private By pricePlace = By.name("product[price]");
    private By quantityPlace = By.name("product[quantity_and_stock_status][qty]");
    private By stockStatusPlace = By.name("product[quantity_and_stock_status][is_in_stock]");
    private By weightPlace = By.name("product[weight]");
    private By saveButton = By.id("save-button");


    public SimpleProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setProductName(String name){
        driver.findElement(productNamePlace).sendKeys(name);
    }

    public void setPrice(String price){
        driver.findElement(pricePlace).sendKeys(price);
    }

    public void setQuantity(String quantity){
        driver.findElement(quantityPlace).sendKeys(quantity);
    }

    public void selectStockStatus(String option){
        findDropDownElementsStockStatus().selectByVisibleText(option);
    }


    public List<String> getSelectedOptionsStockStatus(){
        List<WebElement> selectedElements = findDropDownElementsStockStatus().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findDropDownElementsStockStatus(){
        return new Select(driver.findElement(stockStatusPlace));
    }

    public void setWeight(String weight){
        driver.findElement(weightPlace).sendKeys(weight);
    }

    public boolean isPresentedSuccessText(){
        boolean a = driver.findElement(By.xpath("//div[contains(text(),'You saved the product.')]")).isDisplayed();
        return a;
    }

    public void pressSaveButton(){
        driver.findElement(saveButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
    }

}
