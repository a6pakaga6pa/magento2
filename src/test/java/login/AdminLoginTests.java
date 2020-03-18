package login;

import base.BaseTestsAdmin;
import org.testng.annotations.Test;
public class AdminLoginTests extends BaseTestsAdmin {

    @Test
    public void testLoginWithPreSetCreds() {
        adminSignPage.setAdminName();
        adminSignPage.setAdminPassword();
        var mainPage = adminSignPage.pressLoginButton();
        mainPage.pressCatalogue();
        var products = mainPage.pressProducts();
        products.pressChooseProduct();
        products.pressSimpleProduct();
    }


}
