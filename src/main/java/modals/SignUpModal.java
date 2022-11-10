package modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpModal {
    private WebDriver driver;
    private By signUpText = By.xpath("//h5[@id='signInModalLabel']");
    private By usernameField = By.id("sign-username");
    private By passwordField = By.id("sign-password");
    private By signUpButtonInSignUpModal = By.xpath("//div[@class='modal-footer']//button[@onclick='register()']");


    public SignUpModal(WebDriver driver) {
        this.driver = driver;
    }

    public String getSignUpText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("signInModal")));
        return driver.findElement(signUpText).getText();
    }

    public void clickSignUpButtonInSignUpModal() {
        driver.findElement(signUpButtonInSignUpModal).click();
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
