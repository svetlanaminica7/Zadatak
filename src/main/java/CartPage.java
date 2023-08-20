import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(xpath = "//*[@id=\"item_2_title_link\"]/div")
    WebElement sauceLabsOnesie;

    @FindBy(xpath = "//*[@id=\"item_0_title_link\"]/div")
    WebElement sauceLabsBikeLight;

    @FindBy(xpath = "//*[@id=\"item_1_title_link\"]/div")
    WebElement sauceLabsBoltTShirt;

    @FindBy(id = "remove-sauce-labs-onesie")
    WebElement sauceLabsOnesieButton;

    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement sauceLabsBikeLightButton;

    @FindBy(id = "continue-shopping")
    WebElement continueShopping;

   public CartPage(ChromeDriver driver)
    {
        this.driver = driver;
        //kupi sve elemente koje sam definisala(id) inicijalizuje ih(pripremi)
        PageFactory.initElements(driver,this);
    }

    //ova metoda mi omogucava da pridjem ovom veb elementu iz mojih testova,konkretno da kliknem dugme sa id checkout
    public void clickCheckout()
    {
        checkoutButton.click();
    }

    public String getTextSauceLabsOnesie()
    {
       return sauceLabsOnesie.getText();
    }

    public String getTextSauceLabsBikeLight()
    {
        return sauceLabsBikeLight.getText();
    }

    public String getTextSauceLabsBoltTShirt()
    {
        return sauceLabsBoltTShirt.getText();
    }

    public void removeSauceLabsOnesieButton()
    {
        sauceLabsOnesieButton.click();
    }

    public void removeSauceLabsBikeLightButton()
    {
        sauceLabsBikeLightButton.click();
    }

    public void clickContinueShopping()
    {
        continueShopping.click();
    }
}
