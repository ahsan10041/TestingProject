package myTests;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

public class CheckoutSteps {

    private WebDriver driver;

    @When("User clicks on the Checkout button")
    public void userClicksOnCheckoutButton() {
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
    }

    @Then("User is redirected to the Checkout page")
    public void userIsRedirectedToCheckoutPage() {
        assertTrue(driver.getCurrentUrl().contains("/checkout-step-one.html"));
    }

    @When("User enters shipping details:")
    public void userEntersShippingDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        WebElement firstNameInput = driver.findElement(By.id("first-name"));
        WebElement lastNameInput = driver.findElement(By.id("last-name"));
        WebElement postalCodeInput = driver.findElement(By.id("postal-code"));

        firstNameInput.sendKeys(data.get(0).get("First Name"));
        lastNameInput.sendKeys(data.get(0).get("Last Name"));
        postalCodeInput.sendKeys(data.get(0).get("Zip/Postal Code"));
    }

    @And("User clicks on the Continue button")
    public void userClicksOnContinueButton() {
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();
    }

    @Then("User is on the Checkout Step Two page")
    public void userIsOnCheckoutStepTwoPage() {
        assertTrue(driver.getCurrentUrl().contains("/checkout-step-two.html"));
        driver.quit();
    }
}
