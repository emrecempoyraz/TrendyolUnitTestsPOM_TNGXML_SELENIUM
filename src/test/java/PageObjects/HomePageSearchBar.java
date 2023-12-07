package PageObjects;

import TestManager.ConfigReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePageSearchBar extends BasePage {

    public HomePageSearchBar(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "V8wbcUhU")
    private WebElement searchBar ;

    public void searchProduct () {
        searchBar.click();
        searchBar.clear();
        core.sendKeysTo(searchBar, ConfigReader.getProperty("product") + Keys.ENTER) ;
    }

    public boolean isSearchCompleted () {
        String actualSearchUrl = driver.getCurrentUrl();
        String expectedSearchUrl = "https://www.trendyol.com/sr?q=telefon&qt=telefon&st=telefon&os=1";
        return actualSearchUrl.equals(expectedSearchUrl);
    }


}
