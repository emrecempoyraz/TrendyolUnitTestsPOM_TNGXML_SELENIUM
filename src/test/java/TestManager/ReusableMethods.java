package TestManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReusableMethods {

    private final WebDriver driver ;

    public ReusableMethods (WebDriver driver) {
       this.driver = driver ;
    }

    public void clickTo (WebElement element , long waitTimeInSeconds) {
        WebDriverWait wait = getWait (waitTimeInSeconds) ;
        WebElement elements ;
        elements = wait.until(ExpectedConditions.elementToBeClickable(element));
        elements.click();
    }

    public void sendKeysTo (WebElement element,String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    private WebDriverWait getWait (long waitTimeInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds)) ;
    }

    public void mouseHoverAndClickElement (WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void selectVisibleText (WebElement element , String text) {
        Select slc = new Select(element);
        slc.selectByVisibleText(text);
    }
}
