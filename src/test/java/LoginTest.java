import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void setUp()
    {
        //driver promenjiva sadrzi u sebi instancu Chrome drivera koju nam je vratio metod  browserOpen
        driver = browserOpen();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void LoginOnPage()
    {
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        //Verifikacija da smo se ulogovali
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void loginOnPageWithInvalidUserName()
    {
        loginPage.setUserName("standda");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginOnPageWithInvalidPassword()
    {
        loginPage.setUserName("standard_user");
        loginPage.setPassword("paaaa");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginOnPageWithEmptyUserName()
    {
        loginPage.setUserName("");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Username is required");
    }

    @Test
    public void loginOnPageWithEmptyPassword()
    {
        loginPage.setUserName("standard_user");
        loginPage.setPassword("");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Password is required");
    }

    //Zatvara driver(Chrome Browser)
    @AfterMethod
    public void after()
    {
        driver.quit();
    }



}
