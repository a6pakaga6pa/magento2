package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages_admin.AdminSignInPage;
import java.util.concurrent.TimeUnit;

public class BaseTestsAdmin {
    private WebDriver driver;
    protected AdminSignInPage adminSignPage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        SignInPage();
    }

    @BeforeMethod
    public void SignInPage() {
        driver.get("https://robuwidiva.build.eltrino.io/admin");
        adminSignPage = new AdminSignInPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
