package slider;

import base.BaseTests;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSliderTests extends BaseTests {

    @Test
    public void testSliderIcons() throws InterruptedException {
        WebElement activeSliderElement = homePage.getActiveSliderElement();

        for(int i = 0; i < homePage.getSliderElementCount(); i++) {
            assertEquals(activeSliderElement.getAttribute("data-slide-to"), String.valueOf(i),"Next icon not working");
            homePage.clickNextIconInSlider();
            activeSliderElement = homePage.getActiveSliderElement();
        }

        for(int i = homePage.getSliderElementCount() - 1; i >= 0; i--) {
            homePage.clickPrevIconInSlider();
            activeSliderElement = homePage.getActiveSliderElement();
            assertEquals(activeSliderElement.getAttribute("data-slide-to"), String.valueOf(i),"Prev icon not working");
        }
    }

    @Test
    public void testSliderImageClick() throws InterruptedException {
        assertTrue(homePage.isActiveSlideClickable(),"Product in slider is not clickable!");
    }
}
