
This project is an automated UI testing framework built with Java, Selenium WebDriver, and TestNG.
It automates and validates core user functionalities on the website:

[https://automationexercise.com](https://automationexercise.com)

The project is designed as a learning and practice project to demonstrate how automated tests can be structured, written, and executed using the Page Object Model (POM) design pattern.

---

Environment
Operating System: Windows 10
IDE: IntelliJ IDEA 2025.1.1.1
Browser: Google Chrome
WebDriver: ChromeDriver (compatible with installed Chrome version)

## Technologies Used

* Java
* Selenium WebDriver
* TestNG
* Maven
* WebDriverManager
* ChromeDriver

---

## How to Install and Run the Project

1. Clone the repository from GitHub
2. Open the project in **IntelliJ IDEA**
3. Make sure **Java** and **Maven** are installed
4. Make sure **Google Chrome** is installed
5. Maven will automatically download all dependencies
6. Run test classes using **TestNG**

---

## How to Use the Project

* Each test class represents a real user scenario
* Tests are located inside the `Tests` package
* Page logic is separated into the `Pages` package
* Browser setup and shared logic are handled in `BaseTest`
* Tests can be run individually or as a full test suite

No test credentials are required beyond those already used in the test data.

---

## Tests Included

Login Tests

* Login with valid credentials
* Login with invalid email or password
* Validation of error messages

Logout Tests

* Successful logout
* Verification that login fields are cleared after logout

Sign Up Tests

* Successful account creation
* Signup with an existing email
* Validation of error messages

Cart Tests

* Verify cart is empty before adding products
* Add product to cart
* Remove all products from cart
* Remove product by index


