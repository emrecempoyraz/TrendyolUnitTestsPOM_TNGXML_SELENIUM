package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageMyBasket extends BasePage {

    public HomePageMyBasket(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='account-nav-item basket-preview']")
    private WebElement myBasketButton ;

    @FindBy(xpath = "//*[text()='Sepetinde ürün bulunmamaktadır.']")
    private WebElement emptyBasketMessage ;

    public void clickBasketButton () {
        if (myBasketButton.isDisplayed())
            core.clickTo(myBasketButton,5);
    }

    public boolean isBasketEmpty () {
        String actualMessage = emptyBasketMessage.getText();
        String expectedMessage = "Sepetinde ürün bulunmamaktadır.";
        return actualMessage.contains(expectedMessage);
    }
}
