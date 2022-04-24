package gov.iti.jets.service.interfaces;

import gov.iti.jets.domain.models.CartLineItem;

import java.util.List;

public interface ShoppingCartServiceInt {
    public String addProductToCart( int userId, CartLineItem cartLineItem );

    public String removeProductfromCart( int userId ,int productId );

    public List<CartLineItem> getUserCartitems( int id );

    public String orderItemsinShoppingCart(int userId);
}
