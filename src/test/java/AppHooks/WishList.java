package AppHooks;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;

import com.pages.AccountsPage;
import com.pages.LoginPage;
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

	
}
