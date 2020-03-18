package pages_front;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public SignInPage signIn(){
        driver.findElement(By.xpath("//div[@class='panel header']//li[@class='authorization-link']//a")).click();
        return new SignInPage(driver);
    }

    public CreateAccountPage createAccount(){
        driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Create an Account')]")).click();
        return new CreateAccountPage(driver);
    }

    public GenerateNewUser generateAccount(){
        driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Create an Account')]")).click();
        return new GenerateNewUser(driver);
    }

    public JacketsPage chooseWomenJackets(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("ui-id-4"))).perform();
        actions.moveToElement(driver.findElement(By.id("ui-id-9"))).perform();
        actions.moveToElement(driver.findElement(By.id("ui-id-11"))).perform();
        driver.findElement(By.id("ui-id-11")).click();
        return new JacketsPage(driver);
    }


}
