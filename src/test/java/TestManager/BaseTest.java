package TestManager;

import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {


    protected WebDriver driver ;


    @Parameters ("browser")
    @BeforeTest
    public void setUp (@Optional("chrome") String browser) {
        driver = DriverCross.getDriver(browser) ;
        driver.get(ConfigReader.getProperty("baseUrl"));
    }

    @AfterTest
    public void tearDown () {
        DriverCross.closeDriver();
    }
}
