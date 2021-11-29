Feature: WishList Table

Scenario: Select wishlist Product
Given I add four different products to my wish list
When I view my wishlist table
Then I find total four selected item in my Wishlist
When I search for lowest price product
And I am able to add the lowest price item to my cart
Then I am to verify the item in my cart