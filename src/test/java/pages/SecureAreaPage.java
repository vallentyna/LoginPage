package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecureAreaPage extends Page {

    @FindBy(xpath = "//i[text()=' Logout']")
    private WebElement logoutButton;

    @FindBy(id = "flash")
    private WebElement successfulLoginFlashMessage;

    @FindBy(xpath = "//h4[@class='subheader']")
    private WebElement headerWelcomeMessage;

    public boolean isLogoutButtonDisplayed() {
        System.out.println("Check if Logout button is displayed");
        boolean isDisplayed;
        try {
            isDisplayed = logoutButton.isDisplayed();
        } catch (NoSuchElementException e) {
            isDisplayed = false;
        }
        return isDisplayed;
    }

    public String getSuccessfulLoginFlashMessage() {
        System.out.println("Get Successful Login Flash Message");
        return successfulLoginFlashMessage.getText();
    }

    public String getHeaderWelcomeMessage() {
        System.out.println("Get Header Welcome Message");
        return headerWelcomeMessage.getText();
    }

    public boolean isWelcomeMessageDisplayed() {
        System.out.println("Check if Welcome message is displayed");
        boolean isDisplayed;
        try {
            isDisplayed = headerWelcomeMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            isDisplayed = false;
        }
        return isDisplayed;
    }
}
