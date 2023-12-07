package TestMain;

import PageObjects.*;
import TestManager.BaseTest;
import TestManager.ConfigReader;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMainTrendyol extends BaseTest {

    HomePage homePage ;
    HomePageLogin homePageLogin;
    HomePageMyBasket homePageMyBasket ;
    HomePageSearchBar homePageSearchBar ;
    HomePageLinks homePageLinks ;
    HomePageDropdown homePageDropdown ;


    @Description("Direct login with login button")
    @Test (priority = 1)
    public void logInFail () {
        homePageLogin = new HomePageLogin(driver);
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePageLogin.clickLoginButton();
        homePageLogin.typeEmail();
        homePageLogin.typePassword();
        homePageLogin.submitForm();
        Assert.assertTrue(homePageLogin.isErrorMessageVisible(), "Logged in unsuccessfully");
    }

    @Description("Check mybasket button")
    @Test (priority = 2)
    public void checkBasketButton () {
        homePageMyBasket = new HomePageMyBasket(driver);
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePageMyBasket.clickBasketButton();
        Assert.assertTrue(homePageMyBasket.isBasketEmpty(),"Basket is not empty");
    }

    @Description("Search bar test")
    @Test (priority = 3)
    public void checkSearchBar () {
        homePage = new HomePage(driver);
        homePageSearchBar = new HomePageSearchBar(driver);
        homePage.acceptCookies();
        homePageSearchBar.searchProduct();
        Assert.assertTrue(homePageSearchBar.isSearchCompleted());
    }

    @Description("Hover over to women link and check")
    @Test(priority = 4)
    public void hoverOverWomenLink () {
        homePage = new HomePage(driver);
        homePageLinks = new HomePageLinks(driver);
        homePage.acceptCookies();
        homePageLinks.hoverOverWomen();
        homePageLinks.clickToClothes();
        Assert.assertTrue(homePageLinks.isClothesListed());
    }

    @Description("Hover over to men link and check")
    @Test(priority = 5)
    public void hoverOverMenLink () {
        homePage = new HomePage(driver);
        homePageLinks = new HomePageLinks(driver);
        homePage.acceptCookies();
        homePageLinks.hoverOverMen();
        homePageLinks.clickToBoxer();
        Assert.assertTrue(homePageLinks.isBoxerSelected());
    }

    @Description("Check Most added items to basket link")
    @Test(priority = 6)
    public void checkMostAddedItems () {
        homePage = new HomePage(driver);
        homePageLinks = new HomePageLinks(driver);
        homePage.acceptCookies();
        homePageLinks.clickMostAddedItems();
        Assert.assertTrue(homePageLinks.isMostAddedItemsLinkWorking());
    }

    @Description("Check most popular items link")
    @Test(priority = 7)
    public void checkMostPopularItems () {
        homePage = new HomePage(driver);
        homePageLinks = new HomePageLinks(driver);
        homePage.acceptCookies();
        homePageLinks.clickMostPopularItems();
        Assert.assertTrue(homePageLinks.isMostPopularLinkWorking());
    }

    @Description("Check flash products link")
    @Test(priority = 8)
    public void checkFlashProducts () {
        homePage = new HomePage(driver);
        homePageLinks = new HomePageLinks(driver);
        homePage.acceptCookies();
        homePageLinks.clickFlashProducts();
        Assert.assertTrue(homePageLinks.isFlashProductsLinkWorking());
    }

    @Description("Check dropdown on home page")
    @Test(priority = 9)
    public void checkDropdown () {
        homePage = new HomePage(driver);
        homePageDropdown = new HomePageDropdown(driver);
        homePage.acceptCookies();
        homePageDropdown.clickToLink();
        homePageDropdown.clickDropdown();
        homePageDropdown.filterSelectionDropdownMenu();
        Assert.assertTrue(homePageDropdown.isFilterSelected());
    }




}
