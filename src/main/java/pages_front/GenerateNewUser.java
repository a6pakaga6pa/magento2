package pages_front;

import org.openqa.selenium.WebDriver;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class GenerateNewUser {

    private WebDriver driver;

    public String getCurrentEmail() {
        return fullEmail;
    }

    private String currentEmail2Part = "@email.com";
    private String currentName = "user";
    private String identifyer;
    private String fullEmail;

    public GenerateNewUser(WebDriver driver) {
        this.driver = driver;
    }



    public MyAccountPage generateUser() {
        String filePath = "C:\\Users\\sereb\\Documents\\users.txt";
        try {
            BufferedWriter outputStream = new BufferedWriter(new FileWriter(filePath, true));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
            LocalDateTime now = LocalDateTime.now();
            identifyer = dtf.format(now);
            CreateAccountPage page = new CreateAccountPage(driver);
            fullEmail = currentName + identifyer + currentEmail2Part;
            page.setEmail(fullEmail);
            page.setFirstName(fullEmail);
            page.setLastName(fullEmail);
            page.setPassword("123123Qa");
            page.confirmPassword("123123Qa");
            page.signUpForNewsletter(true);
            outputStream.write(fullEmail + " " + "123123Qa\r");
            outputStream.close();
            page.clickCreateAccountButtonSuccess();
        }  catch (IOException e) {
            e.printStackTrace();
        }



        return new MyAccountPage(driver);
    }

}
