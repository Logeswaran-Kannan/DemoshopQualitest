package AppHooks;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;

//import com.pages.AccountsPage;
//import com.pages.LoginPage;
import com.pages.WishListPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WishList {
	//private WishListPage wishListPage;
	private WishListPage wishListPage = new WishListPage(DriverFactory.getDriver());
	
	@Given("I add four different products to my wish list")
	public void i_add_four_different_products_to_my_wish_list() {
		DriverFactory.getDriver()
		.get("https://testscriptdemo.com/");  
		System.out.println("AM IN THE LOGIN PAGE");
		wishListPage.scrollDown();
		wishListPage.addProduct();
	}

	@When("I view my wishlist table")
	public void i_view_my_wishlist_table() {
		wishListPage.scrollUp();
		wishListPage.clickWishList();
	}

	@Then("I find total four selected item in my Wishlist")
	public void i_find_total_four_selected_item_in_my_wishlist() {
		wishListPage.scrollDown();
		wishListPage.getProductList();
		
	   
	}
	
	@When("I search for lowest price product")
	public void i_search_for_lowest_price_product() {
		wishListPage.clickshop();
		wishListPage.filter();
		wishListPage.min();
	}
	
	@When("I am able to add the lowest price item to my cart")
	public void i_am_able_to_add_the_lowest_price_item_to_my_cart() {
		wishListPage.addcart();
	}

	
	@Then("I am to verify the item in my cart")
	public void i_am_to_verify_the_item_in_my_cart() {
		wishListPage.scrollDown();
		wishListPage.viewcart();
		wishListPage.getcartList();
		 
	}
	
}
