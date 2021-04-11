package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    public LoginPage() {
        url = "https://the-internet.herokuapp.com/login";
    }

    @FindBy(id = "username")
    private WebElement usernameTextField;

    @FindBy(id = "password")
    private WebElement passwordTextField;

    @FindBy(xpath = "//button")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class,'error')]")
    private WebElement errorMessage;

    public LoginPage enterUsername(String username) {
        fill(usernameTextField, username);
        System.out.println("Enter " + username + " in Username text field");
        return new LoginPage();
    }

    public LoginPage enterPassword(String username) {
        fill(passwordTextField, username);
        System.out.println("Enter " + username + " in Username text field");
        return new LoginPage();
    }

    public SecureAreaPage clickLoginButtonAndGoToSecureAreaPage() {
        click(loginButton);
        System.out.println("Click on Login button");
        return new SecureAreaPage();
    }

    public String getErrorMessage() {
        String error = errorMessage.getText();
        System.out.println("Actual error message is : " + error);
        return error;
    }

    public boolean isPasswordTextIsMasked() {
        System.out.println("Check if Password text is masked");
        return passwordTextField.getAttribute("type").equals("password");
    }
}
