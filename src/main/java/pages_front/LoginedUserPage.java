package pages_front;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginedUserPage {

    private WebDriver driver;
    private By welcomeTextPlace = By.xpath("//div[@class='panel header']//span[@class='logged-in']");
    private By switcherPlace = By.xpath("//div[@class='panel header']//button[@class='action switch']");
    private By signOutButton = By.xpath("//li[@class='customer-welcome active']//a[contains(text(),'Sign Out')]");

    public LoginedUserPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getWelcomeText(){
        return driver.findElement(welcomeTextPlace).getText();
    }

    public void signOut(){
        driver.findElement(switcherPlace).click();
        driver.findElement(signOutButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 6);
    }
}
