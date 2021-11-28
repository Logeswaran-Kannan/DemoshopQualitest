Feature: WishList Table

Scenario: Select Product
Given I add four different products to my wish list
When I view my wishlist table
Then I find total four selected item in my Wishlist
