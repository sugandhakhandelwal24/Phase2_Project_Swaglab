package StepDef;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDefinition {

	WebDriver driver = BaseClass.driver;
	
	 @Given("^User is on the homepage$")
	    public void user_is_on_the_homepage() throws Throwable {
		 WebElement ProductPageTitle = driver.findElement(By.xpath("//*[@class='title']"));
			String ActualText =  ProductPageTitle.getText();
			String ExpectedText = "PRODUCTS";
			Assert.assertEquals(ExpectedText, ActualText);
	    }
	 
	  @When("^User selects the \"([^\"]*)\"$")
	    public void user_selects_the_something(String product) throws Throwable {
		  driver.manage().timeouts().implicitlyWait(50000, TimeUnit.MILLISECONDS);
		  WebElement buttonProductSelect = driver.findElement(By.xpath("//*[text()= '" + product + "']//following::button[1]"));
			buttonProductSelect.click();
	    }
	  
	  @And("^Click on the Add to cart button$")
	    public void click_on_the_add_to_cart_button() throws Throwable {
		  WebElement addtoCartIcon = driver.findElement(By.xpath("//*[@class='shopping_cart_link']"));
		  addtoCartIcon.click();
	      
	    }

	  @Then("^Product added successfully to the cart$")
	    public void product_added_successfully_to_the_cart() throws Throwable {

	    	
	    	List<WebElement> iteminCart = driver.findElements(By.xpath("//*[@class ='cart_item']"));
	    	int ProductsCount = iteminCart.size();
	    	System.out.println("Product added successfully count is: " + ProductsCount);
		 
	    }
	  
	  @When("^User selects the product$")
	    public void user_selects_the_product(DataTable table) throws Throwable {
		  
		  String Product1 = table.cell(1, 1);
		  String Product2 = table.cell(2, 1);
	    	String Product3 = table.cell(3, 1);
		  
		  WebElement buttonProductSelect = driver.findElement(By.xpath("//*[text()= '" + Product1 + "']//following::button[1]"));
			buttonProductSelect.click();
			 WebElement buttonProductSelect1 = driver.findElement(By.xpath("//*[text()= '" + Product2 + "']//following::button[1]"));
			 buttonProductSelect1.click();
				 WebElement buttonProductSelect2 = driver.findElement(By.xpath("//*[text()= '" + Product3 + "']//following::button[1]"));
				 buttonProductSelect2.click();
	    }
	  
	
}
