import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BasePage {

    @FindBy(className = "complete-header")
    WebElement header;

    @FindBy(id = "back-to-products")
    WebElement backHomeButton;

    public CheckoutCompletePage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getText()
    {
        return header.getText();
    }

    public void clickBackHomeButton()
    {
        backHomeButton.click();
    }



}
