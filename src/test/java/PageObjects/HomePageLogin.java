package PageObjects;

import TestManager.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePageLogin extends BasePage {


    public HomePageLogin(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='account-nav-item user-login-container']")
    private WebElement logInButton ;



    @FindBy(css = "#login-email")
    private WebElement emailForm ;

    @FindBy(css = "#login-password-input")
    private WebElement passwordForm ;

    @FindBy(xpath = "(//span[text()='Giriş Yap'])[2]")
    private WebElement submitLoginForm ;

    @FindBy (css = "span.message")
    private WebElement errorMessage ;



    public void clickLoginButton () {
        if (logInButton.isDisplayed())
            logInButton.click();
    }

    public void typeEmail () {
        if (emailForm.isDisplayed())
            core.sendKeysTo(emailForm,ConfigReader.getProperty("userName"));
    }

    public void typePassword () {
        if (passwordForm.isDisplayed())
            core.sendKeysTo(passwordForm,ConfigReader.getProperty("pass"));
    }

    public void submitForm () {
        if (submitLoginForm.isDisplayed())
            submitLoginForm.click();
    }

    public boolean isErrorMessageVisible () {
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "E-posta adresiniz ve/veya şifreniz hatalı.";
        return actualErrorMessage.contains(expectedErrorMessage);
    }
}
