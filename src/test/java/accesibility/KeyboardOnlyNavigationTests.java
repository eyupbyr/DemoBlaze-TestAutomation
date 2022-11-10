package accesibility;

import base.BaseTests;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class KeyboardOnlyNavigationTests extends BaseTests {

    @Test
    public void testKeyboardOnlyNavigationForHomePage() throws InterruptedException {
        Thread.sleep(5000);

        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> ((JavascriptExecutor) driver).
                executeScript("return document.readyState").
                toString().
                equals("complete"));*/

        List<WebElement> clickableElements = driver.findElements(By.tagName("a"));
        System.out.println(clickableElements.size());

        driver.findElement(By.tagName("body")).sendKeys(Keys.TAB);

        for(int i = 0; i < clickableElements.size() - 1; i++) {
            driver.switchTo().activeElement().sendKeys(Keys.TAB);
            Thread.sleep(200);
        }

        System.out.println(driver.switchTo().activeElement().getAttribute("id"));
        assertEquals(driver.switchTo().activeElement().getAttribute("id"),
                //HomePage.getIDofLastElementOnPage(),
                "next2",
                "Can't access every element with TAB Key");
    }
}
