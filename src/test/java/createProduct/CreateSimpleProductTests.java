package createProduct;

import base.BaseTestsAdmin;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CreateSimpleProductTests extends BaseTestsAdmin {

    @Test
    public void createSimpleProductTest(){
        adminSignPage.setAdminName();
        adminSignPage.setAdminPassword();
        var mainPage = adminSignPage.pressLoginButton();
        mainPage.pressCatalogue();
        var products = mainPage.pressProducts();
        products.pressChooseProduct();
        var createPage = products.pressSimpleProduct();
        createPage.setProductName("Test product-7");
        createPage.setPrice("15");
        createPage.setQuantity("100");
        createPage.selectStockStatus("Out of Stock");
        createPage.setWeight("2");
        createPage.pressSaveButton();
        assertTrue(createPage.isPresentedSuccessText(), "Not presented!");
    }
}
