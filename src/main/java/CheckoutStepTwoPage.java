import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepTwoPage extends BasePage {
   //Ovo je Item total
    @FindBy(className = "summary_subtotal_label")
    WebElement itemTotal;
    //Ovo je Total(item total+Tax)
    @FindBy(className = "summary_total_label")
    WebElement totalSum;

    @FindBy(id ="finish" )
    WebElement finish;

    public CheckoutStepTwoPage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getItemTotal()
    {
        return itemTotal.getText();
    }

    public String getTotal()
    {
        return totalSum.getText();
    }

    public void clickFinish()
    {
         finish.click();
    }

}
