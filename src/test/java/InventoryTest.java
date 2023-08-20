import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest {
     // Zovemo strane iz testa
    LoginPage loginPage;

    InventoryPage inventoryPage;

    CartPage cartPage;

    CheckoutStepOnePage checkoutStepOnePage;

    CheckoutStepTwoPage checkoutStepTwoPage;

    CheckoutCompletePage checkoutCompletePage;

    @BeforeMethod

    public void SetUp()
    {
        driver = browserOpen();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        loginPage.LoginOnPage();
    }

    //ZADATAK 2
    @Test
    public void AddToCartThreeLowestPriceProducts() {
        //Asertacija da smo na Inventory strani kada se logujemo
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");

        inventoryPage.sortProducts("Price (low to high)");
        inventoryPage.clickSauceLabsOnesie();
        inventoryPage.clickSauceLabsBikeLight();
        inventoryPage.clickSauceLabsBoltTShirt();
        Assert.assertEquals(inventoryPage.getCartNumber(),"3");
        inventoryPage.clickCart();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/cart.html");

        Assert.assertEquals(cartPage.getTextSauceLabsOnesie(),"Sauce Labs Onesie");
        Assert.assertEquals(cartPage.getTextSauceLabsBikeLight(),"Sauce Labs Bike Light");
        Assert.assertEquals(cartPage.getTextSauceLabsBoltTShirt(),"Sauce Labs Bolt T-Shirt");
    }

    //ZADATAK 2*
    @Test
    public void AddToCartTwoProductsEndRemoveFromCart() {
        //Asertacija da smo na Inventory strani kada se logujemo
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        inventoryPage.sortProducts("Price (low to high)");
        inventoryPage.clickSauceLabsOnesie();
        inventoryPage.clickSauceLabsBikeLight();
        Assert.assertEquals(inventoryPage.getCartNumber(),"2");
        inventoryPage.clickCart();

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/cart.html");
        cartPage.removeSauceLabsOnesieButton();
        cartPage.removeSauceLabsBikeLightButton();
        cartPage.clickContinueShopping();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(inventoryPage.isEmptyCart(),true);

    }

   //ZADATAK 3
    @Test
    public void AddToCartThreeLowestPriceProductsAndCheckItemTotal() {

        //Asertacija da smo na toj strani kada se logujemo
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");

        inventoryPage.sortProducts("Price (low to high)");
        inventoryPage.clickSauceLabsOnesie();
        inventoryPage.clickSauceLabsBikeLight();
        inventoryPage.clickSauceLabsBoltTShirt();

        // Asertacija kada ubacimo stvari,i onda nam vrati proizvode(3)
        Assert.assertEquals(inventoryPage.getCartNumber(),"3");

        inventoryPage.clickCart();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/cart.html");
        cartPage.clickCheckout();

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");
        checkoutStepOnePage.setForm("Svetlana","Kojic","1100");
        checkoutStepOnePage.clickContinue();

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");

        Assert.assertEquals(checkoutStepTwoPage.getItemTotal(),"Item total: $33.97");

    }

    //ZADATAK 3*
    @Test
    public void AddToCartThreeLowestPriceProductsAndCheckTotal() {

        //Asertacija da smo na toj strani kada se logujemo
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");

        inventoryPage.sortProducts("Price (low to high)");
        inventoryPage.clickSauceLabsOnesie();
        inventoryPage.clickSauceLabsBikeLight();
        inventoryPage.clickSauceLabsBoltTShirt();

        // Asertacija kada ubacimo stvari,i onda nam vrati proizvode(3)
        Assert.assertEquals(inventoryPage.getCartNumber(),"3");

        inventoryPage.clickCart();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/cart.html");
        cartPage.clickCheckout();

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");
        checkoutStepOnePage.setForm("Svetlana","Kojic","1100");
        checkoutStepOnePage.clickContinue();

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");
        Assert.assertEquals(checkoutStepTwoPage.getTotal(),"Total: $36.69");

    }

    //ZADATAK 4
    @Test
    public void CompleteOrder3Products() {
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        inventoryPage.sortProducts("Price (low to high)");
        inventoryPage.clickSauceLabsOnesie();
        inventoryPage.clickSauceLabsBikeLight();
        inventoryPage.clickSauceLabsBoltTShirt();

        Assert.assertEquals(inventoryPage.getCartNumber(),"3");
        inventoryPage.clickCart();
        cartPage.clickCheckout();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");
        checkoutStepOnePage.setForm("Svetlana","Kojic","1100");
        checkoutStepOnePage.clickContinue();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");
        Assert.assertEquals(checkoutStepTwoPage.getItemTotal(),"Item total: $33.97");
        Assert.assertEquals(checkoutStepTwoPage.getTotal(),"Total: $36.69");
        checkoutStepTwoPage.clickFinish();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-complete.html");
        Assert.assertEquals(checkoutCompletePage.getText(),"Thank you for your order!");
        checkoutCompletePage.clickBackHomeButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");

    }

   @AfterMethod
    public void after()
   {
       driver.quit();
   }

}


