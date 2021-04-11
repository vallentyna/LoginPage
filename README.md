# LoginPage 
The project has several layers. First layer is written in simple English format - Cucumber (language Gherkin). 
Second - definition (Business logic layer), all Assertions/Verification were done for this layer. 
The Definitions layer doesn’t talk with Webdriver. Definitions layer talk with third layer - Page Object which represents every UI page. 
Every java class looks like template for UI page - describes locators (private) and micro methods(public) which are used in the second layer.
