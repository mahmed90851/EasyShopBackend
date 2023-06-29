package org.yearup.data;

import org.yearup.models.ShoppingCart;

public interface ShoppingCartDao
{
    ShoppingCart getByUserId(int userId);
    void addItemToCart(int userId);
    void updateCart(int cartId, int productId, int quantity);
    void clearCart(int cartId);
    // add additional method signatures here

}
