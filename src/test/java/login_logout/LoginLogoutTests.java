package login_logout;

import base.BaseTests;
import modals.LoginModal;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginLogoutTests extends BaseTests {
    private LoginModal loginModal;

    @Test
    public void testClickOnLoginInHomePage() {
        loginModal = homePage.clickLogin();
        String loginText = loginModal.getLoginText();
        assertEquals(loginText,"Log in","Login modal not loaded!");
    }


    @Test(dependsOnMethods = {"testClickOnLoginInHomePage"})
    public void testSuccessfulLogin() {
        loginModal.setUsernameField("eyupbyr");
        loginModal.setPasswordField("123456");
        loginModal.clickLoginButtonInLoginModal();

        String welcomeText = homePage.getWelcomeText();
        assertTrue(welcomeText.startsWith("Welcome"));
    }

    @Test(dependsOnMethods = {"testClickOnLoginInHomePage"})
    public void testFailedLoginWithWrongPassword() {
        loginModal.setUsernameField("eyupbyr");
        loginModal.setPasswordField("654321");
        loginModal.clickLoginButtonInLoginModal();

        String alertText = loginModal.getAlertText();
        assertEquals(alertText,"Wrong password.","Password is not wrong");
    }

    @Test(dependsOnMethods = {"testClickOnLoginInHomePage"})
    public void testFailedLoginWithInvalidUsername() {
        loginModal.setUsernameField("eyupbyr_");
        loginModal.setPasswordField("123456");
        loginModal.clickLoginButtonInLoginModal();

        String alertText = loginModal.getAlertText();
        assertEquals(alertText,"User does not exist.","User exists!");
    }

    @Test(dependsOnMethods = {"testClickOnLoginInHomePage","testSuccessfulLogin"})
    public void testLogOut() {
        homePage.clickLogOut();
        assertTrue(homePage.isLoginButtonPresent(),"Log out unsuccessful!");
    }
}
