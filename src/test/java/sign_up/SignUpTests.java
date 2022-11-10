package sign_up;

import base.BaseTests;
import modals.SignUpModal;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SignUpTests extends BaseTests {
    private SignUpModal signUpModal;
    @Test
    public void testClickOnSignUpInHomePage() {
        signUpModal = homePage.clickSignUp();
        String signUpText = signUpModal.getSignUpText();
        assertEquals(signUpText,"Sign up","Sign Up modal not loaded!");
    }

    @Test(dependsOnMethods = {"testClickOnSignUpInHomePage"})
    public void testSuccessfulSignUp() {
        String generatedString = RandomStringUtils.random(12, true, true);
        System.out.println("Generated username: " + generatedString);
        signUpModal.setUsernameField(generatedString);
        signUpModal.setPasswordField("123456");
        signUpModal.clickSignUpButtonInSignUpModal();

        String alertText = signUpModal.getAlertText();
        assertEquals(alertText,"Sign up successful.","Sign up is not successful!");
    }

    @Test(dependsOnMethods = {"testClickOnSignUpInHomePage"})
    public void testFailedSignUp() {
        signUpModal.setUsernameField("eyupbyr");
        signUpModal.setPasswordField("123456");
        signUpModal.clickSignUpButtonInSignUpModal();

        String alertText = signUpModal.getAlertText();
        assertEquals(alertText,"This user already exist.","User does not exist!");
    }
}
