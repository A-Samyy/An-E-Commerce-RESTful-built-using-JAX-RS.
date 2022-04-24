package gov.iti.jets.domain.dtos.shoppingCart;

import gov.iti.jets.domain.models.CartLineItem;
import gov.iti.jets.domain.models.User;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

public class shoppingCartDto {
    private int id;

    private User owner;

    private final Set<CartLineItem> cartLineItems = new HashSet<>();

}
