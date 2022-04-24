package gov.iti.jets.domain.dtos.util;

import gov.iti.jets.domain.dtos.cartLineItem.CartLineItemGetDto;
import gov.iti.jets.domain.dtos.cartLineItem.CartLineItemPostDto;
import gov.iti.jets.domain.models.CartLineItem;
import gov.iti.jets.service.impl.ProductServiceImpl;
import gov.iti.jets.service.interfaces.ProductServiceInt;

public class CartLineItemMapper {
    public static CartLineItem postToEntity( CartLineItemPostDto postDto ){
        ProductServiceInt productInt = new ProductServiceImpl();
        return new CartLineItem(productInt.getProduct( postDto.getProductId() ), postDto.getQuantity() );
    }
    public static CartLineItemGetDto entityToGet(CartLineItem cartLineItem){
        return new  CartLineItemGetDto(cartLineItem.getProduct(),cartLineItem.getQuantity());
    }
}
