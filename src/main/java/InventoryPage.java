import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.net.IDN;

public class InventoryPage extends BasePage{

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElement sauceLabsOnesie;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement sauceLabsBikeLight;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement sauceLabsBoltTShirt;

    @FindBy(className = "shopping_cart_badge")
    WebElement cart;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeBackpack;

    @FindBy(className = "product_sort_container")
    WebElement sort;

    @FindBy(className = "inventory_item_price")
    WebElement price;

    @FindBy(className = "shopping_cart_link")
    WebElement shoppingCartLink;

    //pravim konstruktor da bi pokupio elemente i preneo na test
    public InventoryPage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickSauceLabsOnesie()
    {
        sauceLabsOnesie.click();
    }

    public void clickSauceLabsBikeLight()
    {
        sauceLabsBikeLight.click();
    }

    public void clickSauceLabsBoltTShirt()
    {
        sauceLabsBoltTShirt.click();
    }


    public String getCartNumber()
    {
       return  cart.getText();
    }

    //Metoda za sortiranje proizvoda
     public void sortProducts(String text)
     {
         Select select = new Select(sort);
         select.selectByVisibleText(text);
     }

    public void clickCart()
    {
        cart.click();
    }

    public boolean isEmptyCart()
    {
        //https://stackoverflow.com/questions/32713009/how-to-check-if-element-contains-specific-class-attribute
        //proveravam da li element sa classname shopping_cart_link ima u sebi class shopping_cart_badge
        //ako ima, imamo proizvode u korpi
        //ako nema shopping_cart_badge klase, korpa je prazna
        return !shoppingCartLink.getAttribute("class").contains("shopping_cart_badge");
    }


}
