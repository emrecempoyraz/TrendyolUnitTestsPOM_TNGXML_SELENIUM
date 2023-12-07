package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button#onetrust-accept-btn-handler")
    private WebElement cookies ;

    public void acceptCookies () {
        if (cookies.isDisplayed())
            cookies.click();
    }
}
