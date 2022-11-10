package pages;

import modals.LoginModal;
import modals.SignUpModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {


    private By loginButton = By.id("login2");
    private By signUpButton = By.id("signin2");
    private By welcomeText = By.id("nameofuser");
    private By logOutButton = By.id("logout2");
    private By nextIconInSlider = By.xpath("//span[@class='carousel-control-next-icon']");
    private By prevIconInSlider = By.xpath("//span[@class='carousel-control-prev-icon']");
    private By activeSliderElement = By.xpath("//div[@id='carouselExampleIndicators']//ol//li[@class='active']");

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginModal clickLogin() {
        driver.findElement(loginButton).click();
        return new LoginModal(driver);
    }

    public SignUpModal clickSignUp() {
        driver.findElement(signUpButton).click();
        return new SignUpModal(driver);
    }

    public String getWelcomeText() {
        return driver.findElement(welcomeText).getText();
    }

    public void clickLogOut() {
        driver.findElement(logOutButton).click();
    }

    public boolean isLoginButtonPresent() {
        return driver.findElement(loginButton).isDisplayed();
    }

    public void clickNextIconInSlider() {
        driver.findElement(nextIconInSlider).click();
    }

    public void clickPrevIconInSlider() {
        driver.findElement(prevIconInSlider).click();
    }

    public WebElement getActiveSliderElement(){
        return driver.findElement(activeSliderElement);
    }

    public boolean isActiveSlideClickable(){
        String currentUrl = driver.getCurrentUrl();
        driver.findElement(activeSliderElement).click();
        String nextUrl = driver.getCurrentUrl();
        return !currentUrl.equals(nextUrl);
    }

    public int getSliderElementCount(){
        String attribute = driver.findElement(By.xpath("//div[@id='carouselExampleIndicators']//ol//li[last()]")).getAttribute("data-slide-to");
        return Integer.valueOf(attribute) + 1;
    }


}
