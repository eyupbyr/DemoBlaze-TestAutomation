package modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginModal {
    private WebDriver driver;

    private By loginText = By.xpath("//h5[@id='logInModalLabel']");
    private By usernameField = By.id("loginusername");
    private By passwordField = By.id("loginpassword");
    private By loginButtonInLoginModal = By.xpath("//div[@class='modal-footer']//button[@onclick='logIn()']");

    public LoginModal(WebDriver driver){
        this.driver = driver;
    }

    public String getLoginText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("logInModal")));
        return driver.findElement(loginText).getText();
    }

    public void clickLoginButtonInLoginModal() {
        driver.findElement(loginButtonInLoginModal).click();
    }

    public void setUsernameField(String email) {
        driver.findElement(usernameField).sendKeys(email);
    }

    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public String getAlertText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }
}
