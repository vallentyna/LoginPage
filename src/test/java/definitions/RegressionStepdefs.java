package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegressionStepdefs {
    @Given("I open Login page")
    public void iOpenLoginPage() {
        new LoginPage().open();
    }

    @When("I enter {string} in username field")
    public void iEnterInUsernameField(String username) {
        new LoginPage().enterUsername(username);
    }

    @And("I enter {string} in password field")
    public void iEnterInPasswordField(String password) {
        new LoginPage().enterPassword(password);
    }

    @When("I click Login button")
    public void iClickLoginButton() {
        new LoginPage().clickLoginButtonAndGoToSecureAreaPage();
    }

    @Then("I see {string} successful Login flash message")
    public void iSeeSuccessfulLoginFlashMessage(String expectedMessage) {
        String actualMessage = new SecureAreaPage().getSuccessfulLoginFlashMessage();
        assertThat(actualMessage).contains(expectedMessage);
    }

    @Then("I see {string} welcome message")
    public void iSeeWelcomeMessage(String expectedMessage) {
        String actualMessage = new SecureAreaPage().getHeaderWelcomeMessage();
        assertThat(actualMessage).contains(expectedMessage);
    }

    @And("I see Logout button is displayed")
    public void iSeeLogoutButtonIsDisplayed() {
        boolean isDisplayed = new SecureAreaPage().isLogoutButtonDisplayed();
        assertThat(isDisplayed).isTrue();
    }

    @Then("I don't see Welcome message")
    public void iDonSeeWelcomeMessage() {
        boolean isDisplayed = new SecureAreaPage().isWelcomeMessageDisplayed();
        assertThat(isDisplayed).isFalse();
    }

    @And("I see error message {string}")
    public void iSeeErrorMessage(String expectedError) {
        String actualError = new LoginPage().getErrorMessage();
        assertThat(actualError).contains(expectedError);
    }

    @Then("I don't see Logout button")
    public void iDonTSeeLogoutButton() {
        boolean isDisplayed = new SecureAreaPage().isLogoutButtonDisplayed();
        assertThat(isDisplayed).isFalse();
    }

    @Then("I don't see the password text")
    public void iDonTSeeThePasswordText() {
        boolean isMasked = new LoginPage().isPasswordTextIsMasked();
        assertThat(isMasked).isTrue();
    }
}
