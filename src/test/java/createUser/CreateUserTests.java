package createUser;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CreateUserTests extends BaseTests {

    @Test
    public void createUserSuccess(){
        var createUserPage = homePage.createAccount();
        createUserPage.setFirstName("Max");
        createUserPage.setLastName("Serebro");
        createUserPage.setEmail("test3@test.com");
        createUserPage.setPassword("123123Qa");
        createUserPage.confirmPassword("123123Qa");
        createUserPage.signUpForNewsletter(true);
        var myPage = createUserPage.clickCreateAccountButtonSuccess();
        assertTrue(myPage.getWelcomeText().contains("Max Serebro"), "Wrong text!");
    }

    @Test
    public void createUserExisted(){
        var createUserPage = homePage.createAccount();
        createUserPage.setFirstName("Max");
        createUserPage.setLastName("Serebro");
        createUserPage.setEmail("test2@test.com");
        createUserPage.setPassword("123123Qa");
        createUserPage.confirmPassword("123123Qa");
        createUserPage.signUpForNewsletter(true);
        var myPage = createUserPage.clickCreateAccountButtonError();
        assertTrue(myPage.getError(), "Element is not presented!");
    }
}
