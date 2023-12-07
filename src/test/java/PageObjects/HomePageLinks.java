package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.ref.SoftReference;

public class HomePageLinks extends BasePage  {


    public HomePageLinks (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//li[@class='tab-link'])[1]")
    private WebElement linkForWomen ;

    @FindBy(xpath = "(//a[@href='/elbise-x-c56'])[1]")
    private WebElement clothes ;

    @FindBy(xpath = "//div[@class='dscrptn dscrptn-V2']")
    private WebElement searchResult ;

    @FindBy(xpath = "//a[@href='/butik/liste/2/erkek']")
    private WebElement linkForMen ;

    @FindBy(xpath = "//ul//li//a[@href='/erkek-boxer-x-g2-c61']")
    private WebElement boxerForMen ;

    @FindBy(xpath = "//a[@href='/sr?fl=sepettekiurunler']")
    private WebElement mostAddedItems ;

    @FindBy(css = "a[href='/sr?fl=encokonecikanurunler'")
    private WebElement mostPopular ;

    @FindBy(xpath = "(//a[@href='/flas-indirimler'])[2] ")
    private WebElement flashProducts ;


    public void hoverOverWomen () {
        core.mouseHoverAndClickElement(linkForWomen);
    }

    public void clickToClothes () {
        core.mouseHoverAndClickElement(clothes);
        core.clickTo(clothes,5);
    }

    public boolean isClothesListed () {
        String actualResult = searchResult.getText();
        String expectedResult = "Elbise";
        return actualResult.contains(expectedResult);
    }

    public void hoverOverMen () {
        core.mouseHoverAndClickElement(linkForMen);
    }

    public void clickToBoxer () {
        core.clickTo(boxerForMen,5);
    }

    public boolean isBoxerSelected () {
        String actualLink = driver.getCurrentUrl();
        String expectedLink = "https://www.trendyol.com/erkek-boxer-x-g2-c61";
        return actualLink.equals(expectedLink);
    }

    public void clickMostAddedItems () {
        mostAddedItems.click();
    }

    public boolean isMostAddedItemsLinkWorking () {
        String actualLink = driver.getCurrentUrl();
        String expectedLink = "https://www.trendyol.com/sr?fl=sepettekiurunler";
        return actualLink.equals(expectedLink);
    }

    public void clickMostPopularItems () {
        mostPopular.click();
    }

    public boolean isMostPopularLinkWorking () {
        String actualLink = driver.getCurrentUrl();
        String expectedLink = "https://www.trendyol.com/sr?fl=encokonecikanurunler" ;
        return actualLink.equals(expectedLink);
    }

    public void clickFlashProducts () {
        flashProducts.click();
    }

    public boolean isFlashProductsLinkWorking () {
        String actualLink = driver.getCurrentUrl();
        String expectedLink = "https://www.trendyol.com/sr?tag=fs_3_12_2023_9_12" ;
        return actualLink.equals(expectedLink);
    }


}
