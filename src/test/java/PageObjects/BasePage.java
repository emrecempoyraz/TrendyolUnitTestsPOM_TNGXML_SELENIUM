package PageObjects;

import TestManager.ReusableMethods;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {


    public WebDriver driver ;
    public ReusableMethods core ;

    public BasePage (WebDriver driver) {
        this.driver = driver ;
        PageFactory.initElements(driver,this);
        core = new ReusableMethods(driver) ;
    }
}
