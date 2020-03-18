package pages_admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminSignInPage {

    private WebDriver driver;

    public AdminSignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setAdminName(String name) {
        driver.findElement(By.id("username")).sendKeys(name);
    }

    public void setAdminName() {
        driver.findElement(By.id("username")).sendKeys("admin");
    }

    public void setAdminPassword(String password) {
        driver.findElement(By.id("login")).sendKeys(password);
    }

    public void setAdminPassword() {
        driver.findElement(By.id("login")).sendKeys("123123q");
    }

    public AdminMainPage pressLoginButton(){
        driver.findElement(By.xpath("//button[@class='action-login action-primary']")).click();
        return new AdminMainPage(driver);
    }
}
