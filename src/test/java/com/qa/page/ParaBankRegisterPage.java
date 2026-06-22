//package com.qa.page;
//
//import java.time.Duration;
//import java.util.Map;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//public class ParaBankRegisterPage {
//
//    WebDriver driver;
//    WebDriverWait wait;
//
//    public ParaBankRegisterPage(WebDriver driver) {
//		this.driver = driver;
//		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	}
//
//    // Locators
//
//    private By firstName = By.id("customer.firstName");
//    private By lastName = By.id("customer.lastName");
//    private By address = By.id("customer.address.street");
//    private By city = By.id("customer.address.city");
//    private By state = By.id("customer.address.state");
//    private By zipCode = By.id("customer.address.zipCode");
//    private By phoneNumber = By.id("customer.phoneNumber");
//    private By ssn = By.id("customer.ssn");
//    private By username = By.id("customer.username");
//    private By password = By.id("customer.password");
//    private By confirmPassword = By.id("repeatedPassword");
//
//    private By registerBtn = By.xpath("//input[@value='Register']");
//
//    private By successMessage =
//            By.xpath("//div[@id='rightPanel']//h1");
//
//    private By logoutLink =
//            By.linkText("Log Out");
//
//    private By usernameError =
//            By.id("customer.username.errors");
//
//    // Methods
//
//    public void registerUser(Map<String, String> data) {
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
//
//        driver.findElement(firstName).clear();
//        driver.findElement(firstName).sendKeys(data.get("FirstName"));
//
//        driver.findElement(lastName).clear();
//        driver.findElement(lastName).sendKeys(data.get("LastName"));
//
//        driver.findElement(address).clear();
//        driver.findElement(address).sendKeys(data.get("Address"));
//
//        driver.findElement(city).clear();
//        driver.findElement(city).sendKeys(data.get("City"));
//
//        driver.findElement(state).clear();
//        driver.findElement(state).sendKeys(data.get("State"));
//
//        driver.findElement(zipCode).clear();
//        driver.findElement(zipCode).sendKeys(data.get("Zip"));
//
//        driver.findElement(phoneNumber).clear();
//        driver.findElement(phoneNumber).sendKeys(data.get("Phone"));
//
//        driver.findElement(ssn).clear();
//        driver.findElement(ssn).sendKeys(data.get("SSN"));
//
//        driver.findElement(username).clear();
//        driver.findElement(username).sendKeys(data.get("Username"));
//
//        driver.findElement(password).clear();
//        driver.findElement(password).sendKeys(data.get("Password"));
//
//        driver.findElement(confirmPassword).clear();
//        driver.findElement(confirmPassword).sendKeys(data.get("Password"));
//
//        driver.findElement(registerBtn).click();
//    }
//
//    public String getRegistrationSuccessMessage() {
//
//        try {
//
//            WebElement message =
//                    wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
//
//            return message.getText();
//
//        } catch (Exception e) {
//
//            return "";
//        }
//    }
//
//    public boolean isRegistrationSuccessful() {
//
//        try {
//
//            String msg = getRegistrationSuccessMessage();
//
//            return msg.contains("Welcome");
//
//        } catch (Exception e) {
//
//            return false;
//        }
//    }
//
//    public String getUsernameErrorMessage() {
//
//        try {
//
//            return driver.findElement(usernameError).getText();
//
//        } catch (Exception e) {
//
//            return "";
//        }
//    }
//
//    public void logout() {
//
//        try {
//
//            wait.until(ExpectedConditions.elementToBeClickable(logoutLink))
//                .click();
//
//        } catch (Exception e) {
//
//            System.out.println("Logout link not found.");
//        }
//    }
//}
















package com.qa.page;

import java.time.Duration;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParaBankRegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    public ParaBankRegisterPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators

    private By firstName = By.id("customer.firstName");
    private By lastName = By.id("customer.lastName");
    private By address = By.id("customer.address.street");
    private By city = By.id("customer.address.city");
    private By state = By.id("customer.address.state");
    private By zipCode = By.id("customer.address.zipCode");
    private By phoneNumber = By.id("customer.phoneNumber");
    private By ssn = By.id("customer.ssn");
    private By username = By.id("customer.username");
    private By password = By.id("customer.password");
    private By confirmPassword = By.id("repeatedPassword");

    private By registerBtn = By.xpath("//input[@value='Register']");

    private By successMessage =
            By.xpath("//div[@id='rightPanel']//h1");

    private By logoutLink =
            By.linkText("Log Out");

    private By usernameError =
            By.id("customer.username.errors");

    // Random String Generator

    public String getRandomString(int length) {

        String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder randomString = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < length; i++) {

            randomString.append(
                    characters.charAt(
                            random.nextInt(characters.length())));
        }

        return randomString.toString();
    }

    // Registration Method

    public void registerUser(Map<String, String> data) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstName));

        String suffix = getRandomString(5);

        driver.findElement(firstName).clear();
        driver.findElement(firstName)
                .sendKeys(data.get("FirstName") + suffix);

        driver.findElement(lastName).clear();
        driver.findElement(lastName)
                .sendKeys(data.get("LastName") + suffix);

        driver.findElement(address).clear();
        driver.findElement(address)
                .sendKeys(data.get("Address") + suffix);

        driver.findElement(city).clear();
        driver.findElement(city)
                .sendKeys(data.get("City") + suffix);

        driver.findElement(state).clear();
        driver.findElement(state)
                .sendKeys(data.get("State") + suffix);

        driver.findElement(zipCode).clear();
        driver.findElement(zipCode)
                .sendKeys(data.get("Zip"));

        driver.findElement(phoneNumber).clear();
        driver.findElement(phoneNumber)
                .sendKeys(data.get("Phone"));

        driver.findElement(ssn).clear();
        driver.findElement(ssn)
                .sendKeys(data.get("SSN"));

        driver.findElement(username).clear();
        driver.findElement(username)
                .sendKeys(data.get("Username") + suffix);

        driver.findElement(password).clear();
        driver.findElement(password)
                .sendKeys(data.get("Password"));

        driver.findElement(confirmPassword).clear();
        driver.findElement(confirmPassword)
                .sendKeys(data.get("Password"));

        driver.findElement(registerBtn).click();
    }

    // Verify Registration

    public boolean isRegistrationSuccessful() {

        try {

            String message = getRegistrationSuccessMessage();

            return message.contains("Welcome");

        } catch (Exception e) {

            return false;
        }
    }

    // Get Success Message

    public String getRegistrationSuccessMessage() {

        try {

            WebElement element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(successMessage));

            return element.getText();

        } catch (Exception e) {

            return "";
        }
    }

    // Get Error Message

    public String getUsernameErrorMessage() {

        try {

            return driver.findElement(usernameError).getText();

        } catch (Exception e) {

            return "No Error Message Found";
        }
    }

    // Logout

    public void logout() {

        try {

            wait.until(
                    ExpectedConditions.elementToBeClickable(logoutLink))
                    .click();

        } catch (Exception e) {

            System.out.println("Logout link not found.");
        }
    }
}