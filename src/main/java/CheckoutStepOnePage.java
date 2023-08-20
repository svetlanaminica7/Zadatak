import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOnePage extends BasePage {
    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement buttonContinue;

    @FindBy(className = "complete-header")
    WebElement infoMessage;

    public CheckoutStepOnePage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


   //Ova metoda popunjava html formu sa podacima koje joj ja dostavljam iz testa(inventory test)
    public void setForm(String name,String last,String zip)
    {
        firstName.sendKeys(name);
        lastName.sendKeys(last);
        postalCode.sendKeys(zip);
    }

    public void clickContinue()
    {
        buttonContinue.click();
    }
}
