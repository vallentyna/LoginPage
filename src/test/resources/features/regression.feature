@regression
Feature: Regression suite for Login Page

  Background:
    Given I open Login page

  Scenario: Verify that User is able to log into secure area with valid username and valid password
    When I enter "tomsmith" in username field
    And I enter "SuperSecretPassword!" in password field
    When I click Login button
    Then I see "You logged into a secure area!" successful Login flash message
    And I see "Welcome to the Secure Area. When you are done click logout below." welcome message
    Then I see Logout button is displayed

  Scenario: Verify if the password text is hidden
    When I enter "tomsmith" in username field
    And I enter "SuperSecretPassword!" in password field
    Then I don't see the password text

  Scenario: Verify that User is not able to log into secure area with the white space before valid username and invalid password
    When I enter " " in username field
    And I enter "tomsmith" in username field
    When I enter "invalidPassword" in password field
    And I click Login button
    Then I don't see Logout button
    Then I see error message "Your password is invalid!"

  Scenario Outline: Verify that User is not able to log into secure area with invalid credentials
    When I enter "<username>" in username field
    And I enter "<password>" in password field
    When I click Login button
    Then I don't see Logout button
    Then I see error message "<errorMessage>"

    Examples:
      | username        | password             | errorMessage              |
#  Scenario : Verify if the user will get the error message when username and password fields are empty
      |                 |                      | Your username is invalid! |

#  Scenario: Verify that User is not able to log into secure area with invalid username and invalid password
      | invalidUsername | invalidPassword      | Your username is invalid! |

#  Scenario: Verify that User is not able to log into secure area with invalid username and valid password
      | invalidUsername | SuperSecretPassword! | Your username is invalid! |

#  Scenario: Verify that User is not able to log into secure area with valid username and invalid password
      | tomsmith        | invalidPassword      | Your password is invalid! |

#  Scenario: Verify that User is not able to log into secure area with the special characters in username and in password
      | <>%$#%#&        | <>%$#%#&             | Your username is invalid! |





