package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListPage {
	private WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	private By wishlisticon = By.xpath("//div[@class='product-wishlist']//span[text()='Add to wishlist']");
	private By wishList = By.xpath("(//a[@title='Wishlist'])[1]//i");
	private By productList= By.xpath("(//tbody[@class='wishlist-items-wrapper']//tr)");
	private By Shopclick = By.xpath("(//a[contains(text(),'Shop')])");
	//private By Shopclick = By.linkText("Shop");
	private By filter = By.xpath("(//button[contains(.,'Filter')])");
	private By min = By.linkText("Min £10.00");
	//private By min = By.xpath("//div[@id='woocommerce_layered_nav_filters-1']/ul/li/a]");
	//private By cart = By.xpath("(//a[contains(text(),'Add to cart')]");
	private By cart = By.linkText("Add to cart");
	private By viewcart = By.linkText("View cart");
	private By cartList= By.xpath("(//tr[@class='woocommerce-cart-form__cart-item.cart_item'])");
	
	public WishListPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addProduct()
	{
		try {
			int count=0;
			for(int i=0;i<4;i++)
			{
				if(count==4)
				{
					break;
				}
				i=i-i;
	           driver.findElements(wishlisticon).get(i).click();
				count=count+1;
				Thread.sleep(5000);
			}
	}
	catch(Exception e)
	{
		System.out.print(e.getMessage());
	}
		
	}
	public void scrollDown()
	{
		  JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(0,350)", "");
	}
	public void scrollUp()
	{
		  JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(0,-350)", "");
	}
	
	public void clickWishList()
	{
		driver.findElement(wishList).click();
	}
	public void clickshop()
	{
		driver.findElement(Shopclick).click();
	}
	public void filter()
	{
		driver.findElement(filter).click();
	}
	public void min()
	{
		driver.findElement(min).click();
	}
	public void viewcart()
	{
		driver.findElement(viewcart).click();
	}
	
	public void addcart()
	{
		try {
			int count=0;
			for(int i=0;i<1;i++)
			{
				if(count==1)
				{
					break;
				}
				i=i-i;
	           driver.findElements(cart).get(i).click();
				count=count+1;
				Thread.sleep(5000);
			}
	}
	catch(Exception e)
	{
		System.out.print(e.getMessage());
	}
		
	}
	
	public void  getProductList()
	{
		String price;
		List<String> accountsList = new ArrayList<>();
		List<WebElement> rows = driver.findElements(productList);
		int rowsize=rows.size();
		for(int i=1;i<=rowsize;i++)
		{
		    List<WebElement> priceList=driver.findElements(By.xpath("(//tbody[@class='wishlist-items-wrapper']//tr)["+i+"]//td[@class='product-price']//span/bdi"));
			int tdprice=priceList.size();
		    for(int j=0;j<tdprice;j++)
		    {
		    	price=priceList.get(j).getText();
		    	String pp=price.replace("£","");
		    	double number = Double.parseDouble(pp);
				System.out.println("price--"+number);
				accountsList.add(price);
		    }	
		}	
		
		
	}
	
	public void  getcartList()
	{
		String price;
		List<String> accountsList = new ArrayList<>();
		List<WebElement> rows = driver.findElements(cartList);
		int rowsize=rows.size();
		for(int i=1;i<=rowsize;i++)
		{
		    List<WebElement> priceList=driver.findElements(By.xpath("(//tr[@class='woocommerce-cart-form__cart-item.cart_item'])["+i+"]//td[@class='product-price']//span/bdi"));
			int tdprice=priceList.size();
		    for(int j=0;j<tdprice;j++)
		    {
		    	price=priceList.get(j).getText();
		    	String pp=price.replace("£","");
		    	double number = Double.parseDouble(pp);
				System.out.println("price--"+number);
				accountsList.add(price);
		    }	
		}	
		
		
	}

}
