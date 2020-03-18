package chooseProduct;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class chooseTests extends BaseTests {

    @Test
    public void chooseJacketsTest(){
        var jackets = homePage.chooseWomenJackets();
        jackets.chooseSize();
        jackets.chooseColor();
        jackets.pressAddToCart();
        assertTrue(jackets.isMessageDisplayed(), "Message not found!");
    }
}
