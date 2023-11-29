package myTests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private WebDriver driver;

    @Given("User is on the Saucedemo login page")
    public void userIsOnLoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("User enters correct username and password")
    public void userEntersCorrectCredentials() {
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();
    }

    @Then("User should be logged in successfully")
    public void userLoggedInSuccessfully() {
        assertTrue(driver.getCurrentUrl().contains("/inventory.html"));
        driver.quit();
    }

    @When("User enters incorrect username {string} and/or password {string}")
    public void userEntersIncorrectCredentials(String username, String password) {
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    @Then("User should see an error message")
    public void userShouldSeeErrorMessage() {
        WebElement errorElement = driver.findElement(By.cssSelector("[data-test='error']"));
        assertTrue(errorElement.isDisplayed());
        driver.quit();
    }

    // Individual scenario implementations with hardcoded values

    @When("User enters incorrect username 'invalid_user' and/or password 'secret_sauce'")
    public void userEntersInvalidCredentials() {
        userEntersIncorrectCredentials("invalid_user", "secret_sauce");
    }

    @When("User enters incorrect username 'locked_out_user' and/or password 'secret_sauce'")
    public void userEntersLockedOutCredentials() {
        userEntersIncorrectCredentials("locked_out_user", "secret_sauce");
    }

    @When("User enters incorrect username 'problem_user' and/or password 'secret_sauce'")
    public void userEntersProblemCredentials() {
        userEntersIncorrectCredentials("problem_user", "secret_sauce");
    }

    @When("User enters incorrect username 'performance_glitch_user' and/or password 'secret_sauce'")
    public void userEntersPerformanceGlitchCredentials() {
        userEntersIncorrectCredentials("performance_glitch_user", "secret_sauce");
    }

    @When("User enters incorrect username 'error_user' and/or password 'secret_sauce'")
    public void userEntersErrorCredentials() {
        userEntersIncorrectCredentials("error_user", "secret_sauce");
    }

    @When("User enters incorrect username 'visual_user' and/or password 'secret_sauce'")
    public void userEntersVisualCredentials() {
        userEntersIncorrectCredentials("visual_user", "secret_sauce");
    }
}
