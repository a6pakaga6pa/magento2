package login;

import base.BaseTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages_front.LoginedUserPage;
import pages_front.SignInPage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin(){
        SignInPage signInPage = homePage.signIn();
        signInPage.setUserEmail("roni_cost@example.com");
        signInPage.setUserPassword("roni_cost3@example.com");
        LoginedUserPage loginedUserPage = signInPage.clickSignInButton("Veronica Costello");
        assertTrue(loginedUserPage.getWelcomeText().contains("Veronica Costello"),
                "Welcome text is incorrect!");
        System.out.println(loginedUserPage.getWelcomeText());
    }

    @Test
    public void testGenerateUserLogin(){
        var generateUser = homePage.generateAccount();
        var loginedUserPage = generateUser.generateUser();
        assertTrue(loginedUserPage.getWelcomeText().contains(generateUser.getCurrentEmail()));
    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][] {
                new Object[] {"user202003161350@email.com","123123Qa","user202003161350@email.com"},
                new Object[] {"user202003161354@email.com","123123Qa","user202003161354@email.com"},
                new Object[] {"user202003161356@email.com","123123Qa","user202003161356@email.com"},
        };
    }

    @Test(dataProvider = "testData")
    public void testLoginCustomers(String email, String password, String message) {
        SignInPage signInPage = homePage.signIn();
        signInPage.setUserEmail(email);
        signInPage.setUserPassword(password);
        LoginedUserPage loginedUserPage = signInPage.clickSignInButton(email);
        assertTrue(loginedUserPage.getWelcomeText().contains(message),
                "Welcome text is incorrect!");
        loginedUserPage.signOut();
    }

    @Test
    public void testLoginFromFile(){
        try{
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\sereb\\Documents\\users.txt"));
        while(reader.ready()) {
            String[] data = reader.readLine().split(" ");
            SignInPage signInPage = homePage.signIn();
            signInPage.setUserEmail(data[0]);
            signInPage.setUserPassword(data[1]);
            LoginedUserPage loginedUserPage = signInPage.clickSignInButton(data[0]);
            assertTrue(loginedUserPage.getWelcomeText().contains(data[0]),
                    "Welcome text is incorrect!");
            loginedUserPage.signOut();
        }
        reader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
            public void restart(){
        tearDown();
    }



}
