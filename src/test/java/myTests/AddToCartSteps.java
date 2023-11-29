package myTests;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;

public class AddToCartSteps {

    private WebDriver driver;

    @When("User adds the product {string} to the cart")
    public void userAddsProductToCart(String productName) {
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-" + formatProductName(productName)));
        addToCartButton.click();
    }

    @Then("The product {string} should be in the cart")
    public void productShouldBeInCart(String productName) {
        WebElement cartButton = driver.findElement(By.id("shopping_cart_container"));
        cartButton.click();

        WebElement cartItem = driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']"));
        assertTrue(cartItem.isDisplayed());
        driver.quit();
    }

    private String formatProductName(String productName) {
        // Format the product name to match the ID format in the HTML
        return productName.toLowerCase().replace(" ", "-");
    }
}
