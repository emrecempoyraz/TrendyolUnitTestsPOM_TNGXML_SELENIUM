package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePageDropdown extends BasePage{


    public HomePageDropdown(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//a[@href='/sr?fl=sepettekiurunler']")
    private WebElement link ;

    @FindBy(css = ".i-new-sort-icon.search-sort-icon")
    private WebElement dropdownList ;

    @FindBy(xpath = "//span[text()='En yüksek fiyat']")
    private WebElement dropdownFilter ;

    @FindBy(css = ".selected-order")
    private WebElement filterMessage ;

    public void clickToLink () {
        link.click();
    }

    public void clickDropdown () {
        dropdownList.click();
    }

    public void filterSelectionDropdownMenu () {
        dropdownFilter.click();
    }

    public boolean isFilterSelected () {
        String actualMessage = filterMessage.getText() ;
        String expectedMessage = "En yüksek fiyat" ;
        return actualMessage.equals(expectedMessage);
    }


}
